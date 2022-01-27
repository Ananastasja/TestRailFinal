package elements.test_case_elements;

import elements.Base;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown extends Base {

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String DROP_DOWN_FIELD_XPATH = "//label[contains(text(),'%s')]/ancestor::td//a";
    public static final String DROP_DOWN_OPTION_XPATH = "//li[contains(text(),'%s')]";

    public void selectOption(String option) {
        log.debug("Dropdown locator is: " + DROP_DOWN_FIELD_XPATH);
        driver.findElement(By.xpath(String.format(DROP_DOWN_FIELD_XPATH, label))).click();
        log.debug("Dropdown option locator is: " + DROP_DOWN_OPTION_XPATH);
        driver.findElement(By.xpath(String.format(DROP_DOWN_OPTION_XPATH, option))).click();
    }
}
