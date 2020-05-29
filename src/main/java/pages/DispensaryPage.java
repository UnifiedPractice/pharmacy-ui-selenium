package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DispensaryPage extends BasePage {

	public DispensaryPage(WebDriver driver) {
		super(driver);
	}

	// Page Locators
	private By startOrder = By.xpath(
			"//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-orders-page[@class='ng-star-inserted']/div[@class='m-orders-page']/div[@class='row']//ufc-orders-list//ul[@class='order-list__list']//ufc-order-view-item//button[.=' Start order ']");
	private By rxDetails = By.cssSelector(".dx-switch-handle");
	private By searchBar = By.cssSelector(".search-container span");
	private By today = By.cssSelector("button:nth-of-type(2) > span");
	private By orderName = By.cssSelector(
			"body > up-root > up-container > div > ufc-orders-page > div > div:nth-child(2) > div > ufc-orders-list > div.m-order-list > div > div > ul > li:nth-child(1) > ufc-order-view-item > div > div:nth-child(1) > div > a");
	private By title = By.cssSelector(".orders-page__title");
	private By notificationsBar = By.xpath("//div[@id='site-navbar-collapse']/ul[2]//i[@class='material-icons']");
	private By notification1 = By.cssSelector(".dx-scrollview-content [role='option']:nth-of-type(1) .badge");

	// Get functions
	public WebElement getStartOrder() {
		return getElement(startOrder);
	}

	public WebElement getRxDetails() {
		return getElement(rxDetails);
	}

	public WebElement getSearchBar() {
		return getElement(searchBar);
	}

	public WebElement getToday() {
		return getElement(today);
	}

	public WebElement getOrderName() {
		return getElement(orderName);
	}

	public WebElement getTitle() {
		return getElement(title);
	}

	public WebElement getNotificationsBar() {
		return getElement(notificationsBar);
	}

	public WebElement getFirstNotification() {
		return getElement(notification1);
	}

	
	// Page Navigation Methods
	public ShippingPage startOrder() {
		getToday().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getStartOrder().click();
		return getInstance(ShippingPage.class);
	}

	public void enter_NotificationsBar() {
		getNotificationsBar().click();
	}
	
	
	//Assertions
	public void assertLateOrder(String expected) {
		Assert.assertEquals(getFirstNotification().getText(), expected);
	}
	
	public void assertOrder(String expected) {
		Assert.assertEquals(getTitle().getText(), expected);
	}
	

	
	public static class ShippingPage extends DispensaryPage {

		public ShippingPage(WebDriver driver) {
			super(driver);
		}

		// Shipping Page button locators
		private By itemSelect = By.cssSelector(".rx-view__action .ng-star-inserted");
		private By lotNumber = By.cssSelector(".dx-selectbox-container .dx-dropdowneditor-icon");
		private By lotNumberSelect = By.cssSelector(".dx-scrollview-content [role='option']:nth-of-type(1) .row");
		private By minQuantity = By.cssSelector(".rx-item-number-min [type='text']");
		private By measuredQuantity = By.cssSelector(".rx-item-lot__numbermeasure [type='text']");
		private By sendQuantity = By.cssSelector("[type='success'] .dx-button-text");
		private By done = By.cssSelector("dx-button:nth-of-type(2)  .dx-button-text");
		private By done_ship = By.cssSelector("dx-button:nth-of-type(1)  .dx-button-text");

		// Get locator functions
		public WebElement getItemSelect() {
			return getElement(itemSelect);
		}

		public WebElement getLotNumber() {
			return getElement(lotNumber);
		}

		public WebElement getLotNumberSelect() {
			return getElement(lotNumberSelect);
		}

		public WebElement getMinQuantity() {
			return getElement(minQuantity);
		}

		public WebElement getMeasuredQuantity() {
			return getElement(measuredQuantity);
		}

		public WebElement getSendQuantity() {
			return getElement(sendQuantity);
		}

		public WebElement getDone() {
			return getElement(done);
		}

		public WebElement getDone_Ship() {
			return getElement(done_ship);
		}

		// Methods
		public void selectItem() {
			getItemSelect().click();
		}

		public void completeQuantities() {
			getLotNumber().click();
			getLotNumberSelect().click();
			String minQ = driver.findElement(By.cssSelector(".rx-item-number-min [type='text']"))
					.getAttribute("aria-valuenow");
			getMeasuredQuantity().sendKeys(minQ);
			getLotNumber().click();
			getSendQuantity().click();
		}

		public DispensaryPage shipOrder() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getDone().click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getDone_Ship().click();
			return getInstance(DispensaryPage.class);
		}

	}

}
