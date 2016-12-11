/**
 * 
 */
package edu.rit.cs.csci651.mail.model;

import java.util.ArrayList;
import java.util.List;

import edu.rit.cs.csci651.mail.util.Base64Encoder;

/**
 * @author Deepak
 *
 */
public class User {

	private String username;
	private String password;
	private String base64User;
	private String base64Pass;
	private List<IMAPFolder> imapFolders;
	private List<Message> messages;

	private ExchangeServerSettings mailServerSettings;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.base64User = Base64Encoder.encode(username);
		this.base64Pass = Base64Encoder.encode(password);
		this.imapFolders = new ArrayList<>();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mailServerSettings
	 */
	public ExchangeServerSettings getMailServerSettings() {
		return mailServerSettings;
	}

	/**
	 * @param mailServerSettings
	 *            the mailServerSettings to set
	 */
	public void setMailServerSettings(ExchangeServerSettings mailServerSettings) {
		this.mailServerSettings = mailServerSettings;
	}

	/**
	 * @return the base64User
	 */
	public String getBase64User() {
		return base64User;
	}

	/**
	 * @param base64User
	 *            the base64User to set
	 */
	public void setBase64User(String base64User) {
		this.base64User = base64User;
	}

	/**
	 * @return the base64Pass
	 */
	public String getBase64Pass() {
		return base64Pass;
	}

	/**
	 * @param base64Pass
	 *            the base64Pass to set
	 */
	public void setBase64Pass(String base64Pass) {
		this.base64Pass = base64Pass;
	}

	/**
	 * @return the imapFolders
	 */
	public List<IMAPFolder> getImapFolders() {
		return imapFolders;
	}

	/**
	 * @param imapFolders
	 *            the imapFolders to set
	 */
	public void setImapFolders(List<IMAPFolder> imapFolders) {
		this.imapFolders = imapFolders;
	}

	/**
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return username;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base64User == null) ? 0 : base64User.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (base64User == null) {
			if (other.base64User != null)
				return false;
		} else if (!base64User.equals(other.base64User))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
