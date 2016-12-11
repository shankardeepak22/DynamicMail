/**
 * 
 */
package edu.rit.cs.csci651.mail.service;

import java.io.BufferedWriter;
import java.io.IOException;

import edu.rit.cs.csci651.mail.model.POPCommand;

/**
 * @author Deepak Ravi Shankar
 * 
 *
 */
public class POP3CommandService implements CommandService {

	BufferedWriter writer = null;

	public POP3CommandService(BufferedWriter writer) {
		this.writer = writer;
	}

	public void sendUser(String username) throws IOException {
		if (writer != null) {
			writer.write(POPCommand.USER + " " + username + "\r\n");
			writer.flush();
		}
	}

	public void sendPass(String password) throws IOException {
		if (writer != null) {
			writer.write(POPCommand.PASS + " " + password + "\r\n");
			writer.flush();
		}
	}

	public void list() throws IOException {
		if (writer != null) {
			writer.write(POPCommand.LIST);
			writer.flush();
		}
	}

	public void retrieve(String mid) throws IOException {
		if (writer != null) {
			writer.write(POPCommand.RETR + " " + mid + "\r\n");
			writer.flush();
		}
	}
	
	public void quit() throws IOException{
		if(writer!=null){
			writer.write(POPCommand.QUIT);
			writer.flush();
		}
	}

	@Override
	public void sendCommand(String cmd, BufferedWriter writer) throws IOException {
		// TODO Auto-generated method stub

	}

}
