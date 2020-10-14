/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object represents RentaTool inc's rental agreements.
 ***************************************************************************************/

package com.rentatool.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {
	//the 'official' date format of RentaTool inc.
	final private static DateTimeFormatter rentaToolDateFormat = DateTimeFormatter.ofPattern("MM/dd/yy");

	private String		toolCode;
	private String		toolType;
	private String		brand;
	private Integer		rentalDays;
	private LocalDate	checkoutDate;
	private LocalDate	dueDate;
	private BigDecimal	dailyCharge;
	private Integer		chargeDays;
	private BigDecimal	preDiscountCharge;
	private BigDecimal	discountPercentage;
	private BigDecimal	discountAmount;
	private BigDecimal	finalCharge;
	
	//Custom toString method
	public String toConsoleString() {
		return 	"Tool Code: " 			+ toolCode
			+	"\nTool Type: " 			+ toolType
			+	"\nTool Brand: " 			+ brand
			+	"\nRental Days: " 			+ rentalDays
			+	"\nCheckout Date: " 		+ checkoutDate.format(rentaToolDateFormat)
			+	"\nDue Date: " 				+ dueDate.format(rentaToolDateFormat)
			+	"\nDaily Charge: $"			+ dailyCharge.setScale(2, RoundingMode.HALF_UP)
			+	"\nCharge Days: " 			+ chargeDays
			+	"\nPre-Discount Charge: $" 	+ preDiscountCharge.setScale(2, RoundingMode.HALF_UP)
			+	"\nDiscount Percentage: " 	+ discountPercentage + "%"
			+	"\nDiscount Amount: $" 		+ discountAmount.setScale(2, RoundingMode.HALF_UP)
			+	"\nFinal Charge: $"			+ finalCharge.setScale(2, RoundingMode.HALF_UP);
	}
	
	public RentalAgreement() {
		super();
	}
	public RentalAgreement(String toolCode, String toolType, String brand, Integer rentalDays, LocalDate checkoutDate,
			LocalDate dueDate, BigDecimal dailyCharge, Integer chargeDays, BigDecimal preDiscountCharge,
			BigDecimal discountPercentage, BigDecimal discountAmount, BigDecimal finalCharge) {
		super();
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.brand = brand;
		this.rentalDays = rentalDays;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.dailyCharge = dailyCharge;
		this.chargeDays = chargeDays;
		this.preDiscountCharge = preDiscountCharge;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
		this.finalCharge = finalCharge;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(Integer rentalDays) {
		this.rentalDays = rentalDays;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getDailyCharge() {
		return dailyCharge;
	}

	public void setDailyCharge(BigDecimal dailyCharge) {
		this.dailyCharge = dailyCharge;
	}

	public Integer getChargeDays() {
		return chargeDays;
	}

	public void setChargeDays(Integer chargeDays) {
		this.chargeDays = chargeDays;
	}

	public BigDecimal getPreDiscountCharge() {
		return preDiscountCharge;
	}

	public void setPreDiscountCharge(BigDecimal preDiscountCharge) {
		this.preDiscountCharge = preDiscountCharge;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getFinalCharge() {
		return finalCharge;
	}

	public void setFinalCharge(BigDecimal finalCharge) {
		this.finalCharge = finalCharge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((chargeDays == null) ? 0 : chargeDays.hashCode());
		result = prime * result + ((checkoutDate == null) ? 0 : checkoutDate.hashCode());
		result = prime * result + ((dailyCharge == null) ? 0 : dailyCharge.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((discountPercentage == null) ? 0 : discountPercentage.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((finalCharge == null) ? 0 : finalCharge.hashCode());
		result = prime * result + ((preDiscountCharge == null) ? 0 : preDiscountCharge.hashCode());
		result = prime * result + ((rentalDays == null) ? 0 : rentalDays.hashCode());
		result = prime * result + ((toolCode == null) ? 0 : toolCode.hashCode());
		result = prime * result + ((toolType == null) ? 0 : toolType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalAgreement other = (RentalAgreement) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (chargeDays == null) {
			if (other.chargeDays != null)
				return false;
		} else if (!chargeDays.equals(other.chargeDays))
			return false;
		if (checkoutDate == null) {
			if (other.checkoutDate != null)
				return false;
		} else if (!checkoutDate.equals(other.checkoutDate))
			return false;
		if (dailyCharge == null) {
			if (other.dailyCharge != null)
				return false;
		} else if (!dailyCharge.equals(other.dailyCharge))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (discountPercentage == null) {
			if (other.discountPercentage != null)
				return false;
		} else if (!discountPercentage.equals(other.discountPercentage))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (finalCharge == null) {
			if (other.finalCharge != null)
				return false;
		} else if (!finalCharge.equals(other.finalCharge))
			return false;
		if (preDiscountCharge == null) {
			if (other.preDiscountCharge != null)
				return false;
		} else if (!preDiscountCharge.equals(other.preDiscountCharge))
			return false;
		if (rentalDays == null) {
			if (other.rentalDays != null)
				return false;
		} else if (!rentalDays.equals(other.rentalDays))
			return false;
		if (toolCode == null) {
			if (other.toolCode != null)
				return false;
		} else if (!toolCode.equals(other.toolCode))
			return false;
		if (toolType == null) {
			if (other.toolType != null)
				return false;
		} else if (!toolType.equals(other.toolType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RentalAgreement [toolCode=" + toolCode + ", toolType=" + toolType + ", brand=" + brand + ", rentalDays="
				+ rentalDays + ", checkoutDate=" + checkoutDate + ", dueDate=" + dueDate + ", dailyCharge="
				+ dailyCharge + ", chargeDays=" + chargeDays + ", preDiscountCharge=" + preDiscountCharge
				+ ", discountPercentage=" + discountPercentage + ", discountAmount=" + discountAmount + ", finalCharge="
				+ finalCharge + "]";
	}
}
