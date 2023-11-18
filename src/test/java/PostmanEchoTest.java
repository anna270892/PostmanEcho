import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void test() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json; charset=UTF-8")
                .body("{ \"id\": 1, \"age\": 31, \"name\": \"Anna\" }") // отправляемые данные (заголовки и query можно выставлять аналогично)

                // Выполняемые действия
                .when()
                .post("/post")

                // Проверки
                .then()
                .log().all()
                .statusCode(200)
                .body("json.id", equalTo(3)) // Проверка, что поле id содержит значение 1
                .body("json.age", equalTo(31)) // Проверка, что поле age содержит значение 31
                .body("json.name", equalTo("Anna")); // Проверка, что поле name содержит значение "Anna"
    }


}
