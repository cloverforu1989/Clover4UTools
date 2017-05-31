package test;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.obex.PasswordAuthentication;

import com.clover4u.scene.Scene;
import com.clover4u.scene.SceneBasic;
import com.clover4u.utils.IListener;
import com.clover4u.utils.Mtd;
import com.clover4u.view.View;

public class TestScene extends Scene {
	Vector path = new Vector();// 存储行走路径
	boolean paintBg = false;
	public static int counter = 0;

	public class Grid {
		int i;
		int j;
		int id = counter++;
	}

	public void init() {
		// TODO Auto-generated method stub

	}

	int gw = 64;
	int gh = 53;
	int sw = 640;
	int sh = 530;
	int startI = 4, startJ = 2, endI = 0, endJ = 9;

	byte[][] grid = new byte[][] { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
			{ 0, 0, 0, 0, 1, 0, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 1, 0, 1, 1, 1, 0 }, 
			{ 0, 0, 3, 0, 1, 0, 1, 0, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, 
			{ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 1, 1, 1, 1 }, 
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
			

	};
   
	public double getDistance(int i, int j, int i2, int j2) {
		//return Mtd.abs(i - i2) + Mtd.abs(j - j2);//只能横竖走
		return Mtd.sqrt2((i - i2) * (i - i2) + (j - j2) * (j - j2)) ;
	}
    
	double minDistance = -1;
	double distanceTemp = 0;
	int i;
	int j;
	int iTemp;
	int jTemp;
	boolean sign = false;

	public void setParams() {
		System.out.println("i = " + i + " j =" + j);
		Mtd.sleep(100);
		if (grid[i][j] == 1 || grid[i][j] == 3 || isPassedBy(i , j)) {
			return;
		}
			
		distanceTemp = getDistance(i, j, endI, endJ);
		System.out.println("distanceTemp = " + distanceTemp);
		if (distanceTemp < minDistance || minDistance == -1) {
			minDistance = distanceTemp;
			iTemp = i;
			jTemp = j;
		}
	}
    
	public void getGridList(Graphics g) {
		
		if(startI == endI && startJ == endJ) return;
		i = startI;
		j = startJ;
		int n = 0;// 记录周围有几个格子可以走
		boolean left  = false;
		boolean right = false;
		if (startJ < grid[0].length - 1) {// 右
			n++;
			right = true;
			i = startI;
			j = startJ + 1;
			setParams();

		}
		if (startJ > 0) {// 左
			n++;
			left = true;
			i = startI;
			j = startJ - 1;
			setParams();

		}
		// 上
		if (startI > 0) {
			n++;
			i = startI - 1;
			j = startJ;
			setParams();
			if (left) {
				n++;
				j = startJ - 1;
				setParams();

			}
			if (right) {
				n++;
				j = startJ + 1;
				setParams();

			}
		}
        
		if (startI < grid.length - 1) {// 下
			n++;
			i = startI + 1;
			j = startJ;
			setParams();
			if (left) {
				n++;
				j = startJ - 1;
				setParams();
			}

			if (right) {
				n++;
				j = startJ + 1;
				setParams();
			}
				

		}
		startI = iTemp;
		startJ = jTemp;
		
		if(!isPassedBy(startI, startJ)) {
			Grid grid = new Grid();
			grid.i = startI;
			grid.j = startJ;
			path.addElement(grid);
		}
		 
		g.setColor(0xff0000);
		drawGrid(startI, startJ,g);
		System.out.println(startI+" "+startJ + " n =" + n);
		minDistance = -1;
		printPath();
		// }
		// return v;
	}
     public void printPath() {
		
		int size = path.size();
		for(int m = 0;  m < size; m++) {
			Grid g = (Grid)path.elementAt(m);
			System.out.print("("+g.i+","+g.j+")");
		}
		System.out.println();
		
	}
	public boolean isPassedBy(int i, int j) {
		
		int size = path.size();
		for(int m = 0;  m < size; m++) {
			Grid g = (Grid)path.elementAt(m);
			if(g.i == i && g.j == j) {
				return true;
			}
		}
		return false;
	}
	public void drawGrid(int i, int j, Graphics g) {
		g.fillRect(j * gw + 2, i * gh + 2, gw - 4, gh - 4 );
	}
	public void drawGrid(int _i, int _j, Grid grid,  Graphics g) {
		g.fillRect(_j * gw + 2, _j * gw + 2, gw - 4, gh - 4);
		g.setColor(0x000);
		g.drawString(grid.id+"", _j * gw + 2, _j * gw + 2, View.ANCHOR_LEFT_TOP);
	}
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!paintBg) {
			g.setColor(0xffffff);
			g.fillRect(0, 0, sw, sh);
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					switch (grid[i][j]) {
					case 0:

						break;
					case 1:
						g.setColor(0x886600);
						drawGrid(i, j, g);
						break;
					case 2:
						g.setColor(0x00ff00);
						drawGrid(i, j, g);
						break;
					case 3:
						g.setColor(0x000);
						drawGrid(i, j, g);
						break;
					}
				}
				
			}

			g.setColor(0x000);
			for (int i = 0; i < sh / gh; i++) {// 横线
				g.drawLine(0, i * gh, sw, i * gh);
			}
			for (int i = 0; i < sw / gw; i++) {// 横线
				g.drawLine(i * gw, 0, i * gw, sh);
			}
			paintBg = true;
		}
		getGridList(g);
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void keyPressed(int keyCode) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(int keyCode) {
		// TODO Auto-generated method stub

	}

	public void loadRes() {
		// TODO Auto-generated method stub

	}

	public void freeRes() {
		// TODO Auto-generated method stub

	}

}
