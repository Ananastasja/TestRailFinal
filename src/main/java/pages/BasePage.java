package pages;

import constants.IBaseConstantsUI;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class BasePage implements IBaseConstantsUI {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Opening url: '{url}'")
    public void openPage(String url) {
        log.info("Opening url: " + url);
        driver.get(url);
    }
}
