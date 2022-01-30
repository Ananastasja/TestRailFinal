package steps;

import objects.ui.Milestone;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.Waiters;

public class MilestoneSteps {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public CreateTestCasePage createTestCasePage;
    TestCasesListOverviewPage testCasesListOverviewPage;
    MilestonesListOverviewPage milestonesListOverviewPage;
    ConfirmationMilestoneModalPage confirmationMilestoneModalPage;
    MilestoneDetailsPage milestoneDetailsPage;
    StartMilestoneModalPage startMilestoneModalPage;

    public MilestoneSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        createTestCasePage = new CreateTestCasePage(driver);
        testCasesListOverviewPage = new TestCasesListOverviewPage(driver);
        milestonesListOverviewPage = new MilestonesListOverviewPage(driver);
        confirmationMilestoneModalPage = new ConfirmationMilestoneModalPage(driver);
        milestoneDetailsPage = new MilestoneDetailsPage(driver);
        startMilestoneModalPage = new StartMilestoneModalPage(driver);
    }

    public MilestoneSteps createMilestone(Milestone milestone, int index, String start, String end) {
        dashboardPage.chooseProjectByIndex(index)
                .clickOnAddMilestoneBtn()
                .fillOutFields(milestone)
                .chooseDate(start, end)
                .clickOnAddSaveMilestoneBtn();
        return this;
    }

    public MilestoneSteps openMilestonePage(int index) {
        dashboardPage.chooseProjectByIndex(index)
                .clickOnAddMilestoneBtn();
        return this;
    }

    public MilestoneSteps deleteTillModalWindow(int index) {
        milestonesListOverviewPage.clickOnCheckBoxByIndex(index)
                .clickOnDeleteBtn();
        return this;
    }

    public MilestoneSteps deleteMilestone(int index) {
        milestonesListOverviewPage.clickOnCheckBoxByIndex(index)
                .clickOnDeleteBtn()
                .selectCheckbox()
                .clickDeleteBtn();
        return this;
    }

    public MilestoneSteps openStartMilestoneWindow(int index) {
        milestonesListOverviewPage.openCreatedMilestoneByIndex(index)
                .clickOnStartMilestoneBtn()
                .isStartMilestoneWindowDisplayed();
        return this;
    }
}
