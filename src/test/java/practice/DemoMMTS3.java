package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoMMTS3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//click on cabs link
		driver.findElement(By.xpath("//li[@data-cy='menu_Cabs']//span[text()='Cabs']")).click();
		
		//click on from and select bengaluru
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//span[text()='Bangalore']")).click();
		
		//click on to and select Goa
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//span[text()='Goa']")).click();
		
		//click on departure dropdown and select 29/12/2023
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri Dec 29 2023']")).click();
		
		//click on search button
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		//click on view prices dropdown
		driver.findElement(By.xpath("(//span[text()='VIEW PRICES'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Value']/../../../../..//span[text()='BOOK']")).click();
		
		//fill the details
		//pickup details
		driver.findElement(By.xpath("//input[contains(@placeholder,'pick-up address')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Tyss, Bengaluru");
		driver.findElement(By.xpath("//span[contains(text(),' Gandhi Bazaar')]")).click();
		//drop-off address
		driver.findElement(By.xpath("//input[contains(@placeholder,'drop address')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("goa");
		driver.findElement(By.xpath("//span[contains(text(),'Dabolim, Goa')]")).click();
		//state dropdown
		driver.findElement(By.xpath("//p[text()='State']/..//input[@data-cy='dt_state_gst_info']")).click();
		driver.findElement(By.xpath("//li[text()='Karnataka']")).click();
		
		
		
		
	}

}
