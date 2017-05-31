package com.clover4u.scene;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.clover4u.paintLoading.PaintLoading;
import com.clover4u.utils.Constant;
import com.clover4u.view.View;

public abstract class SceneBasic implements View {

	/**
	 * @param args
	 */
	
	public static final int KEY_CODE_DEFAULT = -10000;
    public static final int LEFT_TOP = 0;
    public static final int LEFT_BOTTOM = 1;
    public static final int RIGHT_TOP = 2;
    public static final int RIGHT_BOTTOM = 3;
    public static final int HCENTER_VCENTER = 4;
    
	private boolean beQuit = false;
	private boolean display = true; 
	private boolean beUpdated = true; 
	private boolean bePressed = false;
	private boolean beReleased = false;
	private boolean keyLocked = true;
	private PaintLoading pl;
	private int step;
	
	
	private int curIndex = 0;
	private int keyCode =  KEY_CODE_DEFAULT;
	public boolean isBeUpdated() {
		return beUpdated;
	}
	public void setBeUpdated(boolean beUpdated) {
		this.beUpdated = beUpdated;
	}
	
	public boolean isBeQuit() {
		return beQuit;
	}
	public void setBeQuit(boolean beQuit) {
		this.beQuit = beQuit;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public void quit() {
		setKeyLocked(true);
		setBeQuit(true);
	}
	public boolean isBePressed() {
		return bePressed;
	}
	public void setBePressed(boolean bePressed) {
		this.bePressed = bePressed;
	}
	public int getCurIndex() {
		return curIndex;
	}
	public void setCurIndex(int curIndex) {
		this.curIndex = curIndex;
	}
	public int getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}
	public boolean isKeyLocked() {
		return keyLocked;
	}
	public void setKeyLocked(boolean keyLocked) {
		this.keyLocked = keyLocked;
	}
	public boolean isBeReleased() {
		return beReleased;
	}
	public void setBeReleased(boolean beReleased) {
		this.beReleased = beReleased;
	}
	public PaintLoading getPl() {
		return pl;
	}
	public void setPl(PaintLoading pl) {
		this.pl = pl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	

	
}
