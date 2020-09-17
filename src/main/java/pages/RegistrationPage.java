package pages;

import java.io.File;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this); //Initialize page elements
	}

	//WebElements
	@FindBy (css = ".register-form-container form ufc-form-render:nth-child(1) .form-row:nth-child(1) input")
	public WebElement getFirstName;
	@FindBy (css = ".register-form-container form ufc-form-render:nth-child(1) .form-row:nth-child(2) input")
	public WebElement getLastName;
	@FindBy (css = ".register-form-container form ufc-form-render:nth-child(1) .form-row:nth-child(3) input[type='text']")
	public WebElement getPracType;
	@FindBy (xpath = "//body/div/div/div[@class='dx-popup-content']/div[@role='listbox']//div[@class='dx-scrollview-content']/div[1]/div[@class='dx-item-content dx-list-item-content']")
	public WebElement getPracTypeSelection;
	@FindBy (css = ".register-form-container form ufc-form-render:nth-child(1) .form-row:nth-child(4) input[type='text']")
	public WebElement getClinicName;
	@FindBy (css = ".register-form-container form ufc-form-render:nth-child(1) .form-row:nth-child(5) input[type='text']")
	public WebElement getEmail;
	@FindBy (css = "[type='tel']")
	public WebElement getPhoneNumber;
	@FindBy (css = ".ng-untouched.ng-dirty [class='col-6']:nth-of-type(2) .dx-texteditor-buttons-container")
	public WebElement getPhoneType;
	@FindBy (css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
	public WebElement getPhoneTypeSelection;
	@FindBy (css = "ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(1) [type]")
	public WebElement getEmailAddress;
	@FindBy (css = "ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(3) [type]")
	public WebElement getCity;
	@FindBy (css = "ufc-form-render:nth-of-type(2) .ng-dirty:nth-of-type(4) [type]")
	public WebElement getZipCode;
	@FindBy (css = "[displayexpr='name'] .dx-dropdowneditor-icon")
	public WebElement getCountry;
	@FindBy (css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
	public WebElement getCountrySelection;
	@FindBy (css = ".ng-untouched.ng-invalid.dx-dropdowneditor .dx-dropdowneditor-icon")
	public WebElement getState;
	@FindBy (css = "[data-bind] [role='option']:nth-of-type(1) .dx-list-item-content")
	public WebElement getStateSelection;
	@FindBy (css = "ufc-form-render:nth-of-type(3) .ng-dirty:nth-of-type(3) [type]")
	public WebElement getLicense;
	@FindBy (xpath = "//up-root/up-practitioner-registration/div[@class='user-page-full']/div/div//ufc-file-upload[@name='file']/input[@type='file']")
	public WebElement getUploadInput;
	@FindBy (css = "[type='default'] .dx-button-content")
	public WebElement getSubmit;
	@FindBy (xpath = "//up-root/up-practitioner-registration/div[@class='user-page-full']/div[@class='practitioner-register']/div/div[3]/div[1]/form/ufc-form-render[2]/div[1]/div[@class='c-user-box']/div[@class='user-box__item']/dx-text-box//input[@role='textbox']")
	public WebElement getAddress;
	@FindBy (css = ".modal h4")
	public WebElement getSuccessMessage;
	@FindBy (css = "label.up-checkbox")
	public WebElement checkbox;

	// Upload file path
	String filePath = "C://_stash/src/main/java/uploadDocuments/superbill.pdf";

	// Navigation methods
	public void writeCredentials(String firstName, String lastName, String clinicName, String email, String phoneNumber,
			String address, String city, String zipCode, String license) {
		getFirstName.sendKeys(firstName);
		getLastName.sendKeys(lastName);
		getClinicName.sendKeys(clinicName);
		getEmail.sendKeys(email);
		getPhoneNumber.sendKeys(phoneNumber);
		getAddress.sendKeys(address);
		getCity.sendKeys(city);
		getZipCode.sendKeys(zipCode);
		getLicense.sendKeys(license);
	}

	public void selectDropdowns() {
		getPhoneType.click();

		getPhoneTypeSelection.click();
		getPracType.click();
		try {
			getPracTypeSelection.click();
		} catch (Exception e) {
			getPracType.sendKeys(Keys.ESCAPE);
			getPracType.click();
			getPracTypeSelection.click();
		}


		getCountry.click();
		try {
			getCountrySelection.click();
		} catch (Exception e) {
			getCountry.sendKeys(Keys.ESCAPE);
			getCountry.click();
			getCountrySelection.click();
		}

		getState.click();

		getStateSelection.click();
	}

	public void uploadLicense(String expected) {

		String basepath = new File(filePath).getAbsolutePath();
		((JavascriptExecutor) driver).executeScript(expected, getUploadInput);

		getUploadInput.sendKeys(basepath);
	}

	public void submitApplication() {
		checkbox.click();

		getSubmit.click();
	}
	
	public void assertRegistration(String expected) {
		Assert.assertEquals(getSuccessMessage.getText(), expected);
	}

}
