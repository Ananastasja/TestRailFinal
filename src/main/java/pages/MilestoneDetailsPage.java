package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

@Log4j2
public class MilestoneDetailsPage extends HeaderPage{
    public MilestoneDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@class, 'button-edit')]")
    WebElement editMilestoneBtn;
    @FindBy(xpath = "//div[contains(@class, 'message-success')]")
    WebElement milestoneSuccessMsg;
    @FindBy(xpath = "//*[contains(@class,'content-header-title')]")
    WebElement milestoneTitle;
    @FindBy(id = "navigation-milestones-start")
    WebElement startMilestoneBtn;
    @FindBy(xpath = "//*[contains(@class,'message-help')]")
    WebElement milestoneNotStartedMsg;

    public boolean isMilestoneStartedMsgDisplayed() {
        return milestoneNotStartedMsg.isDisplayed();
    }

    @Step("Clicking on 'Start milestone' button on Milestone details page")
    public StartMilestoneModalPage clickOnStartMilestoneBtn() {
        Waiters.waitForElementLocated(driver, startMilestoneBtn, 10);
        log.info("Clicking on 'Start milestone' button");
        log.debug("'Start milestone' button locator is: " + startMilestoneBtn);
        startMilestoneBtn.click();
        return new StartMilestoneModalPage(driver);
    }

    public String getMilestoneTitle() {
        return milestoneTitle.getText();
    }

    public String getMilestoneSuccessMsg() {
        Waiters.waitForElementLocated(driver, milestoneSuccessMsg, 10);
        return milestoneSuccessMsg.getText();
    }

    @Step("Clicking on 'Edit milestone' button on Milestone details page")
    public CreateMilestonePage clickEditMilestoneBtn() {
        log.info("Clicking on 'Edit milestone' button");
        log.debug("'Edit milestone' button locator is: " + editMilestoneBtn);
        editMilestoneBtn.click();
        return new CreateMilestonePage(driver);
    }
}
