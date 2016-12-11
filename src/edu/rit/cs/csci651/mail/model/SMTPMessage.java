/**
 * 
 */
package edu.rit.cs.csci651.mail.model;

/**
 * @author Deepak
 *
 */
public class SMTPMessage {
	private String from;
	private String to;
	private String subject;
	private String plainTextMessage;

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the plainTextMessage
	 */
	public String getPlainTextMessage() {
		return plainTextMessage;
	}

	/**
	 * @param plainTextMessage
	 *            the plainTextMessage to set
	 */
	public void setPlainTextMessage(String plainTextMessage) {
		this.plainTextMessage = plainTextMessage;
	}

}
