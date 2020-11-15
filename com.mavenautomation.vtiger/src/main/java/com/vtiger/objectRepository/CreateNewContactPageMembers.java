package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewContactPageMembers {

	@FindBy(name = "lastname")
	private WebElement lastName_tf;
	
	@FindBy(css = "input[value='  Save  ']")
	private WebElement saveBtn;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement createNewContact_ValidationMsg;

	public WebElement getLastNameTF() {
		return lastName_tf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getCreateNewContact_Text()
	{
		return createNewContact_ValidationMsg;
	}
	
	
}
