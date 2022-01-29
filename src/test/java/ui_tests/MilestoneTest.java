package ui_tests;

import objects.ui.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.DataSupplierInfo;

public class MilestoneTest extends BaseTest {

    @Test(dataProvider = "Create milestone positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating positive milestone and ensuring it was created and is completely new", groups = {"Smoke", "Positive", "Regression"})
    public void addMilestoneTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 0, "1", "5");
        Assert.assertTrue(milestonesListOverviewPage.isMilestoneOverviewPageOpened());
        Assert.assertEquals(milestonesListOverviewPage.getMilestoneSuccessMsg(), MILESTONE_ADDED_MSG);
        Assert.assertTrue(milestonesListOverviewPage.isProgressBarOfLastMilestoneVisible());
        Assert.assertEquals(milestonesListOverviewPage.getZeroPercentTextOfNewMilestone(), MILESTONE_PERCENT_TEXT);
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating milestone and ensuring that the number of milestones displayed at the sidebar is correct", groups = {"Positive", "Regression"})
    public void checkRightSizeOfMilestonesDisplayedTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 0, "1", "5");
        Assert.assertEquals(milestonesListOverviewPage.getMilestonesSize(), milestonesListOverviewPage.getMilestoneNumberText());
    }

    @Test(dataProvider = "Create milestone negative", dataProviderClass = DataSupplierInfo.class,
            description = "Creating milestone with empty required fields and ensuring that there is an error message and same page opened", groups = {"Smoke", "Negative", "Regression"})
    public void createMilestoneWithEmptyRequiredFieldsTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 0, "1", "5");
        Assert.assertTrue(createMilestonePage.isErrorMsgDisplayed());
        Assert.assertTrue(createMilestonePage.isCreateEditMilestonePageOpened());
    }

    @Test(description = "Opening Milestone page and clicking Cancel button without filling any fields in, ensuring that project details page is opened",
            groups = {"Smoke", "Positive", "Regression"})
    public void openMilestonePageAndCancelItsCreationTest() {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.openMilestonePage(3);
        createMilestonePage.clickOnCancelBtn();
        Assert.assertTrue(projectDetailsPage.isProjectChartVisible());
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating milestone and ensuring that is it possible to edit it", groups = {"Positive", "Regression"})
    public void checkEditBtnIsWorkingTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestonesListOverviewPage.openCreatedMilestoneByIndex(0)
                .clickEditMilestoneBtn();
        Assert.assertTrue(createMilestonePage.isCreateEditMilestonePageOpened());
        Assert.assertFalse(createMilestonePage.isSaveBtnEnabled());
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating milestone and editing it, checking that Save btn is enabled when changes are done", groups = {"Positive", "Regression"})
    public void checkSaveBtnEnabledWhenMilestoneEditedTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestonesListOverviewPage.openCreatedMilestoneByIndex(0)
                .clickEditMilestoneBtn()
                .editMilestone("New name");
        Assert.assertTrue(createMilestonePage.isSaveBtnEnabled());
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating and editing milestone, ensuring it was edited successfully", groups = {"Smoke", "Positive", "Regression"})
    public void editMilestoneTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestonesListOverviewPage.openCreatedMilestoneByIndex(0)
                .clickEditMilestoneBtn()
                .editMilestone("New name")
                .clickOnAddSaveMilestoneBtn();
        Assert.assertEquals(milestoneDetailsPage.getMilestoneSuccessMsg(), MILESTONE_EDITED_MSG);
        Assert.assertEquals(milestoneDetailsPage.getMilestoneTitle(), "New name");
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating milestone, ensuring it is possible to delete it", groups = {"Positive", "Regression"})
    public void checkDeleteBtnIsWorkingTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestoneSteps.deleteTillModalWindow(0);
        Assert.assertTrue(confirmationMilestoneModalPage.isConfirmationModalPageVisible());
        Assert.assertFalse(confirmationMilestoneModalPage.isCheckboxSelected());
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating and deleting milestone, ensuring it was deleted successfully", groups = {"Smoke", "Positive", "Regression"})
    public void deleteMilestoneByIndexTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestoneSteps.deleteMilestone(0);
        Assert.assertEquals(milestonesListOverviewPage.getMilestoneSuccessMsg(), MILESTONE_DELETED_MSG);
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating and deleting milestone, ensuring the number of milestones is n-1", groups = {"Positive", "Regression"})
    public void deleteMilestoneByIndexAndCheckItsNumberTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        int milestonesNumberBeforeDelete = milestonesListOverviewPage.getMilestonesSize();
        milestoneSteps.deleteMilestone(0);
        confirmationMilestoneModalPage.waitTillModalWindowNotVisible();
        int milestonesNumberAfterDelete = milestonesListOverviewPage.getMilestonesSize();
        Assert.assertNotEquals(milestonesNumberAfterDelete, milestonesNumberBeforeDelete);
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating and cancelling deleting of milestone, ensuring the conformation of deletion window is not visible(closed)", groups = {"Smoke", "Positive", "Regression"})
    public void cancelMilestoneDeletionTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestoneSteps.deleteTillModalWindow(0);
        confirmationMilestoneModalPage.clickCancelBtn();
        Assert.assertFalse(confirmationMilestoneModalPage.isConfirmationModalPageVisible());
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating and start milestone, ensuring it was started", groups = {"Smoke", "Positive", "Regression"})
    public void createAndStartMilestoneTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestoneSteps.openStartMilestoneWindow(0);
        startMilestoneModalPage.clickOnStartMilestoneBtn();
        Assert.assertEquals(milestoneDetailsPage.getMilestoneSuccessMsg(), MILESTONE_STARTED_MSG);
    }

    @Test(dataProvider = "Create one milestone example positive", dataProviderClass = DataSupplierInfo.class,
            description = "Creating and cancelling the start milestone, ensuring it was not started", groups = {"Smoke", "Positive", "Regression"})
    public void createAndCancelStartOfMilestoneTest(Milestone milestone) {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        milestoneSteps.createMilestone(milestone, 3, "1", "5");
        milestoneSteps.openStartMilestoneWindow(0);
        startMilestoneModalPage.clickOnCancelStartMilestoneBtn();
        Assert.assertTrue(milestoneDetailsPage.isMilestoneStartedMsgDisplayed());
    }
}
