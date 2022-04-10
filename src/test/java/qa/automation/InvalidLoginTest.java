package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CsvHelper;

import java.io.IOException;

public class InvalidLoginTest extends TestUtil {

   @DataProvider (name = "csvInvalidUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException{
   return CsvHelper.readCsvFile("src/test/resources/invalidusers.csv");
    }

    @Test(dataProvider = "csvInvalidUserList")
    public void UnsuccessfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryToLogin(userName, password);
        Assert.assertTrue(loginPage.isLoginErrorMessageShown(), "Error message is not shown!");
    }
}
