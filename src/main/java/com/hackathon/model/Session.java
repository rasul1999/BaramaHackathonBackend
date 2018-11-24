package com.hackathon.model;

import java.nio.charset.Charset;
import java.util.Random;


public class Session {

	public static String getNewToken() {
		byte[] array = new byte[16]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    return generatedString;
	}
}
