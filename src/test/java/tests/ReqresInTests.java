package tests;

import api.Asshurd;
import org.junit.jupiter.api.Test;
import schemas.PageResource;
import schemas.Register;
import schemas.User;

public class ReqresInTests extends Asshurd {

    @Test
    public void getSingleUserTest() {
        getSingleUsers().getBody().prettyPrint();

    }

    @Test
    public void getSingleUserNotFoundTest() {
        System.out.println(getSingleUsersNotFound().getStatusCode());

    }

    @Test
    public void getListResourcesTest() {
        getListResource();
        PageResource list = getListResource().as(PageResource.class);
        System.out.println(list.data().getFirst().name());
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

    //TODO сдлеать второй конструктор в классе и перегрузить его
    @Test
    public void loginUnSuccessfulUserTest() {
        Register register = new Register("eve.holt@reqres.in", "cityslicka");
        loginUser(register);
    }

    @Test
    public void getDelayedResponseTest() {
        getDelayedResponse().getBody().prettyPrint();
    }
}

