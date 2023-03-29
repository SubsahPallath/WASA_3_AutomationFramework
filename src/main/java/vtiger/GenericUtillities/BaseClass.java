package vtiger.GenericUtillities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotation of TestNG
 * 
 * @author palla
 *
 */
public class BaseClass {

	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public static WebDriver sdriver;
	
	public WebDriver driver = null;

	@BeforeSuite (groups = {"smokeTest","regessionTest"})
	public void bsConfig() {

		System.out.println("----- Database Connection successfull -----");

	}
	
	//@Parameters("browser")
	//@BeforeTest
	
	@BeforeClass (groups = {"smokeTest","regessionTest"})
	public void bcConfig(/*String BROWSER*/) throws IOException {

		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----- " + BROWSER + " Launched succesfully-----");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("----- " + BROWSER + " Launched succesfully-----");

		} else {
			System.out.println("Invalid Browser");
		}
		
		sdriver=driver; //Listeners 
		wUtil.maximizeWindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);

	}

	@BeforeMethod (groups = {"smokeTest","regessionTest"})
	public void bmConfig() throws IOException {

		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);

		System.out.println("----- Login successful -----");

	}

	@AfterMethod (groups = {"smokeTest","regessionTest"})
	public void amConfig() {

		HomePage hp = new HomePage(driver);
		hp.LogoutFromApp(driver);

		System.out.println("----- Logout successful -----");
	}

	@AfterClass (groups = {"smokeTest","regessionTest"})
	public void aconfig() {

		driver.quit();
		System.out.println("----- Browser Closed successfully -----");

	}

	@AfterSuite (groups = {"smokeTest","regessionTest"})
	public void asConfig() {

		System.out.println("----- Database Connection successfull -----");

	}
	
	
}
