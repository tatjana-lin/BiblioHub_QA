package com.bibliotheque_API.tests.userController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque_API.dto.UserRequestDto;
import com.bibliotheque_API.tests.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserBlockTests extends TestBase {

    UserRequestDto requestDto = UserRequestDto.builder()
            .email(UserData.validEmail)
            .build();


    @Test
    public void adminBlocksUserApiSuccessTest() {

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.block)
                .then()
                .assertThat().statusCode(200);

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.unlock);

    }

    @Test
    public void adminBlocksUserApiNegativeTestWithInvalidEmail() {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(UserData.invalidEmail))
                .put(EndpointData.block)
                .then()
                .assertThat().statusCode(422);

    }


    @Test
    public void adminBlocksNonExistedUserApiNegativeTest() {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(UserData.wrongEmail))
                .put("/users/block")
                .then()
                .assertThat().statusCode(404);

    }

    //=========================== поменять статус код во 2м . Баг 200 ===============================================
    @Test
    public void adminBlocksAlreadyBlockedUserApiNegativeTest() {

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.block)
                .then()
                .assertThat().statusCode(200);

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.block)
                .then()
                .assertThat().statusCode(409);

        given()
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.unlock);

    }


}
