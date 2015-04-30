package com.example.excilys.exo1;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity implements View.OnClickListener {
	private static final String TAG = "MainActivity";
	private Button mViderBtn;
	private Button mSendBtn;
	private EditText mUserEditTxt;
	private EditText mPwdEditTxt;
	private TextView mErrorUserTxt;
	private TextView mErrorPwdTxt;
	private Activity mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_main);
		Log.i(TAG, "onCreate!");
		mViderBtn = (Button) findViewById(R.id.btVider);
		mSendBtn = (Button) findViewById(R.id.btSend);
		mUserEditTxt = (EditText) findViewById(R.id.editText);
		mPwdEditTxt = (EditText) findViewById(R.id.editText2);
		mErrorUserTxt = (TextView) findViewById(R.id.errorUser);
		mErrorPwdTxt = (TextView) findViewById(R.id.errorPsw);
		mViderBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPwdEditTxt.setText("");
				mUserEditTxt.setText("");
			}
		});

		mSendBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean goToast = false;
				if (mPwdEditTxt.getText().toString().isEmpty()) {
					mErrorPwdTxt.setText("Ce champs est vide!");

					mErrorPwdTxt.setVisibility(View.VISIBLE);
				} else {
					goToast = true;
					mErrorPwdTxt.setVisibility(View.GONE);
				}
				if (mUserEditTxt.getText().toString().isEmpty()) {
					mErrorUserTxt.setVisibility(View.VISIBLE);
					mErrorUserTxt.setText("Ce champs est vide!");
				} else {
					mErrorUserTxt.setVisibility(View.GONE);
					if (!goToast) goToast = true;
				}
				if (goToast) {
					ParlezVousTask task = new ParlezVousTask(mContext);
					task.execute();
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btVider: {

				break;
			}
			case R.id.btSend: {

				break;
			}
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState!");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "onRestoreInstanceState!");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart!");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart!");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		switch (id) {
			case R.id.action_settings:
				return true;
			case R.id.action_bonus:
				Intent intent = new Intent(this, BonusActivity.class);
				startActivity(intent);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private class ParlezVousTask extends android.os.AsyncTask<Object, Object, Integer> {
		private Activity mContext;
		private ProgressBar pb;

		public ParlezVousTask(Activity c) {
			mContext = c;
		}

		@Override
		protected Integer doInBackground(Object[] params) {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://training.loicortola.com/parlez-vous-android/connect/"
					+ mUserEditTxt.getText().toString() + "/" + mPwdEditTxt.getText().toString());
			HttpResponse response = null;
			try {
				response = client.execute(request);
				return response.getStatusLine().getStatusCode();
			} catch (IOException e) {

			}
			return 0;
		}

		@Override
		protected void onPostExecute(Integer o) {
			super.onPostExecute(o);
			pb.setVisibility(View.GONE);
			Toast.makeText(mContext, "Code : " + o, Toast.LENGTH_SHORT).show();
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pb = (ProgressBar) findViewById(R.id.progressBar);
			pb.setVisibility(View.VISIBLE);
		}
	}
}
