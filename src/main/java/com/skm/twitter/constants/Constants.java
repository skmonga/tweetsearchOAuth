package com.skm.twitter.constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final String ACCESS_TOKEN = "";
	
	public static final String ACCESS_TOKEN_SECRET = "";
	
	public static final String CONSUMER_KEY = "";
	
	public static final String CONSUMER_KEY_SECRET = "";
	
	public enum TextLocation {
		INHASHTAG,WITHINTWEET,INSIDEUSERNAME
	}
	
	public static final String replaceWithActualText = "$text$";
	
	public static Map<TextLocation, String> patterns = new HashMap<>();
	
	static {
		patterns.put(TextLocation.INHASHTAG, "#.*$text$.*");
		patterns.put(TextLocation.WITHINTWEET, ".*$text$.*");
		patterns.put(TextLocation.INSIDEUSERNAME, "@.*$text$.*");
	}
	
	
}
