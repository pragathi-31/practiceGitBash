package adv_sel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;




public class DBRmgyantra_UnitTesting {

	public static void main(String[] args) throws SQLException {
		
		Random ran=new Random();
		int num = ran.nextInt(100);
		String Proj_name="Bankin_Banko_Oversight"+num;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://rmgtestingserver:8084/");
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		
		driver.findElement(By.name("projectName")).sendKeys(Proj_name);
		
		
		
		driver.findElement(By.name("createdBy")).sendKeys("pragathi");
		
		WebElement status = driver.findElement(By.name("status"));
		
		Select s=new Select(status);
		
		s.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Connection conn =null;
		try {
		Driver DBdriver = new Driver();
		DriverManager.registerDriver(DBdriver);
		
		conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		
		Statement state = conn.createStatement();
		String query="select * from project where project_name='"+Proj_name+"';";
		
		ResultSet res = state.executeQuery(query);
		
//		ResultSetMetaData table = res.getMetaData();
//		int count = table.getColumnCount();
//		
//		System.out.println(count);
		boolean flag=false;
		while(res.next()) {
			String actual = res.getString(4);
			
			if(actual.equals(Proj_name)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(Proj_name+" added succesfully");
		}else {
			System.out.println(Proj_name+" not added");
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
			System.out.println("DataBase_closed");
		}
	}

}
