package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HeaderPage extends BasePage{

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "navigation-user")
    WebElement accountTab;
    @FindBy(id = "navigation-user-logout")
    WebElement logOutBtn;

    @Step("Clicking on account tab and log out on Header")
    public LoginPage logOut() {
        log.info("Clicking on account tab");
        log.debug("Account tab locator is: " + accountTab);
        accountTab.click();
        log.info("Clicking on 'Log out' button");
        log.debug("'Log out' button locator is: " + logOutBtn);
        logOutBtn.click();
        return new LoginPage(driver);
    }
}
