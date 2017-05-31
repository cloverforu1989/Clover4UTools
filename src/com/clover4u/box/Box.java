package com.clover4u.box;

import com.clover4u.utils.IListener;
import com.clover4u.utils.Key;
import com.clover4u.utils.Mtd;

public  abstract class Box extends BoxBasic{
   private int[] availableKeyArray;
   private IListener quitListener;
   public final void show() {
	   this.setKeyLocked(true);
	    this.init();
		this.setKeyCode(KEY_CODE_DEFAULT);
		BoxManager.addBox(this);
	}

	public int[] getAvailableKeyArray() {
		return availableKeyArray;
	}
	public void setAvailableKeyArray(int[] availableKeyArray) {
		this.availableKeyArray = availableKeyArray;
	}
	public boolean isKeyAvailable() {
		// TODO Auto-generated method stub
		if(getAvailableKeyArray() == null || Mtd.getIndex(getAvailableKeyArray(), getKeyCode(), 0) != -1) {
			System.out.println("getKeyCode()=" + getKeyCode());
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(Mtd.getIndex(new int[]{KEY_OK}, -5, 0));
	}

	public IListener getQuitListener() {
		return quitListener;
	}

	public void setQuitListener(IListener quitListener) {
		this.quitListener = quitListener;
	}

	

}
