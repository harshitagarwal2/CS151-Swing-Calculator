import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.Timer;

public class ClockHand implements MoveableShape {
	private int x;
	private int y;
	private int width;
	private int height;
	private String color;
	private String handType;

	public ClockHand(int x, int y, int width, int height, String handType) {
		this.color = color;
		this.width = width;
		this.x = x;
		this.y = y;
		this.height = height;
		this.handType = handType;
	}

	@Override
	public void draw(Graphics2D g2) {
		int r = width * 2;
		int adjustedY = x + (r - 15);
		
		Rectangle2D.Double hand = new Rectangle2D.Double(x, y, width, height);

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

		g2.fill(hand);
	}

	@Override
	public void translate(int dx, int dy) {
	}

}

