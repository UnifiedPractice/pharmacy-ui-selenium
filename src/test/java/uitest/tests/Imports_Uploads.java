// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.AdminSettings;
import uitest.pageobjects.InventoryPages;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PatientimportPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.PractitionerProfilePage;

class Imports_Uploads extends TestNgTestBase {
    @Test(enabled = true, priority = 1)
    public void import_ChineseNames() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        page.GetInstance(InventoryPages.ProductCatalog.class).uploadFile(Variables.uploadJS);
        page.GetInstance(InventoryPages.ProductCatalog.class)
                .assertImport("You have successfully imported the names for 2 products.");
    }

    @Test(enabled = true, priority = 2)
    public void patient_import() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_patientImportPage();
        page.GetInstance(PatientimportPage.class).uploadFile(Variables.uploadJS);
        page.GetInstance(PatientimportPage.class).validateFile();
        page.GetInstance(PatientimportPage.class).finishImport();
        page.GetInstance(PatientimportPage.class).assertImport(Variables.successfulPatientImport);
    }

    @Test(enabled = true, priority = 3)
    public void terms_and_conditions_upload() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminSettings.class).enter_PharmacySettings();
        Thread.sleep(3000);
        // page.GetInstance(AdminSettings.PharmacySettings.class).enter_GeneralTab();
        page.GetInstance(AdminSettings.PharmacySettings.GeneralTab.class).uploadTerms(Variables.uploadJS);
        page.GetInstance(AdminSettings.PharmacySettings.GeneralTab.class).saveChanges();
        page.GetInstance(AdminSettings.PharmacySettings.GeneralTab.class).assertUploads("Settings saved successfully");
    }

    @Test(enabled = true, priority = 4)
    public void general_LogoUpload() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminSettings.class).enter_PharmacySettings();
        Thread.sleep(3000);
        // page.GetInstance(AdminSettings.PharmacySettings.class).enter_GeneralTab();
        page.GetInstance(AdminSettings.PharmacySettings.GeneralTab.class).uploadLogo(Variables.uploadJS);
        page.GetInstance(AdminSettings.PharmacySettings.GeneralTab.class).saveChanges();
        page.GetInstance(AdminSettings.PharmacySettings.GeneralTab.class).assertUploads("Settings saved successfully");
    }

    @Test(enabled = true, priority = 5)
    public void upload_logo() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).uploadLogo(Variables.uploadJS);
        page.GetInstance(PractitionerProfilePage.class).saveLogo();
        page.GetInstance(PractitionerProfilePage.class).assertChange("Your data has been successfully saved.");
    }

    @Test(enabled = true, priority = 6)
    public void upload_certificate() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).uploadCertificate(Variables.uploadJS);
        page.GetInstance(PractitionerProfilePage.class).complete_userProfile();
        page.GetInstance(PractitionerProfilePage.class).saveCertificate();
        page.GetInstance(PractitionerProfilePage.class).assertChange("Your data has been successfully saved.");
    }
    // IMPORTS AND UPLOADS - DONE
}
