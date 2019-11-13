// Ranorex Webtestit Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

class HelioPres extends TestNgTestBase {
    @Test
    public void practitionerRegistration() throws InterruptedException {
        page.GetInstance(LoginPage.class).enter_Registration();
        page.GetInstance(RegistrationPage.class).writeCredentials();
        page.GetInstance(RegistrationPage.class).selectDropdowns();
        page.GetInstance(RegistrationPage.class).uploadLicense(Variables.uploadJS);
        page.GetInstance(RegistrationPage.class).submitApplication();
    }

    @Test
    public void orderReport_Export() {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_orderReportPage();
        page.GetInstance(OrderReportPage.class).exportFile();
        page.GetInstance(OrderReportPage.class).assertExport();
    }

    @Test
    public void upload_certificate() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).uploadCertificate(Variables.uploadJS);
        page.GetInstance(PractitionerProfilePage.class).complete_userProfile();
        page.GetInstance(PractitionerProfilePage.class).saveCertificate();
    }

}
