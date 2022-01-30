package ui_tests;

import constants.ITestConstantsUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
import steps.EditTestCaseSteps;
import steps.LoginSteps;
import steps.MilestoneSteps;
import steps.TestCaseSteps;
import util.Retry;
import util.TestListener;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest implements ITestConstantsUI {

    WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public LoginSteps loginSteps;
    public HeaderPage headerPage;
    CaseDetailsPage caseDetailsPage;
    CreateTestCasePage createTestCasePage;
    TestCasesListOverviewPage testCasesListOverviewPage;
    ConfirmationTestCaseModalPage confirmationTestCaseModalPage;
    EditTestCasePage editTestCasePage;
    ReviewChangesPage reviewChangesPage;
    TestCaseSteps testCaseSteps;
    EditTestCaseSteps editTestCaseSteps;
    ProjectDetailsPage projectDetailsPage;
    CreateMilestonePage createMilestonePage;
    MilestonesListOverviewPage milestonesListOverviewPage;
    MilestoneDetailsPage milestoneDetailsPage;
    MilestoneSteps milestoneSteps;
    ConfirmationMilestoneModalPage confirmationMilestoneModalPage;
    StartMilestoneModalPage startMilestoneModalPage;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzer(new Retry());
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void initTest(ITestContext iTestContext) {
        initBrowser();
        driver.manage().window().maximize();
        log.debug("Browser is started in fullscreen mode");
        String driverVariable = "driver";
        iTestContext.setAttribute(driverVariable, driver);
        initPage();
    }

    public void initBrowser() {
        if (System.getProperty("browser") != null) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    log.debug("Chrome browser is started");
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    log.debug("Edge browser is started");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    log.debug("Firefox browser is started");
                    break;
            }
        } else {
            try {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } catch (Exception e) {
                log.fatal("FATAL ERROR: Driver is not started");
            }
        }
    }

    public void initPage() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginSteps = new LoginSteps(driver);
        headerPage = new HeaderPage(driver);
        caseDetailsPage = new CaseDetailsPage(driver);
        createTestCasePage = new CreateTestCasePage(driver);
        testCasesListOverviewPage = new TestCasesListOverviewPage(driver);
        confirmationTestCaseModalPage = new ConfirmationTestCaseModalPage(driver);
        editTestCasePage = new EditTestCasePage(driver);
        reviewChangesPage = new ReviewChangesPage(driver);
        testCaseSteps = new TestCaseSteps(driver);
        editTestCaseSteps = new EditTestCaseSteps(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        createMilestonePage = new CreateMilestonePage(driver);
        milestonesListOverviewPage = new MilestonesListOverviewPage(driver);
        milestoneDetailsPage = new MilestoneDetailsPage(driver);
        milestoneSteps = new MilestoneSteps(driver);
        confirmationMilestoneModalPage = new ConfirmationMilestoneModalPage(driver);
        startMilestoneModalPage = new StartMilestoneModalPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
