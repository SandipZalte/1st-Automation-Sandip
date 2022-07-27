package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

	public static WebDriver openBrowser() {
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver","C:\\Selenium jar file\\Browser Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(o);// upcasting
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		
			// driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS); // 
			//--> implicetly wait and this applicable the whole code for launcing browser till
			// the close the browser
		return driver;

	}

}
