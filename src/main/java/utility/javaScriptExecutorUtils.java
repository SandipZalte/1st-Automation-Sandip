package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javaScriptExecutorUtils
 {
	
	//Drawing Border and take screenshot
	public static void drawBorder(WebDriver driver, WebElement element) throws IOException {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'",element );
		
		TakesScreenshot tc =(TakesScreenshot) driver;
		File source =tc.getScreenshotAs(OutputType.FILE);
		File destnation= new  File(".\\Screenshot\\logo.png");
		FileUtils.copyFile(source, destnation);
		
		
	}
	//get title of te page
	public static String getTitleByJS (WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title=js.executeScript("return document.title;").toString();
		System.out.println(title);
		return title;
		
	}
	// click action
	public static void clickElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
		
	}
	
	// genrate alert

	public  static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+ message+"')"); 
		
	}
	
	// refreshig page

	
	public static void refreshBrowserrByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
		
	}
	
	// scrolling action

	public static void scrollPageDown(WebDriver driver) {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeAsyncScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	// scrolling up

	public static void scrollPageUp(WebDriver driver) {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeAsyncScript("window.scrollBy(0,-document.body.scrollHeight)");
		
	}
	
	 // zoom in and out the page

	public static void zoomPageByJS(WebDriver driver,int enterzoomsize) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeAsyncScript("document.body.style.zoom= '50%'");// we can change the zoom % by default its 100
		js.executeAsyncScript("document.body.style.zoom= ' " + enterzoomsize + "%' ");
		
		
	}
	//flash

	public static  void flash(WebDriver driver,WebElement element ) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		String bgcolour=element.getCssValue("backgroundColour");
		for(int i=0;i<15;i++) {
			changecolour("#000000", driver, element);//1
			changecolour(bgcolour, driver, element);//2
			

			//changecolour("pink", driver, element);
			
		}
	}
	
	//change the background color
	public static  void changecolour(String color ,WebDriver driver,WebElement element ) {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.backgroundColor =' " + color + " ' ",element);
			try
			{ 
				Thread.sleep(25);
				
			} 
			catch (InterruptedException e)
				{
					System.out.println(e);
				}
	}

}
