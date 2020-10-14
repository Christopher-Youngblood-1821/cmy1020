/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object represents RentaTool's fabulous tools.
 ***************************************************************************************/

package com.rentatool.models;

import java.math.BigDecimal;


//General Model/Pojo/Bean for our Tools
public class Tool {

	private String 		toolCode;
	private String 		toolType;
	private String 		brand;
	
	//I considered making subclasses for each tool type that simply pre-filled out these attributes,
	//	however, in a long term implementation you would likely want these to be held in the database
	//	in some form since these types of fields are unlikely to remain static in the business logic.
	private BigDecimal 	dailyCharge;
	private boolean 	weekdayCharge;
	private boolean 	weekendCharge;
	private boolean 	holidayCharge;
	
	
	public Tool() {
		super();
	}
	public Tool(String toolType, String brand, String toolCode, BigDecimal dailyCharge, boolean weekdayCharge,
			boolean weekendCharge, boolean holidayCharge) {
		
		super();
		
		this.toolType = toolType;
		this.brand = brand;
		this.toolCode = toolCode;
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
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
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public BigDecimal getDailyCharge() {
		return dailyCharge;
	}
	public void setDailyCharge(BigDecimal dailyCharge) {
		this.dailyCharge = dailyCharge;
	}
	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}
	public void setWeekdayCharge(boolean weekdayCharge) {
		this.weekdayCharge = weekdayCharge;
	}
	public boolean isWeekendCharge() {
		return weekendCharge;
	}
	public void setWeekendCharge(boolean weekendCharge) {
		this.weekendCharge = weekendCharge;
	}
	public boolean isHolidayCharge() {
		return holidayCharge;
	}
	public void setHolidayCharge(boolean holidayCharge) {
		this.holidayCharge = holidayCharge;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((dailyCharge == null) ? 0 : dailyCharge.hashCode());
		result = prime * result + (holidayCharge ? 1231 : 1237);
		result = prime * result + ((toolCode == null) ? 0 : toolCode.hashCode());
		result = prime * result + ((toolType == null) ? 0 : toolType.hashCode());
		result = prime * result + (weekdayCharge ? 1231 : 1237);
		result = prime * result + (weekendCharge ? 1231 : 1237);
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
		Tool other = (Tool) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (dailyCharge == null) {
			if (other.dailyCharge != null)
				return false;
		} else if (!dailyCharge.equals(other.dailyCharge))
			return false;
		if (holidayCharge != other.holidayCharge)
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
		if (weekdayCharge != other.weekdayCharge)
			return false;
		if (weekendCharge != other.weekendCharge)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tool [toolType=" + toolType + ", brand=" + brand + ", toolCode=" + toolCode + ", dailyCharge="
				+ dailyCharge + ", weekdayCharge=" + weekdayCharge + ", weekendCharge=" + weekendCharge
				+ ", holidayCharge=" + holidayCharge + "]";
	}
}
