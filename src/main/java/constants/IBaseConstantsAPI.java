package constants;

import util.PropertyReader;

public interface IBaseConstantsAPI {

    String BASE_URL_API = "https://ananastasjaa.testrail.io/index.php?/api/v2/";
    String ADD_PROJECT_URL = "add_project";
    String DELETE_PROJECT_URL = "delete_project/%d";
    String UPDATE_PROJECT_API = "update_project/%d";
    String GET_ALL_PROJECTS_API = "get_projects";
    String API_KEY = System.getProperty("key", PropertyReader.getProperty("api.key"));
    String EMAIL_API = System.getProperty("email", PropertyReader.getProperty("email"));
}
