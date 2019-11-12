// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import uitest.BasePage;

public class ShippingPage extends BasePage {
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

    public void select_item() throws InterruptedException {
        waitElement(itemSelect);
        click(itemSelect);
    }

    public void completeQuantities() throws InterruptedException {
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
