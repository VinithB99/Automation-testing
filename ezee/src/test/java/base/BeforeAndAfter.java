package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utilities.HTMLReport;
import utilities.ExcelReader;

public class BeforeAndAfter extends HTMLReport {
	public int iBrowserType=1;
	public WebDriver driver;
	public String sSheetName;
	

	


@DataProvider(name = "ExcelData")
  public Object[][] getExcelValue(){
	Object[][] data = ExcelReader.getsheet(sSheetName);
	return data;	
  }





@Override
public String takeScreenshot() {
	// TODO Auto-generated method stub
	return null;
}
}