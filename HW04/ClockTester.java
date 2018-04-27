import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClockTester {
	public static void main(String args[]) {
		JFrame frame = new JFrame();

		// set layout manager
		frame.setLayout(new BorderLayout());

		// create swing components
		ClockFace icon = new ClockFace(0, 0, CLOCK_RADIUS);
		JPanel topNav = new JPanel(new FlowLayout());
		ClockHand secondsHand = new ClockHand();

		// add swing components to content pane
		icon.add(secondsHand);
		
		topNav.add(new JButton("clock"));
		topNav.add(new JButton("stopwatch"));
		
		frame.add(icon, BorderLayout.CENTER);
		frame.add(topNav, BorderLayout.NORTH);

		icon.repaint();

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
}
