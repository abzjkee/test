package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiRequests {

    private final static String URL = "https://reqres.in";
    public static final String HEADER = "x-api-key";
    public static final String VALUE = "reqres-free-v1";


    public Response getAllUsers() {
        return given()
                .when()
                .header(HEADER, VALUE)
                .get(URL + "/api/users?page=2")
                .then()
                .extract().response();
    }

    public Response getSingleUsers() {
        return given()
                .when()
                .header(HEADER, VALUE)
                .get(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response getSingleUsersNotFound() {
        return given()
                .when()
                .header(HEADER, VALUE)
                .get(URL + "/api/unknown/23");
    }

    public Response getListResource() {
        return given()
                .when()
                .header(HEADER, VALUE)
                .get(URL + "/api/unknown")
                .then()
                .extract().response();
    }

    public Response getSingleResource() {
        return given()
                .when()
                .header(HEADER, VALUE)
                .get(URL + "/api/unknown/2")
                .then()
                .extract().response();
    }

    public Response getSingleResourceNotFound() {
        return given()
                .when()
                .header(HEADER, VALUE)
                .get(URL + "/api/unknown/23");
    }

    public Response createUser(Object user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .header(HEADER, VALUE)
                .when()
                .post(URL + "/api/users")
                .then().extract().response();
    }

    public Response registerUser(Object register) {
        return given()
                .contentType(ContentType.JSON)
                .body(register)
                .header(HEADER, VALUE)
                .when()
                .post(URL + "/api/users")
                .then()
                .extract().response();
    }

    public Response upDateUser(Object user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .header(HEADER, VALUE)
                .when()
                .put(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response uPDateUserPatch(Object user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .header(HEADER, VALUE)
                .when()
                .patch(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response deleteUser() {
        return given()
                .contentType(ContentType.JSON)
                .header(HEADER, VALUE)
                .when()
                .delete(URL + "/api/users/2")
                .then()
                .extract().response();
    }

    public Response loginUser(Object register) {
        return given()
                .contentType(ContentType.JSON)
                .body(register)
                .header(HEADER, VALUE)
                .when()
                .post(URL + "/api/login")
                .then()
                .extract().response();
    }

    public Response getDelayedResponse() {
        return given()
                .when()
                .header(HEADER, VALUE)
                .queryParam("delay", 3)
                .get(URL + "/api/users")
                .then()
                .extract().response();
    }
}
