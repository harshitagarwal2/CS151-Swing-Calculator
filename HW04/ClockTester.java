import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClockTester {
   
    public static void main(String[] args) {
       JFrame frame = new JFrame();
       
       // set layout manager
       frame.setLayout(new BorderLayout());

       JPanel topNav = new JPanel(new FlowLayout());
       topNav.add(clockButton);
       topNav.add(stopwatchButton);
       frame.add(topNav, BorderLayout.NORTH);
       
       MyClock clock = new MyClock(0, 0, CLOCK_RADIUS );
       
     
       JPanel clockPanel = new JPanel();
       clockPanel.setLayout(new OverlayLayout(clockPanel));
       clockPanel.add(clock);
      
       frame.add(clockPanel, BorderLayout.CENTER);



       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
       
   	// add behavior- like pressing "stopwatch" and "clock" buttons to display their respective components
		// button.addActionListener(new ActionListener() {
		//		public void actionPerformed(ActionEvent e) {
		//
		//		}
		// })
   }
    private static final int CLOCK_RADIUS = 500;
    private static JButton clockButton = new JButton("Clock");
    private static JButton stopwatchButton = new JButton("Stopwatch");
}
