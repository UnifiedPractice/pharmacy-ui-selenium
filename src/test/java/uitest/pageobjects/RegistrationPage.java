// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uitest.BasePage;
import uitest.Variables;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Practitioner Information
    @FindBy(xpath = "//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[1]/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement firstName;
    @FindBy(xpath = "//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[1]/div[2]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement lastName;

    @FindBy(css = "ufc-form-render:nth-of-type(1) .dx-dropdowneditor.dx-dropdowneditor-button-visible.dx-dropdowneditor-field-clickable.dx-editor-underlined.dx-selectbox.dx-show-clear-button.dx-textbox div[role='button']  .dx-dropdowneditor-icon")
    WebElement pracType;
    @FindBy(xpath = "//body/div/div/div[@class='dx-popup-content']/div[@role='listbox']//div[@class='dx-scrollview-content']/div[1]/div[@class='dx-item-content dx-list-item-content']")
    WebElement pracTypeSelection;

    @FindBy(css = "ufc-form-render:nth-of-type(1) .ng-touched:nth-of-type(4) [type]")
    WebElement clinicName;
    @FindBy(xpath = "//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[1]/div[5]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement email;
    @FindBy(css = "[type='tel']")
    WebElement phoneNumber;

    @FindBy(css = ".ng-untouched.ng-dirty [class='col-6']:nth-of-type(2) .dx-texteditor-buttons-container")
    WebElement phoneType;
    @FindBy(css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
    WebElement phoneTypeSelection;

    @FindBy(css = "ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(1) [type]")
    WebElement emailAddress;
    @FindBy(css = "ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(3) [type]")
    WebElement city;
    @FindBy(css = "ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(4) [type]")
    WebElement zipcode;

    @FindBy(css = "[displayexpr='name'] .dx-dropdowneditor-icon")
    WebElement country;
    @FindBy(css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
    WebElement countrySelection;

    @FindBy(css = ".ng-untouched.ng-invalid.dx-dropdowneditor .dx-dropdowneditor-icon")
    WebElement state;
    @FindBy(css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
    WebElement stateSelection;

    @FindBy(css = "ufc-form-render:nth-of-type(3) .ng-dirty:nth-of-type(3) [type]")
    WebElement license;
    @FindBy(css = "ufc-file-upload[name='file'] > input[type='file']")
    WebElement uploadInput;
    @FindBy(css = "[type='default'] .dx-button-content")
    WebElement submit;
    @FindBy(xpath = "//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[2]/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
    WebElement address;
    // Path to
    String filePath = "C:/Users/Andrew/Downloads/superbill.pdf";

    // Application submitted
    @FindBy(css = ".modal h4")
    WebElement successMessage;

    public void writeCredentials(String firstName, String lastName, String clinicName, String email, String phone,
            String address, String city, String zipCode, String license) throws InterruptedException {

        writeText(firstName, firstName);

        writeText(lastName, lastName);

        writeText(clinicName, clinicName);

        writeText(email, email);

        writeText(phoneNumber, phone);

        writeText(address, address);

        writeText(city, city);

        writeText(zipcode, zipCode);
        writeText(license, license);
    }

    public void selectDropdowns() throws InterruptedException {
        click(phoneType);
        waitElement(phoneTypeSelection);
        click(phoneTypeSelection);
        Thread.sleep(1000);
        click(pracType);
        waitElement(pracTypeSelection);
        click(pracTypeSelection);
        Thread.sleep(1000);
        click(country);
        waitElement(countrySelection);
        click(countrySelection);
        Thread.sleep(1000);
        click(state);
        waitElement(stateSelection);
        click(stateSelection);
    }

    public void uploadLicense(String expected) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript(expected, uploadInput);
        Thread.sleep(1000);
        writeText(uploadInput, filePath);
    }

    public void submitApplication() throws InterruptedException {
        Thread.sleep(1000);
        click(submit);
    }

    public void assert_ApplicationSub(String expected) {
        waitElement(successMessage);
        Assert.assertEquals(readText(successMessage), expected);
    }

}
