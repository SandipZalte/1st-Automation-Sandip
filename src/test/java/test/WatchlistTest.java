package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pojo.ChromeBrowser;
import pom.AutoLogin;
import pom.WatchList;
import utility.Reports;
@Listeners(Listener.class)

public class WatchlistTest extends BaseTest  {
	
	@BeforeMethod
	public void BrowserLaunch() throws EncryptedDocumentException, InterruptedException, IOException {
		
		driver=ChromeBrowser.openBrowser();
		AutoLogin.login(driver);

		
	}
	@AfterMethod
	public  void closedbrowser() {
		Reports.PostExcution();
		driver.close();
		
	}
	@BeforeTest
	public void CreateReport() {
		Reports.GenrateReports("WatchList");
		
	}
	@AfterTest
	public void PublishReport() {
		
		Reports.PublishReport();
	}
	@Test
	public void SearchStock() {
		Reports.TestName("SearchStock");
		WatchList watchList= new WatchList(driver);
		watchList.searchstock("India");
		}
	
	@Test
	public void SearchStockFromWatchlistAndBuy() throws InterruptedException {
		WatchList watchList=new WatchList(driver);
	Thread.sleep(2000);
	watchList.numberofcountinwatchlist();
	watchList.selectstockfromwatchlist(driver,"ADANIENT");
	Thread.sleep(1000);
	//watchList.clickOnBuy(driver);
	
	}
	
	@Test
	public void WatchListTable() throws InterruptedException {
		WatchList watchlist=new  WatchList(driver);
		Thread.sleep(2000);
		watchlist.WatchListTable(driver);
	
	}

}