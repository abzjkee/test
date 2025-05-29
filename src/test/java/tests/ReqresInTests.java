package tests;

import api.ApiRequests;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.*;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReqresInTests extends ApiRequests {

    @BeforeAll
    static void setup() {
        RestAssured.filters(withCustomTemplates()); // Включает логирование запросов/ответов в Allure
    }

    @Test
    public void getAllUsersTest() {
        Response response = Allure.step("Отправка запроса для получения всех пользователей", this::getAllUsers);
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/all-users-schema.json"));
        });
        Allure.step("Проверка статус-кода", () -> {
            Assertions.assertEquals(200, response.getStatusCode(),
                    "Статус-код не соответствует ожидаемому");
        });
    }

    @Test
    public void getSingleUserTest() {
        Response response = Allure.step("Отправка запроса для получения пользователя", this::getSingleUsers);
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/single-user-schema.json"));
        });
        Allure.step("Проверка статус-кода", () -> {
            Assertions.assertEquals(200, response.getStatusCode(),
                    "Статус-код не соответствует ожидаемому");
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
                    .body(matchesJsonSchemaInClasspath("schemes/all-list-resource.json"));
        });
        Allure.step("Проверка статус-кода", () -> {
            Assertions.assertEquals(200, response.getStatusCode(),
                    "Статус-код не соответствует ожидаемому");
        });
    }

    @Test
    public void getSingleResourceTest() {
        Response response = Allure.step("Отправка запроса для получения ресурса", this::getSingleResource);
        Allure.step("Проверка ответа на соответствие JSON Schema", () -> {
            response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchemaInClasspath("schemes/single-list-resource.json"));
        });
        Allure.step("Проверка статус-кода", () -> {
            Assertions.assertEquals(200, response.getStatusCode(),
                    "Статус-код не соответствует ожидаемому");
        });
    }

    @Test
    public void getSingleResourcesNotFoundTest() {
        System.out.println(getSingleResourceNotFound().getStatusCode());
    }

    @Test
    public void createUserTest() {
        User user = new User("morpheus", "leader");
        System.out.println(createUser(user).getStatusCode());

    }

    @Test
    public void registerUserTest() {
        Register register = new Register("eve.holt@reqres.in", "pistol");
        registerUser(register).getBody().prettyPrint();
    }

    @Test
    public void upDateUserPutTest() {
        User user = new User("loh", "Rab");
        upDateUser(user).getBody().prettyPrint();
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

