package com.clover4u.paintLoading;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.clover4u.startup.GameSystem;
import com.clover4u.utils.IListener;
import com.clover4u.utils.Load;
import com.clover4u.utils.Mtd;
import com.clover4u.view.View;

//loading
public  class PaintLoading extends PaintLoadingBasic implements Runnable{

	/**
	 * @param args
	 */
	private IListener listener;
	private int totalResNum;
	private int counter;
	private View view;
	private Load load;
	private Image bkg;
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
	}
	//
	public PaintLoading(int totalResNum, View view, Image bkg, IListener listener) {
	  view.setKeyLocked(true);
	  view.setDisplay(false);
	  this.totalResNum = totalResNum;
	  this.listener = listener;
	  this.setView(view);
	  this.setLoad(new Load(this));
	  setBkg(bkg);
	}
	
	public void endLoading() {
		if(view != null) {
			view.setKeyLocked(false);
			view.setDisplay(true);
		}
		
		if(listener != null) {
			listener.callback();
		}
	}
	public final void show() {
		PaintLoadingManager.addPaintLoading(this);
		new Thread(this).start();
	}
	
	public void init() {
		// TODO Auto-generated method stub
		
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
//		g.setColor(0xCCCCC);
//		g.fillRect(0, 0, Setting.getSceen_w(), Setting.getSceen_h());
		if(bkg != null) {
			Mtd.drawImage(bkg, GameSystem.getSceen_w() / 2, GameSystem.getSceen_h() / 2, View.ANCHOR_HCENTER_VCENTER,g);
		}
		g.setColor(0xCCFFF);
		if(counter > totalResNum) {
			counter = totalResNum;
		}
		g.fillRect(0, 460, GameSystem.getSceen_w() * counter / (totalResNum <= 0?1:totalResNum), 30);
		
		
		
	}
	public void update() {
		// TODO Auto-generated method stub
		//counter ++;
//		if(counter >= totalResNum) {
//			endLoading();
//			
//		}
	}
	public IListener getListener() {
		return listener;
	}
	public void setListener(IListener listener) {
		this.listener = listener;
	}
	public int getTotalResNum() {
		return totalResNum;
	}
	public void setTotalResNum(int totalResNum) {
		this.totalResNum = totalResNum;
	}
	public void freeRes() {
		// TODO Auto-generated method stub
		bkg = null;
		load = null;
		System.gc();
	}
	public void keyPressed(int keyCode) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}
	public void run() {
		// TODO Auto-generated method stub
	   if(view != null) {
			view.loadRes();
		}
		setEnd(true);
		System.out.println("loading½áÊø¡£¡£¡£");
		
	}

	public Load getLoad() {
		return load;
	}
	public void setLoad(Load load) {
		this.load = load;
	}

	public void loadRes() {
		// TODO Auto-generated method stub
		
	}
	
	public void setKeyLocked(boolean sign) {
		// TODO Auto-generated method stub
		
	}
	public View getView() {
		return view;
	}
	public void setView(View view) {
		this.view = view;
	}
	public void setDisplay(boolean sign) {
		// TODO Auto-generated method stub
		
	}
	
	public Image getBkg() {
		return bkg;
	}
	public void setBkg(Image bkg) {
		this.bkg = bkg;
	}
	public void quit() {
		// TODO Auto-generated method stub
		
	}
	public void setAvailableKeyArray(int[] keys) {
		// TODO Auto-generated method stub
		
	}
	public boolean isKeyAvailable() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setQuitListener(IListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	
}
