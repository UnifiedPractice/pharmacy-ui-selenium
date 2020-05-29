package tests;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import databaseConnection.DatabaseConnection;
import enums.operationTypeEnum;
import pages.AdminHomePage;
import pages.DispensaryPage;
import pages.HangfirePage;
import pages.LoginPage;
import pages.PatientListPage;
import variables.Variables;
public class Orders extends BaseTest {
	
	String admin = getCredentials().get("admin");
	String practitioner = getCredentials().get("practitioner");
	String CSR = getCredentials().get("CSR");
	
	@Test(enabled = true, priority = 1)
	public void placeOrder() throws InterruptedException {
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
		page.getInstance(PatientListPage.class).startOrder();
		page.getInstance(PatientListPage.IngredientsPage.class).addIngredients();
		page.getInstance(PatientListPage.IngredientsPage.class).roundupIngredients("100");
		page.getInstance(PatientListPage.IngredientsPage.class).checkoutOrder();
		page.getInstance(PatientListPage.PlaceOrderPage.class).placeOrder();
		page.getInstance(PatientListPage.class).assertOrder(Variables.orderSent);
	}
	
	@Test(enabled = true, priority = 2)
	public void shipOrder() throws InterruptedException {
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
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
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
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
	
	@Test(enabled = true)
	public void orderHour() {
		String sqlQuery = "UPDATE [pharmacy].[dispensing].[Orders] SET PlacedOn = DATEADD(hh, - 1, (CURRENT_TIMESTAMP)) WHERE PlacedOn = (SELECT TOP 1 PlacedOn FROM [pharmacy].[dispensing].[Orders] ORDER BY Id DESC)";
		// String expectedEmpName = "Melissa";
		// Getting employee name by Id
		String actualEmpNameById = DatabaseConnection.executeSQLQuery("QA", sqlQuery, operationTypeEnum.Update);
		System.out.println("Query is :"  + actualEmpNameById);
		// System.out.println("Employee name retrieved from database :" +
		// actualEmpNameById);
		// Assert.assertEquals(actualEmpNameById, expectedEmpName);
	}

}
