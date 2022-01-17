package tests;

import constants.ITestConstantsUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestClassFinder;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.DashboardPage;
import pages.HeaderPage;
import pages.LoginPage;
import steps.LoginSteps;
import util.TestListener;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstantsUI {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    LoginSteps loginSteps;
    HeaderPage headerPage;

    @BeforeMethod
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
