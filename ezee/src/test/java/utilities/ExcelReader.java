package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
 public static Object[][] getsheet(String DataExcelName){
	 
	 Object[][] data=null;
	 
	 try {
		 FileInputStream inputFile = new FileInputStream("./data/"+ DataExcelName +".xlsx");
		 XSSFWorkbook workbook =new XSSFWorkbook(inputFile);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 
		 int rowCount= sheet.getLastRowNum();
		 int colCount = sheet.getRow(0).getLastCellNum();
		 
		 data=new String[rowCount][colCount];
		 
		 for(int i=0;i<rowCount+1;i++) {
			 
			 try {
				 XSSFRow row = sheet.getRow(i);
				 
				 for(int j=0;j<colCount+1;j++) {
					 try {
						 String cellValue="";
						 try {
							 cellValue = row.getCell(j).getStringCellValue();
						 }catch(NullPointerException e) {
							 System.out.println("Unable to Locate the data in Excel file row"+row+"column"+cellValue);
						 }
						 data[i-1][j]  = cellValue; 
						 
					 }catch(Exception e) {
						 e.printStackTrace();
					 }
				 }
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
		 inputFile.close();
		 workbook.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	return data;
	 
 }

}
