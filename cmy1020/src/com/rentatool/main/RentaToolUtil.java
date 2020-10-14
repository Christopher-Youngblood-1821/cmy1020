/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object services as a container for any methods deemed to be utility.
 ***************************************************************************************/

package com.rentatool.main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RentaToolUtil {
	
	final private static DateTimeFormatter rentaToolDateFormat = DateTimeFormatter.ofPattern("M/d/yy");

	public LocalDate formatDateTime(String input) {
		 LocalDate formatedDate = null;
		 
		 //failsoft
		 try {
			 formatedDate = LocalDate.parse(input, rentaToolDateFormat);
		 } catch (Exception e) {
			//e.printStackTrace();
		 }
		
		 return formatedDate;
	}
	
	public boolean checkForHoliday(LocalDate dayToCheck) {
		boolean isHoliday = false;
		ArrayList<LocalDate> holidays = new ArrayList<LocalDate>();
		
		//Independence Day
		LocalDate independenceDay = LocalDate.of(dayToCheck.getYear(), 7, 4);
				
		//Labor Day
		LocalDate laborDay = LocalDate.of(dayToCheck.getYear(), 9, 1); //Set to the first day of Sept.
		//Iterate through the days of Sept. until it reaches the first Monday
		while (!laborDay.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
			laborDay = laborDay.plusDays(1);
		}
				
		holidays.add(independenceDay);
		holidays.add(laborDay);
		
		isHoliday = holidays.contains(dayToCheck);
		
		return isHoliday;
	}
}
