package vtiger.GenericUtillities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class contains implementations for ITestListener interface of TestNG 
 * @author palla
 *
 */

public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
			System.out.println(methodName+"--Excecution Started--");
			
			test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--PASS--");
		
		test.log(Status.PASS, methodName+" --- PASS");
		
	}

	public void onTestFailure(ITestResult result) {

		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--Fail--");
		
		test.log(Status.FAIL, methodName+"--Fail--");
		test.log(Status.INFO, result.getThrowable());
		
		String ScreenshotName = methodName+"-"+jUtil.getSystemDateInFormat();
		
		try {
			String path = wUtil.takeScreenShot(BaseClass.sdriver, ScreenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--Skipped--");
		test.log(Status.SKIP, methodName+" --- SKIP" );
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
			
		System.out.println(" suite Excecution Started--");
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiget Extent Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORTS");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base BROWSER", "chrome");
		report.setSystemInfo("Reporter Name", "Subash Pallath");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("suite Excecution Ended--");
		
		report.flush();
		
		
		
	}
	
	
	
	

}
