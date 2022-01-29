package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import util.Waiters;

import java.util.List;

@Log4j2
public class MilestonesListOverviewPage extends HeaderPage {
    public MilestonesListOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'message-success')]")
    WebElement milestoneSuccessMsg;
    @FindBy(xpath = "(//div[contains(@class,'chart-bar-transparent')])[1]")
    WebElement lastCreatedMilestoneProgressBar;
    @FindBy(xpath = "(//div[contains(@class,'chart-bar-percent')])[1]")
    WebElement lastCreatedMilestonePercentDone;
    @FindBys(@FindBy(xpath = "//div[contains(@id,'milestone')]"))
    List<WebElement> milestonesList;
    @FindBy(xpath = "(//*[contains(@class,'text-softer')])[1]")
    WebElement milestoneSizeUI;
    @FindBys(@FindBy(xpath = "//input[contains(@name,'entity_milestones')]"))
    List<WebElement> milestoneCheckboxesList;
    @FindBy(id = "delete-milestones")
    WebElement deleteMilestoneBtn;
    @FindBy(xpath = "//*[contains(@class,'content-header-title')]")
    WebElement milestoneTitle;
    @FindBys(@FindBy(xpath = "//div[contains(@class, 'summary-title')]/a"))
    List<WebElement> milestoneNamesList;

    public List<WebElement> getMilestoneNamesList() {
        return milestoneNamesList;
    }

    @Step("Clicking on milestone with index: '{index}' on Milestone overview page")
    public MilestoneDetailsPage openCreatedMilestoneByIndex(int index) {
        log.info("Clicking on milestone with index: " + index);
        log.debug("Milestone list locator is: " + milestonesList);
        getMilestoneNamesList().get(index).click();
        return new MilestoneDetailsPage(driver);
    }

    public boolean isMilestoneOverviewPageOpened() {
        Waiters.waitForElementLocated(driver, milestoneTitle, 10);
        return milestoneTitle.isDisplayed();
    }

    @Step("Clicking on 'Delete milestone' button on Milestone overview page")
    public ConfirmationMilestoneModalPage clickOnDeleteBtn() {
        log.info("Clicking on 'Delete milestone' button");
        log.debug("'Delete milestone' button locator is: " + deleteMilestoneBtn);
        deleteMilestoneBtn.click();
        return new ConfirmationMilestoneModalPage(driver);
    }

    public List<WebElement> getMilestoneCheckboxesList() {
        return milestoneCheckboxesList;
    }

    @Step("Selecting milestone checkbox with index: '{index}' on Milestone overview page")
    public MilestonesListOverviewPage clickOnCheckBoxByIndex(int index) {
        Waiters.waitForElementLocated(driver, milestoneCheckboxesList, 10);
        log.info("Clicking on milestone checkbox with index: " + index);
        log.debug("Milestone checkbox list locator is: " + milestoneCheckboxesList);
        getMilestoneCheckboxesList().get(index).click();
        return this;
    }

    public int getMilestoneNumberText() {
        int numberOfMilestones = Integer.parseInt(milestoneSizeUI.getText());
        return numberOfMilestones;
    }

    public List<WebElement> getMilestonesList() {
        return milestonesList;
    }

    public int getMilestonesSize() {
        return getMilestonesList().size();
    }

    public String getMilestoneSuccessMsg() {
        Waiters.waitForElementLocated(driver, milestoneSuccessMsg, 10);
        return milestoneSuccessMsg.getText();
    }

    public boolean isProgressBarOfLastMilestoneVisible() {
        return lastCreatedMilestoneProgressBar.isDisplayed();
    }

    public String getZeroPercentTextOfNewMilestone() {
        return lastCreatedMilestonePercentDone.getText().trim();
    }
}
