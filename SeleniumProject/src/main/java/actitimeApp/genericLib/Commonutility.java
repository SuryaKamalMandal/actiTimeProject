package actitimeApp.genericLib;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commonutility {
	
	public int getRandomNum()
	{
		Random r=new Random();
		int num=r.nextInt(10000);
		return num;
	}
	
	public String getMsgfromAlert(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		String msg=a.getText();
		return msg;
	}
	public void dismissfromAlert(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		a.dismiss();
	}
	public void acceptfromAlert(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	public void sendKeysfromAlert(WebDriver driver,String keyvalue)
	{
		Alert a=driver.switchTo().alert();
		a.sendKeys(keyvalue);
	}
	
	public void textToBePresentInElementLocated(WebDriver driver,By loc,String text)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(loc, text));
	}
	
	public void selectByIndex(WebElement wb, int index)
	{
		Select s=new Select(wb);
		s.selectByIndex(index);
	}
	public void selectByValue(WebElement wb, String value)
	{
		Select s=new Select(wb);
		s.selectByValue(value);
	}
	public void selectByVisibleText(WebElement drop, String visibletext)
	{
		Select s=new Select(drop);
		s.selectByVisibleText(visibletext);
	}
	
	public List<WebElement> getOptionsBySelectClass(WebElement drop)
	{
		//WebElement wb=driver.findElement(loc);
		Select s=new Select(drop);
		List<WebElement> alloptions=s.getOptions();
		return alloptions;
	}
	
	public void moveToElementByActionClass(WebDriver driver, WebElement wb)
	{
		Actions a=new Actions(driver);
		a.moveToElement(wb);
	}
	public void moveToElementByxyActionClass(WebDriver driver, WebElement wb,int x,int y)
	{
		Actions a=new Actions(driver);
		a.moveToElement(wb, x, y);
	}
	
	public void doubleclickByActionClass(WebDriver driver, WebElement wb)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
}