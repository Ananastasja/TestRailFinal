package elements.test_case_elements;

import elements.Base;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddButton extends Base {

    public AddButton(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String ADD_BTN_XPATH = "//div[contains(@class, 'button-group')]//*[contains(text(), '%s')]";

    public void clickOnAddBtn() {
        log.debug("Button locator is: " + ADD_BTN_XPATH);
        driver.findElement(By.xpath(String.format(ADD_BTN_XPATH, label))).click();
    }
}
