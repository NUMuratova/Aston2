import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRawTextTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testPostRawText() {
        String body = "{\n" +
                "  \"hand\": \"wave\"\n" +
                "}";

        Response response = given()
                .contentType("text/plain")
                .body(body)
                .post("/post");

        response.then().statusCode(200);

        response.then().body("data", equalTo(body));
    }
}
