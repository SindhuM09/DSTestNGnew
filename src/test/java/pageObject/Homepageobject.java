package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Homepageobject{
//constructor
	WebDriver driver = null;
	public Homepageobject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//locators
	
	@FindBy(xpath="/html/body/div[1]/nav/div/div[1]/div")WebElement dropdown_loc;
//	@FindBy(xpath="/html/body/div[2]/div[1]/div/div/a")WebElement DSgetstarted_loc;
	//@FindBy(css="body > div.banner-area > div > div > a > button")WebElement getstarted_loc;
//	
	@FindBy(css = "body > div.row.row-cols-1.row-cols-md-3.g-4 > div:nth-child(1) > div > div > a") WebElement DataStructure_loc;
	@FindBy(css = "body > div.row.row-cols-1.row-cols-md-3.g-4 > div:nth-child(2) > div > div > a") WebElement array_loc;
//	
	@FindBy(css = "body > div.row.row-cols-1.row-cols-md-3.g-4 > div:nth-child(3) > div > div > a") WebElement linkedStarted_loc;
	
	
	@FindBy(css = "body > div.row.row-cols-1.row-cols-md-3.g-4 > div:nth-child(4) > div > div > a") WebElement stack_loc;
	@FindBy(css = "body > div.row.row-cols-1.row-cols-md-3.g-4 > div:nth-child(5) > div > div > a") WebElement queue_loc;
	
	@FindBy(css = "body > div.row.row-cols-1.row-cols-md-3.g-4 > div:nth-child(6) > div > div > a") WebElement tree_loc;
	@FindBy(css = "body > div.row.row-cols-1.row-cols-md-3.g-4 > div:nth-child(7) > div > div > a") WebElement graph_loc;
	
	@FindBy(linkText = "Sign in") WebElement sign_loc;
	
	@FindBy(linkText = "Register") WebElement register_loc;
	
	@FindBy(css = "body > div.alert.alert-primary")WebElement loginfail_loc;
	@FindBy(linkText="Sign out")WebElement signout_loc;
	
	
//Action methods

		
	public  void dropdown()
	{
		dropdown_loc.click();
	}
	public void DSgetstarted()
	{
		//DSgetstarted_loc.click();
	}
	public void clickSignIn()
	{
		sign_loc.click();
	}
	
	public void clickRegister()
	{
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(500));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Register")));
		register_loc.click();
	}
	
	
	public void dataGetStarted()
	{
		System.out.println("dataGetStarteddataGetStarteddataGetStarteddataGetStarteddataGetStarteddataGetStarted");
		DataStructure_loc.click();
	}
	public void arrayGetStarted()
	{
		array_loc.click();
	}
	
	public void linkedGetStarted()
	{			
		linkedStarted_loc.click();
	}
	
	public void stackGetStarted()
	{
		stack_loc.click();
	}
	
	public void queueGetStarted()
	{
		queue_loc.click();
	}
	
	public void treeGetStarted()
	{
		tree_loc.click();
	}
	public void graphGetStarted()
	{
		graph_loc.click();
	}
	public String checkLoginError()
	{
		String text = loginfail_loc.getText();
		return text;
	}
	
	public void clickLogout()
	{
		signout_loc.click();
	}
	
	public String getTitle()
	{
		String title = driver.getTitle();
		return title;
	}

}