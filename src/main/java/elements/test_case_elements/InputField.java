package elements.test_case_elements;

import elements.Base;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Waiters;

@Log4j2
public class InputField extends Base {

    public InputField(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String INPUT_XPATH = "//input[@id='%s']";

    public void writeText(String text) {
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(INPUT_XPATH, label))), 10);
        log.debug("Input field locator is: " + INPUT_XPATH);
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }
}
