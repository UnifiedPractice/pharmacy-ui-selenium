// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public ShippingPage startOrder() {
        waitElement(startOrder);
        click(startOrder);
        return new ShippingPage(driver);
    }
}
