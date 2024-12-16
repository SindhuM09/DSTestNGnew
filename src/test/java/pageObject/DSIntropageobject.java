package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DSIntropageobject {
	
		//constructor
	Logger logg = (Logger) LogManager.getLogger(DSIntropageobject.class);
		WebDriver driver = null;
		public DSIntropageobject(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	//locators
		@FindBy(linkText="Time Complexity")WebElement timecomplexity_loc;
		@FindBy(linkText="Practice Questions")WebElement PracticeQuestions_loc;
		@FindBy(linkText="Try here>>>")WebElement tryhere_loc;
		
	//Action methods
		public String  getTitle()
		{
			String title = driver.getTitle();
			return title;
		}

		public void timecomplexity()
		{
			timecomplexity_loc.click();
		}
		
		public void PracticeQuestions()
		{
			PracticeQuestions_loc.click();
		}
		
		public void clickTryHere()
		{
						try {
				tryhere_loc.click();		
				driver.switchTo().alert().accept();
				Assert.assertTrue(true);
				} catch (Exception e) {
					logg.error(e.getMessage());
				}
		}
	}

