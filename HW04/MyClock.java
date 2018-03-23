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
	
	public MyClock(int radius) {
		face =new ClockFace(400,400 ,radius);
	    ClockHand hourHand = new ClockHand(radius/2, y, radius/2 - 15 , 10, Color.BLACK);
	    
	    add(hourHand);
	      ClockHand minHand = new ClockHand(x, cY, cX , 7 , Color.yellow );
	      minHand.draw(g2);
	      ClockHand secHand = new ClockHand(2* radius, cY, cY , 5 , Color.red );
	      secHand.draw(g2); 
	}

	
	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	if (handType == "SECOND") {
		g2.setPaint(Color.RED);
		
		double second = (double) (calendar.get(Calendar.SECOND));
		double secondAngle = second / 60.0 * 2.0 * Math.PI;

		g2.rotate((float) secondAngle, (int) x, (int) adjustedY);
	}
	
	if (handType == "MINUTE") {
		g2.setPaint(Color.BLACK);
		
		double minute = (double)(calendar.get(Calendar.MINUTE)) +
		        (double)(calendar.get(Calendar.SECOND))/60.0;

		double minuteAngle = minute/60.0*2.0*Math.PI;
		
		g2.rotate((float)minuteAngle, (int)x, (int)adjustedY);
	}
	
	if (handType == "HOUR") {
		g2.setPaint(Color.BLACK);
		
		double hour = (double)(calendar.get(Calendar.HOUR_OF_DAY)%12) +
		        (double)(calendar.get(Calendar.MINUTE))/60.0;

		double angle = hour/12.0*2.0*Math.PI;
		g2.rotate((float)angle, (int)x, (int)adjustedY);
	}

}
