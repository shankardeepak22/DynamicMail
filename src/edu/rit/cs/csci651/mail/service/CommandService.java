/**
 * 
 */
package edu.rit.cs.csci651.mail.service;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author Deepak
 *
 */
public interface CommandService {

	public void sendCommand(String cmd, BufferedWriter writer) throws IOException;

}
