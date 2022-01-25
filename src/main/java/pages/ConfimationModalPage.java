package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfimationModalPage extends HeaderPage{
    public ConfimationModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'ui-dialog-content')]//a[contains(@class,'button-positive dialog')]")
    WebElement markAsDeletedBtn;
    @FindBy(xpath = "//*[contains(@class, 'ui-dialog-content')]//a[contains(@class,'dialog-action-secondary')]")
    WebElement deletePermanentlyBtn;
    @FindBy(xpath = "//*[contains(@id, 'casesDeletionConfirmationDialog')]//a[contains(@class,'button-black')]")
    WebElement deletePermanentlySecondPage;

    public TestCasesListPage clickOnMarkAsDeletedBtn() {
        markAsDeletedBtn.click();
        return new TestCasesListPage(driver);
    }

    public ConfimationModalPage clickOnDeletePermanentlyBtn() {
        deletePermanentlyBtn.click();
        return this;
    }

    public TestCasesListPage clickOnDeletePermanentlySecondPage() {
        deletePermanentlySecondPage.click();
        return new TestCasesListPage(driver);
    }
}
