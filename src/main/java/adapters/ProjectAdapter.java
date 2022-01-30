package adapters;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.log4j.Log4j2;
import objects.api.Project;

@Log4j2
public class ProjectAdapter extends BaseAdapter {
    public ResponseBody createProject(Project project) {
        log.info("Creating project: " + project);
        return post(ADD_PROJECT_URL, converter.toJson(project)).body();
    }

    public ResponseBody deleteProject(int projectId, Project project) {
        log.info("Deleting project with id: " + projectId);
        return post(String.format(DELETE_PROJECT_URL, projectId), converter.toJson(project)).body();
    }

    public ResponseBody updateProject(int projectId, Project project) {
        log.info("Updating project with id: " + projectId);
        return post(String.format(UPDATE_PROJECT_API, projectId), converter.toJson(project)).body();
    }

    public Response getAllProjects() {
        log.info("Getting all created projects");
        return get(GET_ALL_PROJECTS_API);
    }
}
