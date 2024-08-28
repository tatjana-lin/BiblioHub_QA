package com.bibliotheque_API.tests.libraryController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllLibrariesTest extends TestBase_API {

    @Test
    public void getAllLibrariesListApiSuccessTest() {

        given()
//                .header(AUTH, UserData.libraryEmail)
                .contentType("application/json")
                .get(EndpointData.getAllLibraries)
                .then()
                .assertThat().statusCode(200);

    }

}
