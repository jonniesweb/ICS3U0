/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-04
 * a3_q3_simpson_j.java
 * --------------------------------------------
 * Description TODO: Create a description
 * --------------------------------------------
 */

// Imports
import java.awt.*;
import hsa.Console;

public class a3_q3_simpson_j {
	static Console c; // The output console

	public static void main(String[] args) {
		c = new Console();

		// Define Variables
		int vip = 0;
		
		
		
		c.println("Wootstock ticket calculator");
		
		c.print("Please specify how many teen tickets will be bought: ");
		int teen = c.readInt();
		
		c.print("Please specify how many senior tickets will be bought: ");
		int senior = c.readInt();
		
		c.print("Please specify how many adult tickets will be bought: ");
		int adult = c.readInt();
		
		c.print("Would you like to purchase any V.I.P. tickets (y/n): ");
		char vipcheck = c.readChar();
		
		
		c.print("Do you have a 30% off coupon? (y/n): ");
		char couponcheck = c.readChar(); // Please tell me why this doesn't work!

		
		if (vipcheck == 'y') {
			
			int totaltickets = teen + senior + adult;
			do {
				c.print("Please specify how many you will purchase. Can be no more than " + totaltickets + ": ");
				vip = c.readInt();
			} while (vip > totaltickets);
		}
		
		// Do some late night math!
		int total = (teen * 8) + (senior * 8) + (adult * 8) + (vip * 30);
		// Phew! glad that's done.
		
		double coupon = 0;
		if (couponcheck == 'y') {
			coupon = total * .3;
		}
		
		double grandtotal = total + coupon;
		
		c.println("You bought " + teen + " teen tickets, " + senior + " senior tickets and " + adult + " adult tickets for Wootstock!");
		
		if (vipcheck == 'y') {
			c.println("You bought " + vip + " V.I.P. tickets.");
		}
		
		if (couponcheck == 'y') {
			c.println("the 30% coupon saved you $" + coupon);
		}
		
		c.println("Your total cost for the tickets are: $" + grandtotal);
		c.println("You lucky guys, no taxes!");
		
		
		
	} // main method
} // test class
