package actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="popup_menu_button_settings")
	private WebElement settings;
	@FindBy(xpath="//div[text()='Manage system settings & configure actiTIME']")
	private WebElement generalsettingslink;
	
	public WebElement getSettings()
	{
		return settings;
	}
	public WebElement getGeneralSettingslink()
	{
		return generalsettingslink;
	}
	
	public void clickSettings()
	{
		getSettings().click();
	}
	public void clickGeneralsettings()
	{
		getGeneralSettingslink().click();
	}

}
