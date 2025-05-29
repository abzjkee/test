package api;

import io.restassured.response.Response;
import specs.Specs;

import static io.restassured.RestAssured.given;


public class ApiRequests {

    public Response getAllUsers() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .get("/api/users?page=2")
                .then()
                .extract().response();
    }

    public Response getSingleUsers() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .get("/api/users/2")
                .then()
                .extract().response();
    }

    public Response getSingleUsersNotFound() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .get("/api/unknown/23");
    }

    public Response getListResource() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .get("/api/unknown")
                .then()
                .extract().response();
    }

    public Response getSingleResource() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .get("/api/unknown/2")
                .then()
                .extract().response();
    }

    public Response getSingleResourceNotFound() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .get("/api/unknown/23");
    }

    public Response createUser(Object user) {
        return given()
                .spec(Specs.baseSpec())
                .body(user)
                .when()
                .post("/api/users")
                .then().extract().response();
    }

    public Response registerUser(Object register) {
        return given()
                .spec(Specs.baseSpec())
                .body(register)
                .when()
                .post("/api/users")
                .then()
                .extract().response();
    }

    public Response upDateUser(Object user) {
        return given()
                .spec(Specs.baseSpec())
                .body(user)
                .when()
                .put("/api/users/2")
                .then()
                .extract().response();
    }

    public Response uPDateUserPatch(Object user) {
        return given()
                .spec(Specs.baseSpec())
                .body(user)
                .when()
                .patch("/api/users/2")
                .then()
                .extract().response();
    }

    public Response deleteUser() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .delete("/api/users/2")
                .then()
                .extract().response();
    }

    public Response loginUser(Object register) {
        return given()
                .spec(Specs.baseSpec())
                .body(register)
                .when()
                .post("/api/login")
                .then()
                .extract().response();
    }

    public Response getDelayedResponse() {
        return given()
                .spec(Specs.baseSpec())
                .when()
                .queryParam("delay", 3)
                .get("/api/users")
                .then()
                .extract().response();
    }
}
