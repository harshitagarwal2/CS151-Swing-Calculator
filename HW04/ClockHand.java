import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;
public class ClockHand implements MoveableShape {
	private int x;
	private int y;
	private int width;
	private int size;
	private Color color;
	
	public ClockHand(int x, int y , int radius, int size,Color color) {
		this.width = radius;
		this.x =x ;
		this.y = y;	
		this.size = size;
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setStroke(new BasicStroke(size));
		Line2D.Float hand = new Line2D.Float(x, y, width, width);
		g2.setPaint(color);
		g2.draw(hand);
	}

	@Override
	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub

	}

}
