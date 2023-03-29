package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.NoSuchElementException;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtillities.ExcelFileUtility;
import vtiger.GenericUtillities.JavaUtility;
import vtiger.GenericUtillities.PropertyFileUtility;
import vtiger.GenericUtillities.WebDriverUtility;
import vtiger.GenericUtillities.JavaUtility;

public class DemoTestScriptWithDDTAndGu {

	public static void main(String[] args) throws IOException {

		// Step1: Create Object for all Utilities
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// Step2: Read all the necessary Data.
		/* Read data from property file-common Data */
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("broser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		/* Read data from excel sheet-Test Data */
		String ORGNAME = eUtil.readDataFromExcel("Organisation", 1, 2)+jUtil.getRandomNumber();
		
		WebDriver driver = null;

		// Step3: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("Invalid browser");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);

		// step4: click on organization
		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Create Organization with mandatory details
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 8: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader + " PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 9: Logout of Application.
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHovwerAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();

	}

}
