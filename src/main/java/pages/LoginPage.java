package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

@Log4j2
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    WebElement emailInput;
    @FindBy(id="password")
    WebElement passwordInput;
    @FindBy(id = "button_primary")
    WebElement logInBtn;
    @FindBy(xpath = "//*[contains(@class, 'error-text')]")
    WebElement errorText;
    @FindBy(xpath = "//*[contains(@class, 'login-text')]")
    WebElement loginBoxText;
    @FindBy(xpath = "//*[contains(@class,'loginpage-message')]")
    WebElement missingRequiredFieldText;

    @Step("Entering email: '{email}' and password: '{password}' on Login page")
    public LoginPage enterLoginCreds(String email, String password) {
        log.info(String.format("Type email: '%s' into 'Email' field", email));
        log.debug("'Email' field locator is: " + emailInput);
        emailInput.sendKeys(email);
        log.info(String.format("Type password: '%s' into 'Password' field", password));
        log.debug("'Password' field locator is: " + passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    public String getMissingRequiredFieldText() {
        return missingRequiredFieldText.getText();
    }

    @Step("Clicking on 'Login' button on Login page")
    public DashboardPage clickLogInBtn() {
        log.info("Clicking on 'Login' button");
        log.debug("'Login' button locator is: " + logInBtn);
        logInBtn.click();
        return new DashboardPage(driver);
    }

    public String getErrorText() {
        return errorText.getText();
    }

    public LoginPage openLoginPage() {
        openPage(BASE_URL);
        return this;
    }

    public String getLoginBoxText() {
        Waiters.waitForElementLocated(driver, loginBoxText, 5);
       return loginBoxText.getText();
    }
}
