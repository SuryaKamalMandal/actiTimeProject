package actitime.testScript;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class proKabaddi {

	public static void main(String[] args) throws Throwable {
		String teamname= "UP Yoddhas";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://www.google.com/search?q=pro+kabaddi+points+table+2022&sxsrf=AB5stBiAG67Awi5JzIFGYRttXTu4tmM71g%3A1689661270885&ei=Vi-2ZNi9NfKfseMP6N6XgAI&ved=0ahUKEwjYwN3ezpeAAxXyT2wGHWjvBSAQ4dUDCA8&uact=5&oq=pro+kabaddi+points+table+2022&gs_lp=Egxnd3Mtd2l6LXNlcnAiHXBybyBrYWJhZGRpIHBvaW50cyB0YWJsZSAyMDIyMgcQABiKBRhDMgoQABiABBgUGIcCMgUQABiABDIFEAAYgAQyBRAAGIAEMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHkiRCVDaAli9BHABeAGQAQCYAdMBoAGZA6oBBTAuMS4xuAEDyAEA-AEBwgIKEAAYRxjWBBiwA8ICChAAGIoFGLADGEPCAg4QABjkAhjWBBiwA9gBAcICEBAuGIoFGMgDGLADGEPYAQLCAgcQIxiKBRgn4gMEGAAgQYgGAZAGE7oGBggBEAEYCboGBggCEAEYCA&sclient=gws-wiz-serp#cobssid=s");
//		String text = driver.findElement(By.xpath("//div[contains(text(),'About')]")).getText();
		
		WebDriverWait wait= new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'About')]")));
		//Names of all the Teams
//		List<WebElement> tablelist = driver.findElements(By.xpath("//div[@class='MjjYud']//div[@class='tsp-tln']"));
		List<WebElement> tablelist = driver.findElements(By.xpath("//div[@class='MjjYud']//div[@class='tsp-tln']//span[contains(text(),'"+teamname+"')]"));
		//Clicked on More
		driver.findElement(By.xpath("(//span[@class='U8v51e S3PB2d'])[3]")).click();
		
		for(WebElement team:tablelist)
		{
			String singlelist=team.getText();
			String win = driver.findElement(By.xpath("//div[@class='tsp-tln']/span[text()='"+singlelist+"']/../../..//td[@class='tsp-kscs tsp-cm'][2]")).getText();
			String loss = driver.findElement(By.xpath("//div[@class='tsp-tln']/span[text()='"+singlelist+"']/../../..//td[@class='tsp-kscs tsp-cm'][3]")).getText();
			String draw = driver.findElement(By.xpath("//div[@class='tsp-tln']/span[text()='"+singlelist+"']/../../..//td[@class='tsp-kscs tsp-cm tsp-kshc']")).getText();
			String points = driver.findElement(By.xpath("//div[@class='tsp-tln']/span[text()='"+singlelist+"']/../../..//td[@class='tsp-kscs tsp-cm tsp-fb']")).getText();
			
			System.out.println(singlelist+"----"+" win--"+win+" loss--"+loss+" draw--"+draw+" TotalPoints--"+points);
		}
	}
}