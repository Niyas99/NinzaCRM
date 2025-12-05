package extentreports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsClass {
	
	@Test
	public void extentReportsClass() {
		
		//Step 1 : Create object of ExtentSparkReporter
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\QSP\\eclipse-workspace1\\Frame\\Report\\report.html");

		//Step 2 : Create object of ExtentSparkReports
		ExtentReports extentReports = new ExtentReports();
		
		//Step 3 : Attach spark reference to extentReports reference
		extentReports.attachReporter(spark);
		
		//step 4 : Create object for ExtentTest using create
		ExtentTest test = extentReports.createTest("Report");
		
		//step 5 : add log messages
		test.log(Status.PASS, "Testcases Pass");
		
		
		//hr
		//step 6 : call flush() to write data into the report
		extentReports.flush();
		
	}

}
