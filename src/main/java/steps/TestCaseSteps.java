package steps;

import objects.ui.TestCase;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TestCasePage;
import pages.TestCasesListPage;

public class TestCaseSteps {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public TestCasePage testCasePage;
    TestCasesListPage testCasesListPage;

    public TestCaseSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        testCasePage = new TestCasePage(driver);
        testCasesListPage = new TestCasesListPage(driver);
    }

    public TestCaseSteps addTestCase(TestCase testCase) {
        dashboardPage.clickOnTestCasesLink()
                .clickOnAddTestCaseBtn()
                .fillAllTestCaseFields(testCase)
                .clickAddTestCaseBtn();
        return this;
    }

    public TestCaseSteps addTestCaseAndAddNewOne(TestCase testCase) {
        dashboardPage.clickOnTestCasesLink()
                .clickOnAddTestCaseBtn()
                .fillAllTestCaseFields(testCase)
                .clickAddAndNextBtn();
        return this;
    }

    public TestCaseSteps openTestCasePageAndClickCancel() {
        dashboardPage.clickOnTestCasesLink()
                .clickOnAddTestCaseBtn()
                .clickCancelCaseBtn();
        return this;
    }

    public TestCaseSteps loginAndOpenTestCasesListPage(String email, String password) {
        loginPage.openLoginPage()
                .enterLoginCreds(email, password)
                .clickLogInBtn()
                .clickOnTestCasesLink();
        return this;
    }
}
