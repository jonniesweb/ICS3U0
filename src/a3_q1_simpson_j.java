/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-11-29
 * a3_q1_simpson_j.java
 * --------------------------------------------
 * This program calculates the users payroll.
 * It requests their name, age, hours worked
 * and hourly wage. It then calculates
 * employment insurance, Canadian Pension Plan
 * and income tax then outputs it to the user.
 * --------------------------------------------
 */

// Imports
import java.awt.*;
import java.text.DecimalFormat;

import hsa.Console;

public class a3_q1_simpson_j {
	static Console c; // The output console

	public static void main(String[] args) {
		c = new Console();

		// Get user input
		c.println("This program calculates your payroll.");
		
		c.print("Please enter your name: ");
		String name = c.readString();
		
		c.print("Please enter your age: ");
		int age = c.readInt();
		
		c.print("Please enter the number of hours you worked this week: ");
		double hours = c.readDouble();
		
		c.print("Please enter your hourly wage: ");
		double wage = c.readDouble();
		
		// Calculate gross
		double gross = hours * wage;
		
		// Calculate Canadian Pension Plan if you are older than 18 and younger than 65
		double cpp = 0;
		if (age >= 18 && age <= 65) {
			cpp = gross * 0.035;
		}
		
		// Calculate employment insurance if over the age of 16
		double ei = 0;
		if (age >= 16) {
			ei = gross * 0.0295;
		}
		
		// Calculate income tax
		double it = gross * 0.25;
		
		// find the net from deducting the deductables from gross
		double net = gross - cpp - ei - it;
		
		// Use decimalformat to get the decimal places correct
		DecimalFormat df = new DecimalFormat("$###,###.00");
		String output = df.format(net);
		
		
		// Print a nice output for the user
		c.println("Hey " + name + ", you are " + age + " years old! Since you worked " + hours + " hours at $" + wage + " you made " + output);
		
		
	} // main method
} // test class
