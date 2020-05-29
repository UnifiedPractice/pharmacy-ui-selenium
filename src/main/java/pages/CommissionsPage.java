package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommissionsPage extends BasePage {

	public CommissionsPage(WebDriver driver) {
		super(driver);
	}

	// Page Locators - main page
	private By searchBar = By.cssSelector("dx-text-box [type]");
	private By setBulk = By.cssSelector(".dx-button-text");

	// Page Locators - Modal page
	private By allItems = By.cssSelector(".dx-numberbox [type='text']");
	private By applyBulk = By.cssSelector(".modal-footer .dx-button-text");
	private By byCategories = By
			.cssSelector(".dx-accordion-wrapper [role='tab']:nth-of-type(2) .dx-accordion-item-title");
	private By byMediums = By.cssSelector(".modal-footer .dx-button-text");
	private By confirmationPop = By
			.cssSelector("div#toast-container > .ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-success");

	// Page Locators - Modal page
	private By lastElement = By.cssSelector("tr:nth-of-type(11) > td:nth-of-type(9)");

	// Get Methods
	public WebElement getSearchBar() {
		return getElement(searchBar);
	}

	public WebElement getSetBulk() {
		return getElement(setBulk);
	}

	public WebElement getAllItems() {
		return getElement(allItems);
	}

	public WebElement getApplyBulk() {
		return getElement(applyBulk);
	}

	public WebElement getByCategories() {
		return getElement(byCategories);
	}

	public WebElement getByMediums() {
		return getElement(byMediums);
	}

	public WebElement getConfirmationPop() {
		return getElement(confirmationPop);
	}

	public WebElement getLastElement() {
		return getElement(lastElement);
	}

	// Methods
	public void set_Commission(String commissionValue) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getSetBulk().click();
		getAllItems().sendKeys(commissionValue); // commission value to be added
		getByCategories().click();
		getApplyBulk().click();
	}

	public void assert_Commission(String expected) {
		Assert.assertEquals(getConfirmationPop().getText(), expected);
	}

}
