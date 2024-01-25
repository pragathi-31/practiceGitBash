package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoClearTrip {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cleartrip.com/");
		
		Actions a=new Actions(driver);
		a.click().perform();
		
		driver.findElement(By.xpath("//input[@placeholder='Where from?']")).sendKeys("BLR");
		
		driver.findElement(By.xpath("//p[contains(text(),'Bangalore, IN')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys("DEL");
		
		driver.findElement(By.xpath("//p[contains(text(),'New Delhi, IN')]")).click();
		
		driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']/child::button//*[name()='svg']")).click();
		
		driver.findElement(By.xpath("//div[text()='January 2024']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='19']")).click();
		
		
	}

}
