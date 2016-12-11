package edu.rit.cs.csci651.mail.service;

import edu.rit.cs.csci651.mail.model.ExchangeServerSettings;
import edu.rit.cs.csci651.mail.model.IMAPFolder;
import edu.rit.cs.csci651.mail.model.Message;
import edu.rit.cs.csci651.mail.model.SMTPMessage;
import edu.rit.cs.csci651.mail.model.User;

public class TestImap {

	public static void main(String[] args) {
		User user = new User("vinayaksmtp@gmail.com", "vin@y@ksmtp");
		ExchangeServerSettings settings = new ExchangeServerSettings();
		settings.setSmtpServerAddress("smtp.gmail.com");
		settings.setPopServerAddress("pop.gmail.com");
		settings.setImapServerAddress("imap.gmail.com");
		settings.setSmtpPort(465);
		settings.setImapPort(993);
		settings.setPopPort(995);
		settings.setSslRequired(true);
		user.setMailServerSettings(settings);
		SMTPMessage message = new SMTPMessage();
		message.setFrom("vinayaksmtp@gmail.com");
		message.setTo("drs3114@rit.edu");
		message.setSubject("Test Subject");
		message.setPlainTextMessage("Test body from the SMTP library...");
		IMAPReceiver receiver = new IMAPReceiver(user);
		receiver.getImapFoldersForUser();
		System.out.println("+++++++++");
		for (IMAPFolder folder : user.getImapFolders()) {
			System.out.println(folder.getName());
			System.out.println("--------------------");
			for (Message msg : folder.getMessages()) {
				System.out.println("to: "+msg.getTo());
				System.out.println("from: "+msg.getFrom());
				System.out.println("date: "+msg.getDate());
				System.out.println("subject: "+msg.getSubject());
				System.out.println(msg.getBody());
			}
			System.out.println("----------------------");
		}
	}
}
