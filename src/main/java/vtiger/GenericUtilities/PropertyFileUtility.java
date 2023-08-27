package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods to read data from property file
 * @author Vijayalakshmi S
 * 
 */
//single line comment
/*multi line comment*/

public class PropertyFileUtility {
	/**
	 * This method will read from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
 public String readDataFromPropertyFile(String key) throws IOException //caller function
 {
	 FileInputStream fis=new FileInputStream(IConstantsUtility.propertyFilePath);
	 Properties pobj=new Properties();
	 pobj.load(fis);
	 
	 String value = pobj.getProperty(key); // Use the parameter 'key' here instead of "key"
	 return value;
	

	}

}
