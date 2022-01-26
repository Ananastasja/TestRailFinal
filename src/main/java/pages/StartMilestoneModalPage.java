package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

public class StartMilestoneModalPage extends HeaderPage{
    public StartMilestoneModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dialog-ident-startMilestoneDialog")
    WebElement startMilestoneWindow;
    @FindBy(id = "startMilestoneSubmit")
    WebElement startMilestoneBtn;
    @FindBy(xpath = "//*[@id='startMilestoneForm']//*[contains(@class,'cancel')]")
    WebElement cancelStartMilestoneBtn;

    public MilestoneDetailsPage clickOnCancelStartMilestoneBtn() {
        cancelStartMilestoneBtn.click();
        return new MilestoneDetailsPage(driver);
    }

    public MilestoneDetailsPage clickOnStartMilestoneBtn() {
        startMilestoneBtn.click();
        return new MilestoneDetailsPage(driver);
    }

    public boolean isStartMilestoneWindowDisplayed() {
        Waiters.waitForElementLocated(driver, startMilestoneWindow, 10);
        return startMilestoneWindow.isDisplayed();
    }
}
