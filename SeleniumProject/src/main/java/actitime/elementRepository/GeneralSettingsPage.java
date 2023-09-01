package actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralSettingsPage {
	public GeneralSettingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userGroupNamingCodeSelect")
	private WebElement usergroupsDD;
	
	@FindBy(id="FormModifiedTextCell")
	private WebElement modificationMsg;
	
	public WebElement getUsergroupDD()
	{
		return usergroupsDD;
	}
	public WebElement getModificationMsg()
	{
		return modificationMsg;
	}
	
	public String getmodificationmsg()
	{
		return getModificationMsg().getText();
	}
}