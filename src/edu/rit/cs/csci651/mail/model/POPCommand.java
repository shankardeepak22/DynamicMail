/**
 * 
 */
package edu.rit.cs.csci651.mail.model;

/**
 * @author Deepak
 *
 */
public class POPCommand {
	public static final String USER = "USER";
	public static final String PASS = "PASS";
	public static final String QUIT = "QUIT\r\n";
	public static final String STAT = "STAT\r\n";
	public static final String LIST = "LIST\r\n";
	public static final String RETR = "RETR";
	public static final String DELE = "DELE";
	public static final String NOOP = "NOOP\r\n";
	public static final String LAST = "LAST\r\n";
	public static final String RSET = "RSET\r\n";
	// These are the additional commands
	public static final String TOP = "TOP";
	public static final String RPOP = "RPOP";
}
