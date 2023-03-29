package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement OrgInfoTxt;

	public OrganizationInfoPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgInfoTxt() {
		return OrgInfoTxt;
	}

	// business lib

	/**
	 * Capture Text and return
	 * 
	 * @return
	 */

	public String getOrgHeader() {
		return OrgInfoTxt.getText();
	}

}
