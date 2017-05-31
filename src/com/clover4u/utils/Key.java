package com.clover4u.utils;

import javax.microedition.lcdui.Graphics;

import com.clover4u.view.View;

public abstract class Key implements View{
	public static final int[] getDefaultAvailableKeyArray() {
	  return (new int[]{KEY_0,KEY_1,KEY_2,KEY_3,KEY_4,KEY_5,KEY_6,KEY_7,KEY_8,KEY_9,//数字键
			KEY_OK,KEY_LEFT,KEY_RIGHT,KEY_UP,KEY_DOWN,//方向和确定键
			-11,-31,-7,0,-32,640});//返回键
   }
	
}
