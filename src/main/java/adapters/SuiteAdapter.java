package adapters;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objects.Project;
import objects.Suite;

import java.util.List;

public class SuiteAdapter extends BaseAdapter{

    public ResponseBody addSuite(int projectId, Suite suite) {
        return post(String.format(ADD_SUITE_API, projectId), converter.toJson(suite)).body();
    }

    public ResponseBody deleteSuiteById(int suiteId, Suite suite) {
        return post(String.format(DELETE_SUITE_API, suiteId), converter.toJson(suite));
    }

    public ResponseBody updateSuiteById(int suiteId, Suite suite) {
        return post(String.format(UPDATE_SUITE_API, suiteId), converter.toJson(suite)).body();
    }

    public List getAllSuitesList(int projectId) {
        return getAllProjects(String.format(GET_ALL_SUITES_API, projectId));
    }

    public Response getAllSuites(int projectId) {
        return get(String.format(GET_ALL_SUITES_API, projectId));
    }

}
