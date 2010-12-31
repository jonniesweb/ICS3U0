

/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-31
 * ClientTest.java
 * --------------------------------------------
 * Description TODO: Create a description
 * --------------------------------------------
 */

import javax.swing.JFrame;

public class ClientTest {

	public static void main(String[] args) {

		Client application;

		if (args.length == 0)

			application = new Client("127.0.0.1");

		else
			application = new Client(args[0]);
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runClient();
		


	}
}
