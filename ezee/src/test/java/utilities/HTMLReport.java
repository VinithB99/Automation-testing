package utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class HTMLReport {
	
	public static ExtentHtmlReporter eReport;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String authors,category;
	
	public void startReport() {
		eReport = new ExtentHtmlReporter("./report/TestReport.html");
		extent = new ExtentReports();
		eReport.setAppendExisting(false);
		extent.attachReporter(eReport);		
	}
	public void endReport() {
		extent.flush();
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		test = extent.createTest(testCaseName, testDescription);
		test.assignCategory(category);
		return test;
	}

	public ExtentTest startTestcase(String nodes) {
		node = test.createNode(nodes);
		//tlNode.set(testSuite.createNode(nodes));
		return node;
	}
	
	public void reportStep(String desc,String status) {
		try {
		if(status.equalsIgnoreCase("pass")){
			node.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			} else if(status.equalsIgnoreCase("fail")) {
				node.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());	
			} else {
				node.info(desc);	
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract String takeScreenshot();

}
