package pages;

import elements.milestone_elements.CalenderInput;
import elements.milestone_elements.InputField;
import objects.ui.Milestone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

public class MilestonePage extends HeaderPage{
    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "description_display")
    WebElement milestoneDescription;
    @FindBy(id = "accept")
    WebElement addOrSaveMilestoneBtn;
    @FindBy(xpath = "//a[contains(@class, 'milestone-form-cancel')]")
    WebElement cancelMilestoneBtn;
    @FindBy(xpath = "//*[contains(@class,'content-header-title')]")
    WebElement milestoneTitle;
    @FindBy(id = "name")
    WebElement milestoneNameField;
    @FindBy(xpath = "//div[contains(text(), 'required field')]")
    WebElement messageError;

    public boolean isErrorMsgDisplayed() {
        return messageError.isDisplayed();
    }

    public boolean isSaveBtnEnabled() {
        return addOrSaveMilestoneBtn.isEnabled();
    }

    public boolean isCreateEditMilestonePageOpened() {
        Waiters.waitForElementLocated(driver, milestoneTitle, 10);
        return milestoneTitle.isDisplayed();
    }

    public MilestonesListOverviewPage clickOnAddSaveMilestoneBtn() {
        addOrSaveMilestoneBtn.click();
        return new MilestonesListOverviewPage(driver);
    }

    public ProjectDetailsPage clickOnCancelBtn() {
        cancelMilestoneBtn.click();
        return new ProjectDetailsPage(driver);
    }

    public MilestonePage fillOutFields(Milestone milestone) {
        new InputField(driver, "name").writeText(milestone.getName());
        new InputField(driver, "reference").writeText(milestone.getReference());
        milestoneDescription.sendKeys(milestone.getDescription());
        return new MilestonePage(driver);
    }

    public MilestonePage chooseDate(String start, String end) {
        new CalenderInput(driver, "start_on").clickOnCalender(start);
        new CalenderInput(driver, "due_on").clickOnCalender(end);
        return this;
    }

    public MilestonePage editMilestone(String name) {
        milestoneNameField.clear();
        milestoneNameField.sendKeys(name);
        return this;
    }
}
