package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoSpiceJetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DMonth="May";
		String AMonth="June";
		int Dyear=2024;
		int Ayear=2024;
		int Ddate=21;
		int Adate=21;
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver =new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		
		driver.findElement(By.xpath("//div[text()='From']")).sendKeys("BLR");
		
		driver.findElement(By.xpath("//div[text()='To']/parent::div/descendant::input")).sendKeys("GoI");
		
		driver.findElement(By.xpath("//div[text()='"+DMonth+" ' and text()='"+Dyear+"']/../../descendant::div[text()='"+Ddate+"']")).click();
		
		
		driver.findElement(By.xpath("//div[text()='"+AMonth+" ' and text()='"+Ayear+"']/../../descendant::div[text()='"+Adate+"']")).click();
		
		driver.findElement(By.xpath("//div[text()='Search Flight']/parent::div")).click();
		
		
	}

}
