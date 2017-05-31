package com.base64;

import java.io.IOException;

public class MainInterface {
	/**
	 * ×Ö·û´®Ñ¹Ëõ
	 * 
	 * @throws Exception
	 */
	public static String getCompressString(String str)  {
		
			byte data[];
			try {
				data = ZipUtil.compress(str.getBytes());
				return HBase64.encode(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return null;
	}

	public static String getDecompressString(String str) {
		try {
			byte data[] = ZipUtil.decompress(HBase64.decode(str));
			return new String(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// Õâ¸öÊÇµÇÂ½µÄÊ±ºò½âÑ¹Ëõ¶Áµµ
}
