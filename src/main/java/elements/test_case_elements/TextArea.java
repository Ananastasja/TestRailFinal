package elements.test_case_elements;

import elements.Base;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Waiters;

@Log4j2
public class TextArea extends Base {

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String TEXT_AREA_XPATH = "//label[contains(normalize-space(.), '%s')]/ancestor::*[contains(@class, 'form-group')]//*[contains(@class, 'field-editor')]";

    public void writeText(String text) {
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(TEXT_AREA_XPATH, label))), 10);
        log.info(String.format("Send keys to text area: '%s' with text: '%s'", label, text));
        log.debug("Text area locator is: " + TEXT_AREA_XPATH);
        driver.findElement(By.xpath(String.format(TEXT_AREA_XPATH, label))).sendKeys(text);
    }
}
