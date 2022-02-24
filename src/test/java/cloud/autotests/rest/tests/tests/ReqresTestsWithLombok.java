package cloud.autotests.rest.tests.tests;


import annotations.Layer;
import cloud.autotests.rest.tests.lombok.CreateUserRequest;
import cloud.autotests.rest.tests.lombok.CreateUserResponse;
import cloud.autotests.rest.tests.lombok.RegisterUser;
import cloud.autotests.rest.tests.lombok.Users;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static cloud.autotests.rest.tests.filters.CustomLogFilter.customLogFilter;
import static cloud.autotests.rest.tests.spec.SpecsReqres.request;
import static cloud.autotests.rest.tests.spec.SpecsReqres.responseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;

@Layer("api")
@Owner("zatulivetrova")
@Story("Reqres")
@Feature("API test")
@Tags({@Tag("all_tests")})

public class ReqresTestsWithLombok {

    @Test
    @DisplayName("Получение списка пользователей")
    void getUserListwithLombok() {
        Users data = given().spec(request)
                .when()
                .get("/users?page=2")
                .then()
                .log().body()
                .extract().as(Users.class);
    }

    @Test
    @DisplayName("Проверка наличия пользователя в базе")
    void getSingleUserNotFound() {
        given()
                .spec(request)
                .when()
                .get("/users/23")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("Создание пользователя")
    void createUserLombok() {
        CreateUserRequest newCreateuser = new CreateUserRequest("ivan", "driver");

        CreateUserResponse response = given().spec(request)
                .filter(customLogFilter().withCustomTemplates())
                .body(newCreateuser)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().as(CreateUserResponse.class);

        assertEquals(newCreateuser.getName(), response.getName());
        assertEquals(newCreateuser.getJob(), response.getJob());
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getCreatedAt().isEmpty());

    }

    @Test
    @DisplayName("Обновление пользователя")
    void updateUserLombok() {
        CreateUserRequest newCreateuser = new CreateUserRequest("morpheus", "zion resident");

        CreateUserResponse response = given().spec(request)
                .body(newCreateuser)
                .when()
                .put("/users/2")
                .then()
                .spec(responseSpec)
                .extract().as(CreateUserResponse.class);

        assertEquals(newCreateuser.getName(), response.getName());
        assertEquals(newCreateuser.getJob(), response.getJob());
    }

    @Test
    @DisplayName("Регистрация пользователя")
    void registerSuccessfulLombok() {
        RegisterUser registrationData = new RegisterUser();
        registrationData.setEmail("eve.holt@reqres.in");
        registrationData.setPassword("pistol");

        CreateUserResponse response = given().spec(request)
                .body(registrationData)
                .when()
                .post("/register")
                .then()
                .spec(responseSpec)
                .extract().as(CreateUserResponse.class);


        assertEquals("4", response.getId());
        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

    @Test
    @DisplayName("Получение одного пользователя")
    void singleUserWithLombok() {
        int expectedId = 2;
        Users userResponse = given().spec(request)
                .when()
                .pathParam("id", "2")
                .get("/users/{id}")
                .then()
                .spec(responseSpec)
                .extract().as(Users.class);

        assertEquals(expectedId, userResponse.getId());
    }

    @Test
    @DisplayName("Проверка id и email пользователя")
    void checkIdAndEmailOfFeaturedUser() {
        Users userResponse = given().spec(request)
                .when()
                .pathParam("id", "2")
                .get("/users/{id}")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().jsonPath().getObject("data", Users.class);

        assertEquals(2, userResponse.getId());
        assertTrue(userResponse.getEmail().endsWith("@reqres.in"));
    }


    @Test
    @DisplayName("Проверка email пользователя с помощью Groovy")
    public void checkEmailUsingGroovy() {

        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));
    }
}

