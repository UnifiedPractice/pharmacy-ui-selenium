// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.CommissionsPage;
import uitest.pageobjects.DispensaryPage;
import uitest.pageobjects.PractitionerHomePage;
import uitest.pageobjects.ProductCatalogPage;
import uitest.pageobjects.ShippingPage;
import uitest.pageobjects.IngredientsPage;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PatientlistPage;
import uitest.pageobjects.PlaceOrderPage;

class SmokeTests extends TestNgTestBase {

    @Test
    public void placeOrder() {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PatientlistPage.class).startOrder();
        page.GetInstance(IngredientsPage.class).addIngredients();
        page.GetInstance(IngredientsPage.class).checkoutOrder();
        page.GetInstance(PlaceOrderPage.class).placeOrder();
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
    }

    @Test
    public void setCommission() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pass);
        page.GetInstance(PractitionerHomePage.class).enter_commissionsPage();
        page.GetInstance(CommissionsPage.class).set_Commission();
        page.GetInstance(CommissionsPage.class).assert_Commission();
    }

    @Test
    public void adjustAdd_inventory() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_ProductCatalog();
        page.GetInstance(ProductCatalogPage.class).startAdjust();
        page.GetInstance(ProductCatalogPage.class).selectItem();
        page.GetInstance(ProductCatalogPage.class).quantityAddition(Variables.lotQuantity);
        page.GetInstance(ProductCatalogPage.class).assertChange(Variables.succesfullAdjustment);
    }

    @Test
    public void adjustRemove_inventory() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_ProductCatalog();
        page.GetInstance(ProductCatalogPage.class).startAdjust();
        page.GetInstance(ProductCatalogPage.class).selectItem();
        page.GetInstance(ProductCatalogPage.class).quantityRemoval(Variables.lotQuantity);
        page.GetInstance(ProductCatalogPage.class).assertChange(Variables.succesfullAdjustment);
    }

    @Test
    public void receive_inventory() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(AdminHomePage.class).enter_ProductCatalog();
        page.GetInstance(ProductCatalogPage.class).startReceive();
        page.GetInstance(ProductCatalogPage.class).selectItem();
        page.GetInstance(ProductCatalogPage.class).quantityReceival(Variables.lotQuantity, Variables.expiryDate);
        page.GetInstance(ProductCatalogPage.class).assertChange(Variables.succesfullAdjustment);
    }

}
