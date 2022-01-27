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
        log.info(String.format("Type text: '%s' into 'Title' field", testCase.getTitle()));
        new InputField(driver, "title").writeText(testCase.getTitle());
        log.info(String.format("Choose option: '%s' from 'Section' dropdown", testCase.getSection()));
        new DropDown(driver, "Section").selectOption(testCase.getSection());
        log.info(String.format("Choose option: '%s' from 'Template' dropdown", testCase.getTemplate()));
        new DropDown(driver, "Template").selectOption(testCase.getTemplate());
        log.info(String.format("Choose option: '%s' from 'Type' dropdown", testCase.getType()));
        new DropDown(driver, "Type").selectOption(testCase.getType());
        log.info(String.format("Choose option: '%s' from 'Priority' dropdown", testCase.getPriority()));
        new DropDown(driver, "Priority").selectOption(testCase.getPriority());
        log.info(String.format("Type text: '%s' into 'Estimate' field", testCase.getEstimate()));
        new InputField(driver, "estimate").writeText(testCase.getEstimate());
        log.info(String.format("Type text: '%s' into 'References' field", testCase.getReferences()));
        new InputField(driver, "refs").writeText(testCase.getReferences());
        log.info(String.format("Choose option: '%s' from 'Automation type' dropdown", testCase.getAutomationType()));
        new DropDown(driver, "Automation Type").selectOption(testCase.getAutomationType());
        log.info(String.format("Type text: '%s' into 'Preconditions' area", testCase.getPreconditions()));
        new TextArea(driver, "Preconditions").writeText(testCase.getPreconditions());
        log.info(String.format("Type text: '%s' into 'Steps' area", testCase.getSteps()));
        new TextArea(driver, "Steps").writeText(testCase.getSteps());
        log.info(String.format("Type text: '%s' into 'Expected result' area", testCase.getExpectedResult()));
        new TextArea(driver, "Expected Result").writeText(testCase.getExpectedResult());
        return this;
    }

    @Step("Clicking on 'Add test case' button on Create test case Page")
    public CaseDetailsPage clickAddTestCaseBtn() {
        log.info("Click on 'Add test case' button");
        new AddButton(driver, "Add Test Case").clickOnAddBtn();
        return new CaseDetailsPage(driver);
    }

    @Step("Click on 'Add&New' button on Create test case Page")
    public CreateTestCasePage clickAddAndNextBtn() {
        log.info("Click on 'Add&New' button");
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
