package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoMakeMytripScenario1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//click on round trip
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		
		// click on from
		driver.findElement(By.id("fromCity")).click();
		//entering Bengaluru
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		//click on BLR
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		//click on To
		driver.findElement(By.xpath("//span[text()='To']")).click();
		//entering Goa
		driver.findElement(By.id("toCity")).sendKeys("Goa");
		//clicking on goa
		driver.findElement(By.xpath("//p[text()='Goa - Dabolim Airport, India']")).click();
		
		//click on departure and select 29/12/2023 and return date on 02/01/2024
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri Dec 29 2023']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Tue Jan 02 2024']")).click();
		
		// click on search button
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		Thread.sleep(2000);
		
		//click on first indigo blore-goa
		driver.findElement(By.xpath("(//b[text()='Bengaluru → Goa - Dabolim Airport']/../..//span[text()='IndiGo '])[1]/../../../..//input[@type='radio']")).click();
		Thread.sleep(2000);
		//click on first indigo goa-blore
		driver.findElement(By.xpath("(//b[text()='Goa - Dabolim Airport → Bengaluru']/../..//span[text()='IndiGo '])[1]/../../../..//input[@type='radio']")).click();
		
		// click on lock price
		driver.findElement(By.xpath("//button[text()='LOCK PRICE']")).click();
		driver.quit();
	}

}
