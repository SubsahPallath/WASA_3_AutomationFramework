package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 {
	
	@Test
	public void dataProviderPractice()	{
		
		System.out.println(getData());
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2]; //3sets of data contains of 2 info
		
		data[0][0] = "Samsung";
		data[0][1] = 1200;
		
		data[1][0] = "Iphone";
		data[1][1] = 50000;
		
		data[2][0] = "Nokia";
		data[2][1] = 10000;
		return data;
		
	}

}
