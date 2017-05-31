package com.clover4u.scene;
import com.clover4u.utils.IListener;
import com.clover4u.utils.Mtd;

public  abstract class Scene extends SceneBasic{
    private int[] availableKeyArray;
    private IListener quitListener;
	public int[] getAvailableKeyArray() {
		return availableKeyArray;
	}

	public final void toScene() {
		init();
		this.setKeyCode(KEY_CODE_DEFAULT);
		SceneManager.addScene(this);
	}

	public boolean isKeyAvailable() {
		// TODO Auto-generated method stub
		if(getAvailableKeyArray() == null || Mtd.getIndex(getAvailableKeyArray(), getKeyCode(), 0) != -1) {
			return true;
		}
		return false;
	}

	public void setAvailableKeyArray(int[] availableKeyArray) {
		this.availableKeyArray = availableKeyArray;
	}

	public IListener getQuitListener() {
		return quitListener;
	}

	public void setQuitListener(IListener quitListener) {
		this.quitListener = quitListener;
	}

}
