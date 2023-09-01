package actitime.testScript;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import actitimeApp.genericLib.BaseClass;

public class TypeofWork extends BaseClass {
	@Test
	public void AlertHandle() throws Throwable, IOException {
		
		driver.findElement(By.xpath("//div[@class='menuTable']/div[2]/div")).click();
		driver.findElement(By.linkText("Types of Work")).click();
		driver.findElement(By.className("i")).click();
		driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelSheet("Sheet1", 0, 1));
		driver.findElement(By.xpath("//td[@id='ButtonPane']//input[@type='button']")).click();
		
		String msg=cu.getMsgfromAlert(driver);
		System.out.println(msg);
		cu.dismissfromAlert(driver);
	}
}