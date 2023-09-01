package actitime.testScript;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import actitimeApp.genericLib.BaseClass;


public class CreateCustomer extends BaseClass {
	@Test
	public void customerCreate() throws EncryptedDocumentException, IOException {
		String cusname=du.getDataFromExcelSheet("Sheet1", 0, 1);
		int num=cu.getRandomNum();
		cusname=cusname+num;
		
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.className("newNameField")).sendKeys(cusname);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys(du.getDataFromExcelSheet("Sheet1", 1, 1));
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		
		cu.textToBePresentInElementLocated(driver, By.cssSelector(".titleEditButtonContainer>.title"), cusname);

		String expcusname=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
		System.out.println(expcusname);		
	}
}