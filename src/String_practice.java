/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-07
 * String_practice.java
 * --------------------------------------------
 * create a program that has the following output
 * 
 * please enter a string:_____________
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * 1. the length of the string is: ________
 * 2. the substring starting at index____ and ending at index ____ is ___
 * 3. the character at index ___ is ____
 * 4. the string in upper case is _________
 * 5. the string in lower case is _________
 * 6. the position where the word ____ starts is _______
 * --------------------------------------------
 */

// Imports
import java.awt.*;
import hsa.Console;

public class String_practice {
	static Console c; // The output console

	public static void main (String[] args)
    {
        c = new Console (25, 80, 14, "String Practice");
		
        		
        		c.print("Enter a two words: ");
        		String text = c.readLine();
        		
        		c.println("--------------------------------");
        		
        		// 1
        		c.println("1. The length of the string is: " + text.length());
        		
        		// 2
        		int middle, end;
        		middle = text.length() / 2;
        		end = text.length();
        		c.println("The substring starting at index " + middle + " and ending at " + end + " is " + text.substring(middle, end));
        		
        		// 3
        		c.println("The character at index " + middle + " is " + text.charAt(middle));
        		
        		// 4
        		c.println("The string in upper case is: " + text.toUpperCase());
        		
        		// 5
        		c.println("The string in lower case is: " + text.toLowerCase());
        		
        		// 6
        		c.println("The position where the word");
        		int word2 = text.indexOf(" ") + 1;
        		c.println(text.substring(word2));
        		
        		
        		
        		
        		
        		
        		
        } // main method
} // test class