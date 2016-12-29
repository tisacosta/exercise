package com.jumia.followupExercise.utilities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class generates random {@link LocalDateTime} dates to be used
 * in by {@link DummyDataGenerator}
 * @author teresa
 *
 */
public class RandomDateGenerator {

	/**
	 * Generates a random date in a range of years
	 * @param startYear {@link Integer} smallest value
	 * @param endYear {@link Integer} higher value
	 * @return {@link LocalDateTime} random generated date
	 */
	public static LocalDateTime getRandomDateBetween(int startYear, int endYear) {
		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(startYear, endYear);
		gc.set(Calendar.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		gc.set(Calendar.HOUR, randBetween(0, 23));
		gc.set(Calendar.MINUTE, randBetween(0, 60));
		gc.set(Calendar.SECOND, randBetween(0, 60));
		Instant instant = Instant.ofEpochMilli(gc.getTime().getTime());
		
		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
	}

	/**
	 * Gets a random value in range
	 * @param start {@link Integer} lower bound
	 * @param end {@link Integer} upper bound
	 * @return {@link Integer} random value
	 */
	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
