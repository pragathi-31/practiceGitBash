package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoIcc1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/odi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		List<WebElement> allteams = driver.findElements(By.xpath("(//div[@class='si-table-data si-pos'])[position()>1]"));
		
		int count = allteams.size();
		for(int i=0;i<count;i++) {

			String tname = allteams.get(i).getText();
			
			String names = driver.findElement(By.xpath("//span[text()='"+tname+"']/../following-sibling::div[@class='si-table-data si-team']/descendant::h3")).getText();
			String points = driver.findElement(By.xpath("//span[text()='"+tname+"']/../following-sibling::div[@class='si-table-data si-pts']/descendant::span")).getText();
			String rating=driver.findElement(By.xpath("//span[text()='"+tname+"']/../following-sibling::div[@class='si-table-data si-rating']/descendant::span")).getText();
			System.out.println(names+"---------->"+points+"---------->"+rating);

		}
		driver.quit();
	}

}
