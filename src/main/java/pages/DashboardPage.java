package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

import java.util.List;

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

    public TestCasesListOverviewPage clickOnTestCasesLink() {
        testCasesLink.click();
        return new TestCasesListOverviewPage(driver);
    }

    public List<WebElement> getProjectsList() {
        return projectsList;
    }

    public ProjectDetailsPage chooseProjectByIndex(int index) {
        Waiters.waitForElementLocated(driver, projectsList, 10);
        getProjectsList().get(index).click();
        return new ProjectDetailsPage(driver);
    }
}
