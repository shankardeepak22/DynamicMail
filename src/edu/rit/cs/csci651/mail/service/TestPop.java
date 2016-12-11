/**
 * 
 */
package edu.rit.cs.csci651.mail.service;

import edu.rit.cs.csci651.mail.model.ExchangeServerSettings;
import edu.rit.cs.csci651.mail.model.Message;
import edu.rit.cs.csci651.mail.model.User;

/**
 * @author Deepak
 *
 */
public class TestPop {
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
		POP3Receiver receiver = new POP3Receiver(user);
		user = receiver.getMessagesForUser();
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("============================");
		for (Message msg : user.getMessages()) {
			System.out.println("from: "+msg.getFrom());
			System.out.println("To: "+msg.getTo());
			System.out.println("Date: "+msg.getDate());
			System.out.println("Subject: "+msg.getSubject());
			System.out.println("Body::");
			System.out.println(msg.getBody());
		}
	}
}
