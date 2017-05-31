package com.clover4u.connection;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import test.FMMidlet;

import com.clover4u.startup.MainMidlet;
import com.clover4u.utils.IListener;
import com.clover4u.utils.Mtd;


public class OpenURL{
	private String defaultProtocol = "POST";	//Ĭ��Э��
	private String defaultEncode = "GBK";		//Ĭ�ϱ���
//	private String defaultEncode = "UTF-8";		//Ĭ�ϱ���
	private IListener listener;
	private String result;
	private String url;
	private int tryingTimes;
	private int maxTringTimes;
	public OpenURL(){}
	public OpenURL(String url, String protocol, String encode){
		this.defaultProtocol = protocol;
		this.defaultEncode = encode;
		this.url = url;
	}
	public OpenURL(String url){
		this.url = url;
	}
	public IListener getListener() {
		return listener;
	}
	public void setListener(IListener listener) {
		this.listener = listener;
	}
	
	public void openURL(int i) {
		
		String result = null;
		InputStream is = null;
		HttpConnection conn = null;
		try {
			//byte[] outbuffer = new byte[4];
			conn = (HttpConnection)Connector.open(this.url);
			if (conn != null) {
				//conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.1");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setRequestProperty("Content-Language", "en-CA");
				conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				conn.setRequestMethod(defaultProtocol);
				if(conn.getResponseCode() == HttpConnection.HTTP_OK) {
				    is = conn.openInputStream();
					if (is != null) {
						//bs = new ByteArrayOutputStream();
						//if (bs != null) {
							int ch;
							StringBuffer sb = new StringBuffer();
							while ((ch = is.read()) != -1) {
								sb.append((char)ch);
							}
	                       result =new String(sb.toString().getBytes("ISO-8859-1"),defaultEncode) ;
							sb = null;
							
							
						//}
					}
				}
				
				
			}
		} catch (IOException e) {
			result = null;
			e.printStackTrace();
		}finally {
			try {
			       if(is != null) {
				       is.close();
			       }
			       if(conn != null) {
			    	   conn.close();
			       }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			setResult(result);
			if(Mtd.crParam(getResult())) {
				if(listener != null) {
					listener.callback();
				}
			}else {
				if(getTryingTimes()  < getMaxTringTimes()) {
					open();
				}else {
				    System.out.println("����ʧ��");
					setTryingTimes(getTryingTimes() + 1);
					if(listener != null) {
						listener.callback();
					}
				}
			}
		}
	}
	public void openURL() {
		String result = null;
		InputStream is = null;
		HttpConnection conn =null;
		ByteArrayOutputStream bs = null;
		try {
			//byte[] outbuffer = new byte[4];
			conn = (HttpConnection)Connector.open(this.url);
			if (conn != null) {
				//conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.1");
				byte[] outbuffer = null;
                
			      if (conn != null) {
			        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			        conn.setRequestProperty("Content-Language", "en-CA");
			        conn.setRequestMethod(this.defaultProtocol);
			        is = conn.openInputStream();
			        if (is != null) {
			          bs = new ByteArrayOutputStream();
			          if (bs != null)
			          {
			            int ch;
			            while ((ch = is.read()) != -1)
			            {
			               bs.write(ch);
			            }
			            outbuffer = bs.toByteArray();
			            result = new String(outbuffer);
			          }
			        }
			      }

				
				
			}
		} catch (IOException e) {
			result = null;
			e.printStackTrace();
		}finally {
			try {
				  if(bs != null) {
					  bs.close();
				  }
			       if(is != null) {
				       is.close();
			       }
			       if(conn != null) {
			    	   conn.close();
			       }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			setResult(result);
			if(Mtd.crParam(getResult())) {
				if(listener != null) {
					listener.callback();
				}
			}else {
				
				if(getTryingTimes()  < getMaxTringTimes()) {
					open();
				}else {
					setResult("����ʧ��");
					setTryingTimes(getTryingTimes() + 1);
					System.out.println("����ʧ��");
					if(listener != null) {
						listener.callback();
					}
				}
			}
		    
			
		}
	}
	/**
	 * @param url
	 * @param defaultProtocol
	 * @param defaultEncode
	 * @param listener
	 * @return
	 */
	public static final String getURLResult(String url, String defaultProtocol,String defaultEncode) {
		String result = null;
		try {
			byte[] outbuffer = new byte[4];
			HttpConnection conn = null;
			ByteArrayOutputStream bs;
			InputStream is = null;
			conn = (HttpConnection) Connector.open(url);
			if (conn != null) {
				conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.1");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				conn.setRequestMethod(defaultProtocol);
				conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				is = conn.openInputStream();
				if (is != null) {
					bs = new ByteArrayOutputStream();
					if (bs != null) {
						int ch;
						while ((ch = is.read()) != -1) {
							bs.write(ch);
						}

						outbuffer = bs.toByteArray();
						//result = new String(outbuffer);
						result = new String(outbuffer, defaultEncode);

						bs.close();
						is.close();
						conn.close();
						conn = null;
						
					}
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static final String writeURL(String url, Object jsonStr,String protocol, String charset, IListener listener) {
		String result = null;
		InputStream is = null;
		HttpConnection conn =null;
		ByteArrayOutputStream bs = null;
		OutputStream os = null;
		try {
			//byte[] outbuffer = new byte[4];
			conn = (HttpConnection)Connector.open(url);
			if (conn != null) {
				//conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.1");
				byte[] outbuffer = null;
                
			      if (conn != null) {
			        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			        conn.setRequestProperty("Content-Language", "en-CA");
			        conn.setRequestMethod(protocol);
			        os = conn.openOutputStream();
			        os.write((jsonStr+"").getBytes());
			        is = conn.openInputStream();
			       
			        if (is != null) {
			          bs = new ByteArrayOutputStream();
			          if (bs != null)
			          {
			            int ch;
			            while ((ch = is.read()) != -1)
			            {
			               bs.write(ch);
			            }
			            outbuffer = bs.toByteArray();
			            result = new String(outbuffer);
			          }
			        }
			      }

				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			return  null;
		}finally {
			try {
				  if(bs != null) {
					  bs.close();
				  }
			       if(is != null) {
				       is.close();
			       }
			       if(os != null) {
			    	   os.close();
			       }
			       if(conn != null) {
			    	   conn.close();
			       }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
		}
		return result;
	}
	
	public void open() {
		ConnectionManager.addOpenURL(this);
		
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public int getTryingTimes() {
		return tryingTimes;
	}
	public void setTryingTimes(int tryingTimes) {
		this.tryingTimes = tryingTimes;
	}
	public int getMaxTringTimes() {
		return maxTringTimes;
	}
	public void setMaxTringTimes(int maxTringTimes) {
		this.maxTringTimes = maxTringTimes;
	}
}
