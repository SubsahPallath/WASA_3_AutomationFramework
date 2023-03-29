/*Scenario 4:
Launch Browser
Login to application with valid credentials
Navigate to Organizations link
Click on Create Organization look Up Image
Create Organization with Mandatory fields
Select "Energy" in the industry drop down
Select "Customer" in the Type Drop down 
Save and Verify
logout of Application*/

package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrganisationWith2types {

	public static void main(String[] args) throws Throwable {

		// step1: Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");

		// step2: Login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// step3: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		// step4: Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

		// step5: Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("PySpiders2");
		driver.findElement(By.xpath("//input[@value=\"U\"]")).click();

		// step6: Select "Energy" in the industry drop down
		WebElement dd = driver.findElement(By.name("industry"));
		WebElement type = driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));
		dd.click();
		type.click();
		Select sc = new Select(dd);
		sc.selectByValue("Energy");
		Thread.sleep(2000);
		Select sct = new Select(type);
		sct.selectByValue("Customer");

		// step7: Save and Verify
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		WebElement ele = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]"));
		String str = ele.getText();

		if (str.contains("PySpiders2"))
			System.out.println(str + "--Pass--");
		else
			System.out.println("--Fail--");

		// step8: logout of Application
		WebElement mo = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(mo).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("Organisation created and logged out");
		// step9: close
		driver.close();

	}

}
