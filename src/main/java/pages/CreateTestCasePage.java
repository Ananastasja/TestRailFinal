package pages;

import elements.test_case_elements.AddButton;
import elements.test_case_elements.DropDown;
import elements.test_case_elements.InputField;
import elements.test_case_elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.ui.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CreateTestCasePage extends HeaderPage {
    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(), 'required field')]")
    WebElement messageError;
    @FindBy(xpath = "//div[@class='message message-success']")
    WebElement confirmationMessage;
    @FindBy(id = "entityAttachmentList")
    WebElement uploadWindow;
    @FindBy(id = "libraryAddAttachment")
    WebElement plusBtn;
    @FindBy(id = "attachmentNewSubmit")
    WebElement attachBtn;
    @FindBy(xpath = "//a[contains(@class, 'case-form-cancel')]")
    WebElement cancelCaseBtn;

    @Step("Enter data into fields title: '{testCase.title}', section: '{testCase.section}', template: '{testCase.template}', type: '{testCase.type}'," +
            "priority: '{testCase.priority}', estimate: '{testCase.estimate}', references: '{testCase.references}', automation type: '{testCase.automationType}'," +
            "preconditions: '{testCase.preconditions}', steps: '{testCase.steps}', expected result: '{testCase.expectedResult}' on Create test case Page")
    public CreateTestCasePage fillAllTestCaseFields(TestCase testCase) {
        new InputField(driver, "title").writeText(testCase.getTitle());
        new DropDown(driver, "Section").selectOption(testCase.getSection());
        new DropDown(driver, "Template").selectOption(testCase.getTemplate());
        new DropDown(driver, "Type").selectOption(testCase.getType());
        new DropDown(driver, "Priority").selectOption(testCase.getPriority());
        new InputField(driver, "estimate").writeText(testCase.getEstimate());
        new InputField(driver, "refs").writeText(testCase.getReferences());
        new DropDown(driver, "Automation Type").selectOption(testCase.getAutomationType());
        new TextArea(driver, "Preconditions").writeText(testCase.getPreconditions());
        new TextArea(driver, "Steps").writeText(testCase.getSteps());
        new TextArea(driver, "Expected Result").writeText(testCase.getExpectedResult());
        return this;
    }

    @Step("Clicking on 'Add test case' button on Create test case Page")
    public CaseDetailsPage clickAddTestCaseBtn() {
        new AddButton(driver, "Add Test Case").clickOnAddBtn();
        return new CaseDetailsPage(driver);
    }

    @Step("Click on 'Add&New' button on Create test case Page")
    public CreateTestCasePage clickAddAndNextBtn() {
        new AddButton(driver, "Add & Next").clickOnAddBtn();
        return this;
    }

    public String getMessageError() {
        return messageError.getText();
    }

    public String getConfirmationMessageAddAndNextBtn() {
        return confirmationMessage.getText();
    }

    @Step("Click on 'Cancel' button on Create test case Page")
    public CaseDetailsPage clickCancelCaseBtn() {
        log.info("Click on 'Cancel' button");
        log.debug("'Cancel' button locator is: " + cancelCaseBtn);
        cancelCaseBtn.click();
        return new CaseDetailsPage(driver);
    }
}
