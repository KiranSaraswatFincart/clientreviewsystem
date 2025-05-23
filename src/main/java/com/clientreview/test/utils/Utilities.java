package com.clientreview.test.utils;

import java.util.Date;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10; 
	public static final int PAGE_LOAD_TIME=10;
	public static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
}
