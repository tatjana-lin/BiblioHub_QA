package com.bibliotheque_API.tests.userController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque_API.dto.UserRequestDto;
import com.bibliotheque_API.tests.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserUnlockTests extends TestBase {

    UserRequestDto requestDto = UserRequestDto.builder()
            .email(UserData.validEmail)
            .build();

    @Test
    public void adminUnlocksBlockedUserApiSuccessTest() {

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.block);

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.unlock)
                .then()
                .assertThat().statusCode(200);

    }


    @Test
    public void adminUnlocksBlockedUserApiNegativeTestWithInvalidEmail() {

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.block);

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(UserData.invalidEmail))
                .put(EndpointData.unlock)
                .then()
                .assertThat().statusCode(422);

        given()
                .contentType("application/json")
                .body(requestDto)
                .put("/users/unlock");

    }

    @Test
    public void adminUnlocksNonExistedUserApiNegativeTest() {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(UserData.wrongEmail))
                .put(EndpointData.unlock)
                .then()
                .assertThat().statusCode(404);

    }

    @Test
    public void adminUnlocksNonBlockedUserApiNegativeTest() {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(UserData.unlockedEmail))
                .put(EndpointData.unlock)
                .then()
                .assertThat().statusCode(409);
    }


}
