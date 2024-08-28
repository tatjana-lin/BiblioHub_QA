package com.bibliotheque_API.tests.libraryController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.LibraryData;
import com.bibliotheque_API.dto.LibraryDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LibraryRegistrationTest extends TestBase_API {

    int id;
    LibraryDto requestDto = LibraryDto.builder()
            .name(LibraryData.name)
            .country(LibraryData.country)
            .city(LibraryData.city)
            .street(LibraryData.street)
            .number(LibraryData.number)
            .zip(LibraryData.zip)
            .phone(LibraryData.phone)
            .librarian_id(LibraryData.librarianId)
            .build();

    @Test
    public void registrationApiSuccessTest() {

        logger.info("Registration with data --> " + LibraryData.name + " * " + LibraryData.country + " * " + LibraryData.librarianId);

        id = given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.libRegister)
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");

    }

    @AfterMethod
    public void cleanUp() {

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .delete(EndpointData.libDelete + id);

    }


}
