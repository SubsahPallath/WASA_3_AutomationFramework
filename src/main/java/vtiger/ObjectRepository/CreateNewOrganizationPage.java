package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtillities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(name = "assigntype")
	private WebElement assignedToCil;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;
	
	
	public CreateNewOrganizationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizatioName() {
		return orgNameEdt;
	}

	public WebElement getAssignedToCil() {
		return assignedToCil;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}
	
	// Business Logic
	
	/**
	 *This method will create organization with OrgName 
	 * @param OrgName
	 */
	
	public void createOrganization(String OrgName) {
		orgNameEdt.sendKeys(OrgName);
		assignedToCil.click();
		SaveBtn.click();
	}
	
	/**
	 * This method will create organization with Industry type
	 * @param OrgName
	 * @param Industry
	 */
	public void createOrganization(String OrgName, String Industry) {
		orgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryDropDwn, Industry);
		SaveBtn.click();
		
	}
	
	
}
