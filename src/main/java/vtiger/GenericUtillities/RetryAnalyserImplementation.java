package vtiger.GenericUtillities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 *This class provides implementation for iretryAnalyser interface of TestNG 
 * @author palla
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count = 0;
	int retryCount = 3;
	
	public boolean retry(ITestResult result) {
		
		while (count<retryCount) {
			count++;
			return true;
		}
		
		return false;
	}
	
	
}
