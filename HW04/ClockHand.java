import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class ClockHand implements MoveableShape {
	private double x;
	private double y;
	private double xaxis;
	private double yaxis;
	private double startingTick;
	private Color color;


    public ClockHand(double x, double y , double xaxis, double yaxis, double startingTick,Color color) {
    	//this.color = color;
    	this.x = x;
		this.y =y;
		this.xaxis =xaxis ;
		this.yaxis = yaxis;	
		this.startingTick = startingTick;
		this.color = color;
    }
    
    public void move() {
        startingTick++;  
        if (startingTick == 60){
           startingTick = 0;
        }
    }
    
    @Override
   	public void translate(double dx, double dy) {
   		xaxis= dx;
   		yaxis =dy;
   		}
    
    public void reset() {
        startingTick = 0;
    }
	

    @Override
    public void draw(Graphics2D g2) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);
     
        double angleFrom12 = 2*Math.PI*(startingTick/60.0);
        double deltaX = Math.cos(Math.PI*1.5+angleFrom12)*xaxis;
        double deltaY = (Math.sin(Math.PI*1.5+angleFrom12)*xaxis);
      
        path.lineTo(x + deltaX, y + deltaY);
        path.lineTo(x + deltaX, y + deltaY);

        g2.setStroke(new BasicStroke((float)yaxis));
        g2.setColor(color);
        g2.draw(path);
    }
    
    public double getstartingTick(){
       return startingTick;
    }
    
   
}
