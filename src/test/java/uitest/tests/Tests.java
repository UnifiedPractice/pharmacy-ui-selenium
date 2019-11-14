// Ranorex Webtestit Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.Variables;
import uitest.databaseConnection.DatabaseConnection;
import uitest.enums.operationTypeEnum;
import uitest.pageobjects.*;

import org.testng.annotations.Test;

class Tests extends TestNgTestBase {

    @Test
    public void ValidCredentials() {

        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        // page.GetInstance(DashboardPage.class).verifyLogin(Variables.patientListBtn);

    }

    @Test
    public void InvalidCredentials() {
        page.GetInstance(LoginPage.class).login(Variables.invalidUser, Variables.invalidPass);
        page.GetInstance(LoginPage.class).verify_invalidUser();
    }

    @Test
    public void AddNewPatient() throws InterruptedException {
        page.GetInstance(LoginPage.class).login(Variables.admin, Variables.pass);
        page.GetInstance(PatientlistPage.class).addPatient();
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
}
