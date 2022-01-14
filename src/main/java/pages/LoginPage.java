package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    WebElement emailInput;
    @FindBy(id="password")
    WebElement passwordInput;
    //TODO: стоит ли делать их в папке elements через динамич локатор?
    @FindBy(id = "button_primary")
    WebElement logInBtn;
    @FindBy(xpath = "//*[contains(@class, 'error-text')]")
    WebElement errorText;
    @FindBy(xpath = "//*[contains(@class, 'login-text')]")
    WebElement loginBoxText;

    public LoginPage enterLoginCreds(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        return this;
    }

    public DashboardPage clickLogInBtn() {
        logInBtn.click();
        return new DashboardPage(driver);
    }

    public String getErrorText() {
        return errorText.getText();
    }

    public LoginPage openLoginPage() {
        openPage("");
        return this;
    }

    public String getLoginBoxText() {
        Waiters.waitForElementLocated(driver, loginBoxText, 5);
       return loginBoxText.getText();
    }

}
