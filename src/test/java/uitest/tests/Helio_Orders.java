// Ranorex Webtestit Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.databaseConnection.DatabaseConnection;
import uitest.enums.operationTypeEnum;
import uitest.pageobjects.*;

import org.testng.annotations.Test;

class Helio_Orders extends TestNgTestBase {
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

    @Test
    public void placeOrder_withCoupon() {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PatientlistPage.class).startOrder();
        page.GetInstance(PatientlistPage.IngredientsPage.class).addIngredients();
        page.GetInstance(PatientlistPage.IngredientsPage.class).roundupIngredients();
        page.GetInstance(PatientlistPage.IngredientsPage.class).checkoutOrder();
        page.GetInstance(PatientlistPage.PlaceOrderPage.class).apply_coupon();
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
}
