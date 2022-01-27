package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiters;

@Log4j2
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

    @Step("Clicking on 'Ok' button on Review changes modal page")
    public TestCasesListOverviewPage clickOkBtn() {
        Waiters.waitForElementLocated(driver, okBtn, 10);
        log.info("Clicking on 'Ok' button");
        log.debug("'Ok' button locator is: " + okBtn);
        okBtn.click();
        return new TestCasesListOverviewPage(driver);
    }
}
