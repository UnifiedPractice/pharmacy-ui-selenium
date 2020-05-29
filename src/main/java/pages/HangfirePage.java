package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HangfirePage extends BasePage {

	public HangfirePage(WebDriver driver) {
		super(driver);
	}

	// Page locators
	private By lateOrder = By.cssSelector("tbody tr:nth-of-type(3) [name]");
	private By importPractitioners = By.cssSelector("tbody tr:nth-of-type(2) [name]");
	private By importInventory = By.cssSelector("tbody tr:nth-of-type(1) [name]");
	private By triggerNow = By.cssSelector(".btn.btn-primary.btn-sm.js-jobs-list-command");

	// Get Functions
	public WebElement getLateOrder() {
		return getElement(lateOrder);
	}

	public WebElement getImportPractitioners() {
		return getElement(importPractitioners);
	}

	public WebElement getImportInventory() {
		return getElement(importInventory);
	}

	public WebElement getTriggerNow() {
		return getElement(triggerNow);
	}

	// Methods
	public void trigger_LateOrder() {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://jobs.stage.helioscript.com/hangfire/recurring");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getLateOrder().click();
		getTriggerNow().click();
		driver.switchTo().window(tabs.get(0));
	}

	public void trigger_importPractitioners() {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://jobs.stage.helioscript.com/hangfire/recurring");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getImportPractitioners().click();
		getTriggerNow().click();
		driver.switchTo().window(tabs.get(0));
	}

	public void trigger_importInventory() {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://jobs.stage.helioscript.com/hangfire/recurring");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getImportInventory().click();
		getTriggerNow().click();
		driver.switchTo().window(tabs.get(0));
	}

}
