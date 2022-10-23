package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import util.Waiters;

import java.util.List;

@Log4j2
public class TestCasesListOverviewPage extends HeaderPage{
    public TestCasesListOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sidebar-cases-add")
    WebElement addTestCaseBtn;
    @FindBy(xpath = "//div[contains(@class, 'content-header-title')]")
    WebElement testCasesListPageTitle;
    @FindBys({
            @FindBy(xpath = "//input[contains(@class, 'selectionCheckbox')]")
    })
    List<WebElement> testCaseCheckboxesList;
    @FindBy(id = "deleteCases")
    WebElement deleteCasesBtn;
    @FindBy(id = "editCases")
    WebElement editCaseBtn;
    @FindBy(id = "editCasesSelected")
    WebElement editSelectedOption;
    @FindBy(xpath = "//*[contains(@class, 'message-success')]")
    WebElement updateSuccessMessage;
    @FindBy(xpath = "//*[@class = 'title']")
    List<WebElement> testCasesTitles;

    @Step("Clicking on 'Add test case' button on Test cases list page")
    public CreateTestCasePage clickOnAddTestCaseBtn() {
        log.info("Clicking on 'Add test case' button");
        log.debug("'Add test case' button locator is: " + addTestCaseBtn);
        addTestCaseBtn.click();
        return new CreateTestCasePage(driver);
    }

    public boolean isTestCaseListTitleVisible() {
        return testCasesListPageTitle.isDisplayed();
    }

    public List<WebElement> getCasesList() {
        Waiters.waitForElementLocated(driver, testCasesListPageTitle, 10);
        return testCaseCheckboxesList;
    }

    @Step("Selecting test case checkbox with index: '{index}' on Test cases list page")
    public TestCasesListOverviewPage chooseCaseCheckboxByIndex(int index) {
        log.info("Selecting test case checkbox with index: " + index);
        log.debug("Test cases checkbox locator is: " + testCaseCheckboxesList);
        getCasesList().get(index).click();
        return this;
    }

    public List<WebElement> getCasesTitleList() {
        Waiters.waitForElementLocated(driver, testCasesListPageTitle, 10);
        return testCasesTitles;
    }

    public String getTitleByIndex(int index) {
        Waiters.waitForElementLocated(driver, testCasesTitles, 10);
        return getCasesTitleList().get(index).getText();
    }

    @Step("Clicking on 'Delete' button on Test cases list page")
    public ConfirmationTestCaseModalPage clickDeleteCaseBtn() {
        log.info("Clicking on 'Delete' button");
        log.debug("'Delete' button locator is: " + deleteCasesBtn);
        deleteCasesBtn.click();
        return new ConfirmationTestCaseModalPage(driver);
    }

    public int getTestCasesNumber() {
        return testCaseCheckboxesList.size();
    }

    @Step("Clicking on Edit button on Test cases list page")
    public TestCasesListOverviewPage clickEditDropDown() {
        log.info("Clicking on 'Edit' button");
        log.debug("'Edit' button locator is: " + editCaseBtn);
        editCaseBtn.click();
        return this;
    }

    @Step("Clicking on Edit selected on Test cases list page")
    public EditTestCasePage clickEditSelected() {
        log.info("Clicking on 'Edit Selected' button");
        log.debug("'Edit Selected' button locator is: " + editSelectedOption);
        editSelectedOption.click();
        return new EditTestCasePage(driver);
    }

    public boolean isUpdateSuccessMsgVisible() {
        return updateSuccessMessage.isDisplayed();
    }
}
