package com.jeremyasm.test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.jeremyasm.util.time.Week;

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
		assertEquals("1472399999000", lastTs);
	}

	@Test
	public void testGetLastTimestampOfWeekString() throws ParseException {
		long timestamp = 1471970942000L;
		long lastTs = Week.getLastTimestampOfWeek(timestamp);
		assertEquals(1472399999000L, lastTs);
	}

}
