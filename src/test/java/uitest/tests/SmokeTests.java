// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.BasePage;
import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.CommissionsPage;
import uitest.pageobjects.CouponCodesPage;
import uitest.pageobjects.DispensaryPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.PractitionerProfilePage;
import uitest.pageobjects.ProductCatalogPage;
import uitest.pageobjects.RegistrationPage;
import uitest.pageobjects.ShippingPage;
import uitest.pageobjects.IngredientsPage;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PatientlistPage;
import uitest.pageobjects.PlaceOrderPage;
import uitest.pageobjects.PatientimportPage;

class SmokeTests extends TestNgTestBase {

    @Test
    public void placeOrder() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PatientlistPage.class).startOrder();
        page.GetInstance(IngredientsPage.class).addIngredients();
        page.GetInstance(IngredientsPage.class).roundupIngredients();
        page.GetInstance(IngredientsPage.class).checkoutOrder();
        page.GetInstance(PlaceOrderPage.class).test();
        page.GetInstance(PatientlistPage.class).assertOrder(Variables.orderSent);
    }

    @Test
    public void shipOrder() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_Dispensary();
        page.GetInstance(DispensaryPage.class).startOrder();
        page.GetInstance(ShippingPage.class).select_item();
        page.GetInstance(ShippingPage.class).completeQuantities();
        page.GetInstance(ShippingPage.class).shipOrder();
        page.GetInstance(DispensaryPage.class).assertTitle();
    }

    @Test // done
    public void setCommission() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_commissionsPage();
        page.GetInstance(CommissionsPage.class).set_Commission();
        page.GetInstance(CommissionsPage.class).assert_Commission();
    }

    @Test // done - pending toast messages
    public void adjustAdd_inventory() {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_ProductCatalog();
        page.GetInstance(ProductCatalogPage.class).startAdjust();
        page.GetInstance(ProductCatalogPage.class).selectItem();
        page.GetInstance(ProductCatalogPage.class).quantityAddition(Variables.lotQuantity);
        page.GetInstance(ProductCatalogPage.class).assertChange(Variables.succesfulAdjustment);
    }

    @Test // done - pending toast messages
    public void adjustRemove_inventory() {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_ProductCatalog();
        page.GetInstance(ProductCatalogPage.class).startAdjust();
        page.GetInstance(ProductCatalogPage.class).selectItem();
        page.GetInstance(ProductCatalogPage.class).quantityRemoval(Variables.lotQuantity);
        page.GetInstance(ProductCatalogPage.class).assertChange(Variables.succesfulAdjustment);
    }

    @Test // done - pending toast messages
    public void receive_inventory() {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_ProductCatalog();
        page.GetInstance(ProductCatalogPage.class).startReceive();
        page.GetInstance(ProductCatalogPage.class).selectItem();
        page.GetInstance(ProductCatalogPage.class).quantityReceival(Variables.lotQuantity, Variables.expiryDate);
        page.GetInstance(ProductCatalogPage.class).assertChange(Variables.succesfulAdjustment);
    }

    @Test
    public void add_new_coupon() {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_CouponCodes();
        page.GetInstance(CouponCodesPage.class).set_new_Coupon("description", "$2", "23", Variables.Active_from_Date,
                Variables.Active_toDate, "3");
    }

    @Test // done
    public void patient_import() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_patientImportPage();
        page.GetInstance(PatientimportPage.class).uploadFile(Variables.uploadJS);
        page.GetInstance(PatientimportPage.class).validateFile();
        page.GetInstance(PatientimportPage.class).finishImport();
        page.GetInstance(PatientimportPage.class).assertImport(Variables.successfulImport);
    }

    @Test // done - pending toast messages
    public void upload_logo() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_myAccountPage();
        page.GetInstance(PractitionerProfilePage.class).uploadLogo(Variables.uploadJS);
        page.GetInstance(PractitionerProfilePage.class).saveLogo();
    }

    @Test // done
    public void practitionerRegistration() throws InterruptedException {
        page.GetInstance(LoginPage.class).enter_Registration();
        page.GetInstance(RegistrationPage.class).writeCredentials();
        page.GetInstance(RegistrationPage.class).selectDropdowns();
        page.GetInstance(RegistrationPage.class).uploadLicense(Variables.uploadJS);
        page.GetInstance(RegistrationPage.class).submitApplication();
        Thread.sleep(5000);
    }

}
