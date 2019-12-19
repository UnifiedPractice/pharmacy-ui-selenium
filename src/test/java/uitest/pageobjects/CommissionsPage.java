// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;
import uitest.Variables;

public class CommissionsPage extends BasePage {
    public CommissionsPage(WebDriver driver) {
        super(driver);
    }

    // Commision Page
    @FindBy(css = "dx-text-box [type]")
    WebElement searchBar;

    @FindBy(css = ".dx-button-text")
    WebElement setBulk;

    // Modal
    @FindBy(css = ".dx-numberbox [type='text']")
    WebElement allItems;
    @FindBy(css = ".modal-footer .dx-button-text")
    WebElement applyBulk;

    @FindBy(css = ".dx-accordion-wrapper [role='tab']:nth-of-type(2) .dx-accordion-item-title")
    WebElement byCategories;
    @FindBy(css = ".modal-footer .dx-button-text")
    WebElement byMediums;

    @FindBy(css = "div#toast-container > .ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-success")
    WebElement confirmationPop;

    // Last loaded page elements
    @FindBy(css = "tr:nth-of-type(11) > td:nth-of-type(9)")
    WebElement lastElement;

    public void set_Commission() {
        waitElement(lastElement);
        click(setBulk);
        waitElement(allItems);
        writeText(allItems, "5");
        click(byCategories);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(applyBulk);
    }

    public void assert_Commission() {
        waitElement(confirmationPop);
        Assert.assertEquals(readText(confirmationPop), Variables.unEscapedHTML);
    }
}
