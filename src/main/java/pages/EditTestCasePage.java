package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

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

    public ReviewChangesPage clickSaveBtn() {
        Waiters.waitForElementLocated(driver, saveTestCaseBtn, 10);
        saveTestCaseBtn.click();
        return new ReviewChangesPage(driver);
    }

    public EditTestCasePage changeTitle(String text) {
        Waiters.waitForElementLocated(driver, titleField, 10);
        titleField.clear();
        titleField.sendKeys(text);
        return new EditTestCasePage(driver);
    }
}
