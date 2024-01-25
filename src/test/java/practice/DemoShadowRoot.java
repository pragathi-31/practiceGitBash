package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoShadowRoot {
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://selectorshub.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//a[text()='PracticePage']")).click();
	WebElement shadow = driver.findElement(By.id("userName"));
	SearchContext first = shadow.getShadowRoot();
	first.findElement(By.cssSelector("#kils")).sendKeys("pragathi");
	WebElement shadow1 = first.findElement(By.cssSelector("#app2"));
	SearchContext second = shadow1.getShadowRoot();
	second.findElement(By.cssSelector("#pizza")).sendKeys("mac");
	
}
}
