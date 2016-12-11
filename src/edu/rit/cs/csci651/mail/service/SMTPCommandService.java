/**
 * 
 */
package edu.rit.cs.csci651.mail.service;

import java.io.BufferedWriter;
import java.io.IOException;

import edu.rit.cs.csci651.mail.model.SMTPCommand;

/**
 * @author Deepak
 *
 */
public class SMTPCommandService implements CommandService {

	BufferedWriter writer = null;

	public SMTPCommandService(BufferedWriter writer) {
		this.writer = writer;
	}

	public void sendHelo() throws IOException {
		if (writer != null)
			sendCommand(SMTPCommand.HELO, writer);
	}

	public void sendEhlo() throws IOException {
		String greetings = System.getProperty("user.name");
		System.out.println("greetings: "+greetings);
		if (writer != null)
			sendCommand(SMTPCommand.EHLO+" "+greetings+"\r\n", writer);
	}

	public void sendAuthLogin() throws IOException {
		if (writer != null)
			sendCommand(SMTPCommand.AUTH, writer);
	}

	public void sendData() throws IOException {
		if (writer != null)
			sendCommand(SMTPCommand.DATA, writer);
	}

	public void sendQuit() throws IOException {
		if (writer != null)
			sendCommand(SMTPCommand.QUIT, writer);
	}

	@Override
	public void sendCommand(String cmd, BufferedWriter writer) throws IOException {
		writer.write(cmd);
		writer.flush();

	}

}
