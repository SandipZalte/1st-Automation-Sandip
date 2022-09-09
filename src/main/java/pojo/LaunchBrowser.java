package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static WebDriver openBrowser() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications"); // option is used for auto  closed the browser notification or any add 
		
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
		WebDriverManager.iedriver().setup();

			//System.setProperty("webdriver.chrome.driver","C:\\Selenium jar file\\Browser Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);// upcasting
//		WebDriver driver= new FirefoxDriver(option);
//		WebDriver driver= new EdgeDriver(option);
//		WebDriver driver= new InternetExplorerDriver(option);
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		
			// driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS); // 
			//--> implicetly wait and this applicable the whole code for launcing browser till
			// the close the browser
		return driver;

	}

}
