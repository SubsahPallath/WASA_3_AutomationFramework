package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtillities.WebDriverUtility;

/**
 * 
 * @author palla
 *
 */
public class HomePage extends WebDriverUtility {
	/**
	 * @param contactsCli
	 */

//Rule 1: create a POM class for Home page

	// rule 2: identify the element
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;

	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SingOutLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;

	// rule 3: create a constructor

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// rule 4: create getter to access the private element

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSingOutLnk() {
		return SingOutLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	// Business Libraries

	/**
	 * This Method will click on organization link
	 */

	public void clickOnOrgnizationsLnk() {
		OrganizationLnk.click();
	}

	/**
	 * This Method will click on Contacts link
	 */

	public void clickOnContactsLnk() {
		ContactsLnk.click();

	}

	/**
	 * This Method will helps to Logout from the application.
	 */

	public void LogoutFromApp(WebDriver driver) {
		mouseHovwerAction(driver, AdministratorImg);
		SingOutLnk.click();
		driver.close();

	}
}
