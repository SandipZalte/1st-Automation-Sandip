package test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.AutoLogin;
import pom.WatchList;
import utility.Reports;
@Listeners( {Listener.class})

public class WatchlistTest extends BaseTest  {
	
	@BeforeMethod
	public void BrowserLaunch() throws EncryptedDocumentException, InterruptedException, IOException {
		driver= LaunchBrowser.openBrowser();
		//driver=ChromeBrowser.openBrowser();
		AutoLogin.login(driver);
	}
	
	@AfterMethod
	public  void closedbrowser() {
		//Reports.PostExcution();
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
	
	//watchList.numberofcountinwatchlist();
	watchList.selectstockfromwatchlist(driver,"ADANIENT");
	
	//watchList.clickOnBuy(driver);
	
	}
	
	
	@Test
	public void WatchListTable() throws InterruptedException {
		WatchList watchlist=new  WatchList(driver);
		Thread.sleep(2000);
		watchlist.WatchListTable(driver);
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MICROSECONDS);
	
	}

}