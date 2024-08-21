package com.bibliotheque_API.tests.userController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque_API.dto.UserRequestDto;
import com.bibliotheque_API.dto.UserUpdateDto;
import com.bibliotheque_API.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserUpdateTests extends TestBase {

    UserRequestDto requestDto;
    int id;

    @BeforeMethod
    public void precondition() {

        requestDto = UserRequestDto.builder()
                .email(UserData.registerEmail)
                .password(UserData.registerPassword)
                .role(UserData.roleUser)
                .build();

        id = given()
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.register)
                .then()
                .extract().path("id");

        System.out.println(id);

    }
    UserUpdateDto updateDto = UserUpdateDto.builder()
            .id(id)
            .email(UserData.registerEmail)
            .name(UserData.firstName)
            .surname(UserData.lastName)
            .country(UserData.country)
            .city(UserData.city)
            .street(UserData.street)
            .number(UserData.house)
            .zip(UserData.zip)
            .phone(UserData.phone)
            .active(true)
            .build();

    @Test
    public void updateUserApiSuccessTest() {

        given()
                .contentType("application/json")
                .body(updateDto)
                .put(EndpointData.update)
                .then()
                .assertThat().statusCode(200);

        given()
                .contentType("application/json")
                .body(requestDto.getEmail())
                .when()
                .delete(EndpointData.delete);
    }


}
