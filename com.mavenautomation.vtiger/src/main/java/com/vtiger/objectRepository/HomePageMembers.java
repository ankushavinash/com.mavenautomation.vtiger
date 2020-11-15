package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.BaseClass;

public class HomePageMembers {

	@FindBy(xpath = "//td[contains(@onmouseover, 'ondemand')]")
	private WebElement signOutDD;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	
	
	public WebElement getSignOutDD()
	{
		return signOutDD;
	}
	
	public WebElement getSignOutLink()
	{
		return signOutLink;
	}
	
	public WebElement getContactLink()
	{
		return contactsLink;
	}
	
	public void logoutFromApp()
	{
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(signOutDD).perform();	
		signOutLink.click();
	}	
}
