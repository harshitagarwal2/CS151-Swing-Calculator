import javax.swing.*;
import java.awt.*;

public class Stopwatch extends JPanel {
    private ClockFace clockFace;
    private StopWatchDial stopWatchDial;
    private ClockHand secondsHand;
    private int radius;
    private int secPassed = 0;

    public Stopwatch(int x, int y, int width) {
        this.radius = width / 2;
        this.clockFace = new ClockFace(x, y, radius * 2);
        this.clockFace.setClockNumberIncrement(5);
        this.stopWatchDial = new StopWatchDial(radius - radius / 2, (int) (y + width/5), radius);
        this.secondsHand = new ClockHand(radius,radius,radius,3,0,Color.RED);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(radius * 2, radius * 2));

        int DELAY = 1000;
        Timer t = new Timer(DELAY, e -> {
            if (secPassed == 59) {
                stopWatchDial.tick();
                secPassed = 0;
            } else 
                secPassed++; 
            secondsHand.move();
            repaint();
        });
        t.start();
    }

    public void reset(){
       secondsHand.reset();
       repaint();
       secPassed = 0;
       stopWatchDial.reset();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockFace.paintComponent(g);
        secondsHand.draw((Graphics2D) g);
        stopWatchDial.paintComponent(g);
        
    }
}
