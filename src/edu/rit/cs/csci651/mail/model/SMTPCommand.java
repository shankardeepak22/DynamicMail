/**
 * 
 */
package edu.rit.cs.csci651.mail.model;

/**
 * @author Deepak
 *
 */
public class SMTPCommand {

	public static final String HELO = "HELO";
	public static final String EHLO = "EHLO";
	public static final String AUTH = "AUTH LOGIN\r\n";
	public static final String DATA = "DATA\r\n";
	public static final String QUIT = "QUIT\r\n";

}
