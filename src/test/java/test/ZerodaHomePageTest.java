package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.ChromeBrowser;
import pom.AutoLogin;
import pom.ZerodaHomePage;
import utility.Reports;
@Listeners(Listener.class)

public class ZerodaHomePageTest extends BaseTest {

	
	@BeforeTest
	public void ConfigureReport() {
		Reports.GenrateReports("homepage");

	}
	@AfterTest
	public void publishReport() {
		Reports.PublishReport();

		
	}

	@BeforeMethod
	public void launchBrowser() throws EncryptedDocumentException, InterruptedException, IOException {
		driver = ChromeBrowser.openBrowser();
		AutoLogin.login(driver);
		

	}
	@AfterMethod
	public void PostExecution() {
		Reports.PostExcution();
	}
	
	
	
	@AfterMethod
	public void ClosedtheLaunchBrowser() {
		//driver.close();
	}
	
	
	

	@Test(priority=0)
	public void serachStockAndClickOnBuyWithRegularMISMarketOrder() throws InterruptedException  {
		Reports.TestName("serachStockAndClickOnBuyWithRegularMISMarketOrder");

		
		
		ZerodaHomePage zerodaHomePage = new ZerodaHomePage(driver);
		
		zerodaHomePage.searchStock(driver, "tata");
		zerodaHomePage.selectStockFromSearchList(driver, "TATAMETALI");
		zerodaHomePage.clickOnBuy();
		//zerodaHomePage.BuySellPage(driver);
		
		zerodaHomePage.selectBSE(driver);
		zerodaHomePage.selectRegularOrder();
		zerodaHomePage.selectMIS(driver);
		zerodaHomePage.enterQuantityofShear(driver, "925");
		zerodaHomePage.selectMarketOrder(driver);
		zerodaHomePage.Refresh();
		zerodaHomePage.clickOnBuyButton();
		
	}
	@Test(priority=1)
	public void serachStockAndClickOnBuyWithRegularCNCMarketOrder() throws InterruptedException  {
		Reports.TestName("serachStockAndClickOnBuyWithRegularCNCMarketOrder");
		
		ZerodaHomePage zerodaHomePage = new ZerodaHomePage(driver);
		
		zerodaHomePage.searchStock(driver, "deep");
		zerodaHomePage.selectStockFromSearchList(driver, "DEEPAKNTR");
		zerodaHomePage.clickOnBuy();
		zerodaHomePage.BuySellPage(driver);
	
		zerodaHomePage.selectBSE(driver);
		zerodaHomePage.selectRegularOrder();
		zerodaHomePage.selectMIS(driver);
		zerodaHomePage.selectCNC(driver);
		zerodaHomePage.enterQuantityofShear(driver,"5000");
		zerodaHomePage.enterStockPrice("1800");
		
		zerodaHomePage.selectMarketOrder(driver);
		
		
		zerodaHomePage.checkboxGTTarget();
		zerodaHomePage.enterGTTStoplossPercentage("7");
		zerodaHomePage.checkboxGTTarget();
//		zerodaHomePage.enterTargetPercentage("14");

	
		zerodaHomePage.Refresh();
		//zerodaHomePage.clickOnBuyButton();
		
	}
	@Test(priority=2)
	public void serachStockAndClickOnSell() throws InterruptedException {
		
	Reports.TestName("serachStockAndClickOnSell");

		ZerodaHomePage zerodaHomePage=new ZerodaHomePage(driver);
	
		zerodaHomePage.searchStock(driver, "maz");
		Thread.sleep(1000);
		zerodaHomePage.selectStockFromSearchList(driver, "MAZDA");
		zerodaHomePage.clickOnSell();
		zerodaHomePage.enterQuantityofShear(driver, "20");
	
	}
	@Test
	public void searchStockAndClickOnChart() throws InterruptedException {
		Reports.TestName("searchStockAndClickOnChartsearchStockAndClickOnChart");

		
		ZerodaHomePage zerodaHomePage=new ZerodaHomePage(driver);
		
		zerodaHomePage.searchStock(driver, "god");
		zerodaHomePage.selectStockFromSearchList(driver, "GODREJPROP");
		zerodaHomePage.clickOnChart();
		
	}

}
