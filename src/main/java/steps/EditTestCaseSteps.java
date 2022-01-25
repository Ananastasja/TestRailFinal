package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class EditTestCaseSteps {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public TestCasePage testCasePage;
    TestCasesOverviewPage testCasesOverviewPage;
    EditTestCasePage editTestCasePage;

    public EditTestCaseSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        testCasePage = new TestCasePage(driver);
        testCasesOverviewPage = new TestCasesOverviewPage(driver);
        editTestCasePage = new EditTestCasePage(driver);
    }

    public EditTestCaseSteps editTestCaseAndSave(int index, String newTitle) {
        testCasesOverviewPage.chooseCaseCheckboxByIndex(index)
                .clickEditDropDown()
                .clickEditSelected()
                .changeTitle(newTitle)
                .clickSaveBtn();
        return this;
    }

    public EditTestCaseSteps editTestWithNoFieldsChangesAndClickSave(int index) {
        testCasesOverviewPage.chooseCaseCheckboxByIndex(index)
                .clickEditDropDown()
                .clickEditSelected()
                .clickSaveBtn();
        return this;
    }
}
