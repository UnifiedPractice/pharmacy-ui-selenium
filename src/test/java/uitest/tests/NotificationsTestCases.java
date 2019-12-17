// Ranorex Webtestit Test File

package uitest.tests;

import org.testng.annotations.Test;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.databaseConnection.DatabaseConnection;
import uitest.enums.operationTypeEnum;
import uitest.pageobjects.AdminHomePage;
import uitest.pageobjects.DispensaryPage;
import uitest.pageobjects.HangfirePage;
import uitest.pageobjects.LoginPage;
import uitest.pageobjects.PatientlistPage;

class NotificationsTestCases extends TestNgTestBase {

    PatientlistPage patientlistPage;

    @Test // DONE
    public void assert_LateOrder() throws InterruptedException {
        page.GetInstance(LoginPage.class).openHelioscript();
        page.GetInstance(LoginPage.class).login(Variables.practitioner, Variables.actualPass);
        page.GetInstance(PatientlistPage.class).startOrder();
        page.GetInstance(PatientlistPage.IngredientsPage.class).addIngredients();
        page.GetInstance(PatientlistPage.IngredientsPage.class).roundupIngredients();
        page.GetInstance(PatientlistPage.IngredientsPage.class).checkoutOrder();
        page.GetInstance(PatientlistPage.PlaceOrderPage.class).placeOrder();
        String sqlQuery = "UPDATE [pharmacy].[dispensing].[Orders] SET PlacedOn = DATEADD(hh, - 1, (CURRENT_TIMESTAMP)) WHERE PlacedOn = (SELECT TOP 1 PlacedOn FROM [pharmacy].[dispensing].[Orders] ORDER BY Id DESC)";
        String actualEmpNameById = DatabaseConnection.executeSQLQuery("QA", sqlQuery, operationTypeEnum.Update);
        page.GetInstance(HangfirePage.class).trigger_lateOrder();
        page.GetInstance(PatientlistPage.class).closeSentOrder();
        page.GetInstance(PatientlistPage.class).logout();
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.actualPass);
        page.GetInstance(AdminHomePage.class).enter_Dispensary();
        page.GetInstance(DispensaryPage.class).seeNotifications();
        page.GetInstance(DispensaryPage.class).assertLateOrder();

    }
}
