package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationMilestoneModalPage extends HeaderPage{
    public ConfirmationMilestoneModalPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "dialog-ident-bulkDeleteDialog")
    WebElement confirmationModalePageDelete;
    @FindBy(id = "confirm-check")
    WebElement confirmationCheckbox;
    @FindBy(xpath = "//*[contains(@id,'bulkDeleteDialog')]//a[contains(@class, 'button-black')]")
    WebElement deleteBtn;
    @FindBy(xpath = "//*[contains(@id,'bulkDeleteDialog')]//a[contains(@class, 'action-close')]")
    WebElement cancelBtn;

    public MilestonesListOverviewPage clickCancelBtn() {
        cancelBtn.click();
        return new MilestonesListOverviewPage(driver);
    }

    public MilestonesListOverviewPage clickDeleteBtn() {
        deleteBtn.click();
        return new MilestonesListOverviewPage(driver);
    }

    public boolean isDeleteBtnEnabled() {
        return deleteBtn.isEnabled();
    }

    public ConfirmationMilestoneModalPage selectCheckbox() {
        confirmationCheckbox.click();
        return this;
    }

    public boolean isConfirmationModalPageVisible() {
        return confirmationModalePageDelete.isDisplayed();
    }
}
