package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Page Locators - Registration Page
	private By firstName = By.xpath(
			"//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[1]/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
	private By lastName = By.xpath(
			"//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[1]/div[2]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");

	private By pracType = By.cssSelector(
			"ufc-form-render:nth-of-type(1) .dx-dropdowneditor.dx-dropdowneditor-button-visible.dx-dropdowneditor-field-clickable.dx-editor-underlined.dx-selectbox.dx-show-clear-button.dx-textbox div[role='button']  .dx-dropdowneditor-icon");
	private By pracTypeSelection = By.xpath(
			"//body/div/div/div[@class='dx-popup-content']/div[@role='listbox']//div[@class='dx-scrollview-content']/div[1]/div[@class='dx-item-content dx-list-item-content']");

	private By clinicName = By.cssSelector("ufc-form-render:nth-of-type(1) .ng-touched:nth-of-type(4) [type]");
	private By email = By.xpath(
			"//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[1]/div[5]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");
	private By phoneNumber = By.cssSelector("[type='tel']");

	private By phoneType = By
			.cssSelector(".ng-untouched.ng-dirty [class='col-6']:nth-of-type(2) .dx-texteditor-buttons-container");
	private By phoneTypeSelection = By.cssSelector("[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content");

	private By emailAddress = By.cssSelector("ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(1) [type]");
	private By city = By.cssSelector("ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(3) [type]");
	private By zipcode = By.cssSelector("ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(4) [type]");

	private By country = By.cssSelector("[displayexpr='name'] .dx-dropdowneditor-icon");
	private By countrySelection = By.cssSelector("[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content");

	private By state = By.cssSelector(".ng-untouched.ng-invalid.dx-dropdowneditor .dx-dropdowneditor-icon");
	private By stateSelection = By.cssSelector("[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content");

	private By license = By.cssSelector("ufc-form-render:nth-of-type(3) .ng-dirty:nth-of-type(3) [type]");
	private By hiddenUpload = By.xpath("//up-root/up-practitioner-registration/div[@class='user-page-full']/div/div//ufc-file-upload[@name='file']/input[@type='file']");
	private By submit = By.cssSelector("[type='default'] .dx-button-content");
	private By address = By.xpath(
			"//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[2]/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']");

	private By successMessage = By.cssSelector(".modal h4");
	// Upload file path
	String filePath = "/helio/src/main/java/uploadDocuments/superbill.pdf";

	// Locator GET methods
	public WebElement getFirstName() {
		return getElement(firstName);
	}

	public WebElement getLastName() {
		return getElement(lastName);
	}

	public WebElement getPracType() {
		return getElement(pracType);
	}

	public WebElement getPracTypeSelection() {
		return getElement(pracTypeSelection);
	}

	public WebElement getClinicName() {
		return getElement(clinicName);
	}

	public WebElement getEmail() {
		return getElement(email);
	}

	public WebElement getPhoneNumber() {
		return getElement(phoneNumber);
	}

	public WebElement getPhoneType() {
		return getElement(phoneType);
	}

	public WebElement getPhoneTypeSelection() {
		return getElement(phoneTypeSelection);
	}

	public WebElement getEmailAddress() {
		return getElement(emailAddress);
	}

	public WebElement getCity() {
		return getElement(city);
	}

	public WebElement getZipCode() {
		return getElement(zipcode);
	}

	public WebElement getCountry() {
		return getElement(country);
	}

	public WebElement getCountrySelection() {
		return getElement(countrySelection);
	}

	public WebElement getState() {
		return getElement(state);
	}

	public WebElement getStateSelection() {
		return getElement(stateSelection);
	}

	public WebElement getLicense() {
		return getElement(license);
	}

	public WebElement getUploadInput() {
		return getElement(hiddenUpload);
	}

	public WebElement getSubmit() {
		return getElement(submit);
	}

	public WebElement getAddress() {
		return getElement(address);
	}

	public WebElement getSuccessMessage() {
		return getElement(successMessage);
	}

	// Navigation methods
	public void writeCredentials(String firstName, String lastName, String clinicName, String email, String phoneNumber,
			String address, String city, String zipCode, String license) {
		getFirstName().sendKeys(firstName);
		getLastName().sendKeys(lastName);
		getClinicName().sendKeys(clinicName);
		getEmail().sendKeys(email);
		getPhoneNumber().sendKeys(phoneNumber);
		getAddress().sendKeys(address);
		getCity().sendKeys(city);
		getZipCode().sendKeys(zipCode);
		getLicense().sendKeys(license);
	}

	public void selectDropdowns() {
		getPhoneType().click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getPhoneTypeSelection().click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getPracType().click();
		getPracTypeSelection().click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getCountry().click();
		getCountrySelection().click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getState().click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getStateSelection().click();
	}

	public void uploadLicense(String expected) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String basepath = new File(filePath).getAbsolutePath();
		((JavascriptExecutor) driver).executeScript(expected, hiddenUpload);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getUploadInput().sendKeys(basepath);
	}

	public void submitApplication() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getSubmit().click();
	}
	
	public void assertRegistration(String expected) {
		Assert.assertEquals(getSuccessMessage().getText(), expected);
	}

}
