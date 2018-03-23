import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;
public class ClockHand implements MoveableShape {
	private int x;
	private int y;
	private int xaxis;
	private int yaxis;
	private int size;
	private Color color;
	
	public ClockHand(int x, int y , int xaxis, int yaxis, int size,Color color) {
		this.xaxis = xaxis;
		this.yaxis =yaxis;
		this.x =x ;
		this.y = y;	
		this.size = size;
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setStroke(new BasicStroke(size));
		Line2D.Float hand = new Line2D.Float(x, y, xaxis, yaxis);
		g2.setPaint(color);
		g2.draw(hand);
	}

	@Override
	public void translate(int dx, int dy) {
		xaxis= dx;
		yaxis =dy;
		}

}
