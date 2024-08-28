package com.bibliotheque_API.tests.userController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque.utils.DataProviders;
import com.bibliotheque_API.dto.UserRequestDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests extends TestBase_API {
    @Test
    public void deleteUserApiSuccessTest() {

        UserRequestDto requestDto = UserRequestDto.builder()
                .email(UserData.registerEmail)
                .password(UserData.registerPassword)
                .role(UserData.roleUser)
                .build();

        given()
                .contentType("application/json")
                .body(requestDto)
                .when()
                .post(EndpointData.register);

        given()
                .contentType("application/json")
                .body(requestDto)
                .when()
                .delete(EndpointData.delete)
                .then()
                .assertThat().statusCode(200);
    }

//    @Test
//    public void deleteUserApiSuccessDemoTest() {
//
//        given()
//                .contentType("application/json")
//                .body(UserRequestDto.builder()
//                        .email(UserData.registerEmail).build())
//                .when()
//                .delete(EndpointData.delete)
//                .then()
//                .assertThat().statusCode(200);
//    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationApi")
    public void deleteUserApiSuccessTestFromCsv(String email, String password) {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(email)
                        .password(password)
                        .role(UserData.roleUser))
                .when()
                .delete(EndpointData.delete)
                .then()
                .assertThat().statusCode(200);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveDeleteApi")
    public void deleteUserApiSuccessTestFromCsvFront(String email, String password) {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(email)
                        .password(password)
                        .role(UserData.roleUser))
                .when()
                .delete(EndpointData.delete)
                .then()
                .assertThat().statusCode(200);
    }

}
