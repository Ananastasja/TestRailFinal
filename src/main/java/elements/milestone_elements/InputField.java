package elements.milestone_elements;

import elements.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Waiters;

public class InputField extends Base {

    public InputField(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String INPUT_XPATH = "//input[@id='%s']";

    public void writeText(String text) {
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(INPUT_XPATH, label))), 10);
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }
}
