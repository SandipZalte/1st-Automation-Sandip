package pom;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodaLoginPage {@FindBy (xpath="//input[@id='userid']")private WebElement userid;
@FindBy(xpath="//input[@placeholder='Password']")private WebElement password;
@FindBy(xpath="//button[@type='submit']")private WebElement login ;
@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forget;
@FindBy(xpath="//a[@class='text-light']")private WebElement signup;
@FindBy(xpath="//input[@id='pin']")private WebElement pin;
@FindBy(xpath="//button[@type='submit']")private WebElement okbutton;
@FindBy(xpath ="//input[@placeholder='Your 10 digit mobile number']")private WebElement mobiNum;
@FindBy(xpath="//button[@type='submit']")private WebElement ContinueSignup;

@FindBy(xpath="(//input[@name='is-userid'])[1]")private WebElement redio_remember_user_id;
@FindBy(xpath="(//input[@class='su-radio'])[2]")private WebElement redio_forget_my_user_id;
@FindBy(xpath="//input[@placeholder='User ID']")private WebElement user_id;
@FindBy(xpath="//input[@placeholder='PAN']")private WebElement pan;


@FindBy(xpath="//input[@label='E-mail']")private WebElement email;
@FindBy(xpath="//input[@label='SMS']")private WebElement sms;
@FindBy(xpath="//input[@placeholder='E-mail (as on account)']")private WebElement enteremail;
@FindBy(xpath="//button[@class='button-orange wide']")private WebElement reset;






public ZerodaLoginPage(WebDriver driver) {// User Defin Constrctor
	PageFactory.initElements(driver,this);
	}
	
	public void enteruserid(String enterid) {
	userid.sendKeys(enterid);
	}
	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickonLogin() {
		login.click();
	}
	public void clickonforget() {
	forget.click();
	}
	public void clickonsignup() {
		signup.click();
	}
	public void enterpin(WebDriver driver,String pinNumber) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000)); // explicit wait used here
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinNumber);
		
	}
	public void clickonContinue() {
		okbutton.click();
	}
	
	public void SwitchFocussignuppage(WebDriver driver) {
		
			Set<String> signupnow = driver.getWindowHandles();
			Iterator<String> i = signupnow.iterator();
			i.next();
			driver.switchTo().window(i.next());	
	}
	
	public void entermobiNumbera(String entermobinum) {
		mobiNum.sendKeys(entermobinum);
	}
	public void clickonContinueSignup() {
		ContinueSignup.click();
	}
	public void forgetusingid(String U_id,String pancard,String validemailid) {
		redio_remember_user_id.isSelected();
		user_id.sendKeys(U_id);
		pan.sendKeys(pancard);
		email.isSelected();
		enteremail.sendKeys(validemailid);
		reset.click();
	}

		
	}
	
		
		
	
	
	


