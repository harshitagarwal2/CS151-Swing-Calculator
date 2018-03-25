import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class MyClock extends JPanel {
	private ClockFace face;
	private ClockHand hand;
	private int radius;
	
	public MyClock(int width) {
		face =new ClockFace(400,400 ,radius);
		add(face);
		int r = radius/2 ;	
		int cX= x + r;
		int cY = y+ r;
		HandIcon s = new HandIcon(, width, height)
	}

}
