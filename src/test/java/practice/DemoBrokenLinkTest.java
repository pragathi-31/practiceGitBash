package practice;



import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBrokenLinkTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		List<WebElement> allLinks = driver.findElements(By.xpath("//a|//link"));
		
		System.out.println(allLinks.size());
		
		for(WebElement link:allLinks) {
			String eachLink = link.getAttribute("href");
			
			int statuscode=0;
			try {
			URL url = new URL(eachLink);
			HttpsURLConnection httpconn= (HttpsURLConnection) url.openConnection();
			statuscode=httpconn.getResponseCode();
			if(statuscode>=400 && eachLink!=null) {
				System.out.println(eachLink+"--->"+statuscode);
			}
		}catch(Exception e) {
			
		}
	}

}
}
