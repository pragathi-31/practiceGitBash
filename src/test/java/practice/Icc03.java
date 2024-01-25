package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc03 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/odi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		List<WebElement> pos = driver.findElements(By.xpath("(//div[@class='si-table-data si-pos'])[position()>1 and position()<9]"));	
		
		for(int i=0;i<pos.size();i++) {
			String position = pos.get(i).getText();
			String name = driver.findElement(By.xpath("//span[text()='"+position+"']/ancestor::div[@class='si-table-data si-pos']/following-sibling::div[@class='si-table-data si-team']")).getText();
			System.out.println(position+"------------>"+name);
		}
		driver.quit();
	}

}
