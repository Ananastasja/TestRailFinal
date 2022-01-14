package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

public class DashboardPage extends HeaderPage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "navigation-dashboard")
    WebElement naviDashboard;

    public boolean isDashboardVisible() {
        Waiters.waitForElementLocated(driver, naviDashboard, 5);
        return naviDashboard.isDisplayed();
    }
}
