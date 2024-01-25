package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoMMTS2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//click on hotels link
		driver.findElement(By.xpath("//li[@data-cy='menu_Hotels']//span[text()='Hotels']")).click();
		
		//click on city/property
		driver.findElement(By.id("city")).click();
		driver.findElement(By.xpath("//span[text()='Goa']")).click();
		
		//click on check-in and check-out
		driver.findElement(By.xpath("//div[@aria-label='Fri Dec 29 2023']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Tue Jan 02 2024']")).click();
		
		//click on rooms and guests
		driver.findElement(By.id("guest")).click();
		
		//click on Rooms and select 2
		driver.findElement(By.xpath("//p[text()='Rooms']/../..//div[@class='gstSlct']")).click();
		driver.findElement(By.xpath("//li[text()='2']")).click();
		//click on Adults and select 4
		driver.findElement(By.xpath("//p[text()='Adults']/../..//div[@class='gstSlct']")).click();
		driver.findElement(By.xpath("//li[text()='4']")).click();
		
		//click on apply button
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		//click on search button
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		//click on ginger hotel goa
		driver.findElement(By.xpath("//span[text()='Ginger Goa, Panjim']")).click();
		
		// click on book now button
		String pwh = driver.getWindowHandle();
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh) {
			driver.switchTo().window(wh);
			if(!(pwh.equals(wh))) {
				driver.findElement(By.linkText("BOOK THIS NOW")).click();
				WebElement title = driver.findElement(By.xpath("//select[@class='frmSelect']"));
				Select s=new Select(title);
				s.selectByVisibleText("Ms");
				driver.findElement(By.id("fName")).sendKeys("Pragathi");
				driver.findElement(By.id("lName")).sendKeys("V");
				driver.findElement(By.id("email")).sendKeys("pragathi@gmail.com");
				driver.findElement(By.id("mNo")).sendKeys("7795642132");
				driver.findElement(By.xpath("//a[text()='Pay Now']")).click();
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.titleContains("MakeMyTrip - #1 Travel Website for Flight Booking, Airline Tickets"));
				String pageTitle = driver.getTitle();
				System.out.println(pageTitle);
			}
		}
		driver.quit();
	}

}
