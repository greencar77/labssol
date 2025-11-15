package pkb.xdemo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class MainTest {

    static {
        RestAssured.baseURI = "https://httpbin.org";
    }

    @Test
	public void testGet() {
        when()
             .get("/get")
        .then()
            .statusCode(200)
            .body("url", equalTo("https://httpbin.org/get"));
	}

    @Test
	public void testPost() {
        String requestBody = """
        {
            "name": "John Doe",
            "job": "Software Engineer"
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/anything")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://httpbin.org/anything"));
	}
}