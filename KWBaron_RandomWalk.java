/*
Kevin Baron
3/2/13
Random Walk
*/

import java.util.Scanner;
import java.awt.Graphics;

public class KWBaron_RandomWalk {
	
	//Give an introduction.
	//Keep track of the given statistics by performing a walk once
	//and then for as long as the user wishes to perform walks.
	//Finally, report the collected statistics.
	public static void main(String[] args) {
		giveIntro();
		Scanner keyboard = new Scanner(System.in);
		int totalWalks = 1;
		int totalSteps = walk(keyboard);
		int bestWalk = totalSteps;
		while (askToWalkAgain(keyboard)) {
			int numSteps = walk(keyboard);
			totalWalks++;
			totalSteps += numSteps;
			if (numSteps < bestWalk) {
				bestWalk = numSteps;
			}//eo if
		}//eo while
		report(totalWalks, totalSteps, bestWalk);
	}//eo main
	
	//pre: none
	//post: introduction has been given.
	public static void giveIntro() {
		System.out.println("A random walk is the collection of repeated steps in random directions.");
		System.out.println("It can be graphed by moving from the center of a circle until the edge is reached.\n");
	}//eo giveIntro
	
	//pre: needs a Scanner
	//post: a random walk has been performed on the DrawingPanel,
	//      and the number of steps taken have been printed and returned.
	public static int walk(Scanner keyboard) {
		System.out.print("Radius? ");
		int radius = keyboard.nextInt();
		int diameter = radius * 2;
		DrawingPanel panel = new DrawingPanel(diameter + 1, diameter + 1);
		Graphics g = panel.getGraphics();
		g.drawOval(0, 0, diameter, diameter);
		KWBaron_Walker walker = new KWBaron_Walker(radius, radius);//constructs the walker at the center of the circle
		int numSteps = 0;
		walker.draw(g);//fills the pixel where the walker is currently located
		KWBaron_Die d = new KWBaron_Die(4);//constructs a four-sided die to roll
		while (walker.distanceToCenter() < radius) {//walker moves a random step until the edge is reached
			numSteps++;
			switch (d.roll()) {
				case 0:
					walker.up();
					break;
				case 1:
					walker.right();
					break;
				case 2:
					walker.down();
					break;
				case 3:
					walker.left();
					break;
			}//eo switch
			panel.sleep(5);//for animation-like effect
			walker.draw(g);
		}//eo while
		String plural = "s";
		if (numSteps == 1) {
			plural = "";
		}//eo if
		System.out.println("I escaped in " + numSteps + " move" + plural + ".");
		return numSteps;
	}//eo walk
	
	//pre: needs a Scanner
	//post: boolean has been returned based on user's y/n response
	public static boolean askToWalkAgain(Scanner keyboard) {
		System.out.print("Walk again (yes/no)? ");
		boolean walkAgain = true;
		if (keyboard.next().toUpperCase().charAt(0) != 'Y') {
			walkAgain = false;
		}//eo if
		System.out.println();
		return walkAgain;
	}//eo askToWalkAgain
	
	//pre: needs the stats collected from the walks
	//post: stats have been printed and DrawingPanels have been closed
	public static void report(int totalWalks, int totalSteps, int bestWalk) {
		System.out.println("Total walks = " + totalWalks);
		System.out.println("Total steps = " + totalSteps);
		System.out.println("Best walk   = " + bestWalk);
		System.exit(0);
	}//eo report
	
}//eo KWBaron_RandomWalk