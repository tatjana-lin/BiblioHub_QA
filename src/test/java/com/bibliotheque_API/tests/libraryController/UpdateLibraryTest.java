package com.bibliotheque_API.tests.libraryController;

import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.LibraryData;
import com.bibliotheque_API.dto.LibraryDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateLibraryTest extends TestBase_API {

    @Test
    public void updateLibraryApiSuccessTest() {

        LibraryDto requestDto = LibraryDto.builder()
                .id(LibraryData.id)
                .name(LibraryData.name)
                .country(LibraryData.country)
                .city(LibraryData.city)
                .street(LibraryData.street)
                .number(LibraryData.number)
                .zip(LibraryData.zip)
                .phone(LibraryData.phone)
                .librarian_id(LibraryData.librarianId)
                .build();

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.libUpdate)
                .then()
                .assertThat().statusCode(200);

    }

    @AfterMethod
    public void restoreProfile(){

        LibraryDto requestDto = LibraryDto.builder()
                .id(LibraryData.id)
                .name(LibraryData.oldName)
                .country(LibraryData.country)
                .city(LibraryData.city)
                .street(LibraryData.street)
                .number(LibraryData.number)
                .zip(LibraryData.zip)
                .phone(LibraryData.oldPhone)
                .librarian_id(LibraryData.librarianId)
                .build();

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .body(requestDto)
                .put(EndpointData.libUpdate);

    }


}
