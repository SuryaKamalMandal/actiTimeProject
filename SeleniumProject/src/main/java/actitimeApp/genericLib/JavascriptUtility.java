package actitimeApp.genericLib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtility {
	
	JavascriptExecutor js;
	
	public void JavaScriptUtility(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]", url);
	}
	
	public void click(WebElement ele)
	{
		js.executeScript("arguments[0].click()", ele);
	}
	
	public String getUrlofCurrentPage()
	{
		String url=(String) js.executeScript("return window.location.href");
		return url;
	}
	
	public String getTitleofCurrentPage()
	{
		String Title=(String) js.executeScript("return document.title");
		return Title;
	}
	
	public void sendKeys(WebElement ele,String text)
	{
		js.executeScript("arguments[0].value=arguments[1]",ele,text);
	}
	
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void javaScriptExe(WebElement ele)
	{
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}
}