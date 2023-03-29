package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
	//Step1: open the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create object of properties from java.util package
		Properties po = new Properties();
		//Step3: load  the file input stream into properties
		
		po.load(fis);
		//step 4: access the value with keys,
		String url = po.getProperty("url");
		String UN = po.getProperty("username");
	
		System.out.println(url);
		System.err.println(UN);
	}	

}
