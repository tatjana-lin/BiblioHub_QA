package com.bibliotheque_API.tests.authController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque_API.dto.LoginRequestDto;
import com.bibliotheque_API.dto.RefreshRequestDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class RefreshTokenTests extends TestBase_API {

    LoginRequestDto requestDto = LoginRequestDto.builder()
            .email(UserData.validEmail)
            .password(UserData.validPassword)
            .build();
    String refreshToken;

    @BeforeMethod
    public void precondition() {

        refreshToken = given()
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.login)
                .then()
                .body(containsString("refreshToken"))
                .extract().path("refreshToken");

    }

    @Test
    public void refreshTokenApiSuccessTest(){

        RefreshRequestDto refreshRequestDto = RefreshRequestDto.builder()
                .refreshToken(refreshToken)
                .build();

        given()
                .contentType("application/json")
                .body(refreshRequestDto)
                .post(EndpointData.refresh)
                .then()
                .assertThat().statusCode(200);

    }


}
