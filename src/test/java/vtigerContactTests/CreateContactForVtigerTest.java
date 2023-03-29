package vtigerContactTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtillities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;


@Listeners(vtiger.GenericUtillities.ListenersImplementation.class)
public class CreateContactForVtigerTest extends BaseClass {
	
	
	@Test (groups = "smokeTest")
	public void createContact() throws IOException {
		
		String LastName = eUtil.readDataFromExcel("Contact", -1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
		Reporter.log("click on contact link is succesfull");
		
		ContactsPage cp = new ContactsPage(driver);
		cp.createContact();
		Reporter.log("click on add contact look up img is succesfull");
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(LastName);
		Reporter.log("new contact created is sucessfull");
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String CONTACTHEADER = cip.getOrgHeader();
				
		Assert.assertTrue(CONTACTHEADER.contains(LastName));
		System.out.println(LastName+"----Contact Created--");
		
		
		
	}
}
