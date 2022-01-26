package elements.milestone_elements;

import elements.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import util.Waiters;

import java.util.List;

public class CalenderInput extends Base {

    public CalenderInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String CALENDER_INPUT_XPATH = "//input[@id='%s']";
    public static final String DATE_XPATH = "//div[contains(@id,'ui-datepicker-div')]//a[text()='%s']";
    @FindBys(@FindBy(xpath = "//a[contains(@class, 'ui-state-default')]"))
    List<WebElement> calenderDates;

    public List<WebElement> getCalenderDates() {
        return calenderDates;
    }

    public void clickOnCalender(String date) {
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(CALENDER_INPUT_XPATH, label))), 10);
        driver.findElement(By.xpath(String.format(CALENDER_INPUT_XPATH, label))).click();
        Waiters.waitForElementLocated(driver, driver.findElement(By.xpath(String.format(DATE_XPATH, date))), 10);
        driver.findElement(By.xpath(String.format(DATE_XPATH, date))).click();
    }
}
