package practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	public void readData() {
		// TODO Auto-generated method stub
		
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = System.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = System.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
		

	}

}