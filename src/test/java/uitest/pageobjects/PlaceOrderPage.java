// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uitest.BasePage;

public class PlaceOrderPage extends BasePage {

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    // Is order a dropship?
    @FindBy(css = "input#radioButtonDropshipYes")
    WebElement yesDropship;
    @FindBy(css = "input#radioButtonDropshipNo")
    WebElement noDropship;

    // Shipping Method
    @FindBy(css = ".shipping-details__box .ng-star-inserted:nth-child(2) [name='shipping']")
    WebElement amazon;

    // Payment Method
    @FindBy(css = ".shipping-details__box .ng-star-inserted:nth-child(2) [name='payment']")
    WebElement clinicPayment;

    // Terms and conditions
    @FindBy(css = ".summary-page__orderbox-send input")
    WebElement termsAgreement;
    @FindBy(css = ".summary-page__orderbox-send .dx-button-content")
    WebElement sendOrder;

    // Delivery address
    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement firstName;

    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[2]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement lastName;

    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[4]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement address;

    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[6]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement city;

    @FindBy(xpath = "//up-root/up-container[@class='ng-star-inserted']/div[@class='page']/ufc-draft-summary-page[@class='ng-star-inserted']/div[@class='m-summary-page']/div[3]/div[2]/div[2]/div[@class='col-8']/ufc-shipping-details//ufc-shipping-address-patient/div/div[@class='row']/form/ufc-form-render/div[7]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement zipcode;

    @FindBy(css = "[displayexpr='name'] .dx-dropdowneditor-icon")
    WebElement country;
    @FindBy(css = "div:nth-of-type(1) > .dx-item-content.dx-list-item-content")
    WebElement countrySelection;

    @FindBy(css = ".ng-untouched.ng-invalid [class='col-6']:nth-of-type(2) .dx-dropdowneditor-icon")
    WebElement state;
    @FindBy(css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
    WebElement stateSelection;

    public void placeOrder() throws InterruptedException {
        waitElement(sendOrder);
        click(yesDropship);
        Thread.sleep(3000);
        // if (firstName.isDisplayed()) {
        // writeText(firstName, "Test");
        // writeText(lastName, "Test");
        // writeText(address, "1918 Mutton Town Road");
        // writeText(city, "Test");
        // writeText(zipcode, "61820");
        // click(country);
        // waitElement(countrySelection);
        // click(countrySelection);
        // Thread.sleep(3000);
        // click(state);
        // waitElement(stateSelection);
        // click(stateSelection);
        // } else {
        // System.out.println("Info is already completed");
        // }
        click(amazon);
        click(clinicPayment);
        click(termsAgreement);
        click(sendOrder);
    }

}
