/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object is a custom exception for an incorrect discount % input.
 ***************************************************************************************/

package com.rentatool.models;

public class InvaildDiscountPercentException extends Exception {

	private static final long serialVersionUID = 6659548163764172149L;

	public InvaildDiscountPercentException() {
		super();
	}

	public InvaildDiscountPercentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvaildDiscountPercentException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvaildDiscountPercentException(String message) {
		super(message);
	}

	public InvaildDiscountPercentException(Throwable cause) {
		super(cause);
	}
}
