package elements.test_case_elements;

import elements.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown extends Base {

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String DROP_DOWN_FIELD_XPATH = "//label[contains(text(),'%s')]/ancestor::td//a";
    public static final String DROP_DOWN_OPTION_XPATH = "//li[contains(text(),'%s')]";

    public void selectOption(String option) {
        driver.findElement(By.xpath(String.format(DROP_DOWN_FIELD_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(DROP_DOWN_OPTION_XPATH, option))).click();
    }
}
