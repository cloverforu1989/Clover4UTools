package com.clover4u.utils;

import javax.microedition.lcdui.Graphics;

//游戏中其他物体对象皆继承此类
public abstract class MyObject {
	
	public int  x;//物体图片x坐标
	public int  y;//物体图片y坐标
	
	public int  objId;//物体 种类id 比如人物、道具 等
	public int  w;//物体当前宽度
	public int  h;//物体当前高度
	public int  dx;//移动x速度
	public int  dy;//移动y速度
	public int  dxTemp;
	public int  dyTemp;
	//要附加的速度 比如小兵在地图上 地图滚动的时候 小兵的速度+地图速度=小兵真正的移动速度
	public int  dx2;
	public int  dy2;
	
	//画图时所需要的 坐标调整值
	public int  addedX;
	public int  addedY;
	
	//画图时所需要的速度调整值
	public int  addedX_dx;
	public int  addedY_dy;
	
	public int  actionState;//行为状态值
	public int  actionStateTemp;//行为状态值
	public int  yzAddedX;//阴影x坐标
	public int  yzAddedY;//阴影y坐标
	public int  step;//状态计时器 受状态变化音响
	public int  stepTemp;//计时器暂存变量
	public int  id;//物体标志id
	public int  layerId;//物体组成部分所在所在图层id
	public int  aliveStep;//物体从产生开始的存活时间计时器 只受暂停 事件影响
	public int  faceDirection;//物体朝哪边 东南西北
    public abstract void paint (Graphics g);//物体需要实现的方法：画图
    public abstract void update();//物体需要实现的方法：下一帧 要呈现的画面 数据的更新
    
}
