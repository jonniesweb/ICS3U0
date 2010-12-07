/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-06
 * stringtest.java
 * --------------------------------------------
 * Description TODO: Create a description
 * --------------------------------------------
 */

// Imports
import java.awt.*;
import hsa.Console;

public class stringtest {
	static Console c; // The output console

	public static void main(String[] args) {
		c = new Console();

		// Define Variables

char c;

String test = "abcd";

for (int i = 0; i < test.length(); i++) {
	c = test.charAt(i);
	System.out.println(c);
	
	
	
}

	} // main method
} // test class
