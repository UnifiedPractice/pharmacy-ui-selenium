// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;
import uitest.Variables;

public class PatientlistPage extends BasePage {

    public PatientlistPage(WebDriver driver) {
        super(driver);
    }

    // Add Patient Button
    @FindBy(css = "dx-button.patients-page__addpatient")
    WebElement addPatient;

    // Add Patient window
    @FindBy(xpath = "/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[1]/div[1]/div/dx-text-box/div/input")
    WebElement firstName;

    @FindBy(xpath = "/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[3]/div[1]/div/dx-text-box/div/input")
    WebElement lastName;

    @FindBy(css = ".dx-visibility-change-handler.dx-dropdowneditor [aria-haspopup]")
    WebElement birthDate;

    @FindBy(xpath = "/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[5]/div/div/ufc-gender-input/div/div/dx-select-box/div/div/div[2]/div/div/div")
    WebElement genderDropdown;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div[1]")
    WebElement genderSelect;

    @FindBy(xpath = "/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[6]/div/div/ufc-phone-input/form/div/div[1]/dx-text-box/div/input")
    WebElement phoneNumber;

    @FindBy(xpath = "/html/body/ufc-add-edit-patient-modal/div/div/div/div[2]/div[1]/form/ufc-form-render/div[6]/div[1]/div/ufc-phone-input/form/div/div[2]/dx-select-box/div[1]/div/div[2]/div")
    WebElement phoneNumberDropdown;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div[1]")
    WebElement phoneNumberSelect;

    @FindBy(css = "body > ufc-add-edit-patient-modal > div > div > div > div.modal-body > div:nth-child(1) > form > ufc-form-render > div:nth-child(7) > div.c-user-box > div > dx-text-box > div > input")
    WebElement emailAddress;

    @FindBy(css = "[displayexpr='name'] .dx-dropdowneditor-icon")
    WebElement countryDropdown;

    // United States
    @FindBy(css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
    WebElement countrySelect;

    @FindBy(css = "[class='col-6 ng-star-inserted'] .dx-dropdowneditor-icon")
    WebElement stateDropdown;

    // Colorado
    @FindBy(css = "[data-bind] [role='option']:nth-of-type(6) .dx-list-item-content")
    WebElement stateSelect;

    @FindBy(css = "dx-button:nth-of-type(1)  .dx-button-text")
    WebElement saveButton;

    @FindBy(css = ".site-menu .site-menu-item.ng-star-inserted:nth-of-type(1) .site-menu-title")
    WebElement patientListBtn;

    // Start ORDER and SEARCH BAR
    @FindBy(css = ".dx-scrollview-content [role='option']:nth-of-type(1) .patients-row__action")
    WebElement startOrder;

    @FindBy(css = ".dx-texteditor-container [type]")
    WebElement searchBar;

    // Finished order
    @FindBy(css = ".modal-title")
    WebElement orderSent;
    @FindBy(css = ".order-sent-modal__info")
    WebElement orderNumber;
    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1)")
    WebElement orderDetails;

    // Logout buttons
    @FindBy(css = ".md-chevron-down")
    WebElement logDrop;
    @FindBy(css = "li:nth-of-type(2) [role] [role='menuitem']:nth-child(3)")
    WebElement logout;
    @FindBy(css = ".close > span")
    WebElement xMark;

    public IngredientsPage startOrder() {
        waitElement(startOrder);
        click(startOrder);
        return new IngredientsPage(driver);
    }

    public void completeCredentials(String emailAddresss, String firstNamee, String lastNamee, String birthdayy,
            String phoneNumberr) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // waitElement(addPatient);
        click(addPatient);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // waitElement(emailAddress);
        writeText(emailAddress, emailAddresss);
        writeText(firstName, firstNamee);
        writeText(lastName, lastNamee);

        writeText(birthDate, birthdayy);
        waitElement(genderDropdown);
        click(genderDropdown);
        click(genderSelect);

        writeText(phoneNumber, phoneNumberr);
        click(lastName);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        click(phoneNumberDropdown);
        waitElement(phoneNumberSelect);
        click(phoneNumberSelect);

        click(countryDropdown);
        waitElement(countrySelect);
        click(countrySelect);

        click(stateDropdown);
        waitElement(stateSelect);
        click(stateSelect);
    }

    public void savePatient() {
        click(saveButton);
    }

    public void get_orderDetails() {
        waitElement(orderDetails);
        click(orderDetails);
    }

    private String get_orderName() {
        waitElement(orderNumber);
        // Get Sentence
        String order = readText(orderNumber);
        // Split sentence words
        String[] words = order.split("\\s+");
        // Replace special character of the 2nd word
        String orderNumber = words[1].replace("#", "");
        System.out.println("This is the extracted word: " + orderNumber);
        return orderNumber.toString();
    }

    public void assertOrder(String expectedText) {
        waitElement(orderSent);
        Assert.assertEquals(readText(orderSent), expectedText);
    }

    public LoginPage logout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(logDrop);
        click(logout);
        return new LoginPage(driver);
    }

    public void closeSentOrder() {
        waitElement(xMark);
        click(xMark);
    }

    public static class IngredientsPage extends PatientlistPage {
        public IngredientsPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(css = ".dx-scrollable-content [role='row']:nth-of-type(4) .material-icons")
        WebElement addIngredient;

        @FindBy(css = "[tabindex='-1']:nth-of-type(2) span")
        WebElement roundUp;

        @FindBy(css = ".draft-order__actions [tabindex='0']:nth-of-type(2)")
        WebElement checkoutOrder;

        @FindBy(css = "dx-number-box [type='text']")
        WebElement setQ;

        public void addIngredients() {
            waitElement(addIngredient);
            click(addIngredient);
        }

        public void roundupIngredients(String quantity) {
            writeText(setQ, quantity);
        }

        public PlaceOrderPage checkoutOrder() {
            if (checkoutOrder.isDisplayed()) {
                click(checkoutOrder);
            } else {
                waitElement(checkoutOrder);
                click(checkoutOrder);
            }
            return new PlaceOrderPage(driver);
        }
    }

    public static class PlaceOrderPage extends PatientlistPage {
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
        WebElement clinicPay;
        @FindBy(css = "div:nth-of-type(2) > .radio-custom > input[name='payment']")
        WebElement onlinePay;

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

        // Coupon input
        @FindBy(css = "input[role='textbox']")
        WebElement couponInput;
        @FindBy(css = ".apply-coupon__butcontainer .dx-button-text")
        WebElement applyCoupon;

        public void placeOrder() {
            waitElement(sendOrder);
            click(yesDropship);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
            click(clinicPay);
            click(termsAgreement);
            click(sendOrder);
        }

        public void apply_coupon(String expected) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeText(couponInput, expected);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(applyCoupon);
        }
    }

}
