import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

import javax.swing.*;

public class ClockHand extends JPanel {

	@Override
	public void paintComponent(Graphics g) {	
		Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setStroke(new BasicStroke(10));
        g2.draw(new Line2D.Double(10, 10, 60, 60));
	}

}
