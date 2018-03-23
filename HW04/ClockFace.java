import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

/**
   A Clock face
*/
public class ClockFace extends JPanel
{
   /**
      Constructs a Clock
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public ClockFace(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.setOpaque(false);
      this.setPreferredSize(new Dimension(width, width));
   }

   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      super.paintComponent(g2);
      // draw the ticks
      int tickLen = 10;
      int medTickLen = 15;
      int longTickLen = 20;
      int r = width/2; //radius of clock
      int cX = x+(width)/2;
      int cY = y+(width)/2;
      Stroke tickStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f);
     
      GeneralPath ticksPath = new GeneralPath();
      Ellipse2D.Double clockFace
            = new Ellipse2D.Double(this.x,this.y,width, width);
      g2.setColor(Color.WHITE);
      g2.fill(clockFace);
     
      for ( int i=1; i<= 60; i++){
          // default tick length is short
          int len = tickLen;
          if ( i % 15 == 0 ){
              // Longest tick on quarters (every 15 ticks)
              len = longTickLen;
          } else if ( i % 5 == 0 ){
           // Medium ticks on the '5's (every 5 ticks)
           len = medTickLen;
          }

          double di = (double)i; // tick num as double for easier math

          // Get the angle from 12 O'Clock to this tick (radians)
          double angleFrom12 = di/60.0*2.0*Math.PI;

          // Get the angle from 3 O'Clock to this tick
              // Note: 3 O'Clock corresponds with zero angle in unit circle
              // Makes it easier to do the math.
          double angleFrom3 = Math.PI/2.0-angleFrom12;

          // Move to the outer edge of the circle at correct position
          // for this tick.
          ticksPath.moveTo(
                  (float)(cX+Math.cos(angleFrom3)*r),
                  (float)(cY-Math.sin(angleFrom3)*r)
          );

          // Draw line inward along radius for length of tick mark
          ticksPath.lineTo(
                  (float)(cX+Math.cos(angleFrom3)*(r-len)),
                  (float)(cY-Math.sin(angleFrom3)*(r-len))
          );
      }
      
      

      // Draw the full shape onto the graphics context.
      g2.setColor(Color.BLACK);
      g2.setStroke(tickStroke);
      g2.draw(ticksPath);
      g2.setColor(Color.RED);

      for ( int i=1; i<=12; i++){
         String numStr = ""+i;
         FontMetrics fm = g2.getFontMetrics(g2.getFont());
         int charWidth = fm.stringWidth(numStr);
         int charHeight = fm.getHeight();

         double di = (double)i;
         double angleFrom12 = di/12.0*2.0*Math.PI;
         double angleFrom3 = Math.PI/2.0-angleFrom12;

         int tx = (int)(Math.cos(angleFrom3)*(r-longTickLen-charWidth));
         int ty = (int)(-Math.sin(angleFrom3)*(r-longTickLen-charHeight));

         g2.drawString(numStr, (int)cX+tx, (int)cY+ty);
            
      }
  	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
  		double second = (double) (calendar.get(Calendar.SECOND));
  		double secondAngle = Math.PI/2 -(second / 60.0 * 2.0 * Math.PI);

		double minute = (double)(calendar.get(Calendar.MINUTE)) +
		        (double)(calendar.get(Calendar.SECOND))/60.0;
		double minAngle =Math.PI/2 - (minute/60.0*2.0*Math.PI);
		
		double hour = (double)(calendar.get(Calendar.HOUR_OF_DAY)%12) + (double)(calendar.get(Calendar.MINUTE))/60.0;
		double hourAngle = Math.PI/2 - (hour/12.0*2.0*Math.PI);
		
		 ClockHand hourHand = new ClockHand(cX, cY, 1 ,276, longTickLen, Color.BLACK);
	      hourHand.draw(g2);
	      ClockHand minHand = new ClockHand(cX, cY, 0 , 250, medTickLen , Color.yellow );
	      minHand.draw(g2);
	      ClockHand secHand = new ClockHand(cX, cY, cX , 0 , tickLen , Color.red );
	      secHand.draw(g2);   

		
		minHand.translate((int)(cX+ r*Math.cos(minAngle)),(int) (cY - Math.sin(minAngle)*r));
		hourHand.translate((int)(cX+ r*Math.cos(hourAngle)),(int) (cY - Math.sin(hourAngle)*r));

		ActionListener listener = event -> {
			int newx = (int)(cX+ r*Math.cos(secondAngle));
			int newy =(int) (cY - Math.sin(secondAngle)*r);
			secHand.translate(newx, newy);
			System.out.println(newx + "\t" + newy);
			repaint();
		};

		final int DELAY = 1000;
		Timer t = new Timer(DELAY, listener);
		t.start();
}

   private int x;
   private int y;
   private int width;
}
