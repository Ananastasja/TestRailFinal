package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Clicking on 'Cancel' button on milestone Modal page")
    public MilestonesListOverviewPage clickCancelBtn() {
        log.info("Clicking on 'Cancel' button");
        log.debug("'Cancel' button locator is: " + cancelBtn);
        cancelBtn.click();
        return new MilestonesListOverviewPage(driver);
    }

    @Step("Clicking on 'Delete' button on milestone Modal page")
    public MilestonesListOverviewPage clickDeleteBtn() {
        log.info("Clicking on 'Delete' button");
        log.debug("'Delete' button locator is: " + deleteBtn);
        deleteBtn.click();
        return new MilestonesListOverviewPage(driver);
    }

    public boolean isDeleteBtnEnabled() {
        return deleteBtn.isEnabled();
    }

    @Step("Selecting checkbox on milestone Modal page")
    public ConfirmationMilestoneModalPage selectCheckbox() {
        log.info("Selecting checkbox");
        log.debug("'Checkbox' locator is: " + confirmationCheckbox);
        confirmationCheckbox.click();
        return this;
    }

    public boolean isConfirmationModalPageVisible() {
        return confirmationModalePageDelete.isDisplayed();
    }
}
