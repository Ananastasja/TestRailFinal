package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import util.Waiters;

import java.util.List;

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

    public void waitForMilestonesListDisplayed() {
        Waiters.waitForElementLocated(driver, milestonesList, 10);
    }

    public List<WebElement> getMilestoneNamesList() {
        return milestoneNamesList;
    }

    public MilestoneDetailsPage openCreatedMilestone(int index) {
        getMilestoneNamesList().get(index).click();
        return new MilestoneDetailsPage(driver);
    }

    public boolean isMilestoneOverviewPageOpened() {
        Waiters.waitForElementLocated(driver, milestoneTitle, 10);
        return milestoneTitle.isDisplayed();
    }

    public ConfirmationMilestoneModalPage clickOnDeleteBtn() {
        deleteMilestoneBtn.click();
        return new ConfirmationMilestoneModalPage(driver);
    }

    public List<WebElement> getMilestoneCheckboxesList() {
        return milestoneCheckboxesList;
    }

    public MilestonesListOverviewPage clickOnCheckBoxByIndex(int index) {
        Waiters.waitForElementLocated(driver, milestoneCheckboxesList, 10);
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
