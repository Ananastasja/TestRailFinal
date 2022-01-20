package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfimationModalPage extends HeaderPage{
    public ConfimationModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[contains(text(), 'Mark')])[2]")
    WebElement markAsDeletedBtn;

    public void clickOnMarkAsDeletedBtn() {
        markAsDeletedBtn.click();
    }
}
