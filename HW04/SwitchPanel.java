import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwitchPanel {

	public void switchPanel(JFrame mainFrame, JPanel oldPanel, 
		JPanel newPanel) {
		mainFrame.remove(oldPanel);
		mainFrame.add(newPanel, BorderLayout.CENTER);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
}