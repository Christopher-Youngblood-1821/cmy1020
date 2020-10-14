/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object is a custom exception for an invalid rental day input.
 ***************************************************************************************/

package com.rentatool.models;

public class InvalidRentalDaysException extends Exception{

	private static final long serialVersionUID = 4828904548105504936L;

	public InvalidRentalDaysException() {
		super();
	}

	public InvalidRentalDaysException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidRentalDaysException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRentalDaysException(String message) {
		super(message);
	}

	public InvalidRentalDaysException(Throwable cause) {
		super(cause);
	}
	
}
