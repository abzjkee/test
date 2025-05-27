package api;

import schemas.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Asshurd {

    private final static String URL = "https://reqres.in";


    @Test
    public void getAllListUsers() {
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        System.out.println(users.getFirst().email());
    }

    public Response getSingleUsers() {
        return given()
                .when()
                .get(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response getSingleUsersNotFound() {
        return given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .get(URL + "/api/unknown/23");
    }

    public Response getListResource() {
        return given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .get(URL + "/api/unknown")
                .then()
                .extract().response();
    }

    //TODO ПРИМЕР
    @Test
    public void dublTest() {
        PageResource response = given()
                .when()
                .get(URL + "/api/unknown")
                .then()
                .extract().body().as(PageResource.class);
        Assertions.assertEquals("cerulean", response.data().getFirst().name(), "huy");

    }

    public Response getSingleResource() {
        return given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .get(URL + "/api/unknown/2")
                .then()
                .extract().response();
    }

    public Response getSingleResourceNotFound() {
        return given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .get(URL + "/api/unknown/23");
    }

    public Response createUser(Object user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .post(URL + "/api/users")
                .then().extract().response();
    }

    public Response registerUser(Object register) {
        return given()
                .contentType(ContentType.JSON)
                .body(register)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .post(URL + "/api/users")
                .then()
                .extract().response();
    }

    public Response upDateUser(Object user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .put(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response uPDateUserPatch(Object user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .patch(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response deleteUser() {
        return given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response loginUser(Object register) {
        return given()
                .contentType(ContentType.JSON)
                .body(register)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .post(URL + "/api/login")
                .then()
                .extract().response();
    }

    public Response getDelayedResponse() {
        return given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .queryParam("delay", 3)
                .get(URL + "/api/users")
                .then()
                .extract().response();
    }
}
