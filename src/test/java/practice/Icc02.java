package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc02 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/odi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		List<WebElement> matches = driver.findElements(By.xpath("//div[@class='si-table-data si-matches']/descendant::span[text()<40]"));
		
		int count = matches.size();
		for(int i=0;i<count;i++) {
			
			String match = matches.get(i).getText();
			String TeamName = driver.findElement(By.xpath("//span[text()='"+match+"']/ancestor::div[@class='si-table-data si-matches']/preceding-sibling::div[@class='si-table-data si-team']")).getText();
			System.out.println(TeamName+"------------->"+match);
			
		}
		driver.quit();
	}

}
