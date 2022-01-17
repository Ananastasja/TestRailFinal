package adapters;

import com.google.gson.Gson;
import constants.IBaseConstantsAPI;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.Suite;
import util.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IBaseConstantsAPI {

    Gson converter = new Gson();

    /*private static final RequestSpecification SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(BASE_URL_API)
            .setContentType(ContentType.JSON)
            .addHeader("Email", EMAIL_API)
            .addHeader("Api key", API_KEY)
            .build();*/

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

    public List getAllProjects(String url) {
        Specifications.installSpecRequest(Specifications.requestSpecification(BASE_URL_API), Specifications.responseSpecification200());
        return given()
                .auth().preemptive().basic(EMAIL_API, API_KEY)
                .when()
                .get(BASE_URL_API + url)
                .then()
                .log().all()
                .extract().body().jsonPath().getList("suites", Suite.class);
    }
}
