package pages;

import elements.test_case_elements.AddButton;
import elements.test_case_elements.DropDown;
import elements.test_case_elements.InputField;
import elements.test_case_elements.TextArea;
import objects.ui.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage extends HeaderPage {
    public TestCasePage(WebDriver driver) {
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

    public TestCasePage fillAllTestCaseFields(TestCase testCase) {
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

    public CaseDetailsPage clickAddTestCaseBtn() {
        new AddButton(driver, "Add Test Case").clickOnAddBtn();
        return new CaseDetailsPage(driver);
    }

    public TestCasePage clickAddAndNextBtn() {
        new AddButton(driver, "Add & Next").clickOnAddBtn();
        return this;
    }

    public String getMessageError() {
        return messageError.getText();
    }

    public String getConfirmationMessageAddAndNextBtn() {
        return confirmationMessage.getText();
    }

    public CaseDetailsPage clickCancelCaseBtn() {
        cancelCaseBtn.click();
        return new CaseDetailsPage(driver);
    }

}
