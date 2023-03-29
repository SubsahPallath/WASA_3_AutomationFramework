package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author palla
 */
public class LoginPage { // rule 1: create a pom class for every web page
	
	//rule 2: identify the web element with @Findby, @FindAll, @Findbys
	
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	//rule 3: Create a constructor to initialize these web elements
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	// rule 4: provide getter to access to these elements 
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business libraries: generic methods specific to this projects
	
	public void loginPage(String username, String password) {

		UsernameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}
	
	
	

}
