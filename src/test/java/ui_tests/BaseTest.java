package ui_tests;

import constants.ITestConstantsUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.DashboardPage;
import pages.HeaderPage;
import pages.LoginPage;
import steps.LoginSteps;
import util.TestListener;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstantsUI {

    WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected LoginSteps loginSteps;
    HeaderPage headerPage;

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
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
