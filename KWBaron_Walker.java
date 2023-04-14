/*
Kevin Baron
3/2/13
Random Walk
Walker Class
*/

import java.awt.Point;
import java.awt.Graphics;

public class KWBaron_Walker {
	
	private Point p0;
	private Point pS;
	
	public KWBaron_Walker(int x, int y) {
		p0 = new Point(x, y);
		pS = new Point(p0);
	}//eo KWBaron_Walker constructor
	
	public double distanceToCenter() {
		return pS.distance(p0);
	}//eo distanceToCenter
	
	public void draw(Graphics g) {
		g.fillRect((int) pS.getX(),(int) pS.getY(), 1, 1);
	}//eo draw
	
	public void up() {
		pS.translate(0, -1);
	}//eo up
	
	public void right() {
		pS.translate(1, 0);
	}//eo right
	
	public void down() {
		pS.translate(0, 1);
	}//eo down
	
	public void left() {
		pS.translate(-1, 0);
	}//eo left
	
}//eo KWBaron_Walker