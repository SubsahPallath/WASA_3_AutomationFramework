package vtiger.GenericUtillities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic method related to webdriver action
 * 
 * @author Subash Pallath
 *
 */

public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for page to be loaded.
	 * 
	 * @param driver
	 */
	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	/**
	 * This method will wait until element be visible
	 * 
	 * @param driver
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method will wait until element be clickable.
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will handle the drop down based on index.
	 * 
	 * @param element
	 * @param index
	 */
	public void handelDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle the dropdown based on value.
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	/**
	 * This method will handle the dropdown based on visible text.
	 * 
	 * @param text
	 * @param element
	 */
	public void habdleDropDown(String text, WebElement element) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	/**
	 * This method will help to perform mouse Hover on an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHovwerAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		;

	}

	/**
	 * This method will right click anywhere on the web page
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick();

	}

	/**
	 * This method will right click on the element of web page
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element);

	}

	/**
	 * This method will double click anywhere on the web page
	 * 
	 * @param dirve
	 */
	public void doubleClickAction(WebDriver dirve) {
		Actions act = new Actions(dirve);
		act.doubleClick().perform();

	}

	/**
	 * This method will double click on the element of web page
	 * 
	 * @param dirve
	 * @param element
	 */
	public void doubleClickAction(WebDriver dirve, WebElement element) {
		Actions act = new Actions(dirve);
		act.doubleClick(element).perform();

	}

	/**
	 * This method will perform drag and drop action
	 * 
	 * @param driver
	 * @param srcElement
	 * @param disElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement disElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, disElement).perform();

	}

	/**
	 * This method will dismiss alert.
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {

		driver.switchTo().alert().dismiss();

	}

	/**
	 * This method will fetch alert text
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {

		return driver.switchTo().alert().getText();

	}

	/**
	 * This method will handle frame by index
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * This method will handle frame by name or id
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);

	}

	/**
	 * This method will handle frame by web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}

	/**
	 * This method will switch to immediate parent
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();

	}

	/**
	 * This method will switch to default parent
	 * 
	 * @param driver
	 */

	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	/**
	 * This method will switch the window based on partial title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {

		// step 1: capture all the window IDs
		Set<String> winIDs = driver.getWindowHandles();

		// step 2: navigate to each window
		for (String win : winIDs) {

			// step 3: switch to window and capture the tile
			String winTitle = driver.switchTo().window(win).getTitle();

			// step 4: compare the winTile with partial title.
			if (winTitle.contains(partialWinTitle)) {
				break;
			}

		}

	}

	/**
	 * This methods will take screen shot and save it in the folder.
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\" + screenshotName + "");
		FileUtils.copyFile(src, dst);

		return dst.getAbsolutePath(); // used for extent reports.

	}

	/**
	 * This method will perform random scroll downward vertically
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500)", "");
	}

	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);

	}
}
