package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import databaseConnection.DatabaseConnection;
import enums.operationTypeEnum;
import pages.AdminHomePage;
import pages.AdminSettings;
import pages.CommissionsPage;
import pages.CouponCodesPage;
import pages.InventoryPages;
import pages.LoginPage;
import pages.PatientListPage;
import pages.PractitionerHomePage;
import variables.Variables;
@Listeners(ListenersPackage.TestsListener.class)
public class SmokeTests extends BaseTest {
	
	String admin = getCredentials().get("admin");
	String practitioner = getCredentials().get("practitioner");
	String CSR = getCredentials().get("CSR");
	
	@Test(enabled = true, priority = 1)
	public void setCommission() throws InterruptedException {
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
		page.getInstance(PractitionerHomePage.class).enter_CommissionsPage();
		page.getInstance(CommissionsPage.class).set_Commission("5");
		Thread.sleep(1500);
		page.getInstance(CommissionsPage.class).assert_Commission(Variables.unEscapedHTML);
	}

	@Test(enabled = false, priority = 1)
	public void adjustAdd_inventory() throws InterruptedException {
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(InventoryPages.class).enter_ProductCatalog();
		Thread.sleep(1000);
		page.getInstance(InventoryPages.ProductCatalog.class).startAdjust();
		page.getInstance(InventoryPages.ProductCatalog.class).selectItem();
		page.getInstance(InventoryPages.ProductCatalog.class).quantityAddition(Variables.lotQuantity);
		page.getInstance(InventoryPages.ProductCatalog.class).assertAdjustment(Variables.succesfulAdjustment);
	}

	@Test(enabled = false, priority = 1)
	public void adjustRemove_inventory() throws InterruptedException {
		
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(InventoryPages.class).enter_ProductCatalog();
		Thread.sleep(1000);
		page.getInstance(InventoryPages.ProductCatalog.class).startAdjust();
		page.getInstance(InventoryPages.ProductCatalog.class).selectItem();
		page.getInstance(InventoryPages.ProductCatalog.class).quantityRemoval(Variables.lotQuantity);
		page.getInstance(InventoryPages.ProductCatalog.class).assertAdjustment(Variables.succesfulAdjustment);
	}

	@Test(enabled = false, priority = 1)
	public void receive_inventory() throws InterruptedException {

		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(InventoryPages.class).enter_ProductCatalog();
		Thread.sleep(1000);
		page.getInstance(InventoryPages.ProductCatalog.class).startReceive();
		page.getInstance(InventoryPages.ProductCatalog.class).selectItem();
		page.getInstance(InventoryPages.ProductCatalog.class).quantityReceival(Variables.lotQuantity,
				Variables.expiryDate);
		page.getInstance(InventoryPages.ProductCatalog.class).assertAdjustment(Variables.succesfulReceival);
	}

	@Test(enabled = false, priority = 1)
	public void add_new_coupon() throws InterruptedException {

		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminHomePage.class).enter_CouponCodesPage();
		page.getInstance(CouponCodesPage.class).createCoupon("SUN000012", "description", "$2", "23",
				Variables.Active_from_Date, Variables.Active_toDate, "3");

	}

	@Test(enabled = false, priority = 2)
	public void medium_Management() {

		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(InventoryPages.class).enter_MediumManagement();
		page.getInstance(InventoryPages.MediumManagement.class).addMedium("MediumName");
		page.getInstance(InventoryPages.MediumManagement.class).assertMedium(Variables.mediumMessage);
	}

	@Test(enabled = false, priority = 1)
	public void invalidCredentials() throws InterruptedException {
		page.getInstance(LoginPage.class).login(Variables.invalidUser, Variables.invalidPass);
		page.getInstance(LoginPage.class).assert_wrongUser_errorMessage(Variables.loginEM);
	}

	@Test(enabled = false, priority = 3)
	public void addNewPatient() {
		page.getInstance(LoginPage.class).login(practitioner.split(":")[0], practitioner.split(":")[1]);
		page.getInstance(PatientListPage.class).completeCredentials(Variables.emailAddress, "Maxim", "Claudiu",
				Variables.dObOption, Variables.phoneNumber);
		page.getInstance(PatientListPage.class).savePatient();
	}

	@Test(enabled = false)
	public void orderHour() {
		String sqlQuery = "UPDATE [pharmacy].[dispensing].[Orders] SET PlacedOn = DATEADD(hh, - 1, (CURRENT_TIMESTAMP)) WHERE PlacedOn = (SELECT TOP 1 PlacedOn FROM [pharmacy].[dispensing].[Orders] ORDER BY Id DESC)";
		// String expectedEmpName = "Melissa";
		// Getting employee name by Id
		String actualEmpNameById = DatabaseConnection.executeSQLQuery("QA", sqlQuery, operationTypeEnum.Update);
		System.out.println("Query is: " + actualEmpNameById);
		// System.out.println("Employee name retrieved from database :" +
		// actualEmpNameById);
		// Assert.assertEquals(actualEmpNameById, expectedEmpName);
	}

	@Test(enabled = false, priority = 1)
	public void shipping_method() {
		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminSettings.class).enter_PharmacySettings();
		page.getInstance(AdminSettings.PharmacySettings.class).enter_ShippingPaymentTab();
		page.getInstance(AdminSettings.PharmacySettings.ShippingPaymentTab.class).addShippingMethod();
		page.getInstance(AdminSettings.PharmacySettings.ShippingPaymentTab.class).saveChanges();
		page.getInstance(AdminSettings.PharmacySettings.ShippingPaymentTab.class)
				.assert_ShippingMethod_addition(Variables.shippingMethodMessage);
	}

	/*
	 * @Test // dropSelect to implement public void set_EphedraProduct() {
	 * 
	 * page.getInstance(LoginPage.class).login(Variables.admin,
	 * Variables.actualPass);
	 * page.getInstance(AdminSettings.class).enter_PharmacySettings();
	 * page.getInstance(AdminSettings.PharmacySettings.class).
	 * enter_EphedraProductTab();
	 * page.getInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).
	 * selectProduct();
	 * page.getInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).
	 * setThresholds();
	 * page.getInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).
	 * uploadWaiver(Variables.uploadJS);
	 * page.getInstance(AdminSettings.PharmacySettings.EphedraProductTab.class).
	 * saveEphedra();
	 * page.getInstance(AdminSettings.PharmacySettings.EphedraProductTab.class)
	 * .assertChanges("Settings saved successfully"); }
	 */

	@Test(enabled = false, priority = 4)
	public void send_AdminInvitation() {

		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminSettings.class).enter_UserList();
		page.getInstance(AdminSettings.UserList.class).send_Admin_Invitation();
		page.getInstance(AdminSettings.UserList.class).assert_sentInvitation(Variables.invititationMessage);
	}

	@Test(enabled = false, priority = 5)
	public void send_CompounderInvitation() {

		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminSettings.class).enter_UserList();
		page.getInstance(AdminSettings.UserList.class).send_Compounder_Invitation();
		page.getInstance(AdminSettings.UserList.class).assert_sentInvitation(Variables.invititationMessage);
	}

	@Test(enabled = false, priority = 6)
	public void send_CSRInvitation() {

		page.getInstance(LoginPage.class).login(admin.split(":")[0], admin.split(":")[1]);
		page.getInstance(AdminSettings.class).enter_UserList();
		page.getInstance(AdminSettings.UserList.class).send_CSR_Invitation();
		page.getInstance(AdminSettings.UserList.class).assert_sentInvitation(Variables.invititationMessage);
	}
	//DONE

}
