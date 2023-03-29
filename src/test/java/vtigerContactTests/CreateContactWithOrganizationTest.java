package vtigerContactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtillities.BaseClass;
import vtiger.GenericUtillities.ExcelFileUtility;
import vtiger.GenericUtillities.PropertyFileUtility;
import vtiger.GenericUtillities.WebDriverUtility;
import vtiger.GenericUtillities.JavaUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void createContact() throws IOException, InterruptedException {

		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 2) + jUtil.getRandomNumber();
		String CONTACTNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOnOrgnizationsLnk();
		Reporter.log("Click on Org ");

		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgImg();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrgHeader();

		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		System.out.println(ORGNAME + "--- Organization Create");

		hp.clickOnContactsLnk();

		ContactsPage cp = new ContactsPage(driver);
		cp.createContact();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, CONTACTNAME, ORGNAME);

		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getOrgHeader();

		Assert.assertTrue(ContactHeader.contains(CONTACTNAME));
		System.out.println(ContactHeader + "--- Contact Create");

	}

}
