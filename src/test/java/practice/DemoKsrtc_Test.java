package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoKsrtc_Test {

	public static void main(String[] args) {
		//launch the browser
		WebDriver driver =new ChromeDriver();
		//maximize the page
		driver.manage().window().maximize();
		
		//enter the url
		driver.get("https://www.ksrtc.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on date of departure
		driver.findElement(By.id("txtJourneyDate")).click();
		
		//click on tommorow's date
		driver.findElement(By.xpath("//a[text()='5']")).click();
	}

}
