package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.Homepageobject;
import pageObject.LoginPageObject;
import pageObject.Stackpageobject;
import util.ExcelReader;

public class StackTestcases extends BaseCases {
	Stackpageobject Spageobject = null;
	WebDriver driver = null;
	LoginPageObject loginObject = null;
	ExcelReader reader = null;
	ExcelReader xcelReader = null;
	String urlhomestr = null;
	Homepageobject homeObject = null;
	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		Spageobject = new Stackpageobject(driver);
		homeObject =new Homepageobject(driver);
		login(driver);
	}
	
	public void navigateHome()
	{
		driver.get(getUrlHome());
		homeObject.stackGetStarted();
	}

@Test(priority =1)
public void OperationsinStackLink() {
	navigateHome();
	Spageobject.operationsinstack();
	String title = Spageobject.getTitle();
	Assert.assertEquals("Operations in Stack", title);
}
@Test(priority= 2)
public void operationtryhere() {
	driver.getCurrentUrl();
	Spageobject.clicktryLink();
	String title = driver.getTitle();
	Assert.assertEquals("Assessment", title);
	
}
@Test(priority = 3)
public void executeoperationsTryHere() {
		
	TryEditorCases tryEditor = new TryEditorCases();
	tryEditor.executeTryEditor(driver);	
}

	@Test(priority =4)
	public void Implementation() {
		navigateHome();
		Spageobject.Implementation();;
		String title = Spageobject.getTitle();
		Assert.assertEquals("Implementation", title);

}
	@Test(priority= 5)
	public void Implementationtryhere() {
		driver.getCurrentUrl();
		Spageobject.clicktryLink();
		String title = driver.getTitle();
		Assert.assertEquals("Assessment", title);
		
	}
	@Test(priority = 6)
	public void executeImplementationTryHere() {
			
		TryEditorCases tryEditor = new TryEditorCases();
		tryEditor.executeTryEditor(driver);	
	}
	@Test(priority =7)
	public void Applications() {
		navigateHome();
		Spageobject.Applications();;
		String title = Spageobject.getTitle();
		Assert.assertEquals("Applications", title);	
	}
	
	@Test(priority = 8)
	public void ApplicationsTryHere() {	
			
			Spageobject.clicktryLink();
			String title = driver.getTitle();
			Assert.assertEquals("Assessment", title);
		}
		
   @Test(priority = 9)
		public void executeApplicationsTryHere() {
				
			TryEditorCases tryEditor = new TryEditorCases();
			tryEditor.executeTryEditor(driver);	
		}
   @Test(priority = 10)
	public void userclickspractice_question_link() {
		navigateHome();
		Spageobject.Applications();
		Spageobject.clickPractice();
		String title = Spageobject.getTitle();
		Assert.assertEquals("Practice Questions", title);
   }
   
  @AfterClass
   public void user_clicks_on_logout_link() {
   		driver.get(getUrlHome());
   		homeObject.clickLogout();
   		driver.quit();
   }

}
