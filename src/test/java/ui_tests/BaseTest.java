package ui_tests;

import constants.ITestConstantsUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.EditTestCaseSteps;
import steps.LoginSteps;
import steps.TestCaseSteps;
import util.TestListener;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstantsUI {

    WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected LoginSteps loginSteps;
    HeaderPage headerPage;
    CaseDetailsPage caseDetailsPage;
    TestCasePage testCasePage;
    TestCasesOverviewPage testCasesOverviewPage;
    ConfirmationTestCaseModalPage confirmationTestCaseModalPage;
    EditTestCasePage editTestCasePage;
    ReviewChangesPage reviewChangesPage;
    TestCaseSteps testCaseSteps;
    EditTestCaseSteps editTestCaseSteps;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initPage();
    }

    public void initPage() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginSteps = new LoginSteps(driver);
        headerPage = new HeaderPage(driver);
        caseDetailsPage = new CaseDetailsPage(driver);
        testCasePage = new TestCasePage(driver);
        testCasesOverviewPage = new TestCasesOverviewPage(driver);
        confirmationTestCaseModalPage = new ConfirmationTestCaseModalPage(driver);
        editTestCasePage = new EditTestCasePage(driver);
        reviewChangesPage = new ReviewChangesPage(driver);
        testCaseSteps = new TestCaseSteps(driver);
        editTestCaseSteps = new EditTestCaseSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
