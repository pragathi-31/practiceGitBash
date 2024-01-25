package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoMMTtest {

	public static void main(String[] args) throws Exception {
		String month="May 2024";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(3000);
		driver.switchTo().frame(2);

		driver.findElement(By.xpath("//a[@class='close']")).click();

		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		for(;;) {

			try {	
				driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='8']")).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

	}

}
