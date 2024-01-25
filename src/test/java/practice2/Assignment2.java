package practice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		WebElement input = driver.findElement(By.id("email"));
		input.sendKeys("hello");
		
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(input);
		actions.click();
		actions.sendKeys("hi").perform();
		
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(" document.getElementById('email').value='hello';");
		
		driver.quit();
	}

}
