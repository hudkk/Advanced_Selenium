package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Vijayalakshmi S
 */

public class javaUtility {
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}
	public String getSystemDateInFormat()
	{
		Date d=new Date();                        
		String date[]=d.toString().split("");//    
		                                      //Sun Aug 13 14:33:04 IST 2023
	   String month=date[1];                    // 0  1    2     3     4   5
		String date1=date[2];
		String time=date[3].replace(":", "-");
		String year=date[5];
		
		String finalDate=date1+" "+month+" "+year+" "+time;
		return finalDate;
	}
	/**
	 * will return a random number for every run
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		return r.nextInt(1000);
	}

}
