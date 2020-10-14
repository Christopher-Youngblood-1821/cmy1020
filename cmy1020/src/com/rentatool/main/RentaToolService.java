/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object will serve as the primary computational hub for the project.
 ***************************************************************************************/

package com.rentatool.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import com.rentatool.models.RentalAgreement;
import com.rentatool.models.Tool;

public class RentaToolService {

	private static RentaToolDao rentaToolDao = new RentaToolDao();
	private static RentaToolUtil rentaToolUtil = new RentaToolUtil();
	
	//simple get function
	public ArrayList<Tool> getTools(Tool criteria){
		ArrayList<Tool> result = new ArrayList<Tool>();
		
		try {
			result = rentaToolDao.getTools(criteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public RentalAgreement processRentalAgreement(Tool selectedTool, RentalAgreement newRentalAgreement) {
		
		//Tool Code
		newRentalAgreement.setToolCode(selectedTool.getToolCode());
		
		//Tool Type
		newRentalAgreement.setToolType(selectedTool.getToolType());
		
		//Tool Brand
		newRentalAgreement.setBrand(selectedTool.getBrand());
		
		//Rental Days
		////Already Set
		
		//Checkout Date
		////Already Set
		
		//Due Date
		newRentalAgreement.setDueDate(
			newRentalAgreement.getCheckoutDate()
				.plusDays(newRentalAgreement.getRentalDays()));
		
		//Daily Charge
		newRentalAgreement.setDailyCharge(selectedTool.getDailyCharge());
		
		//Charge Days
		newRentalAgreement.setChargeDays(calculateChargableDays(selectedTool, newRentalAgreement));
		
		//Pre-Discount Charge
		////preDiscountCharge = dailyCharge * chargeDays
		newRentalAgreement.setPreDiscountCharge(
				newRentalAgreement.getDailyCharge().multiply(
						new BigDecimal(newRentalAgreement.getChargeDays())));
		
		//Discount Percentage
		////Already Set
		
		//Discount Amount
		////discountAmount = preDiscountCharge * (discountPercentage/100)
		newRentalAgreement.setDiscountAmount(
				newRentalAgreement.getPreDiscountCharge().multiply(
							newRentalAgreement.getDiscountPercentage()).divide(
									new BigDecimal(100)
				).setScale(2, RoundingMode.HALF_UP));
		
		//Final Charge
		////finalCharge = preDiscountCharge - discount Amount
		newRentalAgreement.setFinalCharge(
				newRentalAgreement.getPreDiscountCharge().subtract(
						newRentalAgreement.getDiscountAmount()
				).setScale(2, RoundingMode.HALF_UP));
		
		return newRentalAgreement;
	}
	
	//Seperated out mostly for the sake of readability
	//Removes any days that are unchargable from the rental days
	public Integer calculateChargableDays(Tool selectedTool, RentalAgreement newRentalAgreement){
		Integer chargeDays = newRentalAgreement.getRentalDays();
		LocalDate dayToCheck = newRentalAgreement.getCheckoutDate();

		//as specified by the design document, "from day *after* checkout
		dayToCheck = dayToCheck.plusDays(1);
		
		//Iterate through the days following the initial checkout date
		for (Integer i = 0; i < newRentalAgreement.getRentalDays(); i++) {
			
			//Used to track and make sure that the customer can't get double discounts if a holiday
			//	falls on a weekend, etc.
			boolean chargedToday = true;
			
			if (!selectedTool.isWeekdayCharge()
					&& !(dayToCheck.getDayOfWeek().equals(DayOfWeek.SATURDAY)
							|| dayToCheck.getDayOfWeek().equals(DayOfWeek.SUNDAY))
					&& chargedToday) {
				//If we don't charge for weekdays and it's Sat or Sun
				chargeDays -= 1;
				chargedToday = false;
			}
			
			if (!selectedTool.isWeekendCharge()
					&& (dayToCheck.getDayOfWeek().equals(DayOfWeek.SATURDAY)
							|| dayToCheck.getDayOfWeek().equals(DayOfWeek.SUNDAY))
					&& chargedToday) {
				//If we don't charge for weekends and it's Sat or Sun
				chargeDays -= 1;
				chargedToday = false;
			}
			
			if (!selectedTool.isHolidayCharge()
					&& rentaToolUtil.checkForHoliday(dayToCheck)
					&& chargedToday) {
				//If we don't charge for holidays and it is a holiday
				chargeDays -= 1;
				chargedToday = false;
			}
			
			dayToCheck = dayToCheck.plusDays(1);
		}
		
		return chargeDays;
	}
	
}
