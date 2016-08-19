package com.jeremyasm.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.TimeZone;

import org.junit.Test;

import com.jeremyasm.util.time.Week;
import com.jeremyasm.util.time.FormatConverter;

public class WeekTest {

	@Test
	public void testGetFirstTimestampOfWeekLong() throws ParseException {
		String timestamp = "1471970942000";
		String firstTs = Week.getFirstTimestampOfWeek(timestamp);
		assertEquals("1471795200000", firstTs);
	}

	@Test
	public void testGetFirstTimestampOfWeekString() throws ParseException {
		long timestamp = 1471970942000L;
		long firstTs = Week.getFirstTimestampOfWeek(timestamp);
		assertEquals(1471795200000L, firstTs);
	}

	@Test
	public void testGetLastTimestampOfWeekLong() throws ParseException {
		String timestamp = "1471970942000";
		String lastTs = Week.getLastTimestampOfWeek(timestamp);
		assertEquals("1472399999999", lastTs);
	}

	@Test
	public void testGetLastTimestampOfWeekString() throws ParseException {
		long timestamp = 1471970942000L;
		long lastTs = Week.getLastTimestampOfWeek(timestamp);
		assertEquals(1472399999999L, lastTs);
	}
		
	@Test
	public void testGetFirstAndLastTsOfTheWeek() throws ParseException{
		
		long timestamp = 1472749323000L; //2016-9-1 01:02:03 THU
		long firstTs = Week.getFirstTimestampOfWeek(timestamp);
		long lastTs = Week.getLastTimestampOfWeek(timestamp);
		assertEquals(FormatConverter.convertToDateString(firstTs+""),"2016-08-29 00:00:00");
		assertEquals(FormatConverter.convertToDateString(lastTs+""),"2016-09-04 23:59:59");
		
		timestamp = 1472490123000L; //2016-8-30 01:02:03 TUE
		firstTs = Week.getFirstTimestampOfWeek(timestamp);
		lastTs = Week.getLastTimestampOfWeek(timestamp);
		assertEquals(FormatConverter.convertToDateString(firstTs+""),"2016-08-29 00:00:00");
		assertEquals(FormatConverter.convertToDateString(lastTs+""),"2016-09-04 23:59:59");
		
		timestamp = 1471539723000L; //2016-8-19 01:02:03 FRI
		firstTs = Week.getFirstTimestampOfWeek(timestamp);
		lastTs = Week.getLastTimestampOfWeek(timestamp);
		assertEquals(FormatConverter.convertToDateString(firstTs+""),"2016-08-15 00:00:00");
		assertEquals(FormatConverter.convertToDateString(lastTs+""),"2016-08-21 23:59:59");

	}

}
