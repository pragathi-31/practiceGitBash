package adv_sel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties p=new Properties();
		
		  p.setProperty("browser", "chrome"); 
		  p.setProperty("url","http://rmgtestingserver/domain/Online_Banking_System/");
		  p.setProperty("username", "210001"); 
		  p.setProperty("Password", "password");
		  
		  FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		  p.store(fos, "write data");
		 
		 
		
		p.load(fis);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
		
		
		
		
		
	}
}
