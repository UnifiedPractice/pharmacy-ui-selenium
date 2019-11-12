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

    public PatientlistPage placeOrder() throws InterruptedException {
        waitElement(sendOrder);
        click(noDropship);
        click(amazon);
        click(clinicPayment);
        click(termsAgreement);
        click(sendOrder);
        return new PatientlistPage(driver);
    }

}
