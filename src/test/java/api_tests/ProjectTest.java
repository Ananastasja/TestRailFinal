package api_tests;

import adapters.ProjectAdapter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui_tests.BaseTest;
import util.ObjectsData;

public class ProjectTest extends BaseTest {

    @Test(description = "Creating project via API")
    public void createProjectTest() {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        ResponseBody createdProject = new ProjectAdapter().createProject(ObjectsData.projectData);
        String nameFromApi = createdProject.path("name");
        int idFromApi = createdProject.path("id");
        Assert.assertEquals(nameFromApi, dashboardPage.getLastProjectName());
        Assert.assertTrue(idFromApi > 0);
    }

    @Test(description = "Deleting project via API by ID")
    public void deleteProjectByIdTest() {
        Project project = ObjectsData.projectData;
        int projectId = new ProjectAdapter().createProject(project).path("id");
        new ProjectAdapter().deleteProject(projectId, project);
    }

    @Test(description = "Updating project by ID")
    public void updateProjectByIdTest() {
        Project project = ObjectsData.projectData;
        int projectId = new ProjectAdapter().createProject(project).path("id");
        project = Project.builder()
                .announcement("This is announcement")
                .build();
        String announcementFromApi = new ProjectAdapter().updateProject(projectId, project).path("announcement");
        Assert.assertEquals(announcementFromApi, project.getAnnouncement());
    }

    @Test(description = "Comparing number of projects displayed in UI and those got via API request")
    public void checkNumberOfProductsApiAndUiTest () {
        loginSteps.loginAndClickLoginBtn(EMAIL_UI, PASSWORD_UI);
        Response response = new ProjectAdapter().getAllProjects();
        String projectSize = Integer.toString(response.body().path("projects.size"));
        Assert.assertEquals(dashboardPage.getNumberOfProjects(), projectSize);
    }

}
