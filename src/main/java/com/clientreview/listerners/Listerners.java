package com.clientreview.listerners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class Listerners implements ITestListener {
	ExtentReports extentreport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {

		extentreport = com.clientreview.test.utils.ExtentReporter.getExtentReport();

	}

	@Override
	public void onTestStart(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentreport.createTest(TestName);
		extentTest.log(Status.INFO, TestName + "Test started sucessfully");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentreport.createTest(TestName);
		extentTest.log(Status.PASS, TestName + "Test passed sucessfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getName();

		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	    File takeScreenshot=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String destinationScreenshot=System.getProperty("user_dir")+"\\ScreenShots"+TestName+".png";
	    try {
			FileHandler.copy(takeScreenshot,new File( destinationScreenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    extentTest.addScreenCaptureFromPath(destinationScreenshot);
	    extentTest.log(Status.INFO, result.getThrowable());

	    extentTest.log(Status.FAIL, TestName+"Test Failed ");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName=result.getName();
		System.out.println("screenshot taken");
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	    File takeScreenshot=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String destinationScreenshot=System.getProperty("user_dir")+"\\ScreenShots"+TestName+".png";
	    try {
			FileHandler.copy(takeScreenshot,new File( destinationScreenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    extentTest.addScreenCaptureFromPath(destinationScreenshot);
	    extentTest.log(Status.INFO, result.getThrowable());

	    extentTest.log(Status.SKIP, TestName+"Test skipped ");
	
	}

	@Override
	public void onFinish(ITestContext context) {

		extentreport = com.clientreview.test.utils.ExtentReporter.getExtentReport();

	}

}
