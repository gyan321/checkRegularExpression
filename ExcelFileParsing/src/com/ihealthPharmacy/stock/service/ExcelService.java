package com.ihealthPharmacy.stock.service;

public class ExcelService {
	
	
	public static String findDataSize(String givenString) {	
		
		 int firstIndex=givenString.indexOf('(');
		 int secondIndex=givenString.indexOf(')'); 
		 String dataSize=givenString.substring(firstIndex+1,secondIndex);		 
		 return dataSize;
	}
	
	
	public static String findTableName(String inputLine) {
		
		 //String givenString="CREATE TABLE `user_roles` ( `USER_ROLES_ID` int(11) NOT NULL AUTO_INCREMENT,"; 		 
		 
		 String splitArray[]=inputLine.split(" "); 
		 
		 return splitArray[2].replace('`',' ').trim();       
	  
			 
	}

}
