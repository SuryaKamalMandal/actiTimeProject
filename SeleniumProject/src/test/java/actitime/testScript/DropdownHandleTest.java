package actitime.testScript;

import org.testng.annotations.Test;
import actitime.elementRepository.GeneralSettingsPage;
import actitime.elementRepository.HomePage;
import actitimeApp.genericLib.BaseClass;

public class DropdownHandleTest extends BaseClass {
	@Test
	public void handleDropdown()
	{
//		driver.findElement(By.className("popup_menu_button_settings")).click();
//		driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']")).click();
//		WebElement ugroup=driver.findElement(By.id("userGroupNamingCodeSelect"));
//		cu.selectByVisibleText(ugroup, "Location");
//		String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
//		System.out.println(msg);
		
		HomePage hp=new HomePage(driver);
		hp.clickSettings();
		hp.clickGeneralsettings();
		
		GeneralSettingsPage gs=new GeneralSettingsPage(driver);
		cu.selectByVisibleText(gs.getUsergroupDD(), "Location");
		System.out.println(gs.getmodificationmsg());
		
	}
}