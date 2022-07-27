package utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Screenshot {

	/*-------------- 1st type of Screenshot----------*/

	public static void takescreenshotwithname(WebDriver driver, String name) throws IOException {
		String d = DateTime.getdate(); // method of time class

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("F:\\TESTING\\Eclipse IDE\\eclipse-workspace\\KiteZeroda\\test-output\\Screenshot\\"+ name +" "+d + ".png");
		
		FileHandler.copy(source, destination);

	}
//	/*-------------2nd type of Screenshot method---------------*/
//
//	public static void snapshot(String Name) throws IOException, HeadlessException, AWTException {
//		String d = DateTime.getdate();
//		
//		BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//		File path = new File("F:\\TESTING\\Eclipse IDE\\eclipse-workspace\\KiteZeroda\\TestScreenshot" +Name +" "+ d + ".png");	
//		ImageIO.write(img, "png", path);
//	}

	
}
