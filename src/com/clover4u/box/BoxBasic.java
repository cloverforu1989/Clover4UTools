package com.clover4u.box;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.clover4u.paintLoading.PaintLoading;
import com.clover4u.utils.Constant;
import com.clover4u.view.View;
public abstract class BoxBasic implements View{

	/**
	 * @param args
	 */
	private int step;
	private boolean beQuit = false;
	private boolean display = true; 
	private boolean beUpdated = true; 
	private boolean bePressed = false;
	private boolean beReleased = false;
	private int quitTime = -1;
	private int curIndex = 0;
	private int keyCode =  -1000;
	private PaintLoading pl;
	private boolean keyLocked = true;
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
	
	//九宫格
	public static final void drawBox(int x, int y, int w, int h,int kind, int firstIndex, Image[] images,Graphics g) {
		// kind 0 1 2 3 4
		// direction 左上右下 0 1 2 3
		int w0 = images[0].getWidth();
		int h0 = images[0].getHeight();
		int x0 = x;
		int y0 = y;
		switch(kind) {
		case LEFT_TOP:
			break;
		case LEFT_BOTTOM:
			y0 -= h;
			break;
		case RIGHT_TOP:
			x0 += w;
			break;
		case RIGHT_BOTTOM:
			y0 -= h;
			x0 += w;
			break;
		case HCENTER_VCENTER:
			y0 -= h / 2;
			x0 -= w / 2;
			break;
		}
		int m = h / h0;//总行数
		int n = w / w0;//总列数
		System.out.println(m+"    " + n);
		if (kind >= 0 && kind <= 4 && w >= w0 && h >= h0) {
		        int index = 0;
				for (int i = 0; i < m + 2; i++) {//行 i
					for (int j = 0; j < n + 2; j++) {//列 j
						    if (i == 0 && j == 0) {//左上
								index = 0;
							}else if (i == 0 && j < n + 1) {//上
								index = 1;
							}else if (i == 0 && j == n + 1) {//右上
								index = 2;
							}else if (i > 0 &&  i < m + 1 && j == n + 1) {//右
								index = 3;
							}else if (i == m + 1 && j == n + 1) {//右下
								index = 4;
							}else if (i == m + 1 && j > 0 && j < n + 1) {//下
								index = 5;
							}else if (i == m + 1 && j == 0) {//左下
								index = 6;
							}else if (i > 0 && i < n + 1 && j == 0) {//左
								index = 7;
							}else {
								index = 8;
							}
						
						g.drawImage(images[index + firstIndex], x0 + j * w0, y0
								+ i * h0, Constant.TRANS[0]);
					}
				}
				

	}

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
	public boolean isKeyLocked() {
		return keyLocked;
	}
	public void setKeyLocked(boolean keyLocked) {
		this.keyLocked = keyLocked;
	}
	public int getQuitTime() {
		return quitTime;
	}
	public void setQuitTime(int quitTime) {
		this.quitTime = quitTime;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	
	
}
