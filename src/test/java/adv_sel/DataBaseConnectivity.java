  package adv_sel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectivity {

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
		String query = "select * from sdet;";
		
		//execute statement
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
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
