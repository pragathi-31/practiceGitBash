package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DemoAirIndia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String DDate="May 2024";
		String RDate="June 2024";
		int date=20;
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver =new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.airindia.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions a=new Actions(driver);
		WebElement book = driver.findElement(By.xpath("//a[text()='Book & Manage']"));
		a.moveToElement(book).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Search Flights')]")).click();
		
		
		driver.findElement(By.id("From")).sendKeys("Bengaluru"+Keys.ENTER);
		
		driver.findElement(By.id("To")).sendKeys("Goa"+Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@aria-label='DepartDate']/following-sibling::input")).click();
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+DDate+" ']/parent::div//span[text()=' "+date+" ']")).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			}
		}
		
		
		driver.findElement(By.xpath("//input[@aria-label='Return']/following-sibling::input")).click();
		
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()=' "+RDate+" ']/parent::div//span[text()=' "+date+" ']")).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			}
		}
		
		
		driver.findElement(By.xpath("//button[text()=' Show Flights ']")).click();
		
		
		
		
		
		
	}

}
