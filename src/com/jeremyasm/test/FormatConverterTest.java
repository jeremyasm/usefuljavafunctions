package com.jeremyasm.test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.jeremyasm.util.time.FormatConverter;

public class FormatConverterTest {
	
	@Test
	public void testTransferToTimestampString() throws ParseException{
		String dateStr = "2016-08-15 22:22:22";
		String tsStr = FormatConverter.convertToTimestampString(dateStr);
		assertEquals(tsStr, "1471270942000");
	}
	
	@Test
	public void testTransferToDateString() throws ParseException{
		String tsStr = "1471270942000";
		String dateStr = FormatConverter.convertToDateString(tsStr);
		assertEquals(dateStr, "2016-08-15 22:22:22");
	}

}
