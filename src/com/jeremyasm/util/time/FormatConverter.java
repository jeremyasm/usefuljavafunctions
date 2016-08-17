package com.jeremyasm.util.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatConverter {
	
	/**
	 * Convert date to timestamp
	 * @param dateStr, a string date in the format of "yyyy-MM-dd HH:mm:ss"
	 * @return timestampStr
	 * @throws ParseException
	 */
	public static String convertToTimestampString(String dateStr) throws ParseException{
		long timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.parse(dateStr)
								.getTime();
		String timestampStr = timestamp + "";
		return timestampStr;
	}

	
	/**
	 * Convert timestamp to date
	 * @param timestampStr
	 * @return dateStr, a string date in the format of "yyyy-MM-dd HH:mm:ss"
	 * @throws ParseException
	 */
	public static String convertToDateString(String timestampStr) throws ParseException{
		long timestamp = Long.parseLong(timestampStr);
		SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateStr = dateFormat.format(timestamp);  	
		return dateStr;
	} 
	
}
