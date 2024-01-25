package adv_sel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataIntoDB {

	public static void main(String[] args) throws SQLException {
		//register driver
				Connection conn=null;
				try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//get Connection for database
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");
				
				//create statement
				
				Statement state = conn.createStatement();
				String query = "insert into sdet values('Deepa','MT',2);";
				
				//execute statement
				int result = state.executeUpdate(query);
				if(result>=1) {
					System.out.println("Data entered succesfully");
				}else {
					System.err.println("--data not entered--");
				}
				
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					//close the connection
					conn.close();
				}
	}

}
