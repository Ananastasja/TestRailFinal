package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationTestCaseModalPage extends HeaderPage{
    public ConfirmationTestCaseModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'ui-dialog-content')]//a[contains(@class,'button-positive dialog')]")
    WebElement markAsDeletedBtn;
    @FindBy(xpath = "//*[contains(@class, 'ui-dialog-content')]//a[contains(@class,'dialog-action-secondary')]")
    WebElement deletePermanentlyBtn;
    @FindBy(xpath = "//*[contains(@id, 'casesDeletionConfirmationDialog')]//a[contains(@class,'button-black')]")
    WebElement deletePermanentlySecondPage;

    public TestCasesListOverviewPage clickOnMarkAsDeletedBtn() {
        markAsDeletedBtn.click();
        return new TestCasesListOverviewPage(driver);
    }

    public ConfirmationTestCaseModalPage clickOnDeletePermanentlyBtn() {
        deletePermanentlyBtn.click();
        return this;
    }

    public TestCasesListOverviewPage clickOnDeletePermanentlySecondPage() {
        deletePermanentlySecondPage.click();
        return new TestCasesListOverviewPage(driver);
    }
}
