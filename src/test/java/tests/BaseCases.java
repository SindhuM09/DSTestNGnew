package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.Homepageobject;
import pageObject.LoginPageObject;
import util.ExcelReader;

public class BaseCases {
	
	public static WebDriver driver = null;
	public String browser = null;
	ChromeOptions chromeoptions = new ChromeOptions();
	FirefoxOptions firefoxoptions = new FirefoxOptions();
	EdgeOptions edgeoptions = new EdgeOptions();
	LoginPageObject loginObject = null;
	public ExcelReader reader = null;
	ExcelReader xcelReader = null;
	private String urlhomestr = null;
	Homepageobject homeObject = null;
	@Parameters({"browser"})
	@BeforeClass
	public void setUp()
	{
		System.out.println("first commnet");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("edge browser launched");
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched");
		}
			
		//return driver;
				
		reader = new ExcelReader();			
		urlhomestr = reader.getProperty("URLHOME");
	}
	
	public void login(WebDriver driver)
	{
		
		reader = new ExcelReader();
		urlhomestr = reader.getProperty("URLHOME");
		loginObject = new LoginPageObject(driver);
		
		
		driver.get(urlhomestr);
		homeObject  = new Homepageobject(driver);
		String username = reader.getProperty("USERNAME");
		String password = reader.getProperty("PASSWORD");
		homeObject.clickSignIn();
		
		loginObject.setUsername(username);
		loginObject.setPassword(password);
		loginObject.clickLogin();
	}
	public String getUrlHome( )
	{
		return urlhomestr;
	}
	
	@AfterClass
	public void tearDown()
	{
		//return driver;
		driver.quit();
	}

}
