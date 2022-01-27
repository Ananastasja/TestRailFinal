package pages;

import elements.milestone_elements.CalenderInput;
import elements.milestone_elements.InputField;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.ui.Milestone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

@Log4j2
public class CreateMilestonePage extends HeaderPage{
    public CreateMilestonePage(WebDriver driver) {
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

    @Step("Clicking on 'Save/Add' milestone button on Create milestone page")
    public MilestonesListOverviewPage clickOnAddSaveMilestoneBtn() {
        log.info("Clicking on 'Save/Add' button");
        log.debug("'Save/Add' button locator is: " + addOrSaveMilestoneBtn);
        addOrSaveMilestoneBtn.click();
        return new MilestonesListOverviewPage(driver);
    }

    @Step("Clicking on 'Cancel' milestone button on Create milestone page")
    public ProjectDetailsPage clickOnCancelBtn() {
        log.info("Clicking on 'Cancel' button");
        log.debug("'Cancel' button locator is: " + cancelMilestoneBtn);
        cancelMilestoneBtn.click();
        return new ProjectDetailsPage(driver);
    }

    @Step("Entering data into name field: '{milestone.name}', reference field: '{milestone.reference}', description area: '{milestone.description}' on Create milestone page")
    public CreateMilestonePage fillOutFields(Milestone milestone) {
        log.info(String.format("Type text: '%s' into 'Name' field", milestone.getName()));
        new InputField(driver, "name").writeText(milestone.getName());
        log.info(String.format("Type text: '%s' into 'Reference' field", milestone.getReference()));
        new InputField(driver, "reference").writeText(milestone.getReference());
        log.info(String.format("Type text: '%s' into 'Description' field", milestone.getDescription()));
        log.debug("Locator is: " + milestoneDescription);
        milestoneDescription.sendKeys(milestone.getDescription());
        return new CreateMilestonePage(driver);
    }

    @Step("Choosing start date: '{start}' and end date: '{end}' on Create milestone page")
    public CreateMilestonePage chooseDate(String start, String end) {
        log.info("Choosing start date: " + start + " end date: " + end + " from calender");
        new CalenderInput(driver, "start_on").clickOnCalender(start);
        new CalenderInput(driver, "due_on").clickOnCalender(end);
        return this;
    }

    @Step("Clearing name field and giving the milestone a new name: '{name}' on Edit milestone page")
    public CreateMilestonePage editMilestone(String name) {
        log.info("Clearing milestone 'Name' field");
        log.debug("'Name' field locator is: " + milestoneNameField);
        milestoneNameField.clear();
        log.info(String.format("Typing text: '%s' into 'Name' field", name));
        milestoneNameField.sendKeys(name);
        return this;
    }
}
