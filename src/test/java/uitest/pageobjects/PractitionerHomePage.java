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
    @FindBy(css = "body > up-root > up-container > up-sidebar > div > div.site-menubar-body.scrollable.scrollable-inverse.scrollable-vertical.hoverscorll-disabled.is-enabled.is-hovering > div > div > ul > li.site-menu-item.has-sub.ng-star-inserted.hover.open > a > span")
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

    public void enter_patientImportPage() {
        waitElement(patientImport);
        click(patientImport);

    }

    public void enter_commissionsPage() {
        waitElement(commissions);
        click(commissions);
    }


    public void enter_myAccountPage() {
        waitElement(myAccount);
        click(myAccount);

    }

    public void enter_orderReportPage() {
        waitElement(orderReport);
        click(orderReport);
        waitElement(orderReportSelect);
        click(orderReportSelect);
    }

    public void logout() {
        waitElement(practitioner);
        click(practitioner);
        waitElement(logout);
        click(logout);
    }

}
