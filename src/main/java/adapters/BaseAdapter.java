package adapters;

import com.google.gson.Gson;
import constants.IBaseConstantsAPI;
import io.restassured.response.Response;
import util.Specifications;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IBaseConstantsAPI {

    Gson converter = new Gson();

    public Response get(String url) {
        Specifications.installSpecRequest(Specifications.requestSpecification(BASE_URL_API), Specifications.responseSpecification200());
        return
                given()
                        .auth().preemptive().basic(EMAIL_API, API_KEY)
                        .when()
                        .get(BASE_URL_API + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    public Response post(String url, String body) {
        Specifications.installSpecRequest(Specifications.requestSpecification(BASE_URL_API), Specifications.responseSpecification200());
        //не считывает базовый урл из спека
        return
                given()
                        .auth().preemptive().basic(EMAIL_API, API_KEY)
                        .body(body)
                        .when()
                        .post(BASE_URL_API + url)
                        .then()
                        .log().all()
                        .extract().response();
    }
}
