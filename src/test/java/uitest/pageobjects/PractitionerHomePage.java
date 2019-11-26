// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;

public class PractitionerHomePage extends BasePage {

    public PractitionerHomePage(WebDriver driver) {
        super(driver);
    }

    // Menu Buttons
    @FindBy(css = ".site-menu .site-menu-item.ng-star-inserted:nth-of-type(1) .site-menu-title")
    WebElement patientList;
    @FindBy(css = ".site-menu > .ng-star-inserted:nth-of-type(2) .site-menu-title")
    WebElement patientImport;
    @FindBy(css = ".site-menu .ng-star-inserted:nth-of-type(3) .site-menu-title")
    WebElement commissions;
    @FindBy(css = ".site-menu .ng-star-inserted:nth-of-type(4) .site-menu-title")
    WebElement myAccount;
    @FindBy(css = ".has-sub > .ng-star-inserted:nth-child(1)")
    WebElement orderReport;
    @FindBy(css = ".site-menu-sub-item.ng-star-inserted .site-menu-title")
    WebElement orderReportSelect;

    // Practitioner top-right buttons
    @FindBy(css = ".md-chevron-down")
    WebElement practitioner;
    @FindBy(css = "li:nth-of-type(2) > div[role='menu'] > a:nth-of-type(1)")
    WebElement practitionerProfile;
    @FindBy(css = "li:nth-of-type(2) > div[role='menu'] > a:nth-of-type(2)")
    WebElement logout;

    public void assert_dashboardPage(String expectedText) {
        waitElement(patientList);
        Assert.assertEquals(readText(patientList), expectedText);
    }

    public PatientlistPage enter_patientListPage() {
        if (patientList.isDisplayed()) {
            click(patientList);
        } else {
            waitElement(patientList);
            click(patientList);
        }
        return new PatientlistPage(driver);
    }

    public PatientimportPage enter_patientImportPage() {
        waitElement(patientImport);
        click(patientImport);
        return new PatientimportPage(driver);
    }

    public CommissionsPage enter_commissionsPage() {
        waitElement(commissions);
        click(commissions);
        return new CommissionsPage(driver);
    }

    public PractitionerProfilePage enter_myAccountPage() {
        waitElement(myAccount);
        click(myAccount);
        return new PractitionerProfilePage(driver);
    }

    public OrderReportPage enter_orderReportPage() {
        waitElement(orderReport);
        click(orderReport);
        click(orderReportSelect);
        return new OrderReportPage(driver);
    }

    public LoginPage logout() {
        waitElement(practitioner);
        click(practitioner);
        waitElement(logout);
        click(logout);
        return new LoginPage(driver);
    }

}
