/*Scenario 5:
Launch Browser
Login to application with valid credentials
Navigate to Contacts link
Click on Create contact look up image
Create contact with manadatory fields
Select the Organization from organization look up image
Save and verify
logout of app*/

package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganisation {

	public static void main(String[] args) throws SessionNotCreatedException{

		// step1: Launch Browser
				
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("http://localhost:8888/");

				// step2: Login
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();

				// step3: Navigate to Contacts link
				driver.findElement(By.linkText("Contacts")).click();

				// step4: Click on Create contact look Up Image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

				// step5: Create Contact with Mandatory fields
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ambani");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				//Step6: Select the Organization from organization look up image
				driver.findElement(By.xpath("(//img[@align=\"absmiddle\"])[3]")).click();
				driver.findElement(By.linkText("QSPIDER")).click();
				
				// step4: Save and Verify
				String contact = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				if (contact.contains("Ambani"))
					System.out.println(contact + "--Pass--");
				else
					System.err.println("--Fail--");

				// step5: logout of Application
				WebElement over = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				Actions act = new Actions(driver);
				act.moveToElement(over).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				System.err.println("Created contact and logged out");

				driver.close();

	}

}
