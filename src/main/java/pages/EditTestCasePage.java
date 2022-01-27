package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

@Log4j2
public class EditTestCasePage extends HeaderPage {
    public EditTestCasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'content-header-title')]")
    WebElement editTestCasePageTitle;
    @FindBy(xpath = "//*[@id = 'accept']")
    WebElement saveTestCaseBtn;
    @FindBy(xpath = "//*[contains(text(), 'need to update')]")
    WebElement errorMessage;
    @FindBy(xpath = "//input[@id='title']")
    WebElement titleField;

    public boolean isTitleVisible() {
        return editTestCasePageTitle.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        Waiters.waitForElementLocated(driver, errorMessage, 10);
        return errorMessage.isDisplayed();
    }

    @Step("Clicking on 'Save test case' button on Edit test case page")
    public ReviewChangesPage clickSaveBtn() {
        Waiters.waitForElementLocated(driver, saveTestCaseBtn, 10);
        log.info("Clicking on 'Save test case' button");
        log.debug("'Save test case' button locator is: " + saveTestCaseBtn);
        saveTestCaseBtn.click();
        return new ReviewChangesPage(driver);
    }

    @Step("Clearing title field and write text: '{text}' on Edit test case page")
    public EditTestCasePage changeTitle(String text) {
        Waiters.waitForElementLocated(driver, titleField, 10);
        log.info("Clearing 'Title' field");
        log.debug("'Title' field locator is: " + titleField);
        titleField.clear();
        log.info(String.format("Type text: '%s' into 'Title' field", text));
        titleField.sendKeys(text);
        return new EditTestCasePage(driver);
    }
}
