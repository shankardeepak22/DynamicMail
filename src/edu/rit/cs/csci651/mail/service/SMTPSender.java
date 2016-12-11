/**
 * 
 */
package edu.rit.cs.csci651.mail.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import edu.rit.cs.csci651.mail.model.SMTPMessage;
import edu.rit.cs.csci651.mail.model.User;

/**
 * @author Deepak
 *
 */
public class SMTPSender {
	private User user;
	private SMTPMessage message;
	private SocketFactory socketFactory;
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private SMTPCommandService commandService;

	public SMTPSender(User user, SMTPMessage message) {
		this.user = user;
		this.message = message;
	}

	public void secureSend() {
		try {
			init();
			System.out.println("Initialized...");
			print();
			System.out.println("sending helo...");
			commandService.sendEhlo();
			printhlo();
			commandService.sendAuthLogin();
			print();
			System.out.println("logging in...");
			writer.write(user.getBase64User());
			writer.write("\r\n");
			writer.flush();

			print();

			writer.write(user.getBase64Pass());
			writer.write("\r\n");
			writer.flush();

			print();
			System.out.println("logged in...");

			writer.write("MAIL FROM:<" + message.getFrom() + ">");
			writer.write("\r\n");
			writer.flush();

			print();

			writer.write("RCPT TO:<" + message.getTo() + ">");
			writer.write("\r\n");
			writer.flush();

			print();

			writer.write("DATA");
			writer.write("\r\n");
			writer.flush();

			print();
			if (message.getSubject() != "" || message.getSubject() != null) {
				writer.write("SUBJECT: " + message.getSubject());
				writer.write("\r\n");
				writer.flush();
			}

			writer.write(message.getPlainTextMessage());
			writer.write("\r\n.\r\n");
			writer.flush();

			print();
			System.out.println("sending quit");
			commandService.sendQuit();
			print();
			
			

		} catch (IOException e) {

			e.printStackTrace();
		}
		finally{
			
			
		}
	}

	private void print() {
		try {
			System.out.println(reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	private void printhlo() {
		String response = "";
		try {
			while(!(response = reader.readLine()).contains("250 ")){
				System.out.println(response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void init() throws UnknownHostException, IOException {
		connect();
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		commandService = new SMTPCommandService(writer);
	}

	private void connect() throws UnknownHostException, IOException {
		if (this.user.getMailServerSettings().isSslRequired()) {
			socketFactory = SSLSocketFactory.getDefault();
		}
		socket = socketFactory.createSocket(this.user.getMailServerSettings().getSmtpServerAddress(),
				this.user.getMailServerSettings().getSmtpPort());
	}

}
