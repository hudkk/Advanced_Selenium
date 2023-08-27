package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		 try {
		Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
	DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
    	Statement state = con.createStatement();
                                                        
    	String query="insert into candidateinfo values('Vijuu',20,'Banglore');";
    	int result=state.executeUpdate(query);
    	
    	if(result>=1)//verfication only one value is inserted
  
    	{
    		System.out.println("data added");
    	}
    	
    	//call execute query to get whole data
    	ResultSet resul= state.executeQuery("select*from candidateinfo;");
    	
		while(resul.next()) 
    	{
    		System.out.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));
    	}
		 }
		 catch(Exception e) {
		 
		 //handle exception
		 }
	finally
	//close the database
	{
		con.close();
    	System.out.print("db closed");
	}
}
}
