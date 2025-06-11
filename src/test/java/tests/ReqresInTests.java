package tests;

import api.ApiRequests;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.*;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReqresInTests extends ApiRequests {

    User user = new User("morpheus", "leader");
    Register register = new Register("eve.holt@reqres.in", "pistol");

    @BeforeAll
    static void setup() {
        RestAssured.filters(withCustomTemplates());
    }

    @Test
    public void getAllUsersTest() {
        Response response = Allure.step("Отправка запроса для получения всех пользователей", this::getAllUsers);
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/all-users-schema.json"))
                    .statusCode(200);
        });
    }

    @Test
    public void getSingleUserTest() {
        Response response = Allure.step("Отправка запроса для получения пользователя", this::getSingleUsers);
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/single-user-schema.json"))
                    .statusCode(200);
        });
    }

    @Test
    public void getSingleUserNotFoundTest() {
        Response response = Allure.step("Отправка запроса для получения пользователя", this::getSingleUsersNotFound);
        Allure.step("Проверка статус-кода", () -> {
            Assertions.assertEquals(404, response.getStatusCode(),
                    "Статус-код не соответствует ожидаемому");
        });
    }

    @Test
    public void getListResourcesTest() {
        Response response = Allure.step("Отправка запроса для получения ресурса", this::getListResource);
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/all-list-resource.json"))
                    .statusCode(200);
        });
    }

    @Test
    public void getSingleResourceTest() {
        Response response = Allure.step("Отправка запроса для получения ресурса", this::getSingleResource);
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/single-list-resource.json"))
                    .statusCode(200);
        });
    }

    @Test
    public void getSingleResourcesNotFoundTest() {
        Response response = Allure.step("Отправка запроса для получения пользователя", this::getSingleResourceNotFound);
        Allure.step("Проверка статус-кода", () -> {
            Assertions.assertEquals(404, response.getStatusCode(),
                    "Статус-код не соответствует ожидаемому");
        });
    }

    @Test
    public void createUserTest() {
        Response response = Allure.step("Отправка запроса для получения ресурса", () -> createUser(user));
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/create-user.json"))
                    .statusCode(201);
        });
        Allure.step("Проверка name и job созданного объекта", () -> {
            Assertions.assertEquals("morpheus", response.as(CreateUser.class).name(),
                    "Имя не соответствует созданному");
            Assertions.assertEquals("leader", response.as(CreateUser.class).job(),
                    "Имя не соответствует созданному");
        });
    }

    @Test
    public void registerUserTest() {
        Response response = Allure.step("Отправка запроса для получения ресурса", () -> registerUser(register));
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/register-user.json"))
                    .statusCode(201);
        });
        Allure.step("Проверка name и job созданного объекта", () -> {
            Assertions.assertEquals("eve.holt@reqres.in", response.as(ResponseRegisterBody.class).email());
            Assertions.assertEquals("pistol", response.as(ResponseRegisterBody.class).password());
        });
    }

    @Test
    @Feature("Тест")
    @Story("Тест123")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Обновление пользователя")
    public void upDateUserPutTest() {

        upDateUser(user);
    }

    @Test
    public void upDateUserPatchTest() {
        User user = new User("Rab", "zion resident");
        uPDateUserPatch(user).getBody().prettyPrint();
    }

    @Test
    public void deleteUserTest() {
        deleteUser().getBody().prettyPrint();
    }

    @Test
    public void loginSuccessfulUserTest() {
        Register register = new Register("eve.holt@reqres.in", "cityslicka");
        loginUser(register).getBody().prettyPrint();
    }

    @Test
    public void loginUnSuccessfulUserTest() {
        Register register = new Register("eve.holt@reqres.in");
        loginUser(register).getBody().prettyPrint();
        System.out.println(loginUser(register).getStatusCode());
    }

    @Test
    public void getDelayedResponseTest() {
        getDelayedResponse().getBody().prettyPrint();
    }
}

