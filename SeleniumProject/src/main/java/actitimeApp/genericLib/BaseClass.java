package actitimeApp.genericLib;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import actitime.elementRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver listenerdriver;
	public Datautility du=new Datautility();
	public Commonutility cu=new Commonutility();
//	@Parameters("browser")
//	@BeforeClass(alwaysRun=true)
	public void launchBrowser(String browser)
	{	if(browser.equals("chrome"))
	{
		ChromeOptions Ch=new ChromeOptions();
		Ch.addArguments("--disable-notifications");
		Ch.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(Ch);
	}
	else if(browser.equals("edge"))
	{
		EdgeOptions Ch=new EdgeOptions();
		Ch.addArguments("--disable-notifications");
		Ch.addArguments("--remote-allow-origins=*");
		driver=new EdgeDriver(Ch);
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeClass(alwaysRun=true)
	public void launchingBrowser()
	{	
		ChromeOptions Ch=new ChromeOptions();
		Ch.addArguments("--disable-notifications");
		Ch.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(Ch);
		listenerdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException
	{
		driver.get(du.getDataFromProperties("url"));
		LoginPage lp=new LoginPage(driver);
		lp.loginApp(du.getDataFromProperties("un"), du.getDataFromProperties("pwd"));
	}
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void closeBroser()
	{
		driver.quit();
	}
}