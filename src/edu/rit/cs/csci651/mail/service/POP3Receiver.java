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
import java.util.ArrayList;
import java.util.List;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import edu.rit.cs.csci651.mail.model.Message;
import edu.rit.cs.csci651.mail.model.User;

/**
 * @author Deepak
 *
 */
public class POP3Receiver {

	private User user;
	private POP3CommandService commandService;
	private Socket socket;
	private SocketFactory socketFactory;
	private BufferedReader reader;
	private BufferedWriter writer;

	public POP3Receiver(User user) {
		this.user = user;
	}

	public User getMessagesForUser() {
		List<Message> messages = new ArrayList<>();
		try {
			init();
			String response = "";
			response = reader.readLine();
			System.out.println(response);
			if (response.startsWith("+OK")) {
				System.out.println("Sending user...");
				System.out.println(response);
				commandService.sendUser(user.getUsername());
				response = reader.readLine();
				if (response.startsWith("+OK")) {
					System.out.println("Sending pass...");
					System.out.println(response);
					commandService.sendPass(user.getPassword());
					response = reader.readLine();
					if (response.startsWith("+OK")) {
						System.out.println("sending list...");
						System.out.println(response);
						commandService.list();
						List<String> mids = new ArrayList<>();
						while (!(response = reader.readLine()).startsWith(".")) {
							if (response.startsWith("+OK")) {
								System.out.println(response);
								System.out.println(response);
							} else {
								String[] msgMeta = response.split(" ");
								mids.add(msgMeta[0]);
							}
						}
						for (String id : mids) {
							Message msg = new Message();
							boolean body = false;
							String bodyMsg = "";
							commandService.retrieve(id);
							while (!(response = reader.readLine()).startsWith(".")) {
								System.out.println(response);
								if (response.contains("To:")) {
									msg.setTo(response.split(": ")[1]);
								}
								if (response.contains("From:")) {
									msg.setFrom(response.split(": ")[1]);
								}
								if (response.contains("Date:")) {
									msg.setDate(response.split(": ")[1]);
								}
								if (response.contains("Subject:")) {
									msg.setSubject(response.split(": ")[1]);
								}
								if (response.contains("Content-Type:")) {
									body = true;
								}
								if (body) {
									bodyMsg += response;
								}
							}
							msg.setBody(bodyMsg);
							messages.add(msg);
						}
						commandService.quit();
					}
				}
			} else {

			}
			user.setMessages(messages);
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		finally{
			
		}
		return user;
	}

	private void init() throws UnknownHostException, IOException {
		connect();
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		commandService = new POP3CommandService(writer);
	}

	private void connect() throws UnknownHostException, IOException {
		if (this.user.getMailServerSettings().isSslRequired()) {
			socketFactory = SSLSocketFactory.getDefault();
		}
		socket = socketFactory.createSocket(this.user.getMailServerSettings().getPopServerAddress(),
				this.user.getMailServerSettings().getPopPort());
	}

}
