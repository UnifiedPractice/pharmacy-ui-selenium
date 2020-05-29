package tests;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import pages.AdminSettings;
import pages.InventoryPages;
import pages.LoginPage;
import pages.PatientImportPage;
import pages.PractitionerHomePage;
import pages.PractitionerProfilePage;
import variables.Variables;

public class Imports extends BaseTest {
	
	String admin = getCredentials().get("admin");
	String practitioner = getCredentials().get("practitioner");
	String CSR = getCredentials().get("CSR");

	@Test(enabled = true, priority = 1)//done
	public void import_ChineseNames() {
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(InventoryPages.class).enter_ProductCatalog();
		page.getInstance(InventoryPages.ProductCatalog.class).uploadFile(Variables.uploadJS);
		page.getInstance(InventoryPages.ProductCatalog.class).assert_ImportChineseNames(Variables.chineseNamesMessage);
	}

	@Test(enabled = true, priority = 2)//done
	public void patient_import() {
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
		page.getInstance(PractitionerHomePage.class).enter_patientImportPage();
		page.getInstance(PatientImportPage.class).uploadFile(Variables.uploadJS);
		page.getInstance(PatientImportPage.class).validateFile();
		page.getInstance(PatientImportPage.class).finishImport();
		page.getInstance(PatientImportPage.class).assertImport(Variables.successfulPatientImport);
	}

	@Test(enabled = true, priority = 3)//done
	public void terms_and_conditions_upload() throws InterruptedException {
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminSettings.class).enter_PharmacySettings();
		Thread.sleep(3000);
		page.getInstance(AdminSettings.PharmacySettings.GeneralTab.class).uploadTerms(Variables.uploadJS);
		page.getInstance(AdminSettings.PharmacySettings.GeneralTab.class).saveChanges();
		page.getInstance(AdminSettings.PharmacySettings.GeneralTab.class).assertUpload(Variables.settingsMessage);
	}

	@Test(enabled = true, priority = 4)//done
	public void general_LogoUpload() throws InterruptedException {
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminSettings.class).enter_PharmacySettings();
		Thread.sleep(3000);
		page.getInstance(AdminSettings.PharmacySettings.GeneralTab.class).uploadLogo(Variables.uploadJS);
		page.getInstance(AdminSettings.PharmacySettings.GeneralTab.class).saveChanges();
		page.getInstance(AdminSettings.PharmacySettings.GeneralTab.class).assertUpload(Variables.settingsMessage);
	}

	@Test(enabled = true, priority = 5)//done
	public void upload_logo() {
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
		page.getInstance(PractitionerHomePage.class).enter_PractitionerProfilePage();
		page.getInstance(PractitionerProfilePage.class).uploadLogo(Variables.uploadJS);
		page.getInstance(PractitionerProfilePage.class).saveLogo();
		page.getInstance(PractitionerProfilePage.class).assertUpload(Variables.practitionerProfileMessage);
	}

	@Test(enabled = true, priority = 6)//done
	public void upload_certificate() {
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
		page.getInstance(PractitionerHomePage.class).enter_PractitionerProfilePage();
		page.getInstance(PractitionerProfilePage.class).uploadCertificate(Variables.uploadJS);
		page.getInstance(PractitionerProfilePage.class).complete_userProfile();
		page.getInstance(PractitionerProfilePage.class).saveCertificate();
		page.getInstance(PractitionerProfilePage.class).assertUpload(Variables.practitionerProfileMessage);
	}

}
