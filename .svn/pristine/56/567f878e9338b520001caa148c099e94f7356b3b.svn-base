package com.clover4u.utils;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Image;

import com.clover4u.paintLoading.PaintLoading;
import com.clover4u.startup.GameSystem;
public class Load {
	private PaintLoading pl;
	public Load() {
		
	}
    public Load(PaintLoading pl) {
		setPl(pl);
	}
    public Image loadImg(String u, boolean fromServer) {
    	Image image = loadImage(u, fromServer);
    	if(pl != null) {
    		pl.setCounter(pl.getCounter() + 1);
    	}
    	if(pl.getCounter() >= pl.getTotalResNum()) {
    		Mtd.sleep(100);
    	}else {
    		Mtd.sleep(1);
    	}
    	//System.out.println("从"+(fromServer?"服务器":"本地")+"下载资源 "+u+" 数量:" + pl.getCounter());
    	return image;
    }
    public static final Image loadImage(String u, boolean fromServer){
    	System.out.println("从"+(fromServer?"服务器":"本地")+"下载资源 "+u);
		// 创建与服务器的HTTP连接
		Image img = null;
		String s = null;
		if(fromServer) {
			StringBuffer url = new StringBuffer();
			url.append(GameSystem.getRes_url()).append(u);
			HttpConnection hc = null;
	        DataInputStream dis = null;
	        try {
	        	s = url.toString();
	        	hc = (HttpConnection)Connector.open(s);
	            dis = hc.openDataInputStream();
			    int l = (int)hc.getLength();
				byte data[] = new byte[l];
				dis.readFully(data);
				img = Image.createImage(data, 0, l);
				data = null;
				url = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("下载失败：" + u);
				//e.printStackTrace();
				//Mtd.drawLongString("从服务器获取资源失败！请检查资源包的路径是否正确！", 320, 150, 5, 200, 1, KFFCanvas.g);
			}finally {
				
				try {
						if(dis != null)
							dis.close();
						
						if(hc != null)
						    hc.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
		}else {
			try {
			
				img = Image.createImage(u);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        s = null;
       return img;
	}
	public PaintLoading getPl() {
		return pl;
	}
	public void setPl(PaintLoading pl) {
		this.pl = pl;
	}
}
