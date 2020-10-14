/***************************************************************************************
 * Author		: Christopher Youngblood
 * Project		: cmy1020 - Renta Tool
 * Created		: 10/7/2020
 * Description	: This object will serve as the data access object for the project.
 ***************************************************************************************/

package com.rentatool.main;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.rentatool.models.Tool;

//Data Access Object - given that this isn't a full project, just a proof of concept,
//	there won't be any JDBC equivalent wired up.

public class RentaToolDao {

	public ArrayList<Tool> getTools(Tool criteria){
		ArrayList<Tool> result = new ArrayList<Tool>();
		
		try {
			result = fakeSql(criteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	//If this were an actual database, this would be done via SQL and a database instead
	public ArrayList<Tool> fakeSql(Tool criteria){
		ArrayList<Tool> resultSet = new ArrayList<Tool>();
		
		switch ( criteria.getToolCode() ) {
			case "LADW":
				Tool dbToolLADW = new Tool(	 "Ladder"	//toolType
											,"Werner"	//brand
											,"LADW"		//toolCode
											,new BigDecimal("1.99")	//dailyCharge
											,true		//weekdayCharge
											,true		//weekendCharge
											,false);	//holidayCharge
				
				resultSet.add(dbToolLADW);
				break;
			
			case "CHNS":
				Tool dbToolCHNS = new Tool(	 "Chainsaw"	//toolType
											,"Stihl"	//brand
											,"CHNS"		//toolCode
											,new BigDecimal("1.49")	//dailyCharge
											,true		//weekdayCharge
											,false		//weekendCharge
											,true);		//holidayCharge

				resultSet.add(dbToolCHNS);
				break;
				
			case "JAKR":
				Tool dbToolJAKR = new Tool(	 "Jackhammer"	//toolType
											,"Ridgid"	//brand
											,"JAKR"		//toolCode
											,new BigDecimal("2.99")	//dailyCharge
											,true		//weekdayCharge
											,false		//weekendCharge
											,false);	//holidayCharge

				resultSet.add(dbToolJAKR);
				break;
				
			case "JAKD":
				Tool dbToolJAKD = new Tool(	 "Jackhammer"	//toolType
											,"DeWalt"	//brand
											,"JAKD"		//toolCode
											,new BigDecimal("2.99")	//dailyCharge
											,true		//weekdayCharge
											,false		//weekendCharge
											,false);	//holidayCharge

				resultSet.add(dbToolJAKD);
				break;
		}
		
		return resultSet;
	}
	
}
