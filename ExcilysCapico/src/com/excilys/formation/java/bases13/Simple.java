package com.excilys.formation.java.bases13;

import java.applet.Applet;
import java.awt.Graphics;

public class Simple extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5343947434234607449L;
	StringBuffer buffer;

	@Override
	public void init() {
		buffer = new StringBuffer();
		addItem("initializing... ");
	}

	@Override
	public void start() {
		addItem("starting... ");
	}

	@Override
	public void stop() {
		addItem("stopping... ");
	}

	@Override
	public void destroy() {
		addItem("preparing for unloading... ");
	}

	private void addItem(String newWord) {
		System.out.println(newWord);
		buffer.append(newWord);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		g.drawString(buffer.toString(), 5, 15);
	}

}
