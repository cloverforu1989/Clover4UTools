package com.clover4u.view;

import javax.microedition.lcdui.Graphics;

import com.clover4u.utils.IListener;

public interface View {

	/**
	 * @param args
	 */
	public static final int KEY_UP = -1;
	public static final int KEY_LEFT = -3;
	public static final int KEY_RIGHT = -4;
	public static final int KEY_DOWN = -2;
	public static final int KEY_OK = -5;//È·¶¨¼ü
	public static final int KEY_0 = 48;
	public static final int KEY_1 = 49;
	public static final int KEY_2 = 50;
	public static final int KEY_3 = 51;
	public static final int KEY_4 = 52;
	public static final int KEY_5 = 53;
	public static final int KEY_6 = 54;
	public static final int KEY_7 = 55;
	public static final int KEY_8 = 56;
	public static final int KEY_9 = 57;
	public static final int LEFT_TOP = 0;
    public static final int LEFT_BOTTOM = 1;
    public static final int RIGHT_TOP = 2;
    public static final int RIGHT_BOTTOM = 3;
    public static final int HCENTER_VCENTER = 4;
    public static final int KEY_CODE_DEFAULT = -10000;
    public static final int ANCHOR_LEFT_BOTTOM = Graphics.LEFT | Graphics.BOTTOM;
    public static final int ANCHOR_RIGHT_BOTTOM = Graphics.RIGHT | Graphics.BOTTOM;
    public static final int ANCHOR_RIGHT_TOP = Graphics.RIGHT | Graphics.TOP;
    public static final int ANCHOR_LEFT_TOP = Graphics.LEFT | Graphics.TOP;
    public static final int ANCHOR_HCENTER_VCENTER = Graphics.HCENTER | Graphics.VCENTER;
    public abstract void setKeyLocked(boolean sign);
    public abstract void setDisplay(boolean display);
    public abstract void init();
	public abstract void draw(Graphics g);
	public abstract void update();
	public abstract void keyPressed(int keyCode);
	public abstract void keyReleased(int keyCode);
	public abstract void loadRes();
	public abstract void freeRes();
	public abstract void quit();
	public abstract void setQuitListener(IListener listener);
	public abstract boolean isKeyAvailable();
}
