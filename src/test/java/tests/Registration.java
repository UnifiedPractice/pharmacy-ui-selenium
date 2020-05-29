package tests;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.AdminHomePage;
import pages.AdminSettings;
import pages.LoginPage;
import pages.PractitionerHomePage;
import pages.RegistrationPage;
import variables.Variables;

public class Registration extends BaseTest {
	
	String admin = getCredentials().get("admin");
	String practitioner = getCredentials().get("practitioner");
	String CSR = getCredentials().get("CSR");
	
	@Test(enabled = true, priority = 1)
	public void practitionerRegistration() throws InterruptedException {
		page.getInstance(LoginPage.class).enter_Registration();
		page.getInstance(RegistrationPage.class).writeCredentials(Variables.fName, Variables.lName,
				Variables.clinicName, Variables.emailAddress, Variables.phoneNumber, Variables.address, Variables.city,
				Variables.zipCode, Variables.license);
		page.getInstance(RegistrationPage.class).selectDropdowns();
		page.getInstance(RegistrationPage.class).uploadLicense(Variables.uploadJS);
		page.getInstance(RegistrationPage.class).submitApplication();
		page.getInstance(RegistrationPage.class).assertRegistration(Variables.regApproval);
	}

	@Test(enabled = true, priority = 2, dependsOnMethods = "practitionerRegistration") // 21 mm
	public void practitioner_RegistrationApproval() throws InterruptedException {
		
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminHomePage.class).enter_PractitionerApplications();
		page.getInstance(AdminSettings.PractitionerApplications.class).selectStatus_New();
		page.getInstance(AdminSettings.PractitionerApplications.class).approve_application();
		Thread.sleep(5000);
		page.getInstance(AdminSettings.PractitionerApplications.class).assertApproval(Variables.registrationApproval);
	}

	@Test(enabled = false, priority = 3) // methods done, pending clicks
	public void change_practitionerPassword() {
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
		page.getInstance(PractitionerHomePage.class).enter_PractitionerProfilePage();
		/*page.getInstance(PractitionerProfilePage.class).changePass_req(Variables.actualPass, Variables.newPass,
				Variables.confirmPass);
		page.getInstance(PractitionerProfilePage.class).changePassword();*/
	}
}
