package pom;


import java.time.Duration;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class WatchList {
	@FindBy(xpath="//input[@icon='search']")private WebElement search;
	@FindBy(xpath="//span[contains(text(),' / 50')]")private WebElement numberofcount;
	@FindBy(xpath = "//span[@class='nice-name']")private List<WebElement> watchlist;
	
	@FindBy(xpath = "//span[contains(text(),'')]//span[@class='nice-name']")private List<WebElement> watchliststockname;
	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/span[1]")private WebElement actionspan;
	
	@FindBy(xpath = "//button[@class='button-blue buy']")private WebElement buy;
	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/span[1]/span[2]/button[1]")private WebElement sell;
	@FindBy(xpath = "//span[@class='icon icon-align-center']")private WebElement marketdepth;
	@FindBy(xpath = "//span[@class='icon icon-trending-up']")private WebElement chart;
	@FindBy(xpath = "//span[@data-balloon='Delete (del)']")private WebElement delete;
	@FindBy(xpath = "//span[@class='icon icon-ellipsis']")private WebElement more;
	@FindBy(xpath = "//span[@class='settings-button icon icon-settings']")private WebElement setting;
	@FindBy(xpath = "//li[contains(text(),'')]")private List<WebElement> page1to7;
	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/div[1]/div")private List<WebElement> row;
	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span")private List<WebElement> column;
	

	public WatchList(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchstock(String Searchstock) {
		search.sendKeys(Searchstock);
		
	}
	public void numberofcountinwatchlist() {
		numberofcount.getText();
		String count=numberofcount.getText();
		//System.out.println(count);
		String []z = count.split("/");
		
		//System.out.println(z[0]);
		//System.out.println(z[1]);
		
		String s=z[0].trim();
		//System.out.println(s);
		int number=Integer.parseInt(s);
		//System.out.println(number);
		
		SoftAssert soft= new SoftAssert();
		soft.assertTrue(number>0 ,"No stock Added in Watchlist ");
		soft.assertAll();
		
	
	}

	public void selectstockfromwatchlist(WebDriver driver, String EnterstockName) throws InterruptedException {
		int size = watchliststockname.size();

		for (int i = 0; i < size; i++) {
			WebElement StockName = watchliststockname.get(i);
			String ExpectedTitle = StockName.getText();

			String ActualstockName = EnterstockName;
			if (ExpectedTitle.equals(ActualstockName))

			{
				System.out.println(ExpectedTitle);
			Actions actions = new Actions(driver);
			actions.moveToElement(StockName);
			actions.doubleClick();
			actions.build().perform();
			}
//
//			// break.

		}
	}
	public void clickOnBuy(WebDriver driver) {
		buy.click();
		
//		 Actions actions = new Actions(driver);
//		 actions.click().sendKeys(Keys.TAB.ENTER);
//		 actions.build().perform();
	
		

	}

	public void clickOnSell() {
		sell.click();

	}

	public void clickOnMarketDepth() {
		marketdepth.click();
	}

	public void clickOnStockChart() {
		marketdepth.click();

	}

	public void clickOndelete() {
		delete.click();

	}

	public void clickOnMore() {
		more.click();
	}

	public void ClickOnSetting() {
		setting.click();
		{

		}
	}

	public void WatchListTable(WebDriver driver) throws InterruptedException {
		int shiftpage = page1to7.size();
		System.out.println("Number of Page is -->" + " " + shiftpage);
		//int colsize = column.size();
		int rowsize = 0;
		for (int k = 1; k <= shiftpage; k++) {

			//System.out.println("page number is-->" + k);
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body/div[@id='app']/div[2]/div[1]"))));
			
			rowsize = 0;
			try {
				driver.findElement(By.xpath("//li[contains(text()," + k + ")]")).click();
				Thread.sleep(2000);
				rowsize = row.size();
				//System.out.println("Number of rows-->" + "" + rowsize);
			} 
			catch (Exception e) {
			}
			for (int h = 0; h < rowsize; h++) {

				WebElement currentStock = row.get(h);
				String stockdata = currentStock.getText();
				//System.out.println(stockdata);
			}
			System.out.println();
		}
	}

}

