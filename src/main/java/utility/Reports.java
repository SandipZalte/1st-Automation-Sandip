package utility;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	static ExtentReports extent;
	static ExtentTest test;
	static ITestResult result;

	public static ExtentReports GenrateReports(String EnterReportName) 
	{ // Write in @BeforeTest--> we can set the path of file and its name with extension

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Test-Reports +"+EnterReportName + ".html");
		extent = new ExtentReports(); // also known as Engine
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Machine", "LenvoG50"); // add the System info like Build, system,tester
		extent.setSystemInfo("Env", "Testing");
		extent.setSystemInfo("Testing On", "Zeroda Project");
		extent.setSystemInfo("Build", "Functionl");
		extent.setSystemInfo("Tester", "Sandip");
		return extent;

	}

	public static void TestName(String EnterMethodName)
{ // Write in @Test

		test = extent.createTest(EnterMethodName);
		
	}

	public static void PostExcution() 
	
	{ //Write @AfterMethod

		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, result.getName());
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());

		} else {

			test.log(Status.SKIP, result.getName());
		}

	}

	public static void PublishReport() {	//Write @AfterTest
		extent.flush();
	}
}
