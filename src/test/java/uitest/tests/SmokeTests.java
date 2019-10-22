// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.pageobjects.CommissionsPage;
import uitest.pageobjects.DashboardPage;
import uitest.pageobjects.IngredientsPage;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PatientlistPage;
import uitest.pageobjects.ShippingPage;

class SmokeTests extends TestNgTestBase {

    @Test
    public void placeOrder() {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pPass);
        page.GetInstance(PatientlistPage.class).startOrder();
        page.GetInstance(IngredientsPage.class).addIngredients();
        page.GetInstance(IngredientsPage.class).checkoutOrder();
        page.GetInstance(ShippingPage.class).placeOrder();
        page.GetInstance(PatientlistPage.class).assertOrder(Variables.orderSent);
    }

    @Test
    public void setCommission() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.pPass);
        page.GetInstance(DashboardPage.class).enter_commissionsPage();
        page.GetInstance(CommissionsPage.class).set_Commission();
        page.GetInstance(CommissionsPage.class).assert_Commission();
    }
}
