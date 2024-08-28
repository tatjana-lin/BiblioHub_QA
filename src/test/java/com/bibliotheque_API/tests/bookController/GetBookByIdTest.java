package com.bibliotheque_API.tests.bookController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookByIdTest extends TestBase_API {

    int id = 15;

    @Test
    public void getBookByIdApiSuccessTest() {

        given()
//                .header(AUTH, UserData.libraryEmail)
                .contentType("application/json")
                .get(EndpointData.getBookById + id)
                .then()
                .assertThat().statusCode(200);

    }

}
