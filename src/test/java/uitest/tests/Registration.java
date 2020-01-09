// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.AdminSettings;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.PractitionerProfilePage;
import uitest.pageobjects.RegistrationPage;
import uitest.Variables;

class Registration extends TestNgTestBase {
    @Test(enabled = true, priority = 1)
    public void practitionerRegistration() throws InterruptedException {
        page.GetInstance(LoginPage.class).enter_Registration();
        page.GetInstance(RegistrationPage.class).writeCredentials(Variables.fName, Variables.lName,
                Variables.clinicName, Variables.emailAddress, Variables.phoneNumber, Variables.address, Variables.city,
                Variables.zipCode, Variables.license);
        page.GetInstance(RegistrationPage.class).selectDropdowns();
        page.GetInstance(RegistrationPage.class).uploadLicense(Variables.uploadJS);
        page.GetInstance(RegistrationPage.class).submitApplication();
        page.GetInstance(RegistrationPage.class).assert_ApplicationSub("Application Submitted");
    }

    @Test(enabled = true, priority = 2, dependsOnMethods = "practitionerRegistration") // 21 mm
    public void practitioner_RegistrationApproval() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_PractitionerApplications();
        page.GetInstance(AdminSettings.PractitionerApplications.class).selectStatus_New();
        page.GetInstance(AdminSettings.PractitionerApplications.class).approve_application();
        Thread.sleep(5000);
        page.GetInstance(AdminSettings.PractitionerApplications.class).assert_approval(Variables.registrationApproval);
    }

    @Test(enabled = true, priority = 3) // methods done, pending clicks
    public void change_practitionerPassword() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).changePass_req(Variables.actualPass, Variables.newPass,
                Variables.confirmPass);
        page.GetInstance(PractitionerProfilePage.class).changePassword();
    }

    // Registration Class - DONE (expeception is "change_PractitionerPassword")
}
