package vtiger.ObjectRepository;

import org.openqa.selenium.By;
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

public class CreateNewContactPage extends WebDriverUtility {//rule 1: create a generic POM class 
	
	//rule 2: identify the web element
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrgLookUpImg;
	
	@FindBy(xpath = "//input[@class=\"crmButton small save\"]")
	private WebElement SaveBtn;
	
	@FindBy(name = "search_text")
	private	 WebElement SearchEdt;
	
	@FindBy(name = "search")
	private	 WebElement SearchBtn;
	
	
		
	//rule 3: Create constructor
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	//rule 4: create getter
	
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}
		
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	

	
	//business logic


	/**
	 * This method will create contact
	 * @param lastname
	 */
	
	public void createContact(String lastname) {
		getLastNameEdt().sendKeys(lastname);
		SaveBtn.click();	
	}
	
	/**
	 * This method will create contact with organization
	 * @param driver
	 * @param lastname
	 * @param OrgName
	 */
	public void createContact(WebDriver driver, String lastname, String OrgName) {
		getLastNameEdt().sendKeys(lastname);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
}
