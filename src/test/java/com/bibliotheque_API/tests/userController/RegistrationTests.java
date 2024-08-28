package com.bibliotheque_API.tests.userController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque.utils.DataProviders;
import com.bibliotheque_API.dto.UserRequestDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegistrationTests extends TestBase_API {

    UserRequestDto requestDto = UserRequestDto.builder()
            .email(UserData.registerEmail)
            .password(UserData.registerPassword)
            .role(UserData.roleUser)
            .build();

//    @Test
//    public void registrationApiSuccessTest() {
//
//        given()
//                .contentType("application/json")
//                .body(requestDto)
//                .post(EndpointData.register)
//                .then()
//                .assertThat().statusCode(201);
//
//        given()
//                .contentType("application/json")
//                .body(requestDto)
//                .when()
//                .delete(EndpointData.delete);
//
//    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationApi")
    public void registrationApiSuccessTestFromCsv(String email, String password) {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(email)
                        .password(password)
                        .role(UserData.roleUser))
                .post(EndpointData.register)
                .then()
                .assertThat().statusCode(201);

//        given()
//                .contentType("application/json")
//                .body(requestDto)
//                .when()
//                .delete(EndpointData.delete);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationWithInvalidEmailApi")
    public void registrationApiNegativeTestWithInvalidEmailFromCsv(String email, String password) {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(email)
                        .password(password)
                        .role(UserData.roleUser))
                .post(EndpointData.register)
                .then()
                .assertThat().statusCode(422);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationWithInvalidPassApi")
    public void registrationApiNegativeTestWithInvalidPasswordFromCsv(String email, String password) {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(email)
                        .password(password)
                        .role(UserData.roleUser))
                .post(EndpointData.register)
                .then()
                .assertThat().statusCode(422);

    }

    @Test
    public void registrationApiNegativeTestUserAlreadyExists() {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(UserData.validEmail)
                        .password(UserData.validPassword)
                        .role(UserData.roleUser))
                .post(EndpointData.register)
                .then()
                .assertThat().statusCode(409);

    }


}
