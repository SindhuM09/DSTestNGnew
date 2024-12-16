package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Homepageobject;
import pageObject.LoginPageObject;
import util.ExcelReader;

public class LoginTestCases extends BaseCases {
	LoginPageObject pageObject = null;
	ExcelReader reader = null;
	Homepageobject homeObject = null;
	String urlhomestr = null;


	@BeforeClass	
	public void setUp()
	{
		driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver = new ChromeDriver();
		pageObject = new LoginPageObject(driver);
		//driver.get("https://dsportalapp.herokuapp.com/login");
		homeObject = new Homepageobject(driver);
		reader = new ExcelReader(System.getProperty("user.dir")+"\\TestData\\\\logindata.xlsx");
		urlhomestr = reader.getProperty("URLHOME");
	}

	@Test (priority = 1)
	public void checkEmptyUsername()
	{

	driver.get(urlhomestr);
	

	homeObject.clickSignIn();
	
	String[] data = reader.getUserPassword("Sheet1",1);
	
	try
	{
		
		pageObject.setUsername(data[0]);
		pageObject.clickLogin();
		String str = driver.switchTo().activeElement().getAttribute("validationMessage");
		Assert.assertEquals(str, "Please fill out this field.");


	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}

	}

	//	@Test(priority=2)
	//	public void clickRegisterLink()
	//	{
	//		pageObject.clickRegisterLink();
	//		Assert.assertEquals(driver.getTitle(), "Registration");
	//
	//	}


	@Test(priority=3)
	public void checkInvalidUsernamePassword() throws InterruptedException {



		String[] data = reader.getUserPassword("Sheet1",1);

		pageObject.setUsername(data[0]);
		pageObject.setPassword(data[1]);
		pageObject.clickLogin();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Login");
	}

	@Test(priority=4)
	public void checkCorrectUsernamePassword() throws InterruptedException {



		String[] data = reader.getUserPassword("Sheet1",0);

		pageObject.setUsername(data[0]);
		pageObject.setPassword(data[1]);
		pageObject.clickLogin();

	}

	@AfterClass
	public void user_clicks_on_logout_link() {
		driver.get(urlhomestr);
		homeObject.clickLogout();
		driver.quit();
	}



}
