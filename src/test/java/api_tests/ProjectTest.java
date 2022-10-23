package api_tests;

import adapters.ProjectAdapter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objects.api.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.BaseTest;
import util.ObjectsData;

public class ProjectTest extends BaseTest {

    @Test(description = "Creating project via API", groups = {"Smoke", "Positive", "Regression"})
    public void createProjectTest() {
        ResponseBody createdProject = new ProjectAdapter().createProject(ObjectsData.projectData);
        String nameFromApi = createdProject.path("name");
        int idFromApi = createdProject.path("id");
        Assert.assertEquals(nameFromApi, ObjectsData.projectData.getName());
        Assert.assertTrue(idFromApi > 0);
    }

    @Test(description = "Deleting project via API by ID", groups = {"Smoke", "Positive", "Regression"})
    public void deleteProjectByIdTest() {
        Project project = ObjectsData.projectData;
        int projectId = new ProjectAdapter().createProject(project).path("id");
        new ProjectAdapter().deleteProject(projectId, project);
    }

    @Test(description = "Updating project via API using its ID", groups = {"Smoke", "Positive", "Regression"})
    public void updateProjectByIdTest() {
        Project project = ObjectsData.projectData;
        int projectId = new ProjectAdapter().createProject(project).path("id");
        project = Project.builder()
                .announcement("This is announcement")
                .build();
        String announcementFromApi = new ProjectAdapter().updateProject(projectId, project).path("announcement");
        Assert.assertEquals(announcementFromApi, project.getAnnouncement());
    }

    @Test(description = "Compare number of products via API and getting it from UI", groups = {"Positive", "Regression"})
    public void checkNumberOfProductsApiAndUiTest () {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        Response response = new ProjectAdapter().getAllProjects();
        String projectSize = Integer.toString(response.body().path("projects.size"));
        Assert.assertEquals(dashboardPage.getNumberOfProjects(), projectSize);
    }
}
