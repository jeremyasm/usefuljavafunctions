package com.jeremyasm.util.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Week {
	
	/**
	 * Get the first timestamp of the week
	 * @param timestamp
	 * @return firstTimestamp, the first timestamp of Monday of this week
	 * @throws ParseException
	 */
	public static long getFirstTimestampOfWeek(long timestamp) throws ParseException{

		SimpleDateFormat dayFormat =  new SimpleDateFormat("yyyy-MM-dd");  
		String formatedTs = dayFormat.format(timestamp);  
	    Date date = dayFormat.parse(formatedTs); 
	    Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY);   
		cal.set(Calendar. DAY_OF_WEEK, Calendar.MONDAY);  
		long firstTimestamp = cal.getTimeInMillis();
		return firstTimestamp;
	}
	
	
	/**
	 * Get the first timestamp of the week
	 * @param timestamp
	 * @return firstTimestamp, the first timestamp of Monday of this week
	 * @throws ParseException
	 */
	public static String getFirstTimestampOfWeek(String timestamp) throws ParseException{
		return getFirstTimestampOfWeek(Long.parseLong(timestamp))+"";
	}

	
	/**
	 * Get the last timestamp of the week
	 * @param timestamp
	 * @return lastTimestamp, the last timestamp of Sunday of this week
	 * @throws ParseException
	 */
	public static long getLastTimestampOfWeek(long timestamp) throws ParseException{

		SimpleDateFormat dayFormat =  new SimpleDateFormat("yyyy-MM-dd");  
		String formatedTs = dayFormat.format(timestamp);  
	    Date date = dayFormat.parse(formatedTs); 
	    Calendar cal = Calendar.getInstance();  
	    int day_of_week = cal.get(Calendar. DAY_OF_WEEK) - 1;  
	    if (day_of_week == 0 ) {  
	        day_of_week = 7 ;  
	    }  
	    cal.setTime(date);
	    cal.add(Calendar.DATE , -day_of_week + 7);  
	    long lastTimestamp = cal.getTimeInMillis() + 86399000;
	    return lastTimestamp;
	}
	
	
	/**
	 * Get the last timestamp of the week
	 * @param timestamp
	 * @return lastTimestamp, the last timestamp of Sunday of this week
	 * @throws ParseException
	 */
	public static String getLastTimestampOfWeek(String timestamp) throws ParseException{
		return getLastTimestampOfWeek(Long.parseLong(timestamp))+"";
	}
	

}
