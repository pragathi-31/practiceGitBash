package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoFlipkart {
	@Test
	public void flipkart() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		Actions a=new Actions(driver);
		WebElement fashion = driver.findElement(By.xpath("//span[text()='Fashion']"));
		a.moveToElement(fashion).perform();
		Thread.sleep(3000);
		List<WebElement> all = driver.findElements(By.xpath("//span/ancestor::object/child::a"));
		
		for(WebElement l:all) {
			Thread.sleep(1000);
			a.moveToElement(l).perform();
			Thread.sleep(1000);
			List<WebElement> allText = driver.findElements(By.xpath("//div[contains(text(),'More in ')]/../child::a"));
			for(WebElement text:allText) {
				String t = text.getText();
				System.out.println(t);
			}
		}
		driver.quit();
	}
}
