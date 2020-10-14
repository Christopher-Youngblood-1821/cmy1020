/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object will serve as the primary controller for the project,
 * 					directing input from the (pseudo)-UI to the proper service.
 ***************************************************************************************/

package com.rentatool.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.rentatool.models.InvaildDiscountPercentException;
import com.rentatool.models.InvalidRentalDaysException;
import com.rentatool.models.RentalAgreement;
import com.rentatool.models.Tool;

public class RentaToolController {

	private static RentaToolService rentaToolService = new RentaToolService();
	private static RentaToolUtil rentaToolUtil = new RentaToolUtil();
	// Needed for console inputs
	private static Scanner input = new Scanner(System.in);
	
	
	
	//Simple function call version
	public static RentalAgreement rentalAgreementGeneration(String toolCodeIn, String checkoutDateIn,
													Integer rentalDaysIn, String discountIn ) throws InvalidRentalDaysException, InvaildDiscountPercentException {
		
		RentalAgreement newRentalAgreement = new RentalAgreement();	
		
		//Variable for error tracking
		boolean error = false;
			
		//Begin search for Tool via tool code
		Tool criteria = new Tool();
		criteria.setToolCode(toolCodeIn);
		ArrayList<Tool> selectedTool = rentaToolService.getTools(criteria);
		//System.out.println(selectedTool.toString());
					
		if (selectedTool.isEmpty()) {
			System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("x Error: Tool Code Not Found x");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
			error = true;
					
		} else { //if tools are found, gather rental info		
						
			//Input checking and formating for checkoutDate
			LocalDate checkoutDate = rentaToolUtil.formatDateTime(checkoutDateIn);
							
			if (checkoutDate == null) {
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("x Error: Please enter date in mm/dd/yy format x");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				error = true;
								
			} else {
				newRentalAgreement.setCheckoutDate(checkoutDate);
			}
				
			//Input checking for rentalDays
			if (rentalDaysIn <= 0) {
				//The design document specified that this error be thrown as an exception
				throw new InvalidRentalDaysException(	  "\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
														+ "\nx Error: Please enter a number greater than 0 for Rental Days x"
														+ "\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
									
			} else {
				newRentalAgreement.setRentalDays(rentalDaysIn);
			}
					
						
			//Input formating and checking for discount
			BigDecimal discount = new BigDecimal(discountIn); //Use of BigDecimal is for more precision in calculation.
									
			if (discount.compareTo(new BigDecimal(0)) == -1 //Equivalent to discount < 0
					|| discount.compareTo(new BigDecimal(100)) == 1 //Equivalent to discount > 100
					) {
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("x Error:  x");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
				//The design document specified that this error be thrown as an exception
				throw new InvaildDiscountPercentException(	  "\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
															+ "\nx Error: Please enter a number between 0 and 100 for Discount Percent x"
															+ "\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
								
			} else {
				newRentalAgreement.setDiscountPercentage(discount);
			}

			//If no errors where found begin the computation
			if (error == false) {
				//All user input is ready, begin document processing
				////This implementation assumes that tool codes are unique, and thus only 1 tool is actually found
				newRentalAgreement = rentaToolService.processRentalAgreement(selectedTool.get(0), newRentalAgreement);
							
				//Now that all the required info is gathered and processed, Print the finalized Rental Agreement
				System.out.println("\n*************************************");
				System.out.println(newRentalAgreement.toConsoleString());
				System.out.println("*************************************\n");
			}	
		}
		
		return newRentalAgreement;
	}
}
