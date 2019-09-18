package com.ihealthPharmacy.stock.parsingExcel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ihealthPharmacy.stock.model.Table;

public class ParsingSchemaToExcel {

	
	   static Table tableObj;


	   


	public static void main(String[] args)throws Exception {
		
		tableObj=new Table();
		
		 
		 Pattern firstPattern = Pattern.compile("[`][a-zA-Z]+_[a-zA-Z]+[`]"); 		 
		 Pattern secondPattern = Pattern.compile("[(\\s]"); 
		 
		 String thirdDelimiter="[`][A-Z]+_[A-Z]+_[A-Z]+[`][\\s]int[(][0-9]{2}[)][\\s]NOT[\\s]NULL[\\s]AUTO_INCREMENT[,]";
		 
		 Pattern thirdpattern=Pattern.compile(thirdDelimiter,Pattern.CASE_INSENSITIVE);
		
		FileReader fileObject=new FileReader("C:\\Users\\ADMIN\\Documents\\healthPharmacyRelated\\HealthPharmacyProjectStockRelated\\AllSchemaTxtFiles\\userRoles.sql");
		
		BufferedReader bufferReaderObj=new BufferedReader(fileObject);		
		String line= bufferReaderObj.readLine();
		
		//nextLine:
		while(line!=null){
			
			//System.out.println(line);
			
			Matcher firstMatcher = firstPattern.matcher(line); 			
			Matcher secondMatcher = secondPattern.matcher(line); 
			Matcher thirdMatcher=thirdpattern.matcher(line);  
			 
			
			
			     /*   table checking    */
			if(firstMatcher.find()&& line.contains("CREATE")){
				
				tableObj.setTableName(firstMatcher.group());				
				System.out.println("table name"+tableObj.getTableName());
			}
			
			      /*second line checking*/
			 if(secondMatcher.find()){
				line=bufferReaderObj.readLine();
				System.out.println("first ( found" );
				//continue  nextLine;
				
			}
			
			 if(thirdMatcher.find()){
				System.out.println("third line founds");
				
				tableObj.setType("INT");
				tableObj.setDefaults("AUTO INCREMENT");
				tableObj.setConstraint("NOT NULL");
				
			}
			
			
			
			
			line=bufferReaderObj.readLine();			
		}
		
		bufferReaderObj.close();
		
		
	}

}
