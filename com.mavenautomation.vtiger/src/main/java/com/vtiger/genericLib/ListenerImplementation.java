package com.vtiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener  {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println(arg0.getName() + " Execution Finish");		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println(arg0.getName() + " Execution Start");		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println(arg0.getName() + " Failed but some percentage");		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		Date d = new Date();
		String currentDateTime = d.toString().replace(':', '-');
		String testCaseName = arg0.getName();
		System.out.println(testCaseName + " Test Case Failed");	
		EventFiringWebDriver efwd = new EventFiringWebDriver(BaseClass.driver);
		File sourceFile = efwd.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("./Screenshot/" + testCaseName + currentDateTime+ ".png"));
		} catch (IOException e) {
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println(arg0.getName() + " Test Case Skipped");		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.getName() + " Test Case Start");		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(arg0.getName() + " Test Case Success");		
	}


}
