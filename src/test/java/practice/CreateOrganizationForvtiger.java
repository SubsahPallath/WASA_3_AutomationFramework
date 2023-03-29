package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class CreateOrganizationForvtiger {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
			
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		
		String UN = pro.getProperty("username");
		String pwd = pro.getProperty("password");
		
		System.err.println(UN);
		System.err.println(pwd);
		
		// step1: Launch Browser
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		// step2: Login to application with valid credentials
		 WebElement user = driver.findElement(By.name("user_name"));
		user.sendKeys(pro.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys("pwd");
		driver.findElement(By.id("submitButton")).click();

		// step3: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		// step4: Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// step5: Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("JSPIDER");
		driver.findElement(By.xpath("//input[@value='T']")).click();

		WebElement dd = driver.findElement(By.name("assigned_group_id"));
		dd.click();
		Select sel = new Select(dd);
		sel.selectByIndex(2);

		// step6: Save and Verify
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		String org = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (org.contains("JSPIDER"))
			System.out.println(org + "--PASS--");
		else
			System.out.println("--Fail--");

		// step7: logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		System.err.println("Organisation is created");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// step: close the browser
		driver.close();

		
	}

}
