// Ranorex Webtestit Page Object File

package uitest.pageobjects;

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

    @FindBy(css = ".orders-page__title")
    WebElement title;

    public ShippingPage startOrder() throws InterruptedException {
        Thread.sleep(3000);
        click(today);
        Thread.sleep(1000);
        click(startOrder);
        return new ShippingPage(driver);
    }

    public void assertTitle() {
        waitElement(title);
        Assert.assertEquals(readText(title), "Orders list");
    }
}
