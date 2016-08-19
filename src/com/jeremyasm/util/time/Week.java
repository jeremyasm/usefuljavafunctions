package com.jeremyasm.util.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Week {
	
	public static int TIMEZONE_DIFF = 8; //0 for UK, 1 for Germany, 8 for China
	public static long HOUR_IN_MS = 3600000L; //how many milliseconds in one hour
	public static long DAY_IN_MS = 86400000L; //how many milliseconds in one day
	public static long WEEK_IN_MS = 604800000L; //How many milliseconds in one week
	public static long WEEKDAY_OFFSET = 3* DAY_IN_MS + TIMEZONE_DIFF * HOUR_IN_MS; ////1970-01-01 is Thursday, and the 2nd part is about time-zone

	/**
	 * Get the first timestamp of the week (Smart Version)
	 * @param timestamp
	 * @return firstTimestamp, the first timestamp of Monday of this week
	 * @throws ParseException
	 */
	public static long getFirstTimestampOfWeek(long timestamp) throws ParseException{

		long firstTs = timestamp - (timestamp + WEEKDAY_OFFSET) % WEEK_IN_MS;
		return firstTs;
		
	}

	/**
	 * Get the last timestamp of the week (Smart Version)
	 * @param timestamp
	 * @return lastTimestamp, the last timestamp of Sunday of this week
	 * @throws ParseException
	 */
	public static long getLastTimestampOfWeek(long timestamp) throws ParseException{

		long lastTs = getFirstTimestampOfWeek(timestamp) + WEEK_IN_MS - 1;
		return lastTs;
		
	}
	
	//input String, return String
	public static String getFirstTimestampOfWeek(String timestamp) throws ParseException{
		return getFirstTimestampOfWeek(Long.parseLong(timestamp))+"";
	}
	
	//input String, return String
	public static String getLastTimestampOfWeek(String timestamp) throws ParseException{
		return getLastTimestampOfWeek(Long.parseLong(timestamp))+"";
	}
	
//	/**
//	 * Get the first timestamp of the week (STUPID VERSION, see the smart version above.)
//	 * @param timestamp
//	 * @return firstTimestamp, the first timestamp of Monday of this week
//	 * @throws ParseException
//	 */
//	public static long getFirstTimestampOfWeek(long timestamp) throws ParseException{
//
//		SimpleDateFormat dayFormat =  new SimpleDateFormat("yyyy-MM-dd");  
//		String formatedTs = dayFormat.format(timestamp);  
//	    Date date = dayFormat.parse(formatedTs); 
//	    Calendar cal = Calendar.getInstance(); 
//		cal.setTime(date);
//		cal.setFirstDayOfWeek(Calendar.MONDAY);   
//		cal.set(Calendar. DAY_OF_WEEK, Calendar.MONDAY);  
//		long firstTimestamp = cal.getTimeInMillis();
//		return firstTimestamp;
//	}
//
//	/**
//	 * Get the last timestamp of the week (STUPID VERSION, see the smart version above.)
//	 * @param timestamp
//	 * @return lastTimestamp, the last timestamp of Sunday of this week
//	 * @throws ParseException
//	 */
//	public static long getLastTimestampOfWeek(long timestamp) throws ParseException{
//
//		SimpleDateFormat dayFormat =  new SimpleDateFormat("yyyy-MM-dd");  
//		String formatedTs = dayFormat.format(timestamp);  
//	    Date date = dayFormat.parse(formatedTs); 
//	    Calendar cal = Calendar.getInstance();  
//	    int day_of_week = cal.get(Calendar. DAY_OF_WEEK) - 1;  
//	    if (day_of_week == 0 ) {  
//	        day_of_week = 7 ;  
//	    }  
//	    cal.setTime(date);
//	    cal.add(Calendar.DATE , -day_of_week + 7);  
//	    long lastTimestamp = cal.getTimeInMillis() + 86399000;
//	    return lastTimestamp;
//	}
//	
//	

}
