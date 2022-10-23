package adapters;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.log4j.Log4j2;
import objects.api.Suite;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class SuiteAdapter extends BaseAdapter{

    public ResponseBody addSuite(int projectId, Suite suite) {
        log.info("Creating suite for project with id: " + projectId);
        return post(String.format(ADD_SUITE_API, projectId), converter.toJson(suite)).body();
    }

    public ResponseBody deleteSuiteById(int suiteId, Suite suite) {
        log.info("Deleting suite with id: " + suiteId);
        return post(String.format(DELETE_SUITE_API, suiteId), converter.toJson(suite));
    }

    public ResponseBody updateSuiteById(int suiteId, Suite suite) {
        log.info("Updating suite with id: " + suiteId);
        return post(String.format(UPDATE_SUITE_API, suiteId), converter.toJson(suite)).body();
    }

    public List<Suite> getAllSuitesList(int projectId) {
        log.info("Getting all suites from project with id: " + projectId);
        return new ArrayList<>(get(String.format(GET_ALL_SUITES_API, projectId)).body().jsonPath().getList(".", Suite.class));
    }

    public Response getAllSuites(int projectId) {
        log.info("Getting all suites from project with id: " + projectId);
        return get(String.format(GET_ALL_SUITES_API, projectId));
    }
}
