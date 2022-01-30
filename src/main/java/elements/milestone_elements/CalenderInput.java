package elements.milestone_elements;

import elements.Base;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Waiters;

@Log4j2
public class CalenderInput extends Base {

    public CalenderInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String CALENDER_INPUT_XPATH = "//input[@id='%s']";
    public static final String DATE_XPATH = "//div[contains(@id,'ui-datepicker-div')]//a[text()='%s']";

    public void clickOnCalender(String date) {
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(CALENDER_INPUT_XPATH, label))), 10);
        log.info(String.format("Click on calender: '%s'", label));
        log.debug("Calender locator is: " + CALENDER_INPUT_XPATH);
        driver.findElement(By.xpath(String.format(CALENDER_INPUT_XPATH, label))).click();
        log.info(String.format("Choose date: '%s'", date));
        log.debug("Date locator is: " + DATE_XPATH);
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(DATE_XPATH, date))), 10);
        driver.findElement(By.xpath(String.format(DATE_XPATH, date))).click();
    }
}
