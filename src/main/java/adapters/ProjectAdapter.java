package adapters;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objects.api.Project;

public class ProjectAdapter extends BaseAdapter {
    public ResponseBody createProject(Project project) {
        return post(ADD_PROJECT_URL, converter.toJson(project)).body();
    }

    public ResponseBody deleteProject(int projectId, Project project) {
        return post(String.format(DELETE_PROJECT_URL, projectId), converter.toJson(project)).body();
    }

    public ResponseBody updateProject(int projectId, Project project) {
        return post(String.format(UPDATE_PROJECT_API, projectId), converter.toJson(project)).body();
    }

    public Response getAllProjects() {
        return get(GET_ALL_PROJECTS_API);
    }
}
