package com.bibliotheque_API.tests.authController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque.utils.DataProviders;
import com.bibliotheque_API.dto.LoginRequestDto;
import com.bibliotheque_API.tests.TestBase_API;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTests extends TestBase_API {

    LoginRequestDto requestDto = LoginRequestDto.builder()
            .email(UserData.validEmail)
            .password(UserData.validPassword)
            .build();


    @Test
    public void loginApiSuccessTest() {

        given()
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.login)
                .then()
                .assertThat().statusCode(200);

    }

    @Test
    public void loginApiNegativeTestWithWrongEmail() {

        given()
                .body(LoginRequestDto.builder()
                        .email(UserData.wrongEmail)
                        .password(UserData.validPassword).build())
                .contentType(ContentType.JSON)
                .when()
                .post(EndpointData.login)
                .then()
                .assertThat().statusCode(404);

    }

    @Test
    public void loginApiNegativeTestWithWrongPass() {

        given()
                .body(LoginRequestDto.builder()
                        .email(UserData.validEmail)
                        .password(UserData.wrongPassword).build())
                .contentType(ContentType.JSON)
                .when()
                .post(EndpointData.login)
                .then()
                .assertThat().statusCode(403);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeLoginWithInvalidEmailFromCsv")
    public void loginApiNegativeTestWithInvalidEmailFromCsv(String email, String password) {

        given()
                .body(LoginRequestDto.builder()
                        .email(email)
                        .password(password).build())
                .contentType(ContentType.JSON)
                .when()
                .post(EndpointData.login)
                .then()
                .assertThat().statusCode(422);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeLoginWithInvalidPassApi")
    public void loginApiNegativeTestWithInvalidPassFromCsv(String email, String password) {

        given()
                .body(LoginRequestDto.builder()
                        .email(email)
                        .password(password).build())
                .contentType(ContentType.JSON)
                .when()
                .post(EndpointData.login)
                .then()
                .assertThat().statusCode(422);

    }

}
