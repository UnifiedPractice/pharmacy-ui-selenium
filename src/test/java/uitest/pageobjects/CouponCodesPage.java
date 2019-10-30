// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class CouponCodesPage extends BasePage {
    public CouponCodesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "")
    WebElement t;

}
