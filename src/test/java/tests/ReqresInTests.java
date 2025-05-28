package tests;

import api.ApiRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import schemas.*;

public class ReqresInTests extends ApiRequests {

    @Test
    public void getAllUsersTest() {
       // getAllUsers().body().as(UserData.class).email();

    }

    @Test
    public void getSingleUserTest() {

       Response response = getSingleUsers();
       // System.out.println(response.body().as(ListResource.class).id());

    }

    @Test
    public void getSingleUserNotFoundTest() {
        System.out.println(getSingleUsersNotFound().getStatusCode());

    }

    @Test
    public void getListResourcesTest() {

        //PageResource list = getListResource().as(PageResource.class);


    }

    @Test
    public void getSingleResourceTest() {
        getSingleResource().getBody().prettyPrint();
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

