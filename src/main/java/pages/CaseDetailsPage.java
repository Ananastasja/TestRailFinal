package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaseDetailsPage extends HeaderPage{
    public CaseDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='message message-success']")
    WebElement confirmationMessage;
    @FindBy(xpath = "//div[contains(@class, 'content-header-title')] ")
    WebElement createdTestCaseTitle;
    public static final String TEST_CASE_DETAILS_XPATH = "//label[text() = '%s'] ";

    public String getConfirmationMessageAddCaseBtn() {
        return confirmationMessage.getText();
    }

    public String getTestCaseTitle() {
        return createdTestCaseTitle.getText();
    }

    public String getTestCaseDetails(String detail) {
        return driver.findElement(By.xpath(String.format(TEST_CASE_DETAILS_XPATH, detail))).getText();
    }
}
