package org.ninjacrm.listners;

import java.io.File;
import java.io.IOException;

import org.ninjacrm.businessutility.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation extends BaseClass implements ITestListener,ISuiteListener{

	ExtentReports extentReports;
	ExtentTest test;
	String time = jlib.getTime();
	
	@Override
	public void onStart(ISuite suite) {
		
		
		String time = jlib.getTime();
		//Step 1 : Create object of ExtentSparkReporter
		String reportPath="C:\\Users\\QSP\\eclipse-workspace1\\Frame\\Report\\report"+time+".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setDocumentTitle("NinzaCRM");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("NinzaCRM Batch Execution");
		
		//Step 2 : Create object of ExtentSparkReports
		extentReports = new ExtentReports();
		
		
		//Step 3 : Attach spark reference to extentReports reference
		extentReports.attachReporter(spark);
		
		//step 4 : Create object for ExtentTest using create
		test = extentReports.createTest("Report");
		
		//step 5 : add log messages
		
	}

	@Override
	public void onFinish(ISuite suite) {
		extentReports.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>Test Execution Success<<<<<<<<<<<<<<<<<<<<<<<",true);
		test.log(Status.PASS, "Testcases Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String time = jlib.getTime();
		String scPath = "C:\\Users\\QSP\\eclipse-workspace1\\Frame\\ScreenShots\\sc"+time+".png";
		TakesScreenshot ts= (TakesScreenshot) BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(scPath);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, "Testcases Failed");
		
	    test.addScreenCaptureFromPath(scPath);
	    
		Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>Test Execution Failure<<<<<<<<<<<<<<<<<<<<<<<",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>Test Execution Skipped<<<<<<<<<<<<<<<<<<<<<<<",true);
	}

	
	
}
