import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.TimeZone;

public class MyClock extends JPanel {
    private ClockFace clockFace; 
    private ClockHand secondsHand;
    private ClockHand minutesHand;
    private ClockHand hoursHand;
    private double radius;
    
    public MyClock(int x, int y, int width) {
        radius = width / 2;
        clockFace = new ClockFace(x, y, width);
      
        //get current time
        Calendar calendar;
        calendar = Calendar.getInstance(TimeZone.getDefault());
      
        int secondsTick = calendar.get(Calendar.SECOND);
        int minutesTick = calendar.get(Calendar.MINUTE);
        int hours = calendar.get(Calendar.HOUR) * 5;
        int hoursTick = hours + minutesTick / 12;
      
        secondsHand = new ClockHand(radius,radius,radius/4,4,secondsTick,Color.BLACK);
        minutesHand = new ClockHand( radius,radius,radius/2,8,minutesTick,Color.RED);
        hoursHand = new ClockHand(radius,radius,radius/1.5,12,hoursTick,Color.RED);
        
        setOpaque(false);
        setPreferredSize(new Dimension(width, width));
      
        
        final int DELAY = 1000;
        Timer t = new Timer(DELAY, e -> {
            secondsHand.move();
            repaint();
            if (secondsHand.getstartingTick() == 0){
               minutesHand.move();
               if (minutesHand.getstartingTick() % 12 == 0){
                   hoursHand.move();
               }
            }
          
        });
        t.start();
      
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockFace.paintComponent(g);
        hoursHand.draw((Graphics2D) g);
        minutesHand.draw((Graphics2D) g);
        secondsHand.draw((Graphics2D) g);
    }
}
