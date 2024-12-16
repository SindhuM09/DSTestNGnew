package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Stackpageobject {
	
	//constructor
	Logger logg = (Logger) LogManager.getLogger(Stackpageobject.class);
			WebDriver driver = null;
			public Stackpageobject(WebDriver driver) {		
				this.driver = driver;
				PageFactory.initElements(driver, this);
	}

	//locators
			
			@FindBy(linkText="Operations in Stack")WebElement operations_loc;	
			@FindBy(linkText="Implementation")WebElement Implementation_loc;	
			@FindBy(linkText="Applications")WebElement Applications_loc;	
			
			@FindBy(css = "#content > a") WebElement practice_loc;
			
			@FindBy(linkText = "Try here>>>")WebElement try_loc;
							
	//Action methods
			public String  getTitle()
			{
				String title = driver.getTitle();
				return title;
			}

			public  void operationsinstack()
			{
				operations_loc.click();
			}
			public void Implementation()
			{
				Implementation_loc.click();
			}
			public void Applications()
			{
				Applications_loc.click();
			}
			
			public void clickPractice()
			{
				practice_loc.click();
			}
			
			public void clicktryLink()
			{
				try {
					try_loc.click();		
					driver.switchTo().alert().accept();
					Assert.assertTrue(true);
					} catch (Exception e) {
						logg.error(e.getMessage());
					}
			}
			
			}

