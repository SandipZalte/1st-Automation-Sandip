package test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;

public class Listener extends BaseTest implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("On Start");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test has Started -->" + " " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success fully Completed " + " " + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test has been Failed Please Chcek Screenshot Folder-->" + " " + result.getName());
		try {
			Screenshot.takescreenshotwithname(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test has been Failed due to timeout-->");
		System.out.print(result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test has been Skipped -->" + " " + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("on Finish");
	}

}