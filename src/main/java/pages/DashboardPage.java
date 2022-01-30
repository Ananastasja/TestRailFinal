package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

import java.util.List;

@Log4j2
public class DashboardPage extends HeaderPage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "navigation-dashboard")
    WebElement naviDashboard;
    @FindBy(xpath = "(//div[contains(@class, 'summary')]//a[contains(@href, 'overview')])[1]")
    WebElement lastCreatedProject;
    @FindBy(xpath = "(//p[contains(text(), 'active')]/strong)[1]")
    WebElement numberOfProjects;
    @FindBy(xpath = "//a[contains(text(), 'Test Cases')]")
    WebElement testCasesLink;
    @FindBy(xpath = "//div[contains(@class,'summary-title')]/a")
    List<WebElement> projectsList;

    public boolean isDashboardVisible() {
        Waiters.waitForElementLocated(driver, naviDashboard, 5);
        return naviDashboard.isDisplayed();
    }

    public String getLastProjectName() {
        Waiters.waitForElementLocated(driver, lastCreatedProject, 10);
        return lastCreatedProject.getText();
    }

    public String getNumberOfProjects() {
        Waiters.waitForElementLocated(driver, numberOfProjects, 10);
        return numberOfProjects.getText();
    }

    @Step("Clicking on link to test cases list on Dashboard page")
    public TestCasesListOverviewPage clickOnTestCasesLink() {
        log.info("Clicking on link to test cases list");
        log.debug("Test cases link locator is: " + testCasesLink);
        testCasesLink.click();
        return new TestCasesListOverviewPage(driver);
    }

    public List<WebElement> getProjectsList() {
        return projectsList;
    }

    @Step("Clicking on Project with index: '{index}' on Dashboard page")
    public ProjectDetailsPage chooseProjectByIndex(int index) {
        Waiters.waitForElementLocated(driver, projectsList, 10);
        log.info("Clicking on project with index: " + index);
        log.debug("Project list locator is: " + projectsList);
        getProjectsList().get(index).click();
        return new ProjectDetailsPage(driver);
    }
}
