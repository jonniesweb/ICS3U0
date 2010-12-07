/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-05
 * a3_q4_simpson_j.java
 * --------------------------------------------
 * This program generates a random number
 * beetween 1 and 5. It then loops it over 20
 * times and every time it counts how many
 * times the number was chosen. At the end of
 * the program it displays the list of results.
 * --------------------------------------------
 */

// Imports
import java.awt.*;
import hsa.Console;
// import java.lang.*; not needed

public class a3_q4_simpson_j {
	static Console c; // The output console

	public static void main(String[] args) {
		c = new Console(30, 80, 12, "1 to 5 Random Number Generator");

		// Define Variables
		int one = 0, two = 0, three = 0, four = 0, five = 0;

		                

		for (int i = 0; i < 20; i++) {
			int randNum = (int) Math.ceil(Math.random() * 5);

			switch (randNum) {
			case 1:
				c.println("One");
				one++;
				break;
			case 2:
				c.println("Two");
				two++;
				break;
			case 3:
				c.println("Three");
				three++;
				break;
			case 4:
				c.println("Four");
				four++;
				break;
			case 5:
				c.println("Five");
				five++;
				break;

			default:
				c.println("Impossible output achieved!");
				break;
			}
		}
		
		c.println();
		c.println("TOTALS");
		c.println("One: " + one);
		c.println("Two: " + two);
		c.println("Three: "+ three);
		c.println("Four: " + four);
		c.println("Five: " + five);


	} // main method
} // test class
