package util;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Log4j2
public class Waiters {

    public static void waitForElementLocated(WebDriver driver, By element, int timeout) {
        log.debug("Waiter's timeout is: " + timeout + " for element: " + element);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForElementLocated(WebDriver driver, WebElement element, int timeout) {
        log.debug("Waiter's timeout is: " + timeout + " for element: " + element);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementLocated(WebDriver driver, List<WebElement> elements, int timeout) {
        log.debug("Waiter's timeout is: " + timeout + " for elements: " + elements);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
