// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.databaseConnection.DatabaseConnection;
import uitest.enums.operationTypeEnum;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.AdminSettings;
import uitest.pageobjects.CommissionsPage;
import uitest.pageobjects.CouponCodesPage;
import uitest.pageobjects.InventoryPages;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PatientlistPage;
import uitest.pageobjects.PractitionerHomePage;

class SmokeTests extends TestNgTestBase {

    Variables variables;

    @Test // DONE
    public void setCommission() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PractitionerHomePage.class).enter_commissionsPage();
        page.GetInstance(CommissionsPage.class).set_Commission();
        page.GetInstance(CommissionsPage.class).assert_Commission();
    }

    @Test // donee
    public void adjustAdd_inventory() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        Thread.sleep(1000);
        page.GetInstance(InventoryPages.ProductCatalog.class).startAdjust();
        page.GetInstance(InventoryPages.ProductCatalog.class).selectItem();
        page.GetInstance(InventoryPages.ProductCatalog.class).quantityAddition(Variables.lotQuantity);
        page.GetInstance(InventoryPages.ProductCatalog.class).assertChange(Variables.succesfulAdjustment);
    }

    @Test // done
    public void adjustRemove_inventory() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        Thread.sleep(1000);
        page.GetInstance(InventoryPages.ProductCatalog.class).startAdjust();
        page.GetInstance(InventoryPages.ProductCatalog.class).selectItem();
        page.GetInstance(InventoryPages.ProductCatalog.class).quantityRemoval(Variables.lotQuantity);
        page.GetInstance(InventoryPages.ProductCatalog.class).assertChange(Variables.succesfulAdjustment);
    }

    @Test // done
    public void receive_inventory() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_ProductCatalog();
        Thread.sleep(1000);
        page.GetInstance(InventoryPages.ProductCatalog.class).startReceive();
        page.GetInstance(InventoryPages.ProductCatalog.class).selectItem();
        page.GetInstance(InventoryPages.ProductCatalog.class).quantityReceival(Variables.lotQuantity,
                Variables.expiryDate);
        page.GetInstance(InventoryPages.ProductCatalog.class).assertChange(Variables.succesfulReceival);
    }

    @Test // test case to be done with order with coupon applied
    public void add_new_coupon() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_CouponCodes();
        page.GetInstance(CouponCodesPage.class).set_new_Coupon("description", "$2", "23", Variables.Active_from_Date,
                Variables.Active_toDate, "3");
    }

    @Test // not done(not able to type-out in input)
    public void medium_Management() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(InventoryPages.class).enter_MediumManagement();
        page.GetInstance(InventoryPages.MediumManagement.class).addMedium();
        page.GetInstance(InventoryPages.MediumManagement.class).assertMedium();
    }

    @Test // done
    public void invalidCredentials() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.invalidUser, Variables.invalidPass);
        page.GetInstance(LoginPage.class).assert_wrongUser_errorMessage(Variables.loginEM);
    }

    @Test
    public void addNewPatient() {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PatientlistPage.class).completeCredentials("claudiu.maxim@omnisourcetech.com", "Maxim",
                "Claudiu", "birthday", "0722222222");
        page.GetInstance(PatientlistPage.class).savePatient();
        
    }

    @Test
    public void orderHour() {
        String sqlQuery = "UPDATE [pharmacy].[dispensing].[Orders] SET PlacedOn = DATEADD(hh, - 1, (CURRENT_TIMESTAMP)) WHERE PlacedOn = (SELECT TOP 1 PlacedOn FROM [pharmacy].[dispensing].[Orders] ORDER BY Id DESC)";
        // String expectedEmpName = "Melissa";
        // Getting employee name by Id
        String actualEmpNameById = DatabaseConnection.executeSQLQuery("QA", sqlQuery, operationTypeEnum.Update);
        // System.out.println("Employee name retrieved from database :" +
        // actualEmpNameById);
        // Assert.assertEquals(actualEmpNameById, expectedEmpName);
    }

    @Test // done
    public void shipping_method() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminSettings.class).enter_PharmacySettings();
        page.GetInstance(AdminSettings.PharmacySettings.class).enter_ShippingPaymentTab();
        page.GetInstance(AdminSettings.PharmacySettings.ShippingPaymentTab.class).addShippingMethod();
        page.GetInstance(AdminSettings.PharmacySettings.ShippingPaymentTab.class).saveChanges();
        page.GetInstance(AdminSettings.PharmacySettings.ShippingPaymentTab.class)
                .assertChanges("Settings saved successfully");
    }

    @Test // dropSelect to implement
    public void set_EphedraProduct() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminSettings.class).enter_PharmacySettings();
        page.GetInstance(AdminSettings.PharmacySettings.class).enter_EphedraProductTab();
        page.GetInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).selectProduct();
        page.GetInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).setThresholds();
        page.GetInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).uploadWaiver(Variables.uploadJS);
        page.GetInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).saveEphedra();
        page.GetInstance(AdminSettings.PharmacySettings.EphedraProductTab.class)
                .assertChanges("Settings saved successfully");
    }

    @Test // done
    public void send_AdminInvitation() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminSettings.class).enter_UserList();
        page.GetInstance(AdminSettings.UserList.class).send_Admin_Invitation();
        page.GetInstance(AdminSettings.UserList.class).assert_sentInvitation("Invite has been sent.");
    }//

    @Test // done
    public void send_CompounderInvitation() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminSettings.class).enter_UserList();
        page.GetInstance(AdminSettings.UserList.class).send_Compounder_Invitation();
        page.GetInstance(AdminSettings.UserList.class).assert_sentInvitation("Invite has been sent.");
    }

    @Test // done
    public void send_CSRInvitation() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminSettings.class).enter_UserList();
        page.GetInstance(AdminSettings.UserList.class).send_CSR_Invitation();
        page.GetInstance(AdminSettings.UserList.class).assert_sentInvitation("Invite has been sent.");
    }
}
