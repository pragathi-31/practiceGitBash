package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoGoibibiTest {

	public static void main(String[] args) {
		int Ddate=21;
		int Rdate=24;
		String Dmonth="May 2024"; 
		String Rmonth="June 2024";
		//launch the browser
		WebDriver driver =new ChromeDriver();
		//maximize the page
		driver.manage().window().maximize();

		//enter the url
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//close that login/sign up pop up
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		//click on round trip
		driver.findElement(By.xpath("//p[text()='Round-trip']")).click();

		//click on departure
		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		for(;;) {
			try{
				//click on departure date
				driver.findElement(By.xpath("//div[text()='"+Dmonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Ddate+"']")).click();
				System.out.println("departure date clicked");
				break;
			}
			catch(Exception e) {
				//click on next
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}	
			
		}
		//click on done
		driver.findElement(By.xpath("//span[text()='Done']")).click();	
		
		//click on cancel
		driver.findElement(By.xpath("//a[text()='Cancel']")).click();

		//click on return
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		for(;;) {
			try{
				//click on return date
				driver.findElement(By.xpath("//div[text()='"+Rmonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Rdate+"']")).click();
				System.out.println("return date clicked");
				break;
			}
			catch(Exception e) {
				//click on next
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}	
			
		}

		//click on done
		driver.findElement(By.xpath("//span[text()='Done']")).click();

		//click on cancel
		driver.findElement(By.xpath("//a[text()='Cancel']")).click();







	}

}
