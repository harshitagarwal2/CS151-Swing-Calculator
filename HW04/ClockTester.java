import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class ClockTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      SwitchPanel s = new SwitchPanel();
      
      ClockFace clockIcon = new ClockFace(0, 0, CLOCK_RADIUS);
      StopWatch watchIcon = new StopWatch();
      frame.setLayout(new BorderLayout());
      frame.add(clockIcon, BorderLayout.CENTER);
      
      JPanel topNav = new JPanel(new FlowLayout());
      JButton clock = new JButton("clock"); 
      JButton stopwatch = new JButton("stopwatch");
      topNav.add(clock);
      topNav.add(stopwatch);
      frame.add(topNav, BorderLayout.NORTH);
      clockIcon.repaint();
      clock.addActionListener(e -> {
			s.switchPanel(frame, watchIcon, clockIcon);

		});
      stopwatch.addActionListener(e -> {
    	  s.switchPanel(frame, clockIcon, watchIcon);

		});



      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      
   }

   private static final int CLOCK_RADIUS = 500;
}
