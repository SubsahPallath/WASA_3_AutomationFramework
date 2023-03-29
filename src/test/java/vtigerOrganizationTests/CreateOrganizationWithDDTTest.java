package vtigerOrganizationTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v102.network.model.ReportStatus;
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
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithDDTTest extends BaseClass {

	@Test (groups = "regessionTest") 
	private void createOrganization() throws IOException {
		
		/* Read data from excel sheet - Test data */
		
		String ORGNAME = eUtil.readDataFromExcel("Organisation", 1, 2)+jUtil.getRandomNumber();
		System.out.println(ORGNAME);
		
		// Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgnizationsLnk();
		Reporter.log("Click on Organizations link is successfull");
		
		// Click on Create Organization look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log(" Click on Create Organization look up image is successfull");
		
		//create new organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		Reporter.log(" create new organization is successfull");
		
		//validation of organization 
		OrganizationInfoPage oip = new OrganizationInfoPage(null);
		String ORGHEADER = oip.getOrgHeader();
		
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		
		
	
	
		
		
	}
}
