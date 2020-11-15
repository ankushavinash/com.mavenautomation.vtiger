package com.vtiger.testScripts;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;

@Listeners(com.vtiger.genericLib.ListenerImplementation.class)
public class CreateNewProductTest extends BaseClass {

	@Test
	public void createProduct() throws IOException, Exception
	{
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(picker.getDataFromExcel("TestCaseData", 5, 2));
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();

		String actual = driver.findElement(By.cssSelector("span[class='lvtHeaderText']")).getText();
		String expected = picker.getDataFromExcel("TestCaseData", 6, 2);
		
		/*
		Assert.assertEquals(actual, expected);		
		Reporter.log("Validation Pass", true);
		*/
		
		Assert.assertTrue(actual.contains(expected));
		Reporter.log("Validation Pass", true);
		
		//String result = actualText.contains(pick.getDataFromExcel("TestCaseData", 6, 2)) ? 
		//		"Test Pass" : "Test Fail";
	//	Reporter.log(result, true);
	}
}
