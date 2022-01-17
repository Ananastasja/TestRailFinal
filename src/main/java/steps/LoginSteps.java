package steps;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.HeaderPage;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private HeaderPage headerPage;
    WebDriver driver;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    public LoginSteps loginAndClickLoginBtn(String email, String password) {
        loginPage.openLoginPage()
                .enterLoginCreds(email, password)
                .clickLogInBtn();
        return this;
    }

    public LoginSteps logInAndLogOut(String email, String password) {
        loginPage.openLoginPage()
                .enterLoginCreds(email, password)
                .clickLogInBtn()
                .logOut();
        return this;
    }
}
