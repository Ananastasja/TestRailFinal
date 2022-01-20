package elements.test_case_elements;

import elements.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddButton extends Base {

    public AddButton(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String ADD_BTN_XPATH = "//div[contains(@class, 'button-group')]//*[contains(text(), '%s')]";

    public void clickOnAddBtn() {
        driver.findElement(By.xpath(String.format(ADD_BTN_XPATH, label))).click();
    }
}
