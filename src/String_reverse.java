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

		c.print("Please enter y to use the StringBuffer way or n to use the old way: ");
		char type = c.readChar();


		// Get the text that will be reversed
		c.println("This program reverses whatever you type in.");
		c.print("Enter a string: ");
		String text = c.readLine();

		if (type == 'y') {
			// Use this handy dandy object called StringBuffer to reverse the text
			StringBuffer reverse = new StringBuffer(text).reverse();
			c.println("In the reverse the string is: " + reverse);

		} else if (type == 'n') {

			String reverse = "";
			for (int i = text.length() - 1; i >= 0; i--) {

				reverse += text.charAt(i);
			}
			c.println("In the reverse the string is: " + reverse);
		}

		// Print to the console the reversed string


	} // main method
} // test class
