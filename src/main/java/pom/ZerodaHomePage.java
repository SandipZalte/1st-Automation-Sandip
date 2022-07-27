package pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodaHomePage {
	
	
	@FindBy(xpath = "//input[@icon='search']")private WebElement search;
	@FindBy(xpath = "//span[@class='tradingsymbol']")private List<WebElement> stocklist;
	
	
	
	@FindBy(xpath = "//button[@data-balloon='Buy']")private WebElement buy;
	@FindBy(xpath = "//button[@class='button-orange']")private WebElement sell;
	@FindBy(xpath = "//button[@data-balloon='Market depth widget']")private WebElement marketdepthwidget;
	@FindBy(xpath = "//button[@data-balloon='Chart']")private WebElement chart;
	@FindBy(xpath = "//button[@data-balloon='Add']")private WebElement add;
	@FindBy(xpath="//div[@class='first-fields']//div//input[1]")private WebElement quantityofstock;
	
	@FindBy(xpath="//div[@class='exchange-selector']//input[1]")private WebElement BSErediobutton;
	@FindBy(xpath="//div[@class='exchange-selector']//input[2]")private WebElement NSErediobutton;
	@FindBy(xpath="//label[text()='Cover']")private WebElement coverorder;
	@FindBy(xpath="//label[text()='Regular']")private WebElement regular;
	@FindBy(xpath="//label[text()='AMO']")private WebElement amo;
	@FindBy(xpath="//label[text()='Iceberg']")private WebElement iceberg;
	@FindBy(xpath="//input[@value='MIS']")private WebElement misrediobutton;
	@FindBy(xpath="(//label[@class='su-radio-label'])[7]")private WebElement cncrediobutton;
	@FindBy(xpath="//input[@value='MARKET']")private WebElement marketorderrediobutton;
	@FindBy(xpath="//input[@value='LIMIT']")private WebElement limitorderrediobutton;
	@FindBy(xpath="//input[@value='SL']")private WebElement slorderrediobutton;
	@FindBy(xpath="//input[@value='SL-M]")private WebElement slmorderrediobutton;
	@FindBy(xpath="//input[@label='Price']")private WebElement stockprice;
	@FindBy(xpath="//input[@label='Trigger price']")private WebElement triggerprice;
	@FindBy(xpath="//a[@data-balloon='Refresh']")private WebElement refresh;
	@FindBy(xpath="//button[@type='submit']")private WebElement clickonbuy;
	@FindBy(xpath="//button[@class='button-outline cancel']") private WebElement clickoncancel;
	@FindBy(xpath="//span[@class='su-checkbox-box'][1]") private WebElement gttcheckboxstoploss;
	@FindBy(xpath="//div[@class='su-input-group disabled'][1]//input[1]") private WebElement stoplosspercenet;
	
	@FindBy(xpath="//*[@id=\"app\"]/form/section/div/div[3]/div/div[2]/div[1]/label/span[1]") private WebElement gttcheckboxtarget;
	@FindBy(xpath="//div[@class='su-input-group disabled'][1]//input[2]") private WebElement targetpercentage;
	@FindBy(xpath="//body//form")private WebElement buysellpage;
	
	
		public ZerodaHomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
		
		public void searchStock(WebDriver driver ,String stockname) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(1000));
		WebElement w=wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stockname);
	}
		public void selectStockFromSearchList(WebDriver driver,String NameOfStock) {
WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(2000));
List<WebElement >w= wait.until(ExpectedConditions.visibilityOfAllElements(stocklist));
		
		for(int i=0;i<stocklist.size();i++){
		WebElement currentStock=stocklist.get(i);
		String name=currentStock.getText();
		
		if(name.equals(NameOfStock))
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(currentStock);
			actions.perform();
		}
		}
		}
		public void clickOnBuy() {
			
		buy.click();
		}
		public void clickOnSell() {
		sell.click();
		}
		public void clickOnMarketDepth() {
		marketdepthwidget.click();
		}
		public void clickOnChart() {
			chart.click();
		}
		public void clickOnAdd() {
			add.click();

}
		public void enterQuantityofShear(WebDriver driver,String name) {
			quantityofstock.sendKeys(name);
			//act.moveToElement(quantityofstock);
//			quantityofstock.sendKeys(Keys.NUMPAD1);
//			quantityofstock.sendKeys(Keys.NUMPAD1);
//			quantityofstock.sendKeys(Keys.NUMPAD5);
			//act.sendKeys(Keys.NUMPAD1);
			//act.sendKeys(Keys.NUMPAD1);
			//act.sendKeys(Keys.NUMPAD1);
			
			//act.build().perform();
			
		}
		public void selectBSE(WebDriver driver) {
			Actions act=new Actions(driver);
			act.contextClick(BSErediobutton).click();
			act.perform();
			
			}		
		public void selectNSE(WebDriver driver) {
			Actions act=new Actions(driver);
			act.click(NSErediobutton);
			act.perform();
			
			
		}
		public void selectRegularOrder() {
			regular.click();
		}
		public void selectAMO_Order() {
			amo.click();
		}
		public void selectIceberg() {
			iceberg.click();
		}
		public void selectCoverOrder() {
			coverorder.click();
		}
		public void selectMIS(WebDriver driver) {
			Actions act=new Actions(driver);
			act.click(misrediobutton);
			act.perform();
			
		}
		public void selectCNC(WebDriver driver) {
			Actions act=new Actions(driver);
			act.click(cncrediobutton);
			act.perform();
			
		}	
		public void selectMarketOrder(WebDriver driver) {
			Actions act=new Actions(driver);
			act.click(marketorderrediobutton);
			act.perform();
			
		}
		public void selectOnLimitOrder(WebDriver driver) {
			Actions act=new Actions(driver);
			act.click(limitorderrediobutton);
			act.perform();	
		}		
		public void selectOnStopLossOrder(WebDriver driver) {
			Actions act=new Actions(driver);
			act.click(slmorderrediobutton);
			act.perform();
			
		}
		public void selectStopLossAtMarketPriceOrder(WebDriver driver) {
			Actions act=new Actions(driver);
			act.click(slmorderrediobutton);
			act.perform();
			
		}
		public void clickOnBuyButton() {
			clickonbuy.click();
		}
		public void clickOnCancelButton() {
			clickoncancel.click();
		}	
		public void Refresh() {
			refresh.click();
		}
		public void enterStockPrice(String orderprice) {
			
			
			stockprice.sendKeys(orderprice);
			
			
		}
		public void checkBoxGTTStoploss() {
			gttcheckboxstoploss.isSelected();
		}
		public void enterGTTStoplossPercentage(String percentage) {
		
			stoplosspercenet.sendKeys(percentage);
		}	
		public void enterTargetPercentage(String percentage) {
			
			targetpercentage.sendKeys(percentage);
		}
		public void checkboxGTTarget() {
			
			
			gttcheckboxtarget.click();
			
		}
		public void BuySellPage(WebDriver driver) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(2000));
			wait.until(ExpectedConditions.visibilityOf(buysellpage));
			buysellpage.isDisplayed();
		}
	}


