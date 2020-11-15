package com.vtiger.genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.vtiger.objectRepository.HomePageMembers;
import com.vtiger.objectRepository.LoginPageMembers;

public class BaseClass {
	public static WebDriver driver;
	public DataStorage picker = new DataStorage();

	@BeforeSuite
	public void configBS()
	{
		System.out.println("-----------DB Connect-------------");
	}
	@BeforeTest
	public void configBT()
	{
		System.out.println("-----------Before Test Dependency-------------");
	}

	//For batch execution fetching browser value from properties file
	@BeforeClass
	public void configBC() throws IOException 
	{
		String browserValue = picker.getDataFromProperty("browser");
		System.out.println("-----------Launch Browser-------------");
		if(browserValue.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserValue.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(picker.getDataFromProperty("url"));
		driver.manage().window().maximize();
	}	

	/*	For Cross Browser Execution fetching browser value from testng.xml
	@BeforeClass
	@Parameters("browserValue")
	public void configBC(String browserValue) throws IOException
	{
		System.out.println("-----------Launch Browser-------------");
		if(browserValue.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserValue.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(pick.getDataFromProperty("url"));
		driver.manage().window().maximize();
	}
	 */	
	@BeforeMethod
	public void configBM() throws IOException
	{
		//Object creation using PageFactory
		LoginPageMembers login = PageFactory.initElements(driver, LoginPageMembers.class);

		login.loginToApp(picker.getDataFromProperty("username"), picker.getDataFromProperty("password"));
		System.out.println("-----------Login Done-------------");

		/*	Using LoginPageMembers object creation locator is not hardcoded

	    LoginPageMembers login = new LoginPageMembers();
		login.getUsernameField().sendKeys(picker.getDataFromProperty("username"));
		login.getPasswordField().sendKeys(picker.getDataFromProperty("password"));
		login.getLogin_Btn().click();
		 */	

		/*	locator is hardcoded no need to create object

		driver.findElement(By.name("user_name")).sendKeys(picker.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(picker.getDataFromProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		 */			
	}
	@AfterMethod
	public void configAM()
	{
		HomePageMembers hp = PageFactory.initElements(driver, HomePageMembers.class);
		hp.logoutFromApp();
		System.out.println("-----------Logout Done-------------");
		/*	
		WebElement signOutDD = driver.findElement(By.xpath("//td[contains(@onmouseover, 'ondemand')]"));
		Actions act = new Actions(driver);
		act.moveToElement(signOutDD).perform();	
		driver.findElement(By.linkText("Sign Out")).click();
		 */			
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("-----------Close Browser-------------");
		driver.quit();
	}
	@AfterTest
	public void configAT()
	{
		System.out.println("-----------After Test Dependency-------------");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("-----------DB Dis-Connect-------------");
	}

}
