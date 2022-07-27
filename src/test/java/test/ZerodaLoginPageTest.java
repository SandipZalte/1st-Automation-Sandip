package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pojo.ChromeBrowser;
import pom.ZerodaLoginPage;
import utility.Excel;

@Listeners (Listener.class)
public class ZerodaLoginPageTest extends BaseTest {
	
	ExtentReports extent;
	ExtentTest test;
	
	@AfterClass
	public void ClosedBrowser() {
		driver.quit();
	}
	@BeforeTest()
	public void ConfigureReport() {
		extent= new ExtentReports();
		ExtentSparkReporter htmlReports= new ExtentSparkReporter("extentReport.html");
		extent.attachReporter(htmlReports);
	
		extent.setSystemInfo("Syatem", "Lenvog50");
		extent.setSystemInfo("Envornment","Testing" );
		extent.setSystemInfo("test", "ZerodaLoginPage");
		extent.setSystemInfo("Tester", "Sandip");
		
	}
	
	@AfterTest
	public void publishReport() {
		extent.flush();
		
	}
	@BeforeMethod
	public void LaunchBrowser() {
		driver = ChromeBrowser.openBrowser();

	}
	
	@AfterMethod
	public void PostExcution(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(Status.PASS,result.getName());
			
			}
		else if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, result.getName());
			}
		else 
		{
			test.log(Status.SKIP, result.getName());
		}
		
		driver.close();
		
		
		
	}
	
		@Test
		public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException {
			test=extent.createTest("LoginWithValidCredentials");
			
			
			ZerodaLoginPage zerodaLoginPage=new ZerodaLoginPage(driver);
			String ExpectedTitle=driver.getTitle();
			String ActualTitle="Kite - Zerodha's fast and elegant flagship trading platform";
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Title Should Mismatch Please checked Actual and Expected Result");// Hard assert
//			SoftAssert soft=new  SoftAssert();
//			soft.assertEquals(ActualTitle, ExpectedTitle, "Title Should Mismatch");			
			
			
			String id=Excel.getdata("kite", 1, 0);
			String pass=Excel.getdata("kite", 1, 1);
			String pinNumber=Excel.getdata("kite",1,2);
			
			zerodaLoginPage.enteruserid(id);
			zerodaLoginPage.enterpassword(pass);
			zerodaLoginPage.clickonLogin();

			zerodaLoginPage.enterpin(driver, pinNumber);
			zerodaLoginPage.clickonContinue();
		}

	@Test
	public void SignUpNow() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodaLoginPage zerodaLoginPage = new ZerodaLoginPage(driver);
		zerodaLoginPage.clickonsignup();
		
		zerodaLoginPage.SwitchFocussignuppage(driver);
		
		String mobiNum =Excel.getdata("kite",1,3);
		zerodaLoginPage.entermobiNumbera(mobiNum);
		zerodaLoginPage.clickonContinueSignup();

	}
	@Test
	public void forgetAccount() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodaLoginPage zerodaLoginPage=new ZerodaLoginPage(driver);
		String a=Excel.getdata("kite", 7, 0);
		String b=Excel.getdata("kite", 7, 1);
		String c=Excel.getdata("kite", 7, 4);
		
		zerodaLoginPage.clickonforget();
		Thread.sleep(2000);
		zerodaLoginPage.forgetusingid(a,b,c);
	
	}
	
	
	

}
