package com.clover4u.utils;

import java.util.Vector;


/*Ä£ÄâMap*/
public final class Map{
  private Vector v = new Vector();
  public static void main(String[] args) {
	Map map = new Map();
	map.put("1", "2");
	map.put("1", "3");
	System.out.println(map.keyIndexOf("1"));
	Object[] br = map.getEntry(0);
	System.out.println(-1 % 2);
	System.out.println(br[0] + "  " + br[1]);
}
  public void put(String key,Object obj) {
	  int index = keyIndexOf(key);
	  if( index != -1) {
		  v.removeElementAt(index * 2+1);
		  v.insertElementAt(obj, index * 2 + 1);
	  }else {
		  v.addElement(key);
		  v.addElement(obj);
	  }
	  
  }
  public Object[] getEntry(int index) {
	  Object[] objArr= null;
	  if(index <= size() - 1) {
		  objArr= new Object[]{v.elementAt(index * 2),v.elementAt(index * 2 + 1)};
	  }
	 
	  return objArr;
  }
  public Object getKeyValue(String key) {
	  Object obj = null;
	  int index = keyIndexOf(key);
	  if( index != -1) {
		  obj = v.elementAt(index * 2 + 1);
	  }
	  return obj;
  }
  public int keyIndexOf(Object key) {
	  int index = -1;
	  for(int i = v.size() -2; i >=0; i-=2) {
		      Object obj = v.elementAt(i);
		      //System.out.println(key + " ~~~ " + obj);
			  if(obj != null && obj.equals(key) || obj == key) {
				  index = i;
				  break;
			  }
	  }
	  
	  if(index != -1) {
		  index /= 2;
	  }
	  return index;
  }
  public int removeKeyValue(String key) {
	  int result = -1;
	  int index = keyIndexOf(key);
	  if( index != -1) {
		  v.removeElementAt(index * 2);
		  v.removeElementAt(index * 2);
		  result = 1;
	  }
	  return result;
	  
  }
  public int size() {
	  int size = v.size() / 2;
	  return size;
  }
  
  public Object elementAt(int index) {
	  if(index >= size()) {
		  return null;
	  }
	  return v.elementAt(index * 2 + 1);
  }
  
  public void removeAllElements() {
	  v.removeAllElements();
  }
  
  public void free() {
	  removeAllElements();
	  v = null;
	  System.gc();
  }
}
