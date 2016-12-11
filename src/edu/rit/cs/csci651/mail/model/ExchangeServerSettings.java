/**
 * 
 */
package edu.rit.cs.csci651.mail.model;

/**
 * @author Deepak
 *
 */
public class ExchangeServerSettings {

	private String smtpServerAddress;
	private String imapServerAddress;
	private String popServerAddress;
	private int smtpPort;
	private int imapPort;
	private int popPort;
	private boolean sslRequired;

	/**
	 * 
	 */
	public ExchangeServerSettings() {
		super();
	}

	/**
	 * @return the smtpServerAddress
	 */
	public String getSmtpServerAddress() {
		return smtpServerAddress;
	}

	/**
	 * @param smtpServerAddress
	 *            the smtpServerAddress to set
	 */
	public void setSmtpServerAddress(String smtpServerAddress) {
		this.smtpServerAddress = smtpServerAddress;
	}

	/**
	 * @return the imapServerAddress
	 */
	public String getImapServerAddress() {
		return imapServerAddress;
	}

	/**
	 * @param imapServerAddress
	 *            the imapServerAddress to set
	 */
	public void setImapServerAddress(String imapServerAddress) {
		this.imapServerAddress = imapServerAddress;
	}

	/**
	 * @return the popServerAddress
	 */
	public String getPopServerAddress() {
		return popServerAddress;
	}

	/**
	 * @param popServerAddress
	 *            the popServerAddress to set
	 */
	public void setPopServerAddress(String popServerAddress) {
		this.popServerAddress = popServerAddress;
	}

	/**
	 * @return the smtpPort
	 */
	public int getSmtpPort() {
		return smtpPort;
	}

	/**
	 * @param smtpPort
	 *            the smtpPort to set
	 */
	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}

	/**
	 * @return the imapPort
	 */
	public int getImapPort() {
		return imapPort;
	}

	/**
	 * @param imapPort
	 *            the imapPort to set
	 */
	public void setImapPort(int imapPort) {
		this.imapPort = imapPort;
	}

	/**
	 * @return the popPort
	 */
	public int getPopPort() {
		return popPort;
	}

	/**
	 * @param popPort
	 *            the popPort to set
	 */
	public void setPopPort(int popPort) {
		this.popPort = popPort;
	}

	/**
	 * @return the sslRequired
	 */
	public boolean isSslRequired() {
		return sslRequired;
	}

	/**
	 * @param sslRequired
	 *            the sslRequired to set
	 */
	public void setSslRequired(boolean sslRequired) {
		this.sslRequired = sslRequired;
	}

}
