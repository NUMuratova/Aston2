import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRawTextTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testPatchRawText() {
        String body = "hand wave";

        Response response = given()
                .contentType("text/plain")
                .body(body)
                .patch("/patch");

        response.then().statusCode(200);

        response.then().body("data", equalTo(body));
    }
}
