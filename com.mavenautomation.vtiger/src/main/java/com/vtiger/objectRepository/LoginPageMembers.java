package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMembers {
	
	//Using FindBy instead of constructor
	
	@FindBy(name = "user_name")
	private WebElement username_tf;
	
	@FindBy(name = "user_password")
	private WebElement password_tf;
	
	@FindBy(id = "submitButton")
	private WebElement login_Btn;
	
	@FindBy(xpath = "//div[contains(text(),'You must specify')]")
	private WebElement error_msg;
	/*Constructor Declaration is not fit so we use PageFactory 
	Declaring Constructor for initialization
	public LoginPageMembers(WebDriver driver)
	{
		username_tf = driver.findElement(By.name("user_name"));
		password_tf = driver.findElement(By.name("user_password"));
		login_Btn = driver.findElement(By.id("submitButton"));
	}
    */
	public WebElement getUsernameField() {
		return username_tf;
	}

	public WebElement getPasswordField() {
		return password_tf;
	}

	public WebElement getLogin_Btn() {
		return login_Btn;
	}

	public WebElement getErrorMsg() {
		return error_msg;
	}
	
	//Creating reusable business libraries
	public void loginToApp(String username, String password)
	{
		username_tf.sendKeys(username);
		password_tf.sendKeys(password);
		login_Btn.click();
	}
	
}
