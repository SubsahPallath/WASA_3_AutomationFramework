package vtiger.GenericUtillities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic methods to read data form property file.
 * 
 * @author Subash Pallath
 *
 */

public class PropertyFileUtility {

	/**
	 * This method will read data form property file.
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}
