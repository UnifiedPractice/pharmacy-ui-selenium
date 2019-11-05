// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;

public class ProductCatalogPage extends BasePage {

    public ProductCatalogPage(WebDriver driver) {
        super(driver);
    }

    // Adjust buttons
    @FindBy(css = "dx-button:nth-of-type(1)  .dx-button-text")
    WebElement adjust;
    @FindBy(css = "[displayexpr='itemName'] .dx-texteditor-buttons-container")
    WebElement adjustDropdown;
    @FindBy(css = ".dx-scrollview-content > div:nth-of-type(1) .col-4")
    WebElement adjustDropdownSelection;
    @FindBy(css = ".dx-buttongroup-wrapper [role='button']:nth-of-type(1) .dx-button-text")
    WebElement typeAdd;
    @FindBy(css = ".dx-buttongroup-wrapper [role='button']:nth-of-type(2) .dx-button-text")
    WebElement typeRemove;
    @FindBy(css = "[displayexpr='lotNumber'] .dx-dropdowneditor-icon")
    WebElement lotNumber;
    @FindBy(css = ".dx-scrollview-content > div:nth-of-type(1)  .lot-autocomplete__box-res")
    WebElement lotNumberSelection;
    @FindBy(css = "input[role='spinbutton']")
    WebElement lotQuantity;
    @FindBy(css = "[type] .dx-button-text")
    WebElement saveBtn;

    // Receive buttons
    @FindBy(css = "dx-button:nth-of-type(2)  .dx-button-text")
    WebElement receive;
    @FindBy(css = ".dx-dropdowneditor.dx-datebox-calendar [aria-haspopup]")
    WebElement expiryDate;

    @FindBy(css = "")
    WebElement toastMessage;

    public void startAdjust() throws InterruptedException {
        Thread.sleep(2500);
        click(adjust);
    }

    public void startReceive() throws InterruptedException {
        Thread.sleep(2500);
        click(receive);
    }

    public void selectItem() throws InterruptedException {
        waitElement(adjustDropdown);
        click(adjustDropdown);
        waitElement(adjustDropdownSelection);
        click(adjustDropdownSelection);
    }

    public void quantityAddition(String expectedText) {
        waitElement(typeAdd);
        click(typeAdd);
        click(lotNumber);
        waitElement(lotNumberSelection);
        click(lotNumberSelection);
        writeText(lotQuantity, expectedText);
        click(saveBtn);
    }

    public void quantityRemoval(String expectedText) {
        waitElement(typeRemove);
        click(typeRemove);
        click(lotNumber);
        waitElement(lotNumberSelection);
        click(lotNumberSelection);
        writeText(lotQuantity, expectedText);
        click(saveBtn);
    }

    public void quantityReceival(String lotQ, String expiryD) {
        waitElement(lotNumber);
        writeText(lotQuantity, lotQ);
        writeText(expiryDate, expiryD);
        click(lotNumber);
        waitElement(lotNumberSelection);
        click(lotNumberSelection);
        click(saveBtn);
    }

    public void assertChange(String expectedText) {
        waitElement(toastMessage);
        Assert.assertEquals(readText(toastMessage), expectedText);
    }

}
