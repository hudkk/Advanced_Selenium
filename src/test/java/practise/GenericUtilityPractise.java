package practise;

import java.io.IOException;
import java.util.Properties;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.javaUtility;

public class GenericUtilityPractise {

	public static void main(String[] args) throws IOException {


		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
	   String value = eUtil.readDataFromExcel("Contacts", 1, 2);
	   System.out.println(value);

	   System.out.println(eUtil.getRowCount("Contacts"));
	   eUtil.writeDataIntoExcel1("Contacts", 4, 6, "Batsman");
	   
	   javaUtility jUtil=new javaUtility();
	   System.out.println(jUtil.getSystemDate());
	   System.out.println(jUtil.getSystemDateInFormat());
	   System.out.println(jUtil.getRandomNumber());
	   
}
}
