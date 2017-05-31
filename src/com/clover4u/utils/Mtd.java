package com.clover4u.utils;
import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


//常用方法 Method
/**
 * @author Clover4Green
 *
 */
public class Mtd {
	
		public static String formatIntArrToStr(int[] numbers,String c) {
			StringBuffer sb = new StringBuffer();
	    	if(numbers != null) {
	    		for(int i = 0; i < numbers.length; i ++) {
		    		sb.append(numbers[i]);
		    		if(i <  numbers.length - 1) {
		    			sb.append(c);
		    		}
		    	} 
	    	}
	    	
	    	return sb.toString();
	    }
		
	  public static int[] formatStrArrToIntArr(String[] numbers) {
	    	int[] num = new int[numbers.length];
	    	for(int i = 0; i < num.length; i ++) {
	    		num[i] = Integer.parseInt(numbers[i]);
	    	} 
	    	return num;
	    }
	// public static void main(String args[]) {
	// double a = 99999999999999.0;
	// //System.out.println("1 " + sqrt2(a));
	// //System.out.println("2 " + sqrt2(a));
	// //System.out.println("3 " + Math.sqrt(a));
	// for (int i = 0; i < 20; i++) {
	// goodLuck(0.5);
	// }
	// }
  public static double sqrt(double data){//牛顿迭代算法
	        if(data == 0) return 0;
		    double x0,x1;
		    x0 = data / 2;
		    do{
		       x1 = x0;
		       x0 = (x1 + data /x1) / 2;
		    }while(abs(x0-x1)>= 1e-6 );
		    return x0;
}
   public static  double sqrt4(double x)         
	  {
	      
	      double g=x;
	      while(abs(g*g-x)>0.000001)
	      {
	          g=(g+x/g)/2;
	      }
	      return g;
	}   
	public static double sqrt3(double number) {
		double x, x0;
		x = 1.5;
		do {
			x0 = x;
			x = x / 2 + (number / 2) / x;
		} while (abs(x - x0) >= 1e-10);
		return x;
	}

	public static double sqrt2(double n) {
		double x1 = n, x2 = n;
		if (n == 0)
			return 0;
		do {
			//x1=(x2*2+n/x2/x2)/3;//求立方根的
			//x2=(x1*2+n/x1/x1)/3; //求立方根的
			x1 = (x2 + n / x2) / 2; // 求平方根的
			x2 = (x1 + n / x1) / 2; // 求平方根的
		} while (abs(x1 - x2) >= 1e-5);
		return x2;
	}

	public static void freeArray(Object[] objArray) {

		if (objArray != null) {
			for (int i = objArray.length - 1; i >= 0; i--) {
				objArray[i] = null;

			}
			System.gc();
		}

	}

	public static void freeArray(Object[] objArray, int startIndex, int endIndex) {

		if (objArray != null) {
			for (int i = startIndex; i <= endIndex; i++) {
				objArray[i] = null;

			}
			System.gc();
		}

	}

	public static void freeArray(int[][] intArray) {
		if (intArray != null) {
			for (int i = intArray.length - 1; i >= 0; i--) {
				intArray[i] = null;

			}
			System.gc();
		}
	}

	public static void freeArray(Object[][] objArray) {
		if (objArray != null) {
			for (int i = objArray.length - 1; i >= 0; i--) {
				freeArray(objArray[i]);
				objArray[i] = null;

			}
			System.gc();
		}

	}

	// 计算绝对值
	public static final int abs(int num) {
		if (num > 0) {
			return num;
		} else
			return -num;
	}

	public static final double abs(double num) {
		if (num > 0) {
			return num;
		} else
			return -num;
	}

	// 物体是否发生碰撞 水平距离允许误差 为 5 垂直误差 为8
	public static boolean isImpact(int x1, int y1, int halfwidth1,
			int halfHeight1, int x2, int y2, int halfwidth2,
			int halfHeight2, int errorLimitX, int errorLimitY) {
		// ////System.out.println(" image w="+boss.width);
		if (abs(x1 - x2) <= halfwidth1 + halfwidth2 + errorLimitX
				&& abs(y1 - y2) <= halfHeight1 + halfHeight2 + errorLimitY) {
			return true;
		}
		return false;
	}

	// 得到一个min 至 max 之间的没正整数
	public static final int getRandomNum(int min, int max) {
		int temp = 0;
		if (max < min) {
			temp = max;
			max = min;
			min = temp;
		}
		return Constant.r.nextInt(max + 1 - min) + min;
	}
    public static final void addNumber(int[] s, int index, int min, int max) {
    	while(true) {
    		int n = getRandomNum(min, max);
    		if(getIndex(s, n, 0) == -1) {
    			s[index] = n;
    			break;
    		}
    	}
    }
	// 得到一个min 至 max - 1 之间的没有重复元素的数组 正整数 max >= min len <= max-min
	public static final int[] getRandomArray(int min, int max, int len) {
		int temp = 0;
		if (max < min) {
			temp = max;
			max = min;
			min = temp;
		}
		int result = 0;
		int counter = 0;
		int[] array = null;

		boolean flag;
		// Random r = new Random();
		if (max != min && len <= max - min + 1 && len > 0 && min >= 0) {
			array = new int[len];
			initIntArray(array, -1);
			while (true) {
				flag = false;
				result = Constant.r.nextInt(max - min) + min;

				for (int i = 0; i <= counter; i++) {
					if (array[i] == result) {
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				if (flag) {
					array[counter] = result;
					counter++;
				}
				if (counter > len - 1) {
					break;
				}
			}
			// System.out.println("counter = " + counter);
		}

		return array;

	}

	// 用一定帧数时间靠近某点得到x轴和y轴方向的速度
	public static double[] getXYSpeed(double x, double y, double x0, double y0,
			double time, double errorLimitX, double errorLimitY) {
		double distantX = x0 - x;
		double distantY = y0 - y;
		double speedX = 0;
		double speedY = 0;
		if (abs(distantX) > errorLimitX) {
			speedX = distantX / time;
		}

		if (abs(distantY) > errorLimitY) {
			speedY = distantY / time;
		}

		return new double[] { speedX, speedY };
	}

	// 用一定速度飞向某点
	public static double[] getXYSpeed2(int x, int y, int x0, int y0, int v,
			int errorLimitX, int errorLimitY) {
		double speedX = 0;
		double speedY = 0;
		int distantX = x0 - x;
		int distantY = y0 - y;
		int m = distantX * distantX;
		int n = distantY * distantY;
		int c = m + n;
		double sqrtC = sqrt(c);

		if (abs(distantX) > errorLimitX) {
			speedX = v * (distantX) / sqrtC;
		}

		if (abs(distantY) > errorLimitY) {
			speedY = v * (distantY) / sqrtC;
		}

		return new double[] { speedX, speedY };

	}

	// //用一定速度飞向某点
	// public static int[] getXYSpeed2(int x, int y, int x0, int y0, int v , int
	// errorLimitX ,int errorLimitY ) {
	// int speedX = 0;
	// int speedY = 0;
	// int distantX = x0 - x;
	// int distantY = y0 - y;
	// if(abs(distantX) > errorLimitX) {
	// speedX = v * (distantX)/(abs(distantX) + abs(distantY));
	// }
	//
	// if(abs(distantY) > errorLimitY) {
	// speedY = v * (distantY)/(abs(distantX) + abs(distantY));
	// }
	//
	// return new int[] {speedX, speedY};
	//
	// }

	// 得到x,y 关于 x0 y0的对称点
	public static int[] getSymmetryPoint(int x, int y, int x0, int y0) {
		return new int[] { 2 * x0 - x, 2 * y0 - y };
	}

	// int minX, int maxX, int minY, int maxY 左右上下边界
	public static boolean outOfBound(int x, int y, int width, int height,
			int minX, int maxX, int minY, int maxY) {
		if ((x - (width >> 1) <= minX || x + (width >> 1) >= maxX
				|| y - (height >> 1) <= minY || y + (height >> 1) >= maxY)) {
			return true;
		}

		return false;
	}

	// 得到整数的位数
	public static int getIntNumber(int interger) {

		int number = 1;
		while (true) {
			interger /= 10;
			if (interger > 0) {
				number++;
			} else {
				break;
			}
		}
		return number;

	}

	// 得到正整数的每1位数
	public static int[] getIntNumberArray(int interger) {
		interger = abs(interger);
		int counter = 1;
		int number[] = new int[getIntNumber(interger)];
		while (true) {
			number[counter - 1] = interger % 10;
			// //System.out.println("=====number["+(counter - 1)+"]=" +
			// number[counter - 1]);
			interger /= 10;
			if (interger > 0) {
				counter++;
			} else {
				break;
			}
		}
		return number;
	}

	//
	// 概率抽取
	public static final boolean goodLuck(double probability, double k) {
		// Constant.r = new Random();
		boolean sign = false;
		if (probability > 1) {
			probability = 1;
		}
		if (k < 100) {
			k = 100;
		}
		int luckyNumber = (int) (probability * k);
		// Constant.r.setSeed(System.currentTimeMillis());
		int number = Constant.r.nextInt((int) k);
		// System.out.println("number = " + number);
		if (number < luckyNumber) {
			sign = true;
		}
		// Constant.r = null;
		return sign;
	}
	
	// 概率抽取
		public static final boolean goodLuck(int probability, int k) {
			// Constant.r = new Random();
			boolean sign = false;
			if (probability > 100) {
				probability = 100;
			}
			if (k < 100) {
				k = 100;
			}
			int luckyNumber = (int) (probability * k / 100);
			// Constant.r.setSeed(System.currentTimeMillis());
			int number = Constant.r.nextInt(k);
			// System.out.println("number = " + number);
			if (number < luckyNumber) {
				sign = true;
			}
			// Constant.r = null;
			return sign;
		}

	// 统计一个整数数组中含有的不同元素以及数量
	public static final int[][] getKindAndNumOfArray(int[] enemyId) {
		int[][] kindsAndNum = new int[2][enemyId.length];
		initIntArray(kindsAndNum, -1);
		for (int i = 0; i < enemyId.length; i++) {
			int index = getIndex(kindsAndNum[0], enemyId[i], 0);
			if (index == -1) {
				index = getIndex(kindsAndNum[0], -1, 0);
				kindsAndNum[0][index] = enemyId[i];
				kindsAndNum[1][index] = 1;
			} else {
				kindsAndNum[1][index] += 1;
			}
		}

		// 第一行存id 第二行存数量
		return kindsAndNum;
	}

	public static final void initIntArray(int[][] intArray, int para, int addedNum, int startIndex, int endIndex) {
		for (int i = startIndex; i <= endIndex; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = para;
			}
			para += addedNum;
		}
	}

	public static final void initIntArray(int[][] intArray, int para, int addedNum, int startIndex, int endIndex, int[] cosIndex) {
		for (int i = startIndex; i <= endIndex; i++) {
			for (int j = 0; j < cosIndex.length; j++) {
				intArray[i][cosIndex[j]] = para;
			}
			para += addedNum;
		}
		
	}
	public static final void initIntArray(int[][] intArray, int para) {
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = para;
			}
		}
	}
	public static final void initIntArray(int[] intArray, int para) {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = para;
		}
	}
	//递增序列
	public static final void initIntArray(int[] intArray, int startParam, int addedNum, int startIndex, int endIndex) {
		if (startIndex < 0) {
			startIndex = 0;
		}
		
		if (endIndex > intArray.length - 1) {
			endIndex = intArray.length - 1;
		}
		
		for (int i = startIndex; i <= endIndex; i++) {
			intArray[i] = startParam;
			startParam += addedNum;
		}
	}
	public static final void initIntArray(int[] intArray, int para,
			int startIndex, int endIndex) {
		if (startIndex < 0) {
			startIndex = 0;
		}
		
		if (endIndex > intArray.length - 1) {
			endIndex = intArray.length - 1;
		}
		
		for (int i = startIndex; i <= endIndex; i++) {
			intArray[i] = para;
       }
	}

	// 元素不重複的數組中查找一個數并返回下標
	public static final int getIndex(int[] intArray, int value, int startIndex) {
		int index = -1;
		for (int i = startIndex; i < intArray.length; i++) {
			if (intArray[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 元素不重複的數組中查找一個數并返回下標
	public static final int getIndex(int[] intArray, int[] valueArray,
			int startIndex) {
		int index = -1;
		for (int i = intArray.length - 1; i >= startIndex; i--) {
			for (int j = valueArray.length - 1; j >= 0; j--)
				if (intArray[i] == valueArray[j]) {
					index = i;
					break;
				}
		}
		return index;
	}

	// 攻击类型 圆形区域 1 十字架 2
	public static final void drawAtkRegion(int x, int y, int filled,
			int atkDistant, Graphics g) {
		int d = atkDistant << 1;
		if (filled == 0)
			g.drawRoundRect(x - atkDistant, y - atkDistant, d, d, d, d);
		else if (filled == 1) {
			g.fillRoundRect(x - atkDistant, y - atkDistant, d, d, d, d);
		}
	}
	//单张图
	/**
	 * @param x
	 * @param y
	 * @param number
	 * @param imgKind 0 横着  1竖着
	 * @param numImg
	 * @param kind -1左对齐 0 居中 1 右对齐 2斜对齐左高右低
	 * @param g
	 */
	public static final void paintNumber(int x, int y, String number,
			int imgKind, Image numImg, int kind, Graphics g) {
		//imgKind 0 横着  1竖着
		// kind -1左对齐 0 居中 1 右对齐 2斜对齐左高右低
		int clipW = g.getClipWidth();
		int clipH = g.getClipHeight();
		int clipX = g.getClipX();
		int clipY = g.getClipY();
		if(!isNumber(number)) {
			drawLongString(number, x, y, 1, clipW, kind - 1, g);
			return;
		}
		int w = 0;
		int h = 0;
		int lx = 0;
		if(imgKind == 0) {
			w = numImg.getWidth() / 10;
			h = numImg.getHeight();
		}else if(imgKind == 1) {
			w = numImg.getWidth();
			h = numImg.getHeight() / 10;
		}
		int size = number.length();
		if (kind == -1) {
			lx = x;
		} else if (kind == 0) {
			lx = x - size  * w / 2 ;
		}else if (kind == 1) {
			lx = x - size * w;
		}
        for (int i = 0; i <= size - 1; i++) {
        	int x0 = lx + i * w;
			if(imgKind == 0) {
				drawImage(numImg, x0, y - (h >> 1), Integer.parseInt(number.charAt(i) + "") * w, 0, w, h, g);
			}else if(imgKind == 1) {
				drawImage(numImg, x0, y - (h >> 1), 0, Integer.parseInt(number.charAt(i) + "") * h, w, h, g);
            }
		}
		
	}
	
	public static final void paintNumber(int x, int y, int number, int firstIndex, Image[] numbersImages, int kind, Graphics g) {
		// para 0 small 1 large
		// kind -1左对齐 0 居中 1 右对齐 2斜对齐左高右低
		
		number = abs(number);
		int w = numbersImages[firstIndex].getWidth();
		int h = numbersImages[firstIndex].getHeight();
		int[] numberArray = getIntNumberArray(number);
		int size = numberArray.length;
		int lx = 0;
		if (kind == -1) {
			lx = x;
		} else if (kind == 0) {
			lx = x - size  * w / 2 ;
		}else if (kind == 1) {
			lx = x - size * w;
		}
        for (int i = 0; i <= size - 1; i++) {
        	int x0 = lx + i * w;
        	g.drawImage(numbersImages[firstIndex + numberArray[i]], x0, y - (h >> 1), Constant.TRANS[0]);
		}
			
   }

	public static final void paintNumber(int x, int y, int number, int firstIndex, Image[] numbersImages, int kind, int addW,
			int addH, Graphics g) {
		// para 0 small 1 large
		// kind -1左对齐 0 居中 1 右对齐 2斜对齐左高右低
		// addW x 错开 addHy 错开
		number = abs(number);
		int w = numbersImages[firstIndex].getWidth() + addW;
		int h = numbersImages[firstIndex].getHeight();
		int[] numberArray = getIntNumberArray(number);
		int size = numberArray.length;
		int lx = 0;
		if (kind == -1) {
			lx = x;
		} else if (kind == 0) {
			lx = x - size  * w / 2 ;
		}else if (kind == 1) {
			lx = x - size * w;
		}
        for (int i = 0; i <= size - 1; i++) {
        	int x0 = lx + i * w;
        	g.drawImage(numbersImages[firstIndex + numberArray[i]], x0, y - (h >> 1) + addH * i, Constant.TRANS[0]);
		}
		

	}

	public static int getNumberLen(String number, int[] _w) {
		int len = 0;
		for(int i = number.length() - 1; i < 0; i --) {
			len += _w[Integer.parseInt(number.charAt(i)+"")];
		}
		
		return len;
	}
	
	/**
	 * @param x
	 * @param y
	 * @param number
	 * @param firstIndex
	 * @param numbersImages
	 * @param kind  -1左对齐 0 居中 1 右对齐
	 * @param g
	 */
	public static void paintNumber(int x, int y, String number, int firstIndex, Image[] numbersImages, int kind, Graphics g) {
		if(!isNumber(number)) {
			drawLongString(number, x, y, 1, 640, kind - 1, g);
			return;
		}
		int[] _w = new int[10];
		int halfH = numbersImages[firstIndex].getHeight() / 2;
		for(int i = 0; i < 10; i ++) {
			_w[i] = numbersImages[i + firstIndex].getWidth();
		}
        int x0 = 0;
        int numberW = getNumberLen(number, _w);
        int size = number.length();
        if (kind == -1) {
			x0 = x;
		} else if (kind == 0) {
			x0 = x - (numberW / 2);
		} else if (kind == 1) {
			x0 = x - numberW;
		}
        
		for (int i = 0; i <= size - 1; i++) {
			int n = Integer.parseInt(number.charAt(i) + "");
			g.drawImage(numbersImages[firstIndex + n], x0 , y - halfH, Constant.TRANS[0]);
			x0 += _w[n];

		}

	}
	
	public static final void paintHpLine(double x, double y, int hp, int oriHp, int w, int h, Image image, Graphics g) {
		double pp = hp * 1.0 / oriHp;
		g.setColor(255, 0, 0);
		g.fillRect((int) (x - w / 2.0), (int) (y - h / 2.0), (int) (1.0 * w * pp), h);
		g.setColor(255, 255, 255);
		g.drawImage(image, (int) (x - w / 2.0 - 2), (int) (y - h / 2.0) - 2, Constant.TRANS[0]);
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
		case Constant.LEFT_TOP:
			break;
		case Constant.LEFT_BOTTOM:
			y0 -= h;
			break;
		case Constant.RIGHT_TOP:
			x0 += w;
			break;
		case Constant.RIGHT_BOTTOM:
			y0 -= h;
			x0 += w;
			break;
		case Constant.HCENTER_VCENTER:
			y0 -= h / 2;
			x0 -= w / 2;
			break;
		}
		x0 -= w0;
		y0 -= h0;
		int m = h / h0;//总行数
		int n = w / w0;//总列数
		if (kind >= 0 && kind <= 4 && w >= w0 && h >= h0) {
		        int index = 0;
				for (int i = 0; i < h / h0 + 2; i++) {//行 i
					for (int j = 0; j < w / w0 + 2; j++) {//列 j
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
	public static final void drawBox(int x, int y, int w, int h, int kind,
			Image[] images, int firstIndex, int len, int len2, int TRANSection,
			int onFocus, Graphics g) {
		// kind 0 1 2 3 4
		// TRANSection 左上右下 0 1 2 3
		if (onFocus == 1) {
			if (TRANSection < 0 || TRANSection > 3) {
				TRANSection = 0;
			}
			
			if (len2 <= 0) {
				len2 = 1;
			}
			
			if (kind >= 0 && kind <= 4 && w >= 10 && h >= 10) {
				// Image[] images = new Image[5];
				// images[0] = Load.loadImage("/box/"+kind+"-1.png", true);
				// images[1] = Load.loadImage("/box/"+kind+"-2.png", true);
				// images[2] = Image.createImage(images[0], 0, 0, 10, 10,
				// Constant.TRANS[4]);
				// images[3] = Image.createImage(images[2], 0, 0, 10, 10,
				// Constant.TRANS[5]);
				// images[4] = Image.createImage(images[3], 0, 0, 10, 10,
				// Constant.TRANS[6]);
				int index = 0;
				for (int i = 0; i < h / 10 + 2; i++) {
					for (int j = 0; j < w / 10 + 2; j++) {
						if (i == 0 && j == 0) {
							index = 0;
						} else if (i == 0 && j == w / 10 + 1) {
							index = 1;
						} else if (i == h / 10 + 1 && j == 0) {
							index = 3;
						} else if (i == h / 10 + 1 && j == w / 10 + 1) {
							index = 2;
						} else {
							index = 4;
						}
						// //System.out.println("images = " + images +
						// " images[index + firstIndex]" + images[index +
						// firstIndex]);
						// System.out.println(images);
						g.drawImage(images[index + firstIndex], x + j * 10, y
								+ i * 10, Constant.TRANS[0]);
					}
				}
				if (len > 0 && len2 > 0) {
					switch (TRANSection) {
					case 0:// 左
						for (int i = 0; i < len; i++) {
							if (i == len - 1) {
								g.drawImage(images[firstIndex],
										x - i * 10 - 10, y + h - (len2 - 1)
												* 10, Constant.TRANS[0]);
							} else
								g.drawImage(images[firstIndex + 4], x - i * 10
										- 10, y + h - (len2 - 1) * 10,
										Constant.TRANS[0]);
						}
						break;
					case 1:
						for (int i = 0; i < len; i++) {
							if (i == len - 1) {
								g.drawImage(images[firstIndex], x + len2 * 10,
										y - i * 10, Constant.TRANS[0]);
							} else
								g.drawImage(images[firstIndex + 4], x + len2
										* 10, y - i * 10, Constant.TRANS[0]);
						}
						break;
					case 2:
						for (int i = 0; i < len; i++) {
							if (i == len - 1) {
								g.drawImage(images[firstIndex + 2], x + w / 10
										* 10 + i * 10 + 20, y + h - (len2 - 1)
										* 10, Constant.TRANS[0]);
							} else
								g.drawImage(images[firstIndex + 4], x + w / 10
										* 10 + i * 10 + 20, y + h - (len2 - 1)
										* 10, Constant.TRANS[0]);
						}
						break;
					case 3:
						for (int i = 0; i < len; i++) {
							if (i == len - 1) {
								g.drawImage(images[firstIndex + 3], x + len2
										* 10, y + h + i * 10 + 20,
										Constant.TRANS[0]);
							} else
								g.drawImage(images[firstIndex + 4], x + len2 * 10, y + h + i * 10 + 20, Constant.TRANS[0]);
						}
						break;
					}

				}

			}
		}

	}
    
	public static final int getSumOfIntArray(int[] intArray) {
		int sum = 0;
		if (intArray != null) {
			for (int i = intArray.length - 1; i >= 0; i--) {
				sum += intArray[i];
			}
		}
		return sum;
	}

	// 已知当前时刻松鼠和怪物x坐标分别为 x1 x2 怪物速度为 dx2 dx2 子弹下落的时间为 t 求子弹要击中怪物的水平速度 dx【简单相遇问题】
	public static final double getDx(double x1, double x2, double dx2, double t) {
		double dx1 = 0;// x1 + t * dx1 = x2 + t * dx2
		dx1 = (x2 - x1) / t + dx2;
		return dx1;
	}
   
	/**识别跳行符 \n
	 * @param str
	 * @param x
	 * @param y
	 * @param jiange
	 * @param w
	 * @param kind kind 对齐方式 0左 1居中 2右
	 * @param g
	 */
	public static final void AjustDrawString(String str, int x, int y,
			int jiange, int w, int kind, Graphics g){
		String[] m = spliteStr(str,"\n");
//		for(int i = 0; i < m.length; i++) {
//			System.out.println(m[i]);
//		};
		if (w <= 0) {
			w = 1;
		}
		Font f = g.getFont();
		int h = f.getHeight();
		StringBuffer s = new StringBuffer();
		int n = 0;
		int trans = 0;
		int _w = 0;
		int wTemp = w;
		if (kind == 1) {
			_w = w >> 1;
			trans = Constant.TRANS[0];
		} else if (kind == 0) {
			trans = Constant.TRANS[0];
		} else if (kind == 2) {
			trans = Constant.TRANS[1];
		}
		for(int j = 0; j < m.length; j++) {
			w = wTemp;
			if(f.stringWidth(m[j]) < w) {
				w = f.stringWidth(m[j]);
			}
			for (int i = 0; i <m[j].length(); i++) {
				s.append(m[j].charAt(i));
				if (f.stringWidth(s.toString()) >= w) {
					g.drawString(s.toString(), x - _w, y + n * (jiange + h), trans);
					s.delete(0, s.length());
					n++;
				}else {
					if (i == m[j].length() - 1) {
						g.drawString(s.toString(), x - _w, y + n * (jiange + h),
								trans);
						s.delete(0, s.length());
						n++;
					}
				}
			}
		}
		
		
        freeArray(m);
        m = null;
		s = null;
		f = null;
		
	}
	
	/**将一个长字符串拆分成几行 不识别跳行
	 * @param str
	 * @param x
	 * @param y
	 * @param jiange 每行的间隔 
	 * @param w 
	 * @param kind 对齐方式 0左 1居中 2右
	 * @param g
	 */
	public  static final void drawLongString(String str, int x, int y,
			int jiange, int w, int kind, Graphics g) {
		if (w <= 0) {
			w = 1;
		}
		Font f = g.getFont();
		int h = f.getHeight();
		StringBuffer s = new StringBuffer();
		int size = str.length();
		int n = 0;
		int trans = 0;
		int _w = 0;
		if(f.stringWidth(str) < w) {
			w = f.stringWidth(str);
		}
		if (kind == 1) {
			_w = w >> 1;
			trans = Constant.TRANS[0];
		} else if (kind == 0) {
			trans = Constant.TRANS[0];
		} else if (kind == 2) {
			trans = Constant.TRANS[1];
		}
		for (int i = 0; i < size; i++) {
			s.append(str.charAt(i));
			if (f.stringWidth(s.toString()) >= w) {
				g.drawString(s.toString(), x - _w, y + n * (jiange + h), trans);
				s.delete(0, s.length());
				n++;
			}else {
				if (i == size - 1) {
					g.drawString(s.toString(), x - _w, y + n * (jiange + h),
							trans);
					s.delete(0, s.length());
				}
			}
		}

		s = null;
		f = null;

	}

	// xy
	public static final void drawMyImage(String url, int x, int y, int kind,
			Graphics g) {
		Image image;
		try {
			image = Image.createImage(url);
			g.drawImage(image, x, y, kind);
			image = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 各种对齐方式
	public static final void drawMyImage(String url, int x, int y,
			boolean fromServer, int kind, Graphics g) {
		Image image;
		image = Load.loadImage(url, fromServer);
		if (kind == 0) {// x, y居中
			g.drawImage(image, x - (image.getWidth() >> 1),
					y - (image.getHeight() >> 1), Constant.TRANS[0]);
		} else if (kind == 1) {// x居中 底部对齐
			g.drawImage(image, x - (image.getWidth() >> 1), y,
					Constant.TRANS[2]);
		} else if (kind == 2) {// x居中 顶部对齐
			g.drawImage(image, x - (image.getWidth() >> 1), y,
					Constant.TRANS[0]);
		} else if (kind == 3) {// y居中 左部对齐
			g.drawImage(image, x, y - (image.getHeight() >> 1),
					Constant.TRANS[0]);
		} else if (kind == 4) {// y居中 右部对齐
			g.drawImage(image, x, y - (image.getHeight() >> 1),
					Constant.TRANS[1]);
		} else if (kind == 5) {
			g.drawImage(image, x, y, Constant.TRANS[0]);
		}

		image = null;
	}

	public static final void drawMyImage(Image image, int x, int y, int kind,
			Graphics g) {

		if (kind == 0) {// x, y居中
			g.drawImage(image, x - (image.getWidth() >> 1),
					y - (image.getHeight() >> 1), Constant.TRANS[0]);
		} else if (kind == 1) {// x居中 底部对齐
			g.drawImage(image, x - (image.getWidth() >> 1), y,
					Constant.TRANS[2]);
		} else if (kind == 2) {// x居中 顶部对齐
			g.drawImage(image, x - (image.getWidth() >> 1), y,
					Constant.TRANS[0]);
		} else if (kind == 3) {// y居中 左部对齐
			g.drawImage(image, x, y - (image.getHeight() >> 1),
					Constant.TRANS[0]);
		} else if (kind == 4) {// y居中 右部对齐
			g.drawImage(image, x, y - (image.getHeight() >> 1),
					Constant.TRANS[1]);
		} else if (kind == 5) {
			g.drawImage(image, x, y, Constant.TRANS[0]);
		}
	}

	public static final void drawMyString(String str, int x, int y, Graphics g) {// 字符串相对于
																					// x
																					// y居中
		Font f = g.getFont();
		int len = f.stringWidth(str);
		int h = f.getHeight();
		g.drawString(str, x - (len >> 1), y - (h >> 1), Constant.TRANS[0]);
		f = null;
	}
    
	/*
	 * 平铺图片 x,y 起始坐标 wOrh 平铺的高度或者宽度 tileKind = 0 wOrh 取宽度 = 1 取 高度 及横向和纵向排列
	 */
	public static final void tileImage(Image image, int x, int y, int tw,
			int th, Graphics g) {
		double q1;
		double q2;
		int w;
		int h;
		w = image.getWidth();
		h = image.getHeight();
		q1 = tw / w;// 列数
		if (q1 - (int) q1 > 0) {
			q1 = (int) q1 + 1;
		}
		q2 = th / h;// 行数
		if (q2 - (int) q2 > 0) {
			q2 = (int) q2 + 1;
		}
		
		for (int i = 0; i < q1; i++) {
			for (int j = 0; j < q2; j++) {
				g.drawImage(image, x + i * w, y + j * h, Constant.TRANS[0]);
			}
		}
	}

	// 画血条 x y 居中
	public static void drawHpLine(int x, int y, int hp, int oriHp, int l,
			int h, Graphics g) {
		g.setColor(255, 0, 0);
		g.fillRect(x - (l >> 1), y - (h >> 1), (int) (l * hp * 1.0 / oriHp), h);
		g.setColor(255, 255, 255);
		g.drawRect(x - (l >> 1), y - (h >> 1), l, h);

	}

	// 分割字符串 str 为要分割的字符串 c为分割标志
	public static String[] spliteStr(String str, String c) {
		String[] strArray = null;
		String strTemp = str;

		if (str != null && c != null && !c.equals("") && str.indexOf(c) != -1) {
			int index = 0;
			int count = 0;

			while ((index = str.indexOf(c)) != -1) {
				count++;
				str = str.substring(index + c.length());
			}
			count++;
			strArray = new String[count];
			count = 0;
			while ((index = strTemp.indexOf(c)) != -1) {
				strArray[count] = strTemp.substring(0, index);
				strTemp = strTemp.substring(index + c.length());
				count++;
			}

			strArray[count] = strTemp;
			// System.out.println("strArray["+count+"]  =  " + strArray[count]);

		}else {
			strArray = new String[]{str};
		}

		return strArray;
	}

	// 精灵碰撞
	public static boolean spriteImpact(Image img1, int x1, int y1, Image img2,
			int x2, int y2) {
		boolean result = false;
		Sprite s1 = new Sprite(img1);
		Sprite s2 = new Sprite(img2);
		s1.setRefPixelPosition(x1, y1);
		s2.setRefPixelPosition(x2, y2);
		result = s1.collidesWith(s2, true);
		s1 = null;
		s2 = null;
		return result;
	}
	//图片  图片x  图片y 屏幕宽 屏幕高 原始图片宽 原始图片高 选取图片的相对x 选取图片的相对y 区域高度 区域宽度 
    public static final void drawImage(Image img, int x, int y, int rx, int ry,   int regionW, int regionH,  Graphics g){
	int clipW = g.getClipWidth();
	int clipH = g.getClipHeight();
	int clipX = g.getClipX();
	int clipY = g.getClipY();
	int oriImgW = img.getWidth();
	int oriImgH = img.getHeight();
     if(oriImgW < regionW) {
   		 oriImgW = regionW;
   	 }
   	 if(oriImgH < regionH) {
   		 oriImgH = regionH;
   	 }
   	 g.setClip(x, y, regionW, regionH);
     drawImage(img, x - rx , y - ry , Constant.TRANS[0], g);
   	 //g.drawImage(img, x - rx , y - ry , Constant.TRANS[0]);
   	 g.setClip(clipX, clipY, clipW, clipH);
   	 //g.drawRect( x, y, regionW, regionH);
   	 }
	
	public static void drawImage(Image img, int x, int y, int trans, Graphics g) {
		
		if(img != null) {
			g.drawImage( img,  x,  y,  trans);
		}else {
			System.out.println("图片为空");
		}
		
		//g.drawImage(imgs[btnId[i]], btnXY[btnId[i]][0], btnXY[btnId[i]][1], Constant.TRANS[0]);
	}
	
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 将一个long类型数字 用分隔符c每per个数字加一个c
	 * @param num
	 * @param c
	 * @param per
	 * @return
	 */
	public static String getFormatStr(long num, String c, int per) {
            StringBuffer sb = new StringBuffer();
			String q = "";
			if(num < 0) {
				q="-";
			}
			sb.append(num>0?num:-num);
			
			int m = sb.length() % per;
			int n = sb.length() / per + (m > 0?0:-1);
			int k =(m > 0?0:per) ;
			for(int i = 0; i < n; i++) {
				sb.insert(i * per + m + i + k, c);
			}
			sb.insert(0, q);
			return sb.toString();
			
		
		
	}
 	
	public static final boolean crParam(String param) {
		if(param == null || param.equals("") || param.equals("null")){
			return false;
		}
		return true;
	}
	
	 public static boolean isNumber(String str) {
	  	   boolean sign = true;
	  	   if(str!=null && !str.equals("")) {
	  		 for(int i = str.length() - 1; i >= 0; i--) {
		  		   char c = str.charAt(i);
		  		   if((c > '9' || c < '0') && !(c=='-' && i==0)) {
		  			   sign = false;
		  			   break;
		  		   }
		  	   }
	  	   }else sign = false;
		  	   
	  	   return sign; 
	 }
	 
	 /**根据设定的概率 摇奖  将b 分为 24段 然后随机取一个数 看在哪个段  就是中哪个格子
	     * @param chance 概率数组
	      * @param b  随机数取数范围
	     * @return 随机到的数字
	     *  chance[i] * b / a 表示一个组织断长度
	     */
	    public static int getRandomNumberByChance(int[] chance, int b) {
	    	Constant.r.setSeed(System.currentTimeMillis() + Constant.r.nextLong());
	    	int a = Mtd.getSumOfIntArray(chance);//求chance数组元素之和
			 //刚开始只有一个格子抽取要中的概率
	    	 int toIndex = -1;
	    	 int randomNumber =  Constant.r.nextInt(b) + 1;
	    	 int sum = 0;
	    	 for(int i =0; i < chance.length; i ++) {
	    		 int temp = sum + 1;
	    		 if(i ==  chance.length - 1) {//最后一段 用b减去前面的和 为了避免 / 产生的误差
	    			 sum = b;
	    		 }else {
	    			 sum += chance[i] * 1.0 * b / a;
	    		 }
	    		if(randomNumber >= temp  && randomNumber <= sum) {
	    			toIndex = i;
	    			break;
	    		}
	    	 }
	    	
	    	return toIndex;
	    }
	    
	  public static final String replaceAll(String str, String regex, String replacement) {
		  if(str == null || regex == null || replacement==null) return str;
		  StringBuffer sb = new StringBuffer(str);
		  int index = -1;
		  while((index = sb.toString().indexOf(regex)) != -1 ) {
			  sb.delete(index, index + regex.length());
			  sb.insert(index, replacement);
			  
		  }
		  return sb.toString();
	  }
	  public static String replaceByChar(String str, char c,int startIndex, int endIndex) {
		  StringBuffer result = new StringBuffer(str);
		  
		  if(str != null) {
			  if(startIndex < 0) {
				  startIndex = 0;
			  }
			  if(endIndex >= str.length()) {
				  endIndex = str.length() - 1;
			  }
			  for(int i = startIndex; i <= endIndex; i++) {
				      result.deleteCharAt(i);
					  result.insert(i, c);
				}
		  }
		  return result.toString();
	  }
	public static void main(String[] a) {
	  
	   //System.out.println(Mtd.replaceAll("asd123asd123asd123", "asd", ""));
		System.out.println(sqrt(123123d));
	}
	
	/**如果obj为空则返回obj2 否返回obj
	 * @param obj
	 * @param obj2
	 * @return
	 */
	public static Object ifNull(Object obj,Object obj2) {
		if(obj == null) {
			return  obj2;
		}
		return obj;
	}
	
	public static final Map getConfigMap(String configStr,char c1, char c2) {
		Map map = new Map();
		String[] s = Mtd.spliteStr(configStr, c1+"");
		for(int i = 0; i < s.length; i++) {
			if(s[i] != null && s[i].indexOf(c2)!=-1) {
				String[] s2 = Mtd.spliteStr(s[i], c2+"");
				map.put(s2[0], s2[1]);
				System.out.println(s2[0] +" : " + s2[1] );
				s2 = null;
			}
		}
		return map;
	}
	
	public static final int getNumOfValue(int[] array, int value,int startIndex, int endIndex) {
		int num = 0;
		if(array != null) {
			for(int i = startIndex; i <= endIndex; i++) {
				if(array[i] == value) {
					num ++;
				}
			}
		}
		return num;
	}
	
}
