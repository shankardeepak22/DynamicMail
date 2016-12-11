/**
 * 
 */
package edu.rit.cs.csci651.mail.model;

/**
 * @author Deepak
 *
 */
public enum CommandType {

	/*
	 * Used to identify a SMTP command type.
	 */
	SMTP("SMTP", 1),
	/*
	 * Used to identify a IMAP command type.
	 */
	IMAP("IMAP", 2),
	/*
	 * Used to identify a POP3 command type.
	 */
	POP3("POP3", 3);
	// this is the string to be displayed when enumeration is refereed to be
	// displayed.
	private String displayName;

	// this is the id that uniquely represents the each enumeration.
	private int id;

	// This is a constructor to create an enumeration.
	private CommandType(final String displayName, final int id) {
		this.displayName = displayName;
		this.id = id;

	}

	/**
	 * This is method is used to get the string representation of the
	 * enumeration.
	 * 
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * This method is used to get the id of an enumeration.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method is used to get the name of the enumeration.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name();
	}

}
