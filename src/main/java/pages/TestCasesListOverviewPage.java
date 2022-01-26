package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import util.Waiters;

import java.util.List;

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
    List<WebElement> testCases;
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

    public TestCasePage clickOnAddTestCaseBtn() {
        addTestCaseBtn.click();
        return new TestCasePage(driver);
    }

    public boolean isTestCaseListTitleVisible() {
        return testCasesListPageTitle.isDisplayed();
    }

    public List<WebElement> getCasesList() {
        Waiters.waitForElementLocated(driver, testCasesListPageTitle, 10);
        return testCases;
    }

    public TestCasesListOverviewPage chooseCaseCheckboxByIndex(int index) {
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


    public ConfirmationTestCaseModalPage clickDeleteCaseBtn() {
        deleteCasesBtn.click();
        return new ConfirmationTestCaseModalPage(driver);
    }

    public int getTestCasesNumber() {
        return testCases.size();
    }

    public TestCasesListOverviewPage clickEditDropDown() {
        editCaseBtn.click();
        return this;
    }

    public EditTestCasePage clickEditSelected() {
        editSelectedOption.click();
        return new EditTestCasePage(driver);
    }

    public boolean isUpdateSuccessMsgVisible() {
        return updateSuccessMessage.isDisplayed();
    }
}
