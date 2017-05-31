package com.clover4u.box;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;

import com.clover4u.scene.Scene;
import com.clover4u.view.View;

public final class BoxManager{
   /**
	 * @param args
	 */
	private static Vector boxQuene = new Vector(3,1);
	private static int size;
	public static final void addBox(Box box) {
		if(box != null) {
			boxQuene.addElement(box);
			size ++;
		}
		  
	}
	public static final void removeBox(Box box) {
		if(box != null) {
			box.freeRes();
			boxQuene.removeElement(box);
			size --;
			System.out.println("box.getQuitListener() = " + box.getQuitListener());
			if(box.getQuitListener() != null) {
				box.getQuitListener().callback();
				box.setQuitListener(null);
			}
			System.gc();
		}
		  
	}
	
	
	public static void init() {
		
	} 
	public static void check() {
		int j = size();
		for(int i = 0; i < j; i ++) {
			Box box = ((Box)boxQuene.elementAt(i));
			if(box.getQuitTime() > 0) {
				if(box.getStep() > box.getQuitTime()) {
					box.setBeQuit(true);
				}
			}
			if(box.isBeQuit()) {
				removeBox(box);
				j--;
				i--;
				box = null;
				if(j == 0 || i==j - 1) {
				    break;
				}
			}
		}
	}
	public static void draw(Graphics g) {
		
		int j = size();
		for(int i = 0; i < j; i++) {
			Box box = ((Box)boxQuene.elementAt(i));
			if(box.isDisplay()) {
				((Box)boxQuene.elementAt(i)).draw(g);
			}
			box = null;
		}
	}
	
	public static void update() {
		int j = size();
	    if(j > 0) {
			Box box = ((Box)boxQuene.elementAt(j - 1));
			if(box.isBeUpdated()) {
				if(box.isBePressed()) {
					box.keyPressed(box.getKeyCode());
					box.setBePressed(false);
					box.setKeyCode(Box.KEY_CODE_DEFAULT);
				}else if(box.isBeReleased()) {
					box.keyReleased(box.getKeyCode());
					box.setBeReleased(false);
					box.setKeyCode(Box.KEY_CODE_DEFAULT);
				}
				box.update();
				box = null;
			}	
		}
	}
	
	public static void keyPressed(int keyCode) {
		int j = size();
		if(j > 0 ) {
			Box box = ((Box)boxQuene.elementAt(j - 1));
			if(box.getKeyCode() == View.KEY_CODE_DEFAULT)
			  box.setKeyCode(keyCode);
			if(!box.isBePressed() && !box.isKeyLocked() && box.isKeyAvailable()) {
				box.setBePressed(true);
			}else {
				box.setKeyCode(View.KEY_CODE_DEFAULT);
			}
		}
	}
	public static void keyReleased(int keyCode) {
		int j = size();
		if(j > 0 ) {
			Box box = ((Box)boxQuene.elementAt(j - 1));
			if(box.getKeyCode() == View.KEY_CODE_DEFAULT)
			  box.setKeyCode(keyCode);
			if(!box.isBeReleased() && !box.isKeyLocked() && box.isKeyAvailable()) {
				box.setBeReleased(true);
			}else {
				box.setKeyCode(View.KEY_CODE_DEFAULT);
			}
		}
	}
	
	public static int size() {
		return size;
	}
}
