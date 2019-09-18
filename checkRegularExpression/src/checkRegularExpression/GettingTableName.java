package checkRegularExpression;

public class GettingTableName {
	
	public static String main(String[] args) {
		
		 String givenString="CREATE TABLE `user_roles` ( `USER_ROLES_ID` int(11) NOT NULL AUTO_INCREMENT,"; 		 
		 
		 String splitArray[]=givenString.split(" "); 
		 
		 return splitArray[2].replace('`',' ').trim();       
	  
			 
	}
}
