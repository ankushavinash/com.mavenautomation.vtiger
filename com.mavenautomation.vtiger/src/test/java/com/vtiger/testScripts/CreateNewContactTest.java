package com.vtiger.testScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepository.ContactInformationPageMembers;
import com.vtiger.objectRepository.ContactPageMembers;
import com.vtiger.objectRepository.CreateNewContactPageMembers;
import com.vtiger.objectRepository.HomePageMembers;

@Listeners(com.vtiger.genericLib.ListenerImplementation.class)
public class CreateNewContactTest extends BaseClass {

	@Test
	public void createContact() throws IOException, Exception
	{
		HomePageMembers hp = PageFactory.initElements(driver, HomePageMembers.class);
		hp.getContactLink().click();	
		
		ContactPageMembers cp = PageFactory.initElements(driver, ContactPageMembers.class);
		SoftAssert s = new SoftAssert();
		//Validating Contact Page
		s.assertTrue(driver.getTitle().contains(picker.getDataFromExcel("TestCaseSteps", 2, 2)));	
		cp.getCreateContactPlusIcon().click();
		
		CreateNewContactPageMembers cncp = PageFactory.initElements(driver, CreateNewContactPageMembers.class);
		//Validating Create New Contact Page
		s.assertTrue(cncp.getCreateNewContact_Text().getText().
											contains(picker.getDataFromExcel("TestCaseSteps", 4, 2)));
		
		cncp.getLastNameTF().sendKeys(picker.getDataFromExcel("TestCaseData", 10, 2));
		cncp.getSaveBtn().click();
		
		ContactInformationPageMembers cip = PageFactory.initElements(driver, ContactInformationPageMembers.class);
		String actualText = cip.getSuccessMsg().getText();
		
		//Validating Contact information Page
		assertTrue(actualText.contains(picker.getDataFromExcel("TestCaseData", 11, 2)));
		Reporter.log("Contact Created Successfully", true);
		s.assertAll();
	}
}
