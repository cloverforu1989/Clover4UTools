package com.clover4u.connection;

import java.util.Vector;

import test.FMMidlet;

import com.clover4u.startup.MainMidlet;
import com.clover4u.utils.Mtd;


public class ConnectionManager implements Runnable{

	/**
	 * @param args
	 */
	private static boolean sign = true;
	private static Vector connectionQuene = new Vector(10,1);
	private static int size;
	public static final void addOpenURL(OpenURL ou) {
		if(ou != null) {
			 connectionQuene.addElement(ou);
			 size ++;
			 System.out.println("添加链接===" + size);
			 
			 synchronized (MainMidlet.connectionThread) {
				
				 MainMidlet.connectionThread.notify();
			 }
		}
		 
	}
	public static int size() {
		return size;
	}
	public static final void removeOpenURL(int index) {
		     connectionQuene.removeElementAt(index);
			 size --;
			 System.out.println("删除链接===" + size);
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while(sign){
			int size = size();
			
			if(size > 0) {
				Object obj = connectionQuene.elementAt(0);
				if(obj != null) {
					((OpenURL)obj).openURL();
					System.out.println("请求结果:"+((OpenURL)obj).getResult());
				}
				removeOpenURL(0);
				obj = null;
			}else {
				synchronized (MainMidlet.connectionThread) {
					try {
						MainMidlet.connectionThread.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	
	public void destroy() {
		setSign(false);
		
	}
	public static boolean isSign() {
		return sign;
	}
	public static void setSign(boolean sign) {
		ConnectionManager.sign = sign;
	}
    
	
}
