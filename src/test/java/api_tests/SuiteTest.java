package api_tests;

import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objects.api.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.BaseTest;
import util.ObjectsData;

import java.util.List;

public class SuiteTest extends BaseTest {

    @Test(description = "Add test suite via API using project ID", groups = {"Smoke", "Positive", "Regression"})
    public void addSuiteTest() {
        Suite suite = ObjectsData.suiteData;
        int projectId = new ProjectAdapter().createProject(ObjectsData.projectData).path("id");
        String suiteName = new SuiteAdapter().addSuite(projectId, suite).path("name");
        Assert.assertEquals(suiteName, suite.getName());
    }

    @Test(description = "Deleting test suite via API by its ID", groups = {"Smoke", "Positive", "Regression"})
    public void deleteSuiteTest() {
        Suite suite = ObjectsData.suiteData;
        int projectId = new ProjectAdapter().createProject(ObjectsData.projectData).path("id");
        int suiteId = new SuiteAdapter().addSuite(projectId, suite).path("id");
        ResponseBody response = new SuiteAdapter().deleteSuiteById(suiteId, suite);
        Assert.assertFalse(response.toString().isEmpty());
    }

    @Test(description = "Updating test suite vi API by its ID", groups = {"Smoke", "Positive", "Regression"})
    public void updateSuiteTest() {
        Suite suite = ObjectsData.suiteData;
        int projectId = new ProjectAdapter().createProject(ObjectsData.projectData).path("id");
        int suiteId = new SuiteAdapter().addSuite(projectId, suite).path("id");
        suite = Suite.builder()
                .description("This is a test suite description")
                .build();
        String descriptionFromApi = new SuiteAdapter().updateSuiteById(suiteId, suite).path("description");
        Assert.assertEquals(descriptionFromApi, suite.getDescription());
    }

    @Test(description = "Get all IDs of all test suites and ensure they all are > 0", groups = {"Positive", "Regression"})
    public void getAllSuitesTest() {
        List<Suite> suites = new SuiteAdapter().getAllSuitesList(76);
        suites.forEach(x -> Assert.assertTrue(x.getId() > 0));
    }

    @Test(description = "Get the size of all test suites of a certain project and compare with expected size", groups = {"Positive", "Regression"})
    public void getAllSuitesAndGetSize() {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        Response response = new SuiteAdapter().getAllSuites(76);
        int suitesSize = response.body().path("suites.size");
        Assert.assertEquals(suitesSize, 3);
    }
}
