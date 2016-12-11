/**
 * 
 */
package edu.rit.cs.csci651.mail.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak
 *
 */
public class IMAPFolder {

	private String name;
	private List<Message> messages;

	public IMAPFolder(String name) {
		this.name = name;
		this.messages = new ArrayList<>();

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

}
