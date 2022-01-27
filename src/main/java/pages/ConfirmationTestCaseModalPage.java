package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Clicking on 'Mark as deleted' button on test case Modal page")
    public TestCasesListOverviewPage clickOnMarkAsDeletedBtn() {
        log.info("Clicking on 'Mark as deleted' button");
        log.debug("'Mark as deleted' button locator is: " + markAsDeletedBtn);
        markAsDeletedBtn.click();
        return new TestCasesListOverviewPage(driver);
    }

    @Step("Clicking on 'Delete permanently' button on test case Modal page")
    public ConfirmationTestCaseModalPage clickOnDeletePermanentlyBtn() {
        log.info("Clicking on 'Delete permanently' button");
        log.debug("'Delete permanently' button locator is: " + deletePermanentlyBtn);
        deletePermanentlyBtn.click();
        return this;
    }

    @Step("Clicking on 'Delete permanently' button on second Delete test case Modal page")
    public TestCasesListOverviewPage clickOnDeletePermanentlySecondPage() {
        log.info("Clicking on 'Delete permanently' button on second Delete test case Modal page");
        log.debug("'Delete permanently' button locator is: " + deletePermanentlySecondPage);
        deletePermanentlySecondPage.click();
        return new TestCasesListOverviewPage(driver);
    }
}
