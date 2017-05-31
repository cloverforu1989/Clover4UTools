package com.clover4u.startup;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

import com.clover4u.box.BoxManager;
import com.clover4u.paintLoading.PaintLoadingManager;
import com.clover4u.scene.SceneManager;
import com.clover4u.utils.Mtd;

public class MainCanvas extends Canvas implements Runnable{

	/**
	 * @param args
	 */
	public static boolean sign = true;
	private static MainMidlet mainMidlet;
	private long step;
	public MainCanvas(MainMidlet mainMidlet) {
		MainCanvas.setMainMidlet(mainMidlet);
		this.setFullScreenMode(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public MainCanvas() {
		super();
		this.setFullScreenMode(true);
		// TODO Auto-generated constructor stub
	}

	protected void paint(Graphics g) {
		if(GameSystem.getGcTime() > 0) {
			if(step % GameSystem.getGcTime() == 0) {
				System.gc();
				step=0;
			}
		}
		g.setFont(GameSystem.getFont());
		//g.setColor(0x00000);
		//g.fillRect(0, 0, GameSystem.getSceen_w(), GameSystem.getSceen_h());
		// TODO Auto-generated method stub
		BoxManager.check();
		SceneManager.check();
		//System.out.println("PaintLoadingManager.size()  = " + PaintLoadingManager.size() );
		if(PaintLoadingManager.size() > 0) {//load page
			PaintLoadingManager.update();// box
			PaintLoadingManager.draw(g);
		}else {
			if(SceneManager.size() > 0) {
				SceneManager.draw(g);
				if(BoxManager.size() == 0) {
					SceneManager.update();
				}
			}
			if(BoxManager.size() > 0){
				BoxManager.update();
				BoxManager.draw(g);
			}
		}
		step++;
		
	}

	protected void keyPressed(int keyCode) {
		// TODO Auto-generated method stub
		super.keyPressed(keyCode);
		if(BoxManager.size() > 0){
			BoxManager.keyPressed(keyCode);
		}else if(SceneManager.size() > 0) {
			SceneManager.keyPressed(keyCode);
		}
		
	}
    
	
	protected void keyReleased(int keyCode) {
		// TODO Auto-generated method stub
		super.keyReleased(keyCode);
		if(BoxManager.size() > 0){
			BoxManager.keyReleased(keyCode);
		}else if(SceneManager.size() > 0) {
			SceneManager.keyReleased(keyCode);
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while(sign) {
			long time1 = System.currentTimeMillis();
			repaint();
			long n = System.currentTimeMillis() - time1; 
			//System.out.println("time: " + n);	
		    if(n < GameSystem.getFps()) {
				Mtd.sleep(GameSystem.getFps() - n);
			}else {
				Mtd.sleep(1);
			} 
			//System.out.println("realTime:" + (System.currentTimeMillis() - time1));
			
		}
	}
	
	public static MainMidlet getMainMidlet() {
		return mainMidlet;
	}
	public static void setMainMidlet(MainMidlet mainMidlet) {
		MainCanvas.mainMidlet = mainMidlet;
	}
	public long getStep() {
		return step;
	}
	public void setStep(long step) {
		this.step = step;
	}

}
