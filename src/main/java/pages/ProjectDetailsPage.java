package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public MilestonePage clickOnAddMilestoneBtn() {
        addMilestoneBtn.click();
        return new MilestonePage(driver);
    }
}
