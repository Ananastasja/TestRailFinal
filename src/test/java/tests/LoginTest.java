package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.PropertyReader;

public class LoginTest extends BaseTest{

    @Test(description = "Login using valid creds", groups = {"Smoke", "Regression", "Positive"})
    public void loginWithValidCredsTest() {
        loginSteps.loginAndClickLoginBtn(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")));
        Assert.assertTrue(dashboardPage.isDashboardVisible());
    }

    @Test(description = "Login using invalid creds", groups = {"Regression", "Negative"})
    public void loginWithInvalidCredsTest() {
        loginSteps.loginAndClickLoginBtn(INVALID_EMAIL, INVALID_PASSWORD);
        Assert.assertEquals(loginPage.getErrorText(), ERROR_MESSAGE_LOGIN);
    }

    @Test(description = "Log out from Dashboard page", groups = {"Smoke", "Regression", "Positive"})
    public void logOutTest() {
        loginSteps.logInAndLogOut(System.getProperty("email", PropertyReader.getProperty("email")), System.getProperty("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(loginPage.getLoginBoxText(), LOGIN_BOX_TEXT);
    }
}
