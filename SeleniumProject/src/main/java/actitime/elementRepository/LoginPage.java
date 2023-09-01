package actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	private WebElement un;
	@FindBy(name="pwd")
	private WebElement pass;
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	
	public WebElement getusername()
	{
		return un;
	}
	public WebElement getpassword()
	{
		return pass;
	}
	public WebElement getloginButton()
	{
		return loginButton;
	}
	
	public void loginApp(String username,String password)
	{
		getusername().sendKeys(username);
		getpassword().sendKeys(password);
		getloginButton().click();
	}
}