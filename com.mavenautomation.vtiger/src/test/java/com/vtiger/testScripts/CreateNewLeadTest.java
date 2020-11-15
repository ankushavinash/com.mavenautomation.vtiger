
package com.vtiger.testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;

@Listeners(com.vtiger.genericLib.ListenerImplementation.class)
public class CreateNewLeadTest extends BaseClass {

	@Test
	public void createLead() throws IOException, Exception {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(picker.getDataFromExcel("TestCaseData", 1, 2));
		driver.findElement(By.name("company")).sendKeys(picker.getDataFromExcel("TestCaseData", 2, 2));
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();

		String actualText = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
		Reporter.log(actualText, true);
		String result = actualText.contains(picker.getDataFromExcel("TestCaseData", 3, 2)) ? 
				"Test Pass" : "Test Fail";
		Reporter.log(result, true);
		
	}
}
