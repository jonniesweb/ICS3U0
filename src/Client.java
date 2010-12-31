import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-17
 * Client.java
 * --------------------------------------------
 * Description TODO: Create a description
 * --------------------------------------------
 */



public class Client extends JFrame {

	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String chatServer;
	private Socket client;

	// Initialise chatServer and set up GUI
	public Client(String host) {
		super("Client");

		chatServer = host; // set server to which this client connects

		Container container = getContentPane();

		// create enterField and register listener
		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				sendData(event.getActionCommand());
				enterField.setText("");

			}
		}
		);

		container.add(enterField, BorderLayout.SOUTH);

		//create displayArea
		displayArea = new JTextArea();
		container.add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(300, 150);
		setVisible(true);
	}

	// connect to server and process messages from server
	public void runClient() {

		// connect to server, get streams, process connection
		try {
			connectToServer(); // step 1: create a socket to make connection
			getStreams(); // step 2: get the input and output streams
			processConnection(); // process connection
		} catch (EOFException ioException) {
			System.err.println("Client terminated connection");

		} catch (IOException ioException) {
			ioException.printStackTrace();

		} finally {
			closeConnection();
		}
	}

	// connect to server
	private void connectToServer() throws IOException {
		displayMessage("Attempting connection\n");

		// create Socket to make connection to server
		client = new Socket(InetAddress.getByName(chatServer), 12345);

		//display connection information
		displayMessage("Connected to: " + client.getInetAddress().getHostName());

	}

	// get streams to send and receive data
	private void getStreams() throws IOException {

		// set up output stream for objects
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush(); // flush output buffer to send header information

		// set up input stream for objects
		input = new ObjectInputStream(client.getInputStream());

		displayMessage("\nGot I/O streams\n");


	}

	// process connection with server
	private void processConnection() throws IOException {

		// enable enterField so client user can send messages
		setTextFieldEditable(true);

		do {
			try {
				message = (String) input.readObject();
				displayMessage("\n " + message);
			} catch (ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type recieved");
			}
		} while (!message.equals("SERVER>>> TERMINATE"));

	}

	// close streams and socket
	private void closeConnection() {
		displayMessage("\nClosing connection");
		setTextFieldEditable(false);

		try {
			output.close();
			input.close();
			client.close();

		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	// send message to server
	private void sendData(String message) {
		try {
			output.writeObject("CLIENT>>> " + message);
			output.flush(); // send data to server
			displayMessage("\nCLIENT>>> " + message);
		} catch (IOException ioException) {
			displayArea.append("\nError writing object");
		}
	}

	// manipulates the displayArea in the event-dispatch thread
	private void displayMessage(final String messageToDisplay) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				
				displayArea.append(messageToDisplay);

			}
		}
		);
	}

	// manipulates enterField in the event-dispatch thread
	private void setTextFieldEditable(final boolean editable) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				enterField.setEditable(editable); // set enterFields editability

			}
		}
		);
	}
	
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

