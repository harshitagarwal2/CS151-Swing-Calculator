import java.awt.*;

import javax.swing.JPanel;

public class StopWatch extends JPanel {
	private ClockFace innerFace;
	private ClockFace outerFace;
	private ClockHand innerHand;
	private ClockHand outerHand;
	
	
	public StopWatch() {
		setLayout(new FlowLayout());
		innerFace = new ClockFace(0, 0, 600);
		add(innerFace);
		outerFace = new ClockFace(50, 50, 300);
		add(outerFace);
	}

}
