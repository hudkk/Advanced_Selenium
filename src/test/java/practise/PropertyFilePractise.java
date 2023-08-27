package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractise {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//step 1:open the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2:create object of properties from java.util package
		Properties pobj=new Properties();
		
		//step 3:load the file input stream into properties
		pobj.load(fis);
		
		//step 4:access the values with keys
		String url=pobj.getProperty("url");
		String username = pobj.getProperty("username");
		
		System.out.print(url);
		System.out.print(username);
	}	

}
