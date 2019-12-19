// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import uitest.BasePage;

public class AdminSettings extends BasePage {
    public AdminSettings(WebDriver driver) {
        super(driver);
    }
    //sd
    @FindBy(css = "")
    WebElement settings;

    public UserList enter_UserList() {

        return new UserList(driver);
    }

    public PractitionerList enter_PractitionerList() {

        return new PractitionerList(driver);
    }

    public AdminSettings enter_PractitionerApplications() {

        return new AdminSettings(driver);
    }

    public PharmacySettings enter_PharmacySettings() {

        return new PharmacySettings(driver);
    }

    public static class UserList extends AdminSettings {
        public UserList(WebDriver driver) {
            super(driver);
        }
    }

    public static class PractitionerList extends AdminSettings {
        public PractitionerList(WebDriver driver) {
            super(driver);
        }

    }

    public static class PractitionerApplications extends AdminSettings {
        public PractitionerApplications(WebDriver driver) {
            super(driver);
        }

        // Filters
        @FindBy(css = ".dx-selectbox-container .dx-dropdowneditor-icon")
        WebElement appStatus;
        @FindBy(css = "div:nth-of-type(2) > .dx-item-content.dx-list-item-content")
        WebElement newStatus;

        @FindBy(css = "[class] [class='col-3']:nth-of-type(2) [aria-haspopup]")
        WebElement startDate;
        @FindBy(css = "[class] [class='col-3']:nth-of-type(3) [aria-haspopup]")
        WebElement endDate;

        // Datagrid
        @FindBy(css = "tr:nth-of-type(1) > td:nth-of-type(1) > .dx-datagrid-group-closed")
        WebElement applicationDropdown;
        @FindBy(css = "dx-button:nth-of-type(1)  .dx-button-text")
        WebElement approve;
        @FindBy(css = "dx-button:nth-of-type(2)  .dx-button-text")
        WebElement reject;

        // Practitioner approval
        @FindBy(css = ".o-button.o-button--primary.o-button--small")
        WebElement yes;
        @FindBy(css = ".o-button.o-button--secondary.o-button--small")
        WebElement no;

        // Error messages
        @FindBy(css = "div#toast-container")
        WebElement approvalMessage;

        public void selectStatus_New() {
            waitElement(appStatus);
            click(appStatus);
            click(newStatus);
        }

        public void approve_application() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(applicationDropdown);
            click(approve);
            waitElement(yes);
            click(yes);
        }

        public void assert_approval(String errorName) {
            Assert.assertEquals(readText(approvalMessage), errorName);
        }

    }

    public static class PharmacySettings extends AdminSettings {
        public PharmacySettings(WebDriver driver) {
            super(driver);
        }
    }
}
