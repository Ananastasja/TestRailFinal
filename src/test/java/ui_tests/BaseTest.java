package ui_tests;

import constants.ITestConstantsUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.EditTestCaseSteps;
import steps.LoginSteps;
import steps.MilestoneSteps;
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
    TestCasesListOverviewPage testCasesListOverviewPage;
    ConfirmationTestCaseModalPage confirmationTestCaseModalPage;
    EditTestCasePage editTestCasePage;
    ReviewChangesPage reviewChangesPage;
    TestCaseSteps testCaseSteps;
    EditTestCaseSteps editTestCaseSteps;
    ProjectDetailsPage projectDetailsPage;
    MilestonePage milestonePage;
    MilestonesListOverviewPage milestonesListOverviewPage;
    MilestoneDetailsPage milestoneDetailsPage;
    MilestoneSteps milestoneSteps;
    ConfirmationMilestoneModalPage confirmationMilestoneModalPage;
    StartMilestoneModalPage startMilestoneModalPage;

    @BeforeMethod
    public void initTest() {
        if (System.getProperty("browser") != null) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        initPage();
    }

    public void initPage() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginSteps = new LoginSteps(driver);
        headerPage = new HeaderPage(driver);
        caseDetailsPage = new CaseDetailsPage(driver);
        testCasePage = new TestCasePage(driver);
        testCasesListOverviewPage = new TestCasesListOverviewPage(driver);
        confirmationMilestoneModalPage = new ConfirmationMilestoneModalPage(driver);
        editTestCasePage = new EditTestCasePage(driver);
        reviewChangesPage = new ReviewChangesPage(driver);
        testCaseSteps = new TestCaseSteps(driver);
        editTestCaseSteps = new EditTestCaseSteps(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        milestonePage = new MilestonePage(driver);
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
