package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ProjectDetailsPage extends HeaderPage{
    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sidebar-milestones-add")
    WebElement addMilestoneBtn;
    @FindBy(id = "chartobject-1")
    WebElement projectChart;

    public boolean isProjectChartVisible() {
        return projectChart.isDisplayed();
    }

    @Step("Clicking on 'Add milestone' button on Project details page")
    public CreateMilestonePage clickOnAddMilestoneBtn() {
        log.info("Clicking on 'Add milestone' button");
        log.debug("'Add milestone' button locator is: " + addMilestoneBtn);
        addMilestoneBtn.click();
        return new CreateMilestonePage(driver);
    }
}
