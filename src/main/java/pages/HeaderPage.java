package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "navigation-user")
    WebElement accountTab;
    @FindBy(id = "navigation-user-logout")
    WebElement logOutBtn;

    public LoginPage logOut() {
        accountTab.click();
        logOutBtn.click();
        return new LoginPage(driver);
    }
}
