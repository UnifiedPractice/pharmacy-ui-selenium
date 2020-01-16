// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import uitest.BasePage;
import uitest.pageobjects.InventoryPages.ProductCatalog;
import uitest.pageobjects.AdminReports.AdminOrderReportPage;
import uitest.pageobjects.AdminSettings.PractitionerApplications;

// Admin HomePage

public class AdminHomePage extends BasePage {
    public AdminHomePage(WebDriver driver) {
        super(driver);
    }

    // Side Menu
    @FindBy(css = ".site-menu .site-menu-item.ng-star-inserted:nth-of-type(1) .site-menu-title")
    WebElement dispensary;

    @FindBy(css = ".site-menu li:nth-of-type(2) .material-icons.ng-star-inserted")
    WebElement inventoryDropdown;
    @FindBy(css = "li:nth-of-type(2) > .ng-star-inserted.site-menu-sub > li:nth-of-type(2) > .ng-star-inserted  .site-menu-title")
    WebElement productCatalog;

    @FindBy(css = ".site-menu .has-sub:nth-of-type(3) .material-icons.ng-star-inserted")
    WebElement settingsDropdown;
    @FindBy(css = "li:nth-of-type(3) > .ng-star-inserted.site-menu-sub > li:nth-of-type(4) > .ng-star-inserted  .site-menu-title")
    WebElement practitionerApplications;

    @FindBy(css = ".site-menu > .ng-star-inserted:nth-of-type(4) .site-menu-title")
    WebElement couponCodes;
    // Reports
    @FindBy(css = ".site-menu .ng-star-inserted:nth-of-type(5) .material-icons.ng-star-inserted")
    WebElement reports;
    @FindBy(xpath = "/html/body/up-root/up-container/up-sidebar/div/div[1]/div/div/ul/li[5]/ul/li[2]/up-sidebar-item/a/span")
    WebElement orderReport;

    // Notifications
    @FindBy(css = "[class='nav-item ng-tns-c3-0 ng-star-inserted'] .nav-link")
    WebElement notifications;
    // findELementss
    @FindBy(xpath = "")
    String notificationList;
    @FindBy(css = "li:nth-of-type(2) > .ng-star-inserted.site-menu-sub")
    WebElement list;

    public PractitionerApplications enter_PractitionerApplications() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (practitionerApplications.isDisplayed()) {
            click(practitionerApplications);
        } else {
            click(settingsDropdown);
            click(practitionerApplications);
        }
        return new PractitionerApplications(driver);
    }

    public DispensaryPage enter_Dispensary() {
        waitElement(dispensary);
        click(dispensary);
        return new DispensaryPage(driver);
    }

    public CouponCodesPage enter_CouponCodes() {
        waitElement(couponCodes);
        click(couponCodes);
        return new CouponCodesPage(driver);
    }

    public AdminOrderReportPage enter_ReportPage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        click(reports);
        click(orderReport);
        return new AdminOrderReportPage(driver);
    }

    public void access_NotificationsBar() {
        waitElement(notifications);
        click(notifications);
    }

    public void assert_lateOrder() throws InterruptedException {
        Thread.sleep(2500);
        List<WebElement> notifications = driver.findElements(By.xpath(notificationList));
        for (int i = 1; i <= notifications.size(); i++) {
            notifications = driver.findElements(By.xpath(notificationList));
            // Waiting for the element to be visible
            // (i-1) because the list's item start with 0th index
            wait.until(ExpectedConditions.visibilityOf(notifications.get(i - 1)));
            // Clicking on the first element
            notifications.get(i - 1).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.print(i + " element clicked\t--");
            System.out.println("pass");
        }
    }

}
