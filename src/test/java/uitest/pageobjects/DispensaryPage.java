// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;

public class DispensaryPage extends BasePage {
    public DispensaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".order-list__list .order-list__item.ng-star-inserted:nth-of-type(1) .order-view__action")
    WebElement startOrder;

    @FindBy(css = ".dx-switch-handle")
    WebElement rxDetails;

    @FindBy(css = ".search-container span")
    WebElement searchBar;

    @FindBy(css = "button:nth-of-type(2) > span")
    WebElement today;

    @FindBy(css = "body > up-root > up-container > div > ufc-orders-page > div > div:nth-child(2) > div > ufc-orders-list > div.m-order-list > div > div > ul > li:nth-child(1) > ufc-order-view-item > div > div:nth-child(1) > div > a")
    WebElement orderName;

    @FindBy(css = ".orders-page__title")
    WebElement title;

    @FindBy(xpath = "//div[@id='site-navbar-collapse']/ul[2]//i[@class='material-icons']")
    WebElement notificationsBar;

    @FindBy(css = ".dx-scrollview-content [role='option']:nth-of-type(1) .badge")
    WebElement notification1;

    public ShippingPage startOrder() {
        waitElement(orderName);
        click(today);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        click(startOrder);
        return new ShippingPage(driver);
    }

    public void seeNotifications() {
        waitElement(notificationsBar);
        click(notificationsBar);
    }

    public void assertLateOrder() {
        waitElement(notification1);
        Assert.assertEquals(readText(notification1), "Late Order");
    }

    public void assertTitle() {
        waitElement(title);
        Assert.assertEquals(readText(title), "Orders list");
    }

    public static class ShippingPage extends DispensaryPage {
        public ShippingPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = ".rx-view__action .ng-star-inserted")
        WebElement itemSelect;

        // Lot Number
        @FindBy(css = ".dx-selectbox-container .dx-dropdowneditor-icon")
        WebElement lotNumber;
        @FindBy(css = ".dx-scrollview-content [role='option']:nth-of-type(1) .row")
        WebElement lotNumberSelect;

        // Quantities
        @FindBy(css = ".rx-item-number-min [type='text']")
        WebElement minQuantity;

        @FindBy(css = ".rx-item-lot__numbermeasure [type='text']")
        WebElement measuredQuantity;
        @FindBy(css = "[type='success'] .dx-button-text")
        WebElement sendQuantity;

        // Ship Buttons
        @FindBy(css = "dx-button:nth-of-type(2)  .dx-button-text")
        WebElement done;
        @FindBy(css = "dx-button:nth-of-type(1)  .dx-button-text")
        WebElement done_ship;

        public void select_item() {
            waitElement(itemSelect);
            click(itemSelect);
        }

        public void completeQuantities() {
            waitElement(lotNumber);
            click(lotNumber);
            waitElement(lotNumberSelect);
            click(lotNumberSelect);
            waitElement(sendQuantity);
            String minQ = driver.findElement(By.cssSelector(".rx-item-number-min [type='text']"))
                    .getAttribute("aria-valuenow");
            writeText(measuredQuantity, minQ);
            click(lotNumber);
            click(sendQuantity);
        }

        public DispensaryPage shipOrder() throws InterruptedException {
            Thread.sleep(2000);
            click(done);
            Thread.sleep(8000);
            click(done_ship);
            return new DispensaryPage(driver);
        }

    }
}
