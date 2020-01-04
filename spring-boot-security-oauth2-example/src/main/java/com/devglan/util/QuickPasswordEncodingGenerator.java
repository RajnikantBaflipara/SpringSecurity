package com.devglan.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class QuickPasswordEncodingGenerator.
 */
public class QuickPasswordEncodingGenerator {
	
	/**
	 * Gets the encoded password.
	 *
	 * @param password the password
	
	 */
	public static void getEncodedPassword(String password) {		
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       // System.out.println(passwordEncoder.encode(password));
	}
	/*public static void main(String args[])
	{
		getEncodedPassword("admin");
	}*/
}