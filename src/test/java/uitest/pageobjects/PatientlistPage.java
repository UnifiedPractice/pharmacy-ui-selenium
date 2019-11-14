// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import java.util.Arrays;

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

    public IngredientsPage startOrder() {
        waitElement(startOrder);
        click(startOrder);
        return new IngredientsPage(driver);
    }

    public void addPatient() {
        waitElement(addPatient);
        click(addPatient);
        waitElement(emailAddress);
        writeText(emailAddress, Variables.emailAddress);
        writeText(firstName, Variables.firstName);
        writeText(lastName, Variables.lastName);

        writeText(birthDate, Variables.dObOption);
        waitElement(genderDropdown);
        click(genderDropdown);
        click(genderSelect);

        writeText(phoneNumber, Variables.phoneNumber);
        click(phoneNumberDropdown);
        waitElement(phoneNumberSelect);
        click(phoneNumberSelect);

        click(countryDropdown);
        waitElement(countrySelect);
        click(countrySelect);

        click(stateDropdown);
        waitElement(stateSelect);
        click(stateSelect);

        click(saveButton);
    }

    public void get_orderDetails() {
        waitElement(orderDetails);
        click(orderDetails);
    }

    public String get_orderName() {
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
        waitElement(logDrop);
        click(logDrop);
        click(logout);
        return new LoginPage(driver);
    }

}
