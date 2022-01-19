package api_tests;

import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objects.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.BaseTest;
import util.ObjectsData;

import java.util.List;

public class SuiteTest extends BaseTest {

    @Test(description = "Adding test suite to the project")
    public void addSuiteTest() {
        Suite suite = ObjectsData.suiteData;
        int projectId = new ProjectAdapter().createProject(ObjectsData.projectData).path("id");
        String suiteName = new SuiteAdapter().addSuite(projectId, suite).path("name");
        Assert.assertEquals(suiteName, suite.getName());
    }

    @Test(description = "Deleting test suite from a project")
    public void deleteSuiteTest() {
        Suite suite = ObjectsData.suiteData;
        int projectId = new ProjectAdapter().createProject(ObjectsData.projectData).path("id");
        int suiteId = new SuiteAdapter().addSuite(projectId, suite).path("id");
        ResponseBody response = new SuiteAdapter().deleteSuiteById(suiteId, suite);
        Assert.assertFalse(response.toString().isEmpty());
        //+assertion of status code via spec
    }

    @Test(description = "Partially updating test suite")
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

    @Test(description = "Getting all test suites and ensure that they have an ID > 0")
    public void getAllSuitesTest() {
        List<Suite> suites = new SuiteAdapter().getAllSuitesList(76);
        suites.forEach(x -> Assert.assertTrue(x.getId() > 0));
    }

    @Test(description = "Getting all test suites and ensure that there is the right number of them")
    public void getAllSuitesAndGetSize() {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        Response response = new SuiteAdapter().getAllSuites(76);
        int suitesSize = response.body().path("suites.size");
        Assert.assertEquals(suitesSize, 3);
    }
}
