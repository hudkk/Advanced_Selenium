package practise;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecutequery {

	public static void main(String[] args) throws SQLException {
		
		//driver for mysql database
		Driver driverRef=new Driver();
		
		//Step 1:Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2:get the connection from database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//Step 3:issue the create statement
		Statement state = con.createStatement();
		
		
		//Step 4:execute a query
		ResultSet result= state.executeQuery("select * from candidateinfo;");
		
		//dont know how many termination point go for while loop
		while(result.next()) 
		{
			System.out.println(result.getString(1)+""+result.getInt(2)+""+result.getString(3));
		}
	//step 5:close the database
		con.close();
		System.out.println("db closed");

	}

}


