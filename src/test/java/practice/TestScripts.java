	package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScripts {
	
		@Test(retryAnalyzer = vtiger.GenericUtillities.RetryAnalyserImplementation.class)
		public void pub() {
			Assert.fail();
			System.out.println("HI");
		}
	
		
		
		
		
		
		
		

	}

