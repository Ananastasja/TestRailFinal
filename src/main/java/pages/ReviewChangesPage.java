package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

public class ReviewChangesPage extends HeaderPage {
    public ReviewChangesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ui-dialog-title-confirmDiffDialog")
    WebElement reviewChangesPageTitle;
    @FindBy(id = "confirmDiffSubmit")
    WebElement okBtn;

    public boolean isReviewChangesPageDisplayed() {
        Waiters.waitForElementLocated(driver, reviewChangesPageTitle, 10);
        return reviewChangesPageTitle.isDisplayed();
    }

    public TestCasesOverviewPage clickOkBtn() {
        Waiters.waitForElementLocated(driver, okBtn, 10);
        okBtn.click();
        return new TestCasesOverviewPage(driver);
    }
}
