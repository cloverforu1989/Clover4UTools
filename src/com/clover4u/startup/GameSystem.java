package com.clover4u.startup;

import javax.microedition.lcdui.Font;
import javax.microedition.midlet.MIDletStateChangeException;

import com.clover4u.connection.ConnectionManager;
import com.clover4u.utils.Load;

public class GameSystem {

	/**
	 * @param args
	 */
	private static int sceen_w = 640; 
	private static int sceen_h = 530; 
	private static int fps = 100;
	private static String res_url = null;
	private static String host_url = null;
	private static MainMidlet mmidlet;
	private static Font font = Font.getDefaultFont();
	private static String data;
	private static int gcTime;//调用gc的帧数
	public static final void exitGame() {
		try {
			mmidlet.destroyApp(true);
			mmidlet.notifyDestroyed();
		} catch (MIDletStateChangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getAppProperty(String key) {
		return mmidlet.getAppProperty(key);
	}
	public static final void start() {
		MainMidlet.connectionThread = new Thread(new ConnectionManager());
		MainMidlet.connectionThread.start();//请求线程启动
		new Thread(MainMidlet.getCanvas()).start();//游戏启动
		
	}
   
	public static int getSceen_w() {
		return sceen_w;
	}

	public static void setSceen_w(int sceen_w) {
		GameSystem.sceen_w = sceen_w;
	}

	public static int getSceen_h() {
		return sceen_h;
	}

	public static void setSceen_h(int sceen_h) {
		GameSystem.sceen_h = sceen_h;
	}

	public static String getRes_url() {
		return res_url;
	}

	public static void setRes_url(String res_url) {
		GameSystem.res_url = res_url;
	}
	
	public static MainMidlet getMmidlet() {
		return mmidlet;
	}
	
	public static void setMmidlet(MainMidlet mmidlet) {
		GameSystem.mmidlet = mmidlet;
	}
	
	public static Font getFont() {
		return font;
	}
	public static void setFont(Font font) {
		GameSystem.font = font;
	}
	
	public static int getFps() {
		return fps;
	}
	
	public static void setFps(int fps) {
		GameSystem.fps = fps;
	}
	
	public static String getData() {
		return data;
	}
	
	public static void setData(String data) {
		GameSystem.data = data;
	}

	public static String getHost_url() {
		return host_url;
	}

	public static void setHost_url(String host_url) {
		GameSystem.host_url = host_url;
	}
	
	public static int getGcTime() {
		return gcTime;
	}
	
	public static void setGcTime(int gcTime) {
		GameSystem.gcTime = gcTime;
	}

	


	
}
