/**
 * 
 */
package edu.rit.cs.csci651.mail.util;

import java.util.Base64;

/**
 * @author Deepak
 *
 */
public class Base64Encoder {

	public static String encode(String plainText) {
		return Base64.getEncoder().encodeToString(plainText.getBytes());
	}

}
