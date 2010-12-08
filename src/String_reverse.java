/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-07
 * String_revers.java
 * --------------------------------------------
 * Enter a string: apple
 * in reverse the string is: elppa
 * --------------------------------------------
 */

// Imports
import java.awt.*;
import hsa.Console;

public class String_reverse {
	static Console c; // The output console

	public static void main (String[] args)
	{
		c = new Console (25, 80, 14, "String Reverser");
		
		// Get the text that will be reversed
		c.println("This program reverses whatever you type in.");
		c.print("Enter a string: ");
		String text = c.readLine();
		
		// Use this handy dandy object called StringBuffer to reverse the text
		StringBuffer reverse = new StringBuffer(text).reverse();

		// Print to the console the reversed string
		c.println("In the reverse the string is: " + reverse);

	} // main method
} // test class
