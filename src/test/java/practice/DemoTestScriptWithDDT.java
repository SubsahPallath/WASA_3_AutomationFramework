package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.GenericUtillities.ExcelFileUtility;

public class DemoTestScriptWithDDT {

	public static void main(String[] args) throws IOException, Throwable {
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties po = new Properties();
		po.load(fise);
		String URL = po.getProperty("url");
		String BROWSER=po.getProperty("browser");
		String USERNAME = po.getProperty("username");
		String PASSWORD = po.getProperty("password");
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);
		/*FileInputStream fisx = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisx);
		String LASTNAME = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();*/
		
		WebDriver driver = null;
		
		//Launch browser from property file
		if (BROWSER.equalsIgnoreCase("chrome")) 
			driver = new ChromeDriver();
		 else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			System.out.println("Invalid Browser");
		
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);;
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);;
		driver.findElement(By.id("submitButton")).click();

		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String contact = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (contact.contains(LASTNAME))
			System.out.println(contact + "--Pass--");
		else
			System.err.println("--Fail--");

		// step5: logout of Application
		WebElement over = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(over).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.err.println("Created contact and logged out");
		Thread.sleep(5000);

		driver.close();

		
		
		
	}	

}
