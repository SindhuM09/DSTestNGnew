package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver driver = null;
	//constructor
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//locators-
	
	@FindBy(name="username") WebElement username_loc;
	//By username_loc = By.name("username");
	@FindBy(name="password") WebElement password_loc;
	//By password_loc = By.name("password");
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/form/input[4]" ) WebElement login_loc;
	//By login_loc = By.xpath("/html/body/div[2]/div/div[2]/form/input[4]");
	@FindBy(linkText="NumpyNinja") WebElement linkText_loc;
	//boolean flag = driver.findElement(By.linkText("NumpyNinja")).isDisplayed();
	//@FindBy(className = "alert alert-primary") WebElement error_loc;
	@FindBy(linkText ="Register!") WebElement register_loc;
	
	//Action methods
	
	public void setUsername(String username)
	{
		username_loc.sendKeys(username);
		
	}
	
	public void setPassword(String password)
	{
		password_loc.sendKeys(password);
	}
	
	public void clickLogin()
	{
		login_loc.click();
	}
	
	public boolean checkInHomePage()
	{
		boolean flag = false;
		flag = linkText_loc.isDisplayed();
		return flag;
	}
	
	public void clickRegisterLink()
	{
		register_loc.click();
	}
//	public String getErrorMsg()
//	{
//		String errorMsg = error_loc.getText();
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+errorMsg);
//		return errorMsg;
//		
//	}
}
