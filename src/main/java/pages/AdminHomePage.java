package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.AdminReports.AdminOrderReportPage;
import pages.AdminSettings.PractitionerApplications;

public class AdminHomePage extends BasePage {

	public AdminHomePage(WebDriver driver) {
		super(driver);
	}

	// Side-menu locators
	private By dispensary = By.cssSelector(".site-menu .site-menu-item.ng-star-inserted:nth-of-type(1) .site-menu-title");
	private By inventoryDropdown = By.cssSelector(".site-menu li:nth-of-type(2) .material-icons.ng-star-inserted");
	private By productCatalog = By.cssSelector("li:nth-of-type(2) > .ng-star-inserted.site-menu-sub > li:nth-of-type(2) > .ng-star-inserted  .site-menu-title");
	private By settingsDropdown = By.cssSelector(".site-menu .has-sub:nth-of-type(3) .material-icons.ng-star-inserted");
	private By practitionerApplications = By.cssSelector("li:nth-of-type(3) > .ng-star-inserted.site-menu-sub > li:nth-of-type(4) > .ng-star-inserted  .site-menu-title");
	private By couponCodes = By.cssSelector(".site-menu > .ng-star-inserted:nth-of-type(4) .site-menu-title");
	
	// Report locators
	private By reports = By.cssSelector(".site-menu .ng-star-inserted:nth-of-type(5) .material-icons.ng-star-inserted");
	private By orderReport = By.xpath("/html/body/up-root/up-container/up-sidebar/div/div[1]/div/div/ul/li[5]/ul/li[2]/up-sidebar-item/a/span");
	
	// Notifications locators
	private By notifications = By.cssSelector("[class='nav-item ng-tns-c3-0 ng-star-inserted'] .nav-link");
	private By notificationList = By.cssSelector("");
	private By list = By.cssSelector("li:nth-of-type(2) > .ng-star-inserted.site-menu-sub");

	// Get functions
	public WebElement getDispensary() {
		return getElement(dispensary);
	}

	public WebElement getInventoryDropdown() {
		return getElement(inventoryDropdown);
	}

	public WebElement getProductCatalog() {
		return getElement(productCatalog);
	}

	public WebElement getSettingsDropdown() {
		return getElement(settingsDropdown);
	}

	public WebElement getPractitionerApplications() {
		return getElement(practitionerApplications);
	}

	public WebElement getCouponCodes() {
		return getElement(couponCodes);
	}
	
	public WebElement getReports() {
		return getElement(reports);
	}

	public WebElement getOrderReport() {
		return getElement(orderReport);
	}
	
	public WebElement getNotifications() {
		return getElement(notifications);
	}
	
	public WebElement getNotificationsList() {
		return getElement(notificationList);
	}
	
	public WebElement getList() {
		return getElement(list);
	}

	
	// Methods - left side menu navigation functions
	public PractitionerApplications enter_PractitionerApplications() {
		try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		getSettingsDropdown().click();
		getPractitionerApplications().click();
		return getInstance(PractitionerApplications.class); 
	}
	
	public DispensaryPage enter_DispensaryPage() {
		getDispensary().click();
		return getInstance(DispensaryPage.class);
	}

	public CouponCodesPage enter_CouponCodesPage() {
		getCouponCodes().click();
		return getInstance(CouponCodesPage.class);
	}

	public AdminOrderReportPage enter_ReportPage() {
		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
		getReports().click();
		getOrderReport().click();
		return getInstance(AdminOrderReportPage.class);
	}
	
	public void access_NotificationsBar() {
		getNotifications().click();
	}
	
	

}
