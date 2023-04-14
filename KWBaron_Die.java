/*
Kevin Baron
3/3/13
Random Walk
Die Class
*/

import java.util.Random;

public class KWBaron_Die {
	
	private int sides;
	private static final Random r = new Random();
	
	public KWBaron_Die(int sides) {
		this.sides = sides;
	}//eo KWBaron_Die constructor
	
	public int roll() {
		return r.nextInt(sides);
	}
	
}//eo KWBaron_Die