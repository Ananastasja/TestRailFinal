package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

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

    public StartMilestoneModalPage clickOnStartMilestoneBtn() {
        Waiters.waitForElementLocated(driver, startMilestoneBtn, 10);
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

    public MilestonePage clickEditMilestoneBtn() {
        editMilestoneBtn.click();
        return new MilestonePage(driver);
    }
}
