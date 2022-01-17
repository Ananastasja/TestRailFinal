package api_tests;

import adapters.ProjectAdapter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.BaseTest;

public class ProjectTest extends BaseTest {

    @Test(description = "Creating project via API")
    public void createProjectTest() {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        Project project = Project.builder()
                .name("Test Project")
                .build();
        ResponseBody createdProject = new ProjectAdapter().createProject(project);
        String nameFromApi = createdProject.path("name");
        int idFromApi = createdProject.path("id");
        Assert.assertEquals(nameFromApi, dashboardPage.getLastProjectName());
        Assert.assertTrue(idFromApi > 0);
    }

    @Test(description = "Deleting project via API by ID")
    public void deleteProjectByIdTest() {
        Project project = Project.builder()
                .name("Test Project")
                .build();
        int projectId = new ProjectAdapter().createProject(project).path("id");
        new ProjectAdapter().deleteProject(projectId, project);
        //assertion = status code, already in specification. So if test passes = status code asserted
    }

    @Test
    public void updateProjectByIdTest() {
        Project project = Project.builder()
                .name("Test Project")
                .build();
        int projectId = new ProjectAdapter().createProject(project).path("id");
        project = Project.builder()
                .announcement("This is announcement")
                .build();
        String announcementFromApi = new ProjectAdapter().updateProject(projectId, project).path("announcement");
        Assert.assertEquals(announcementFromApi, project.getAnnouncement());
    }

    @Test
    public void checkNumberOfProductsApiAndUiTest () {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        Response response = new ProjectAdapter().getAllProjects();
        String size = Integer.toString(response.body().path("projects.size"));
        Assert.assertEquals(dashboardPage.getNumberOfProjects(), size);
    }
}
