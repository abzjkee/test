package services;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserService {

    // Получение пользователя по ID
    public static Response getUser(int userId) {
        return given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}");
    }
}