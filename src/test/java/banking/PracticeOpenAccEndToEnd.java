package banking;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.libraries.ExcelUtils;
import com.generic.libraries.Fileutils;
import com.generic.libraries.WebDriverUtils;
import com.repo.ApplyDebitCardPage;
import com.repo.ConfirmRegistrationPage;
import com.repo.CustomerProfilePage;
import com.repo.DashBoardPage;
import com.repo.HomePage;
import com.repo.InternetBankingLoginPage;
import com.repo.InternetBankingRegisterPage;
import com.repo.PendingCustomerPage;
import com.repo.RegistrationPage;
import com.repo.StaffLoginPage;

public class PracticeOpenAccEndToEnd {
	@Test
	public void endToEnd() throws Throwable {
		Fileutils fLib=new Fileutils();
		WebDriverUtils wLib=new WebDriverUtils();
		ExcelUtils eLib=new ExcelUtils();
				
			
				
				//open browser maximize and implicit wait
				WebDriver driver=new ChromeDriver();
				
				//maximize the browser
				wLib.windowMaximize(driver);
			
				
				//page load timeout
				wLib.waitForPageLoadTimeOut(driver, 20);
				
				
				//entering the url
				String URL=fLib.readDataFromProperty("url");
				driver.get(URL);
				
				//click on open account
				HomePage hp=new HomePage(driver);
				hp.clickOnOpenAcc();
				
				//to send multiple data to multiple text fields
				
				HashMap<String, String> map = eLib.hashMapData("OpenAccount", 1);
				
				//enter the required data and click on submit button and return the data required for applying debit card
				RegistrationPage page=new RegistrationPage(driver);
				String[] registrationDate = page.enterDataIntoForm(map, driver, "Female", "Texas", "San Diego", "Saving");
				
				//verify the details and click on confirm button it will generate a customer application number
				ConfirmRegistrationPage confirm=new ConfirmRegistrationPage(driver);
				String applicationNumber = confirm.clickOnConfirmButton(driver);	
		
				//click on staff login and enter valid username and password and login
				DashBoardPage db=new DashBoardPage(driver);
				db.clickOnStaffLoginButton();
				String sID = fLib.readDataFromProperty("staffid");
				String pwd = fLib.readDataFromProperty("password");
				StaffLoginPage login=new StaffLoginPage(driver);
				login.staffLogin(sID, pwd);
				
				//approve account
				PendingCustomerPage pcPage=new PendingCustomerPage(driver);
				String accountNumber = pcPage.approveCustomer(driver, applicationNumber);
		
		
		
		//write data into excel to use while applying for debitcard
		eLib.setExcelData("DebitCardApply", registrationDate[0],0);
		eLib.setExcelData("DebitCardApply", registrationDate[1],1);
		eLib.setExcelData("DebitCardApply", registrationDate[2],2);
		eLib.setExcelData("DebitCardApply", accountNumber,3);
		
		
		
	
		//click on home major tab
		db.clickOnHomeButton();
		//apply debit card
		ApplyDebitCardPage apply=new ApplyDebitCardPage(driver);
		String[] debitCardDetails = apply.applyDebitCard(driver);
	
		
		//writing data into excel to send the data into Internet banking page
		eLib.setExcelData("DebitCardDetails", registrationDate[0],0);
		eLib.setExcelData("DebitCardDetails", accountNumber,1);
		eLib.setExcelData("DebitCardDetails",debitCardDetails[0],2);
		eLib.setExcelData("DebitCardDetails",debitCardDetails[1],3);
		eLib.setExcelData("DebitCardDetails", registrationDate[2],4);
		eLib.setExcelData("DebitCardDetails", registrationDate[1],5);
		eLib.setExcelData("DebitCardDetails", "0", 6);
		eLib.setExcelData("DebitCardDetails", "password", 7);
		eLib.setExcelData("DebitCardDetails", "password", 8);
		
		//click on home button and then click on internet banking register
		db.clickOnHomeButton();
		hp.clickOnInternetBankingRegister(driver);
		
		
		//enter Internet banking details
		InternetBankingRegisterPage register=new InternetBankingRegisterPage(driver);
		String customerID=register.registerForInternetBanking(driver);
		
		//get the customer id 
		eLib.setExcelData("customerDetails", customerID,0);
		eLib.setExcelData("customerDetails", "password", 1);
		
		
		//login to internet banking
		
		int lastCell = eLib.getLastCellNum("customerDetails", 0);
		String custID = eLib.getExcelData("customerDetails", 0,lastCell-1 );
		String customerPassword = eLib.getExcelData("customerDetails", 1, lastCell-1);
		db.clickOnHomeButton();
		hp.clickOnInternetBankingLogin(driver);
		InternetBankingLoginPage IBlogin=new InternetBankingLoginPage(driver);
		IBlogin.customerLogin(custID, customerPassword);
		
		//change the password
		//password changed successfully message should be displayed
		CustomerProfilePage profile=new CustomerProfilePage(driver);
		String changePasswordText = profile.changePassword(driver, "password1234");
		System.out.println(changePasswordText);
		driver.quit();
		
		
	
	}
}
