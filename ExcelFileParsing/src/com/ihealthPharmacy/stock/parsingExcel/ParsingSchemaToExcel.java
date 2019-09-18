package com.ihealthPharmacy.stock.parsingExcel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ihealthPharmacy.stock.model.Table;
import com.ihealthPharmacy.stock.service.ExcelService;

public class ParsingSchemaToExcel {

	
	   static Table tableObj; 
	   static ExcelService excelServiceObj; 


	   //@SuppressWarnings("unused")
	   public static void main(String[] args)throws Exception {
		
		tableObj=new Table();
		
		 System.out.println("check");
		 
		 String firstLineDelimiter="[`][A-Z]+_[A-Z]+_[A-Z]+[`][\\s]int[(][0-9]{2}[)][\\s]NOT[\\s]NULL[\\s]AUTO_INCREMENT[,]";
		 /*Pattern tableNamePattern = Pattern.compile("[`][a-zA-Z]+_[a-zA-Z]+[`]"); 		 
		 Pattern columnNamePattern = Pattern.compile("[`][A-Z]+_[A-Z]+_[A-Z]+[`]"); 
		 Pattern sizePatternFor2Digit=Pattern.compile("[a-zA-Z]+[(][0-9]{2}[)]");
		 */
		 
		 
		 //String firstLineDelimiter="[`][A-Z]+_[A-Z]+_[A-Z]+[`][\\s]int[(][0-9]{2}[)][\\s]NOT[\\s]NULL[\\s]AUTO_INCREMENT[,]";
      
		 
		Pattern firstLinepattern=Pattern.compile(firstLineDelimiter,Pattern.CASE_INSENSITIVE); 
		
		FileReader fileObject=new FileReader("C:\\Users\\ADMIN\\Documents\\healthPharmacyRelated\\HealthPharmacyProjectStockRelated\\AllSchemaTxtFiles\\userRoles.sql");
		
		BufferedReader bufferReaderObj=new BufferedReader(fileObject);
		
		String line= bufferReaderObj.readLine();
		
		
		List<Table>tableListObj=new ArrayList<>();
		
		byte totalNumberOfLines= 0;
		
		//nextLine:
		while(line!=null){
			
			//System.out.println("check 2");
			
			//System.out.println(line);
			
			Matcher firstLineMatcher = firstLinepattern.matcher(line);   
			
			
			
			
			if(firstLineMatcher.find()){
				
				String firstLineMatcherInString=firstLineMatcher.group(); 
				
				System.out.println("first line found");
				System.out.println(firstLineMatcherInString);
				tableObj.setDefaults("AUTO_INCREMENT");
				tableObj.setType("INT");
				tableObj.setConstraint("NOT NULL");	
				
				if(firstLineMatcherInString.contains("AUTO_INCREMENT")){
				String dataSize= ExcelService.findDataSize(firstLineMatcherInString);
				
				tableObj.setSize(dataSize);
				 System.out.println("size is:"+dataSize);
				}
				
				
				String tableName=ExcelService.findTableName(line);
				tableObj.setTableName(tableName);
				
				System.out.println("table name:"+tableObj.getTableName());
				
				tableObj.setForeignKey("NULL");
				tableObj.setForeignKeyTable("NULL");
				tableObj.setRelationShip("NULL");
				
				
				
			}
			
			/*Matcher firstMatcher = tableNamePattern.matcher(line); 			
			Matcher secondMatcher = columnNamePattern.matcher(line); 
			Matcher thirdMatcher=thirdpattern.matcher(line);  */
			 
			
			
			     /*   table checking    */
			/*if(firstMatcher.find()&& line.contains("CREATE")){
				
				tableObj.setTableName(firstMatcher.group());				
				System.out.println("table name"+tableObj.getTableName());
			}*/
			
			      /*second line checking*/
			/* if(secondMatcher.find()){
				line=bufferReaderObj.readLine();
				System.out.println("first ( found" );
				//continue  nextLine;
				
			}*/
			
			/* if(thirdMatcher.find()){
				System.out.println("third line founds");
				
				tableObj.setType("INT");
				tableObj.setDefaults("AUTO INCREMENT");
				tableObj.setConstraint("NOT NULL");
				
			}*/
			
			totalNumberOfLines++;
			
			
			line=bufferReaderObj.readLine();			
		}
		
		bufferReaderObj.close();
		
		System.out.println("total line :"+totalNumberOfLines);
		
		
	}
	
	
	public void getDataTypeSize(){
		String givenString="int(11)";
		 
		 int firstIndex=givenString.indexOf('(');
		 int secondIndex=givenString.indexOf(')');
		 
		 String size=givenString.substring(firstIndex+1,secondIndex);
		 
		 System.out.println("size is "+size);
	}
	
	
	

}
