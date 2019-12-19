// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.AdminReports;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.PractitionerProfilePage;
import uitest.pageobjects.PractitionerReports;
import uitest.pageobjects.RegistrationPage;

class HelioPres extends TestNgTestBase {
    @Test // DONE
    public void practitionerRegistration() throws InterruptedException {
        page.GetInstance(LoginPage.class).enter_Registration();
        page.GetInstance(RegistrationPage.class).writeCredentials();
        page.GetInstance(RegistrationPage.class).selectDropdowns();
        page.GetInstance(RegistrationPage.class).uploadLicense(Variables.uploadJS);
        page.GetInstance(RegistrationPage.class).submitApplication();
        page.GetInstance(RegistrationPage.class).assert_ApplicationSub("Application Submitted");
    }

    @Test // DONE
    public void practitionerOrderReport_Export() {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_orderReportPage();
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).exportFile();
        page.GetInstance(PractitionerReports.PractitionerOrderReportPage.class).assertExport(Variables.orderReport);
    }

    @Test // DONE
    public void upload_certificate() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).uploadCertificate(Variables.uploadJS);
        page.GetInstance(PractitionerProfilePage.class).complete_userProfile();
        page.GetInstance(PractitionerProfilePage.class).saveCertificate();
        page.GetInstance(PractitionerProfilePage.class)
                .assert_CertificateUpload("Your data has been successfully saved.");
    }

    @Test // DONE
    public void adminOrderReport_Export() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_ReportPage();
        page.GetInstance(AdminReports.AdminOrderReportPage.class).exportFile();
        page.GetInstance(AdminReports.AdminOrderReportPage.class).assertExport("order-report.csv");
    }

}
