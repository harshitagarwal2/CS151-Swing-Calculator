import javax.swing.*;
import java.awt.*;

public class StopWatchDial extends JPanel {
    private ClockFace clockFace;
    private int radius;
    private ClockHand minutesHand;

    public StopWatchDial(int x, int y, int width) {
        this.radius = width / 2;
        this.clockFace = new ClockFace(x, y, radius * 2);
        clockFace.setClockNumberIncrement(5);
        
        this.minutesHand = new ClockHand(x + radius,y + radius, radius,3,0,Color.RED);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(width, width));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockFace.paintComponent(g);
        minutesHand.draw((Graphics2D) g);
    }

    public void tick() {
        minutesHand.move();
        repaint();
    }
  
    public void reset(){
        minutesHand.reset();
        repaint();
    }
}
