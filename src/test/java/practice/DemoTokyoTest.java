package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTokyoTest {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		List<WebElement> allTeams = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		String name="Czechia";
		
		
		int count = allTeams.size();
		
		
		for(int i=0;i<count;i++) {
			
			String team = allTeams.get(i).getText();
			if(team.equals(name)) {
			
			int j=i+1;	
			String gold = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::div[@data-row-id='country-medal-row-"+j+"']/following-sibling::div[@data-medal-id='gold-medals-row-"+j+"']")).getText();
			String silver = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::div[@data-row-id='country-medal-row-"+j+"']/following-sibling::div[@data-medal-id='silver-medals-row-"+j+"']")).getText();
			String bronze = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::div[@data-row-id='country-medal-row-"+j+"']/following-sibling::div[@data-medal-id='bronze-medals-row-"+j+"']")).getText();
			
			System.out.println(gold+" "+silver+" "+bronze);
			
			
			}
		
		}
		
		
		driver.quit();
	}

}
