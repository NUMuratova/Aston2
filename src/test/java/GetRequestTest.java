import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetQueryParams() {
        String foo1 = "bar1";
        String foo2 = "bar2";

        Response response = given()
                .queryParam("foo1", foo1)
                .queryParam("foo2", foo2)
                .get("/get");

        response.then().statusCode(200);

        response.then().body("args.foo1", equalTo(foo1));
        response.then().body("args.foo2", equalTo(foo2));
    }
}