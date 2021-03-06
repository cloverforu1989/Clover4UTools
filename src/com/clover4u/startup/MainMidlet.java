package com.clover4u.startup;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import com.clover4u.connection.ConnectionManager;
import com.clover4u.paintLoading.PaintLoadingManager;
public  class MainMidlet extends MIDlet {
   
    private Display dis;
    private static MainCanvas canvas;
    private  PaintLoadingManager plm ;
    public static Thread connectionThread;
    public static MainCanvas getCanvas() {
		return canvas;
	}

	public static void setCanvas(MainCanvas canvas) {
		MainMidlet.canvas = canvas;
	}

	public MainMidlet() {
		// TODO Auto-generated constructor stub
		GameSystem.setMmidlet(this);
		this.dis = Display.getDisplay(this);
		
	}
    
	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub
		if(canvas == null) {
			canvas = new MainCanvas(this);
		}
		dis.setCurrent(canvas);
		this.setPlm(new PaintLoadingManager());

	}

	public PaintLoadingManager getPlm() {
		return plm;
	}

	public void setPlm(PaintLoadingManager plm) {
		this.plm = plm;
	}
    
    
   
}
