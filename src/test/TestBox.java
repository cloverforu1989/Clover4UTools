package test;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import com.clover4u.box.Box;
import com.clover4u.startup.GameSystem;
import com.clover4u.utils.Load;
import com.clover4u.utils.Mtd;

public class TestBox extends Box{
   Image img = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(0, 0, 640, 530);
		Mtd.paintNumber(100, 100, "1023456789", 0, img, -1, g);
		System.out.println(img);
	}
    
	public void freeRes() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		loadRes();
		setKeyLocked(false);
		
	}

	public void keyPressed(int arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		quit();
		
	}

	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void loadRes() {
		// TODO Auto-generated method stub
		img = Load.loadImage("/44444.png", false);
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

}
