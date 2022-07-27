package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utility.Excel;

public class AutoLogin {
	WebDriver driver;
	
	public static void login(WebDriver driver) throws InterruptedException, EncryptedDocumentException, IOException {
		
			ZerodaLoginPage zerodaLoginPage = new ZerodaLoginPage(driver);
			String id = Excel.getdata("kite", 1, 0);
			String pass = Excel.getdata("kite", 1, 1);
			String pinNumber = Excel.getdata("kite", 1, 2);

			zerodaLoginPage.enteruserid(id);
			zerodaLoginPage.enterpassword(pass);
			zerodaLoginPage.clickonLogin();
			Thread.sleep(2000);
			zerodaLoginPage.enterpin(driver, pinNumber);
			zerodaLoginPage.clickonContinue();
	
	}
	public AutoLogin(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

	}

