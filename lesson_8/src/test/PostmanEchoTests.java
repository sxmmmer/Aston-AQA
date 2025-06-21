import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {
    private final String BASE_URL = "https://postman-echo.com";

    @Test
    void getRequestTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when().get(BASE_URL + "/get")
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .statusCode(200);
    }

    @Test
    void postRawTextTest() {
        given()
                .contentType("application/json")
                .body("{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}")
                .when().post(BASE_URL + "/post")
                .then()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .statusCode(200);
    }

    @Test
    void postFormDataTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().post(BASE_URL + "/post")
                .then()
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .statusCode(200);
    }

    @Test
    void putRequestTest() {
        String expectedText = "This is expected to be sent back as part of response body.";

        given()
                .header("Content-Type", "text/plain")
                .body(expectedText)
                .when().put(BASE_URL + "/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(expectedText));
    }

    @Test
    void patchRequestTest() {
        String expectedText = "This is expected to be sent back as part of response body.";

        given()
                .header("Content-Type", "text/plain")
                .body(expectedText)
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(expectedText));
    }

    @Test
    void deleteRequestTest() {
        String expectedText = "This is expected to be sent back as part of response body.";

        given()
                .header("Content-Type", "text/plain")
                .body(expectedText)
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(expectedText));
    }
}
