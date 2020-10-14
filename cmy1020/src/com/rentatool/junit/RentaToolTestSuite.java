/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/13/2020
 * Description	: This suite will contain all the JUnit tests, implemented via a
 * 					Comparison of an expected result object verses a returned object.
 ***************************************************************************************/

package com.rentatool.junit;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.rentatool.main.RentaToolController;
import com.rentatool.main.RentaToolUtil;
import com.rentatool.models.InvaildDiscountPercentException;
import com.rentatool.models.InvalidRentalDaysException;
import com.rentatool.models.RentalAgreement;

public class RentaToolTestSuite {

	private static RentaToolUtil util = new RentaToolUtil();
	
	//Expected to throw an exception due to discount percentage
	@Test
	public void testCase1() throws InvalidRentalDaysException, InvaildDiscountPercentException {
		RentalAgreement actualAgreement = RentaToolController.rentalAgreementGeneration(	 "JAKR"
																							,"9/3/15" //checkoutDateIn
																							,5 //rentalDaysIn
																							,"101" //discountIn
																							);
	}
	
	@Test
	public void testCase2() throws InvalidRentalDaysException, InvaildDiscountPercentException {
		RentalAgreement expectedAgreement = new RentalAgreement(	 "LADW" //toolCode
																	,"Ladder" //toolType
																	,"Werner" //brand
																	,3 //rentalDays
																	,util.formatDateTime("7/2/20") //checkoutDate
																	,util.formatDateTime("7/5/20") //dueDate
																	,new BigDecimal("1.99") //dailyCharge
																	,2 //chargeDays
																	,new BigDecimal("3.98") //preDiscountCharge
																	,new BigDecimal("10") //discountPercentage
																	,new BigDecimal("0.40") //discountAmount
																	,new BigDecimal("3.58") //finalCharge
																	);
	    
		RentalAgreement actualAgreement = RentaToolController.rentalAgreementGeneration(	 "LADW"
																							,"7/2/20" //checkoutDateIn
																							,3 //rentalDaysIn
																							,"10" //discountIn
																							);
		
		assertEquals(expectedAgreement, actualAgreement);
	}
	
	@Test
	public void testCase3() throws InvalidRentalDaysException, InvaildDiscountPercentException {
		RentalAgreement expectedAgreement = new RentalAgreement(	 "CHNS" //toolCode
																	,"Chainsaw" //toolType
																	,"Stihl" //brand
																	,5 //rentalDays
																	,util.formatDateTime("7/2/15") //checkoutDate
																	,util.formatDateTime("7/7/15") //dueDate
																	,new BigDecimal("1.49") //dailyCharge
																	,3 //chargeDays
																	,new BigDecimal("4.47") //preDiscountCharge
																	,new BigDecimal("25") //discountPercentage
																	,new BigDecimal("1.12") //discountAmount
																	,new BigDecimal("3.35") //finalCharge
																	);
	    
		RentalAgreement actualAgreement = RentaToolController.rentalAgreementGeneration(	 "CHNS"
																							,"7/2/15" //checkoutDateIn
																							,5 //rentalDaysIn
																							,"25" //discountIn
																							);
		
		assertEquals(expectedAgreement, actualAgreement);
	}
	
	@Test
	public void testCase4() throws InvalidRentalDaysException, InvaildDiscountPercentException {
		RentalAgreement expectedAgreement = new RentalAgreement(	 "JAKD" //toolCode
																	,"Jackhammer" //toolType
																	,"DeWalt" //brand
																	,6 //rentalDays
																	,util.formatDateTime("9/3/15") //checkoutDate
																	,util.formatDateTime("9/9/15") //dueDate
																	,new BigDecimal("2.99") //dailyCharge
																	,3 //chargeDays
																	,new BigDecimal("8.97") //preDiscountCharge
																	,new BigDecimal("0") //discountPercentage
																	,new BigDecimal("0.00") //discountAmount
																	,new BigDecimal("8.97") //finalCharge
																	);
	    
		RentalAgreement actualAgreement = RentaToolController.rentalAgreementGeneration(	 "JAKD"
																							,"9/3/15" //checkoutDateIn
																							,6 //rentalDaysIn
																							,"0" //discountIn
																							);
		
		assertEquals(expectedAgreement, actualAgreement);
	}
	
	@Test
	public void testCase5() throws InvalidRentalDaysException, InvaildDiscountPercentException {
		RentalAgreement expectedAgreement = new RentalAgreement(	 "JAKR" //toolCode
																	,"Jackhammer" //toolType
																	,"Ridgid" //brand
																	,9 //rentalDays
																	,util.formatDateTime("7/2/15") //checkoutDate
																	,util.formatDateTime("7/11/15") //dueDate
																	,new BigDecimal("2.99") //dailyCharge
																	,5 //chargeDays
																	,new BigDecimal("14.95") //preDiscountCharge
																	,new BigDecimal("00") //discountPercentage
																	,new BigDecimal("0.00") //discountAmount
																	,new BigDecimal("14.95") //finalCharge
																	);
	    
		RentalAgreement actualAgreement = RentaToolController.rentalAgreementGeneration(	 "JAKR"
																							,"7/2/15" //checkoutDateIn
																							,9 //rentalDaysIn
																							,"0" //discountIn
																							);
		
		assertEquals(expectedAgreement, actualAgreement);
	}
	
	@Test
	public void testCase6() throws InvalidRentalDaysException, InvaildDiscountPercentException {
		RentalAgreement expectedAgreement = new RentalAgreement(	 "JAKR" //toolCode
																	,"Jackhammer" //toolType
																	,"Ridgid" //brand
																	,4 //rentalDays
																	,util.formatDateTime("7/2/20") //checkoutDate
																	,util.formatDateTime("7/6/20") //dueDate
																	,new BigDecimal("2.99") //dailyCharge
																	,1 //chargeDays
																	,new BigDecimal("2.99") //preDiscountCharge
																	,new BigDecimal("50") //discountPercentage
																	,new BigDecimal("1.50") //discountAmount
																	,new BigDecimal("1.49") //finalCharge
																	);
	    
		RentalAgreement actualAgreement = RentaToolController.rentalAgreementGeneration(	 "JAKR"
																							,"7/2/20" //checkoutDateIn
																							,4 //rentalDaysIn
																							,"50" //discountIn
																							);
		
		assertEquals(expectedAgreement, actualAgreement);
	}
}
