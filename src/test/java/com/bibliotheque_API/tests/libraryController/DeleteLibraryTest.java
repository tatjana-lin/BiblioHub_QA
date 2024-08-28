package com.bibliotheque_API.tests.libraryController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.LibraryData;
import com.bibliotheque_API.dto.LibraryDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteLibraryTest extends TestBase_API {
    int id;

    @BeforeMethod
    public void precondition() {

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

        id = given()
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.libRegister)
                .then()
                .extract().path("id");

    }

    @Test
    public void deleteLibraryByIdApiSuccessTest() {

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .delete(EndpointData.libDelete + id)
                .then()
                .assertThat().statusCode(200);

    }

}
