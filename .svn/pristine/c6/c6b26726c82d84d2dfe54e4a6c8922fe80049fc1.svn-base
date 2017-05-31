package com.clover4u.paintLoading;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;

public final class PaintLoadingManager{
   /**
	 * @param args
	 */
	private static Vector plQuene = new Vector();
	private static int size=0;
	public static final void addPaintLoading(PaintLoading pl) {
		if(pl != null) {
			 plQuene.addElement(pl);
			size++;
			System.out.println("Ìí¼Óloading size=" + size());
		}
		 
	}
	public static final void removePaintLoading(PaintLoading pl) {
		System.out.println("×¼±¸~~É¾³ýloading size=" + size());
		if(pl != null) {
			pl.freeRes();
			 plQuene.removeElement(pl);
			size--;
			System.out.println("É¾³ýloading size=" + size());
			System.gc();
		}
		 
		 
	}
	
	
	public static void init() {
		
	} 
    
	public static void draw(Graphics g) {
		
		int j = size();
		if(j > 0) {
			((PaintLoading)plQuene.elementAt(0)).draw(g);
		}
	}
	public static int size() {
		return size;
	}
	public static void update() {
		int j = size();
		System.out.println("loading~~size = " + size());
		for(int i = 0; i < j; i++) {
			PaintLoading pl = ((PaintLoading)plQuene.elementAt(i));
			if(pl.isEnd()) {
				pl.endLoading();
				removePaintLoading(pl);
				j--;
				i--;
				pl = null;
				if(j == 0 || i==j - 1) {
				    break;
				}
			}else {
				pl.update();
			}
			
		}
	}
	
	
}
