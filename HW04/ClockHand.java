import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;
public class ClockHand implements MoveableShape {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public ClockHand(int x, int y , int width, int height) {
		this.width = width;
		this.x =x ;
		this.y = y;	
		this.height = height;
	}

	@Override
	public void draw(Graphics2D g2) {
		Rectangle2D.Double hand = new Rectangle2D.Double(x, y, width, height);
		g2.setPaint(Color.BLUE);
		g2.fill(hand);
	}

	@Override
	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub

	}

}
