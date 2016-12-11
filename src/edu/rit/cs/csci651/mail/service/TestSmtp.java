/**
 * 
 */
package edu.rit.cs.csci651.mail.service;

import edu.rit.cs.csci651.mail.model.ExchangeServerSettings;
import edu.rit.cs.csci651.mail.model.SMTPMessage;
import edu.rit.cs.csci651.mail.model.User;

/**
 * @author Deepak
 *
 */
public class TestSmtp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User("shankar.deepak22@yahoo.com", "smtppassword");
		ExchangeServerSettings settings = new ExchangeServerSettings();
		settings.setSmtpServerAddress("smtp.mail.yahoo.com");
		settings.setPopServerAddress("pop.gmail.com");
		settings.setImapServerAddress("imap.gmail.com");
		settings.setSmtpPort(465);
		settings.setImapPort(993);
		settings.setPopPort(995);
		settings.setSslRequired(true);
		user.setMailServerSettings(settings);
		SMTPMessage message = new SMTPMessage();
		message.setFrom("shankar.deepak22@yahoo.com");
		message.setTo("drs3114@rit.edu");
		message.setSubject("Test Subject");
		message.setPlainTextMessage("Test body from the SMTP library...");
		SMTPSender sender = new SMTPSender(user, message);
		sender.secureSend();
	}

}
