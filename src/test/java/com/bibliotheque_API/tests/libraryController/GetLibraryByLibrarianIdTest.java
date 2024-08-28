package com.bibliotheque_API.tests.libraryController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetLibraryByLibrarianIdTest extends TestBase_API {

    String id = "3";

    @Test
    public void getLibraryByLibrarianIdApiSuccessTest() {

        given()
//                .header(AUTH, UserData.libraryEmail)
                .contentType("application/json")
                .get(EndpointData.getLibraryByLibrarianId + id)
                .then()
                .assertThat().statusCode(200);

    }

}
