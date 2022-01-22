package elements.test_case_elements;

import elements.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Waiters;

public class TextArea extends Base {

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String TEXT_AREA_XPATH = "//label[contains(normalize-space(.), '%s')]/ancestor::*[contains(@class, 'form-group')]//*[contains(@class, 'field-editor')]";

    public void writeText(String text) {
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(TEXT_AREA_XPATH, label))), 10);
        driver.findElement(By.xpath(String.format(TEXT_AREA_XPATH, label))).sendKeys(text);
    }
}
