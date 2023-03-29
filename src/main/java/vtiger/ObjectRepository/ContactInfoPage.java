package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {	
	
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement ContactInfoTxt;
	
	public ContactInfoPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactInfoTxt() {
		return ContactInfoTxt;
	}
	
	
	//business lib
	
	/**
	 * Capture Text and return
	 * @return
	 */
	
	public String getOrgHeader() {
		return ContactInfoTxt.getText();
	}
	
	
}
