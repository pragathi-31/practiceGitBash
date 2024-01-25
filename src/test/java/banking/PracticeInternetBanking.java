package banking;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.libraries.ExcelUtils;
import com.generic.libraries.Fileutils;
import com.generic.libraries.WebDriverUtils;
import com.repo.HomePage;
import com.repo.InternetBankingLoginPage;

public class PracticeInternetBanking {
	@Test
	public void internetBanking() throws IOException, InterruptedException {
		WebDriverUtils wLib=new WebDriverUtils();
		Fileutils fLib=new Fileutils();
		
		//open browser maximize and implicit wait
		WebDriver driver=new ChromeDriver();
		wLib.windowMaximize(driver);
		wLib.waitForPageLoadTimeOut(driver, 20);
		
		
		//entering the url
		String URL =fLib.readDataFromProperty("url");
		driver.get(URL);
		
		//click on Internet Banking login
		HomePage hp=new HomePage(driver);
		hp.clickOnInternetBankingLogin(driver);
		
		//login using customer id and password
		InternetBankingLoginPage login=new InternetBankingLoginPage(driver);
		ExcelUtils eLib=new ExcelUtils();
		int lastCell = eLib.getLastCellNum("customerDetails", 0);
		String customerID = eLib.getExcelData("customerDetails", 0, lastCell-1);
		String customerPassword = eLib.getExcelData("customerDetails", 1, lastCell-1);
		login.customerLogin(customerID, customerPassword);
		driver.quit();
	}
}
