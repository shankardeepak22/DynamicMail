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

import edu.rit.cs.csci651.mail.model.IMAPFolder;
import edu.rit.cs.csci651.mail.model.Message;
import edu.rit.cs.csci651.mail.model.User;

/**
 * @author Deepak
 *
 */
public class IMAPReceiver {
	private User user;
	private IMAPCommandService commandService;
	private Socket socket;
	private SocketFactory socketFactory;
	private BufferedReader reader;
	private BufferedWriter writer;

	public IMAPReceiver(User user) {
		this.user = user;

	}

	public void getImapFoldersForUser() {
		List<IMAPFolder> folders = new ArrayList<>();
		try {
			init();
			String response = "";
			while (!(response = reader.readLine()).contains("* OK")) {
				System.out.println(response);
			}
			commandService.askToLogin(user.getUsername(), user.getPassword());
			while (!(response = reader.readLine()).contains("a1 OK")) {
				System.out.println(response);
			}
			commandService.listAll();
			while (!(response = reader.readLine()).contains("a2 OK")) {
				System.out.println(response);
				String[] folderNames = response.split("\"/\"");
				IMAPFolder folder = new IMAPFolder(folderNames[folderNames.length - 1]);
				folders.add(folder);
			}
			List<IMAPFolder> invalidFOlders = new ArrayList<>();
			for (IMAPFolder imapFolder : folders) {
				if (!populateFolder(imapFolder)) {
					invalidFOlders.add(imapFolder);
				}

			}
			for (IMAPFolder imapFolder : invalidFOlders) {
				folders.remove(imapFolder);
			}
			user.setImapFolders(folders);

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private boolean populateFolder(IMAPFolder imapFolder) {

		try {
			List<Message> messages = new ArrayList<>();
			int numberOfMessages = 0;
			commandService.examineFolder(imapFolder.getName());
			String response = "";

			boolean body = false;
			while (!(response = reader.readLine()).contains("a3 OK")) {
				if (response.contains("a3 NO")) {
					return false;
				}
				if (response.contains("EXISTS")) {
					System.out.println(response);
					String[] result = response.split(" ");
					numberOfMessages = Integer.parseInt(result[1]);

				}
				System.out.println(response);
			}
			for (int i = 1; i <= numberOfMessages; i++) {
				Message message = new Message();
				String bodyMessage = "";
				commandService.fetchHeader(String.valueOf(i));
				while (!(response = reader.readLine()).contains("a4 OK")) {
					if (response.contains("Date:")) {
						message.setDate(response.split(":")[1]);
					}
					if (response.contains("SUBJECT:")) {
						message.setSubject(response.split(":")[1]);
					}
					if (response.contains("From:")) {
						message.setFrom(response.split(":")[1]);
					}

				}
				commandService.fetchMessage(String.valueOf(i));

				while (!(response = reader.readLine()).contains("a4 OK")) {

					if (!response.contains("FETCH")) {
						bodyMessage += response.trim();
					}

				}
				System.out.println("Body length: " + bodyMessage.length());
				message.setBody(bodyMessage);
				System.out.println(bodyMessage);
				messages.add(message);

			}
			imapFolder.setMessages(messages);
		} catch (IOException e) {

			e.printStackTrace();
		} 
		return true;

	}

	private void init() throws UnknownHostException, IOException {
		connect();
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		commandService = new IMAPCommandService(writer);
	}

	private void connect() throws UnknownHostException, IOException {
		if (this.user.getMailServerSettings().isSslRequired()) {
			socketFactory = SSLSocketFactory.getDefault();
		}
		socket = socketFactory.createSocket(this.user.getMailServerSettings().getImapServerAddress(),
				this.user.getMailServerSettings().getImapPort());
	}

}
