package practice2;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		String title1 = driver.getTitle();
		System.out.println(title1);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		  String title2 = (String)(js.executeScript("return document.title;"));
		  System.out.println(title2);
		  
	}
}
