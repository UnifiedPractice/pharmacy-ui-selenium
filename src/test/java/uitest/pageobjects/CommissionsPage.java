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
    @FindBy(css = "dx-data-grid#byMediums > div[role='grid']  .dx-datagrid-content > table[role='presentation'] > tbody > tr:nth-of-type(3) > td:nth-of-type(2)")
    WebElement powder;
    @FindBy(css = "td:nth-of-type(2) input[role='spinbutton']")
    WebElement powderInput;
    @FindBy(css = ".modal-footer .dx-button-text")
    WebElement applyBulk;

    @FindBy(css = ".dx-accordion-wrapper [role='tab']:nth-of-type(2) .dx-accordion-item-title")
    WebElement byCategories;
    @FindBy(css = ".modal-footer .dx-button-text")
    WebElement byMediums;

    @FindBy(css = "div#toast-container > .ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-success")
    WebElement popUp;

    public void set_Commission() throws InterruptedException {
        waitElement(setBulk);
        click(setBulk);
        Thread.sleep(2000);
        click(powder);
        Thread.sleep(2000);
        writeText(powderInput, "5");
        Thread.sleep(2000);
        click(byCategories);
        click(applyBulk);
    }

    public void assert_Commission() {
        waitElement(popUp);
        Assert.assertEquals(readText(popUp), Variables.unEscapedHTML);
    }
}
