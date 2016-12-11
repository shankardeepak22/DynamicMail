/**
 * 
 */
package edu.rit.cs.csci651.mail.service;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author Deepak
 *
 */
public class IMAPCommandService implements CommandService {

	BufferedWriter writer = null;

	public IMAPCommandService(BufferedWriter writer) {
		this.writer = writer;
	}

	public void askToLogin(String username, String password) throws IOException {
		if (writer != null) {
			writer.write("a1 LOGIN " + username + " " + password + "\r\n");
			writer.flush();
		}
	}

	public void listAll() throws IOException {
		if (writer != null) {
			String command = "a2 LIST \"\" \"*\"\r\n";
			System.out.println("List command: " + command);
			writer.write(command);
			writer.flush();
		}
	}

	public void examineFolder(String foldername) throws IOException {
		if (writer != null) {
			String cmd = "a3 EXAMINE" + foldername + "\r\n";
			System.out.println("Examine cmd: " + cmd);
			writer.write(cmd);
			writer.flush();
		}
	}

	public void fetchMessage(String msgID) throws IOException {
		if (writer != null) {
			writer.write("a4 FETCH " + msgID + " BODY[TEXT]\r\n");
			writer.flush();
		}
	}

	@Override
	public void sendCommand(String cmd, BufferedWriter writer) throws IOException {
		writer.write(cmd);
		writer.flush();

	}

	public void fetchHeader(String msgID) throws IOException {

		if (writer != null) {
			writer.write("a4 FETCH " + msgID + " (FLAGS BODY[HEADER.FIELDS (DATE FROM SUBJECT)])\r\n");
			writer.flush();
		}

	}

}
