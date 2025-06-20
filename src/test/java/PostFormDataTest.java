import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostFormDataTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testPostFormData() {
        String foo1 = "bar1";
        String foo2 = "bar2";

        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", foo1)
                .formParam("foo2", foo2)
                .post("/post");

        response.then().statusCode(200);

        response.then().body("form.foo1", equalTo(foo1));
        response.then().body("form.foo2", equalTo(foo2));
    }
}