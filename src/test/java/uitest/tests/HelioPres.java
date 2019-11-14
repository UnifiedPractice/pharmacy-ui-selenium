// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.OrderReportPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.PractitionerProfilePage;
import uitest.pageobjects.RegistrationPage;

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
    public void practitionerOrderReport_Export() {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_orderReportPage();
        page.GetInstance(OrderReportPage.class).exportFile();
        page.GetInstance(OrderReportPage.class).assertExport();
    }

    @Test // done - pending toast messages
    public void upload_certificate() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).uploadCertificate(Variables.uploadJS);
        page.GetInstance(PractitionerProfilePage.class).complete_userProfile();
        page.GetInstance(PractitionerProfilePage.class).saveCertificate();
    }

    @Test // pending implementation - TODO
    public void adminOrderReport_Export() {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_ReportPage();
    }

}
