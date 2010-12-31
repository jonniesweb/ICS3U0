/* Jonnie Simpson
 * Humberview S.S.
 * ICS 3U0, Created on 2010-12-15
 * Server.java
 * --------------------------------------------
 * Description TODO: Create a description
 * --------------------------------------------
 */

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Server extends JFrame {
	
	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private int counter = 1;
	
	public Server() {
		super("Server");
		
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
		
		container.add(enterField, BorderLayout.NORTH);
		
		// create displayAre
		displayArea = new JTextArea();
		container.add(new JScrollPane(displayArea), BorderLayout.CENTER);
		
		setSize(300, 150);
		setVisible(true);
		
	}// end Server
	
	// set up and run server
	public void runServer() {
		try {
			server = new ServerSocket(12345, 100);
			
			while(true) {
				try {
					waitForConnection();
					getStreams();
					processConnection();
				} catch (EOFException eofException) {
					System.err.println("Server terminated connection");
				}
				
				finally {
					closeConnection();
					++counter;
					
				}
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	} // end method runServer

	private void waitForConnection() throws IOException {
		displayArea.setText("Waiting for connection\n");
		connection = server.accept(); // accept the connection
		displayArea.append("Connection " + counter + " recieved from: " + connection.getInetAddress().getHostName());
		
	}
	
	// get streams to send and recieve data
	private void getStreams() throws IOException {
		// set up output and stream for objects
		output = new ObjectOutputStream(connection.getOutputStream());
		
		//flush output buffer to send header information
		output.flush();
		
		//set up input stream for objects
		input = new ObjectInputStream(connection.getInputStream());
		
		displayArea.append("\nGot I/O streams\n");
	}
	
	// process connection with client
	private void processConnection() throws IOException {
		
		// send connection successful message to client
		String message = "SERVER>>> Connection Successful";
		output.writeObject(message);
		output.flush();
		
		// enable enterField so server user can sed messages
		enterField.setEnabled(true);
		
		// process messages sent from client
		do {
			
			// read messages and display it
			try {
				message = (String) input.readObject();
				displayArea.append("\n" + message);
				displayArea.setCaretPosition(displayArea.getText().length());
			} catch (ClassNotFoundException classNotFoundException) {
				displayArea.append("\nUnknown object type recieved");
			} // end try
			
		} while (!message.equals("CLIENT>>> TERMINATE"));
		
	} // end method
	
	
	// close streams and socket
	private void closeConnection() throws IOException {
		displayArea.append("\nUser terminated connection");
		enterField.setEnabled(false);
		output.close();
		input.close();
		connection.close();
	}
	
	// send message to client
	private void sendData(String message) {
		
		// send object to client
		try {
			output.writeObject("SERVER>>> " + message);
			output.flush();
			displayArea.append("\nSERVER>>> " + message); 
		} catch (IOException ioException) {
			displayArea.append("\nError writing object");
		}
	}
	
	// execute application
	public static void main(String args[]) {
		Server application = new Server();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		application.runServer();
	}
	
	//
	
}
