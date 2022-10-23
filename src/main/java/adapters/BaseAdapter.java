package adapters;

import com.google.gson.Gson;
import constants.IBaseConstantsAPI;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import util.Specifications;
import static io.restassured.RestAssured.given;

@Log4j2
public class BaseAdapter implements IBaseConstantsAPI {

    Gson converter = new Gson();

    /*private static final RequestSpecification SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(BASE_URL_API)
            .setContentType(ContentType.JSON)
            .addHeader("Email", EMAIL_API)
            .addHeader("Api key", API_KEY)
            .build();*/

    public Response get(String url) {
        log.info("Sending API GET request with endpoint: " + url + " and email: " + EMAIL_API + " and API key: " + API_KEY);
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
        log.info("Sending API POST request with endpoint: " + url + " and email: " + EMAIL_API + " and API key: " + API_KEY);
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
}
