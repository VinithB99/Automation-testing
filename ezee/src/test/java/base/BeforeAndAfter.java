package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class BeforeAndAfter {
	public int iBrowserType=1;
	public WebDriver driver;
	public String sSheetName;
	


@DataProvider(name = "ExcelData")
  public Object[][] getExcelValue(){
	Object[][] data = ExcelReader.getsheet(sSheetName);
	return data;	
  }
}