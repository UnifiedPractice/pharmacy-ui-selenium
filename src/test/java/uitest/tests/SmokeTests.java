// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.AdminSettings;
import uitest.pageobjects.CommissionsPage;
import uitest.pageobjects.CouponCodesPage;
import uitest.pageobjects.DispensaryPage;
import uitest.pageobjects.InventoryPages;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PatientimportPage;
import uitest.pageobjects.PatientlistPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.PractitionerProfilePage;
import uitest.pageobjects.RegistrationPage;

class SmokeTests extends TestNgTestBase {

    PatientlistPage patientlistPage;

    @Test // DONE
    public void placeOrder() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PatientlistPage.class).startOrder();
        page.GetInstance(PatientlistPage.IngredientsPage.class).addIngredients();
        page.GetInstance(PatientlistPage.IngredientsPage.class).roundupIngredients();
        page.GetInstance(PatientlistPage.IngredientsPage.class).checkoutOrder();
        page.GetInstance(PatientlistPage.PlaceOrderPage.class).placeOrder();
        page.GetInstance(PatientlistPage.class).get_orderName();
        page.GetInstance(PatientlistPage.class).assertOrder(Variables.orderSent);
    }

    @Test // DONE
    public void shipOrder() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_Dispensary();
        page.GetInstance(DispensaryPage.class).startOrder();
        page.GetInstance(DispensaryPage.ShippingPage.class).select_item();
        page.GetInstance(DispensaryPage.ShippingPage.class).completeQuantities();
        page.GetInstance(DispensaryPage.ShippingPage.class).shipOrder();
        page.GetInstance(DispensaryPage.class).assertTitle();
    }

    @Test // DONE
    public void setCommission() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_commissionsPage();
        page.GetInstance(CommissionsPage.class).set_Commission();
        page.GetInstance(CommissionsPage.class).assert_Commission();
    }

    @Test // done
    public void adjustAdd_inventory() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        page.GetInstance(InventoryPages.ProductCatalog.class).startAdjust();
        page.GetInstance(InventoryPages.ProductCatalog.class).selectItem();
        page.GetInstance(InventoryPages.ProductCatalog.class).quantityAddition(Variables.lotQuantity);
        page.GetInstance(InventoryPages.ProductCatalog.class).assertChange(Variables.succesfulAdjustment);
    }

    @Test // done - pending toast messages
    public void adjustRemove_inventory() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        page.GetInstance(InventoryPages.ProductCatalog.class).startAdjust();
        page.GetInstance(InventoryPages.ProductCatalog.class).selectItem();
        page.GetInstance(InventoryPages.ProductCatalog.class).quantityRemoval(Variables.lotQuantity);
        page.GetInstance(InventoryPages.ProductCatalog.class).assertChange(Variables.succesfulAdjustment);
    }

    @Test // done - pending toast messages
    public void receive_inventory() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        page.GetInstance(InventoryPages.ProductCatalog.class).startReceive();
        page.GetInstance(InventoryPages.ProductCatalog.class).selectItem();
        page.GetInstance(InventoryPages.ProductCatalog.class).quantityReceival(Variables.lotQuantity,
                Variables.expiryDate);
        page.GetInstance(InventoryPages.ProductCatalog.class).assertChange(Variables.succesfulReceival);
    }

    @Test // test case to be done with order with coupon applied
    public void add_new_coupon() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_CouponCodes();
        page.GetInstance(CouponCodesPage.class).set_new_Coupon("description", "$2", "23", Variables.Active_from_Date,
                Variables.Active_toDate, "3");
    }

    @Test // dones
    public void patient_import() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_patientImportPage();
        page.GetInstance(PatientimportPage.class).uploadFile(Variables.uploadJS);
        page.GetInstance(PatientimportPage.class).validateFile();
        page.GetInstance(PatientimportPage.class).finishImport();
        page.GetInstance(PatientimportPage.class).assertImport(Variables.successfulPatientImport);
    }

    @Test // done - pending toast messages
    public void upload_logo() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).uploadLogo(Variables.uploadJS);
        page.GetInstance(PractitionerProfilePage.class).saveLogo();
    }

    @Test // done
    public void practitionerRegistration() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).enter_Registration();
        page.GetInstance(RegistrationPage.class).writeCredentials();
        page.GetInstance(RegistrationPage.class).selectDropdowns();
        page.GetInstance(RegistrationPage.class).uploadLicense(Variables.uploadJS);
        page.GetInstance(RegistrationPage.class).submitApplication();
    }

    @Test
    public void practitioner_RegistrationApproval() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_PractitionerApplications();
        page.GetInstance(AdminSettings.PractitionerApplications.class).selectStatus_New();
        page.GetInstance(AdminSettings.PractitionerApplications.class).approve_application();
        page.GetInstance(AdminSettings.PractitionerApplications.class).assert_approval(Variables.registrationApproval);
    }

    @Test
    public void change_practitionerPassword() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).changePass_req(Variables.actualPass, Variables.newPass,
                Variables.confirmPass);
        page.GetInstance(PractitionerProfilePage.class).changePassword();
    }

    @Test
    public void import_ChineseNames() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        page.GetInstance(InventoryPages.ProductCatalog.class).uploadFile(Variables.uploadJS);
        page.GetInstance(InventoryPages.ProductCatalog.class)
                .assertImport("You have successfully imported the names for 0 products.");
    }

    @Test
    public void thresholdReport() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ThresholdReport();
        page.GetInstance(InventoryPages.ThresholdReport.class).generateExportList();
        page.GetInstance(InventoryPages.ThresholdReport.class).assertDownload("Threshold Report.csv");
    }

    @Test
    public void expired_LotNumber() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ExpiredLotNumber();
        page.GetInstance(InventoryPages.ExpiredLotNumber.class).exportFile();
        page.GetInstance(InventoryPages.ExpiredLotNumber.class).assertExport("Expired_lot_report_12_19_2019");
    }
}
