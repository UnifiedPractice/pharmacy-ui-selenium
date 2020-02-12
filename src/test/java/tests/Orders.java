package tests;

import org.testng.annotations.Test;

import databaseConnection.DatabaseConnection;
import enums.operationTypeEnum;
import pages.AdminHomePage;
import pages.DispensaryPage;
import pages.HangfirePage;
import pages.LoginPage;
import pages.PatientListPage;
import variables.Variables;

public class Orders extends BaseTest {

	@Test(enabled = true, priority = 1)
	public void placeOrder() throws InterruptedException {
		page.getInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
		page.getInstance(PatientListPage.class).startOrder();
		page.getInstance(PatientListPage.IngredientsPage.class).addIngredients();
		page.getInstance(PatientListPage.IngredientsPage.class).roundupIngredients("100");
		page.getInstance(PatientListPage.IngredientsPage.class).checkoutOrder();
		page.getInstance(PatientListPage.PlaceOrderPage.class).placeOrder();
		page.getInstance(PatientListPage.class).assertOrder(Variables.orderSent);
	}
	
	@Test(enabled = true, priority = 2)
	public void shipOrder() throws InterruptedException {
		page.getInstance(LoginPage.class).login(Variables.admin,Variables.actualPass);
		page.getInstance(AdminHomePage.class).enter_DispensaryPage();
		page.getInstance(DispensaryPage.class).startOrder();
		Thread.sleep(7000);
		page.getInstance(DispensaryPage.ShippingPage.class).selectItem();
		page.getInstance(DispensaryPage.ShippingPage.class).completeQuantities();
		page.getInstance(DispensaryPage.ShippingPage.class).shipOrder();
		page.getInstance(DispensaryPage.class).assertOrder("Orders list");
	}

	@Test(enabled = true, priority = 3)
	public void assert_LateOrder() throws InterruptedException {
		page.getInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
		page.getInstance(PatientListPage.class).startOrder();
		page.getInstance(PatientListPage.IngredientsPage.class).addIngredients();
		page.getInstance(PatientListPage.IngredientsPage.class).roundupIngredients("100");
		page.getInstance(PatientListPage.IngredientsPage.class).checkoutOrder();
		page.getInstance(PatientListPage.PlaceOrderPage.class).placeOrder();
		String sqlQuery = "UPDATE [pharmacy].[dispensing].[Orders] SET PlacedOn = DATEADD(hh, - 1, (CURRENT_TIMESTAMP)) WHERE PlacedOn = (SELECT TOP 1 PlacedOn FROM [pharmacy].[dispensing].[Orders] ORDER BY Id DESC)";
		String actualEmpNameById = DatabaseConnection.executeSQLQuery("QA", sqlQuery, operationTypeEnum.Update);
		System.out.println("Actual name is: " + actualEmpNameById);
		page.getInstance(HangfirePage.class).trigger_LateOrder();
		page.getInstance(PatientListPage.class).closeSentOrder();
		page.getInstance(PatientListPage.class).logout();
		page.getInstance(LoginPage.class).login("admin@mail.com", "Up1234$#@!");
		page.getInstance(AdminHomePage.class).enter_DispensaryPage();
		page.getInstance(DispensaryPage.class).enter_NotificationsBar();
		page.getInstance(DispensaryPage.class).assertLateOrder("Late Order");
	}

}