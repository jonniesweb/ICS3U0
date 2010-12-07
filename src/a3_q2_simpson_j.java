/* Jonnie Simpson
* Humberview S.S.
* ICS 3U0, Created on 2010-12-01
* a3_q2_simpson_j.java
* --------------------------------------------
* This program is a very basic inventory
* program. It takes input from the user about
* the part name, price, number and quantity.
* If the quantity is below 50 ask the user to
* repeat the quantity. If below 10 say "Low
* Stock Warning".
* --------------------------------------------
*/

// Imports
import java.awt.*;
import hsa.Console;

public class a3_q2_simpson_j {
	static Console c; // The output console

	
	// Method for getting integers and quitting when zero is entered
	public static int getint(String question) {
		
		// take the passed variable 'question' and print it to the console
		c.print(question);
		
		// get input from the user
		int x = c.readInt();
		
		// If the user entered zero then quit the program
		if (x == 0) {
			System.exit(0);
		}
		
		// give x back to the method it was called from
		return x;
	}

	
	// You let me not comment this and the other related methods
	public static String getString(String question) {
		c.print(question);
		String x = c.readString();
		if (x == "0") {
			System.exit(0);
		}
		return x;
	}

	public static double getdouble(String question) {
		c.print(question);
		double x = c.readDouble();
		if (x == 0) {
			System.exit(0);
		}
		return x;
	}

	public static void main(String[] args) {
		
		// Start the HSA console
		c = new Console();

		// Define Variables
		String pna; // part name
		double p; // part cost
		int q = 1, pn; // part quantity and part number

		// Introduce the program
		c.println("Inventory Program");
		c.println("Enter '0' at any prompt to quit");

		// Get input from the user using these methods
		pn = getint("Please enter the part number: ");
		pna = getString("Please enter the part name: ");
		p = getdouble("Please enter the part price: ");
		
		
		// Run this program FOREVER* (Because getdouble, getstring and readint will quit the program)
		while (1 == 1) {
			
			// get the quantity
			q = getint("Please enter the part quantity: ");
			
			// print this if quantity is below or equal to 10
			if (q <= 10) {
				c.println("LOW STOCK WARNING");
			}
			
			int qcompare = 0;
			
			// if quantity is below 50 and greater than 10 compare 
			if (q <= 50 && qcompare != q && q > 10) {
				qcompare = getint("Please confirm the quantity: ");
				
				// Find out if the comparison was correct or not
				if (qcompare == q) {
					c.println("Quantity Confirmed");
				} else {
					c.println("You entered the wrong number");
				}
			}
		}
	} // main method
} // test class
