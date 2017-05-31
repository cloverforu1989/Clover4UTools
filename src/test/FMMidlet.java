package test;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.lcdui.Font;
import javax.microedition.midlet.MIDletStateChangeException;

import com.clover4u.connection.OpenURL;
import com.clover4u.startup.GameSystem;
import com.clover4u.startup.MainMidlet;
import com.clover4u.utils.IListener;
import com.clover4u.utils.Mtd;

public class FMMidlet extends MainMidlet {
	 protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	
	 }
	static int counter = 0;
	protected void pauseApp() {
		// TODO Auto-generated method stub
    }
   
	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub
	    super.startApp();
	    GameSystem.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
		GameSystem.setFps(60);
		GameSystem.setGcTime(150);
		GameSystem.start();
		//new TestBox().show();
		new TestScene().toScene();
	}
	
    public static void main() {
    	Calendar canlendar = Calendar.getInstance();
    	Date date = canlendar.getTime();
    	canlendar.setTime(date);
    	long m = date.getTime();
    	Date date2 = new Date(12123123L);
    }
}
