package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 */

public class ContactsPage {//rule1: create a POM class
	
	//rule 2: find all the elements
	@FindAll({@FindBy(xpath = "//img[@alt=\"Create Contact...\"]"),@FindBy(xpath = "src=\"themes/softed/images/btnL3Add.gif\"")})
	private WebElement CreateContactLookUpImg;
	
	//rule 3: Create a constructor
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 4: create a getter to access the element 
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	
	//Business libraries: Particular to the project
	
	/**
	 *This method will click operation on the create contact look up img 
	 */
	
	public void createContact() {
		CreateContactLookUpImg.click();
		
	}
	
	
	
	
	
	
	

}
