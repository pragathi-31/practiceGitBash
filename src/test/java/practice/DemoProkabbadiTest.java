package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoProkabbadiTest {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String teamName="U.P. Yoddhas";
		List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='team-name']/p"));
		
		for(WebElement indname:allNames) {
		String name = indname.getText();
		if(name.equals(teamName)) {
		String position = driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/preceding-sibling::div[@class='table-data position']/p[@class='position']")).getText();
		String play = driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']")).getText();
		String won = driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-won']")).getText();
		String lost = driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-lost']")).getText();
		String scoreDiff = driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data score-diff']")).getText();
		System.out.print(position+"-->"+name+"-->"+play+"-->"+won+"-->"+lost+"-->"+scoreDiff+"-->");
		List<WebElement> form = driver.findElements(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data form']//li"));
		for(WebElement f:form) {
			String WorL = f.getText();
			System.out.print(WorL+" ");
		}
		String points = driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data points']")).getText();
			System.out.print("-->"+points);
		
		System.out.println();
		}
		
		}
		driver.quit();
	}

}
