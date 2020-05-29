package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PractitionerHomePage extends BasePage {

	public PractitionerHomePage(WebDriver driver) {
		super(driver);
	}

	// Page Locators - Left side main menu buttons
	private By patientList = By
			.cssSelector(".site-menu .site-menu-item.ng-star-inserted:nth-of-type(1) .site-menu-title");
	private By patientImport = By.cssSelector(".site-menu > .ng-star-inserted:nth-of-type(2) .site-menu-title");
	private By commissions = By.cssSelector(".site-menu .ng-star-inserted:nth-of-type(3) .site-menu-title");
	private By myAccount = By.cssSelector(".site-menu .ng-star-inserted:nth-of-type(4) .site-menu-title");
	private By orderReport = By.cssSelector(".has-sub > .ng-star-inserted:nth-child(1)");
	private By orderReportSelect = By.cssSelector(".site-menu-sub-item.ng-star-inserted .site-menu-title");

	// Page Locators - top-right dropdown buttons
	private By practitioner = By.cssSelector(".md-chevron-down");
	private By practitionerProfile = By.cssSelector("li:nth-of-type(2) > div[role='menu'] > a:nth-of-type(1)");
	private By logoutButton = By.cssSelector("li:nth-of-type(2) > div[role='menu'] > a:nth-of-type(2)");

	// Get functions
	public WebElement getPatientList() {
		return getElement(patientList);
	}

	public WebElement getPatientImport() {
		return getElement(patientImport);
	}

	public WebElement getCommissions() {
		return getElement(commissions);
	}

	public WebElement getProfilePage() {
		return getElement(myAccount);
	}

	public WebElement getOrderReport() {
		return getElement(orderReport);
	}

	public WebElement getOrderReportSelect() {
		return getElement(orderReportSelect);
	}

	public WebElement getLogoutButton() {
		return getElement(logoutButton);
	}

	
	// Methods - left side menu navigation functions
	public PatientListPage enter_PatientListPage() {
		getPatientList().click();
		return getInstance(PatientListPage.class);
	}

	public PatientImportPage enter_patientImportPage() {
		getPatientImport().click();
		return getInstance(PatientImportPage.class);
	}

	public CommissionsPage enter_CommissionsPage() {
		getCommissions().click();
		return getInstance(CommissionsPage.class);
	}

	public PractitionerProfilePage enter_PractitionerProfilePage() {
		getProfilePage().click();
		return getInstance(PractitionerProfilePage.class);
	}

	public PractitionerReports enter_OrderReportPage() {
		getOrderReport().click();
		getOrderReportSelect().click();
		return getInstance(PractitionerReports.class);
	}
	
	public LoginPage logout() {
		getLogoutButton().click();
		return getInstance(LoginPage.class);
	}

}
