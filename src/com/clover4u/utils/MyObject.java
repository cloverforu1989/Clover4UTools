package com.clover4u.utils;

import javax.microedition.lcdui.Graphics;

//��Ϸ�������������Լ̳д���
public abstract class MyObject {
	
	public int  x;//����ͼƬx����
	public int  y;//����ͼƬy����
	
	public int  objId;//���� ����id ����������� ��
	public int  w;//���嵱ǰ���
	public int  h;//���嵱ǰ�߶�
	public int  dx;//�ƶ�x�ٶ�
	public int  dy;//�ƶ�y�ٶ�
	public int  dxTemp;
	public int  dyTemp;
	//Ҫ���ӵ��ٶ� ����С���ڵ�ͼ�� ��ͼ������ʱ�� С�����ٶ�+��ͼ�ٶ�=С���������ƶ��ٶ�
	public int  dx2;
	public int  dy2;
	
	//��ͼʱ����Ҫ�� �������ֵ
	public int  addedX;
	public int  addedY;
	
	//��ͼʱ����Ҫ���ٶȵ���ֵ
	public int  addedX_dx;
	public int  addedY_dy;
	
	public int  actionState;//��Ϊ״ֵ̬
	public int  actionStateTemp;//��Ϊ״ֵ̬
	public int  yzAddedX;//��Ӱx����
	public int  yzAddedY;//��Ӱy����
	public int  step;//״̬��ʱ�� ��״̬�仯����
	public int  stepTemp;//��ʱ���ݴ����
	public int  id;//�����־id
	public int  layerId;//������ɲ�����������ͼ��id
	public int  aliveStep;//����Ӳ�����ʼ�Ĵ��ʱ���ʱ�� ֻ����ͣ �¼�Ӱ��
	public int  faceDirection;//���峯�ı� ��������
    public abstract void paint (Graphics g);//������Ҫʵ�ֵķ�������ͼ
    public abstract void update();//������Ҫʵ�ֵķ�������һ֡ Ҫ���ֵĻ��� ���ݵĸ���
    
}
