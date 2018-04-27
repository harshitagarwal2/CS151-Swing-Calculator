import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ClockTester {
   
    public static void main(String[] args) {
    	
    	Stopwatch stopwatch = new Stopwatch(0, 0, CLOCK_RADIUS);
        MyClock clock = new MyClock(0, 0, CLOCK_RADIUS );
    	
    	JFrame frame = new JFrame();
       
       // set layout manager
       frame.setLayout(new BorderLayout());

       JPanel topNav = new JPanel(new FlowLayout());
       topNav.add(clockButton);
       topNav.add(stopwatchButton);
       frame.add(topNav, BorderLayout.NORTH);
       
       JPanel clockPanel = new JPanel();
       clockPanel.setLayout(new OverlayLayout(clockPanel));
       clockPanel.add(clock);
       clockPanel.add(stopwatch);
       frame.add(clockPanel, BorderLayout.CENTER);
       
      
       stopwatch.setVisible(false);
       
       clockButton.addActionListener(event -> {
           stopwatch.setVisible(false);
           clock.setVisible(true);
       });
       stopwatchButton.addActionListener(event -> {
           stopwatch.reset();
           clock.setVisible(false);
           stopwatch.setVisible(true);
       });

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
    
   }
    private static final int CLOCK_RADIUS = 500;
    private static JButton clockButton = new JButton("Clock");
    private static JButton stopwatchButton = new JButton("Stopwatch");
}
