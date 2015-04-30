package com.example.excilys.exo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;


public class DashBoardActivity extends Activity {
	private String mUser;
	private String mPwd;
	TextView hello;
	TextView chat;
	ChatTask chatTask;
	Button mBtn;
	SendTask sendTask;
	EditText msg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dash_board);
		hello = (TextView) findViewById(R.id.hello_user);
		chat = (TextView) findViewById(R.id.chat);
		mUser = getIntent().getStringExtra("User");
		mPwd = getIntent().getStringExtra("Pwd");
		msg=(EditText) findViewById(R.id.edit_text_msg);
		hello.setText("Bonjour " + mUser);
		chatTask = new ChatTask();
		chatTask.execute();
		mBtn = (Button) findViewById(R.id.btSend);
		mBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(sendTask == null){
					sendTask = new SendTask();
					sendTask.execute(msg.getText().toString());
				}
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_dash_board, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private class ChatTask extends android.os.AsyncTask<String, Object, InputStream> {
		@Override
		protected InputStream doInBackground(String... params) {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://training.loicortola.com/parlez-vous-android/message/"
					+ mUser + "/" + mPwd);
			try {
				HttpResponse response = client.execute(request);
				return response.getEntity().getContent();
			} catch (IOException e) {
				Log.e("lol", e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(InputStream integer) {
			super.onPostExecute(integer);
			chat.setText(convert(integer));
		}

		public String convert(InputStream is) {
			String line = "";
			StringBuilder builder = new StringBuilder();

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			try {
				while ((line = rd.readLine()) != null) {
					builder.append(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			return builder.toString();
		}

		@Override
		protected void onProgressUpdate(Object... values) {
			super.onProgressUpdate(values);
		}
	}


	private class SendTask extends android.os.AsyncTask<String, Object, InputStream> {
		@Override
		protected InputStream doInBackground(String... params) {
			if(params == null  || params.length != 1)
			{
				throw new IllegalArgumentException("Should be 1 argument");
			}
			DefaultHttpClient client = new DefaultHttpClient();
			HttpPut request = new HttpPut("http://training.loicortola.com/parlez-vous-android/message/"
					+ mUser + "/" + mPwd);



			try {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("uuid", UUID.randomUUID().toString());
				jsonObject.put("login", mUser);
				jsonObject.put("message", params[0]);
				StringEntity entity =new StringEntity(jsonObject.toString(), HTTP.UTF_8);
				entity.setContentType("application/json");
				request.setEntity(entity);
				HttpResponse response = client.execute(request);
				return response.getEntity().getContent();
			} catch (IOException | JSONException e) {
				Log.e("lol", e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(InputStream integer) {
			super.onPostExecute(integer);
			sendTask = null;

		}

		@Override
		protected void onProgressUpdate(Object... values) {
			super.onProgressUpdate(values);
		}
	}
}
