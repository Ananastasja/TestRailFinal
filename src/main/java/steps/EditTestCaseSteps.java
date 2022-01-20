package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class EditTestCaseSteps {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public TestCasePage testCasePage;
    TestCasesListPage testCasesListPage;
    EditTestCasePage editTestCasePage;

    public EditTestCaseSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        testCasePage = new TestCasePage(driver);
        testCasesListPage = new TestCasesListPage(driver);
        editTestCasePage = new EditTestCasePage(driver);
    }

    public EditTestCaseSteps editTestCaseAndSave(int index, String newTitle) {
        testCasesListPage.chooseCaseCheckboxByIndex(index)
                .clickEditDropDown()
                .clickEditSelected()
                .changeTitle(newTitle)
                .clickSaveBtn();
        return this;
    }

    public EditTestCaseSteps editTestWithNoFieldsChangesAndClickSave(int index) {
        testCasesListPage.chooseCaseCheckboxByIndex(index)
                .clickEditDropDown()
                .clickEditSelected()
                .clickSaveBtn();
        return this;
    }
}
