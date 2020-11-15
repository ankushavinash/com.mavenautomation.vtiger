package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPageMembers {

	@FindBy(css = "span[class='dvHeaderText']")
	private WebElement successMsg;
	
	public WebElement getSuccessMsg()
	{
		return successMsg;
	}
}
