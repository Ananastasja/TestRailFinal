package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

@Log4j2
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

    @Step("Clicking on 'Cancel' button on Start milestone modal page")
    public MilestoneDetailsPage clickOnCancelStartMilestoneBtn() {
        log.info("Clicking on 'Cancel' button");
        log.debug("'Cancel' button locator is: " + cancelStartMilestoneBtn);
        cancelStartMilestoneBtn.click();
        return new MilestoneDetailsPage(driver);
    }

    @Step("Clicking on Start milestone button on Start milestone modal page")
    public MilestoneDetailsPage clickOnStartMilestoneBtn() {
        log.info("Clicking on 'Start milestone' button");
        log.debug("'Start milestone' button locator is: " + startMilestoneBtn);
        startMilestoneBtn.click();
        return new MilestoneDetailsPage(driver);
    }

    public boolean isStartMilestoneWindowDisplayed() {
        Waiters.waitForElementLocated(driver, startMilestoneWindow, 10);
        return startMilestoneWindow.isDisplayed();
    }
}
