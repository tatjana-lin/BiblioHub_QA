package com.bibliotheque_API.tests.bookController;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.EndpointData;
import com.bibliotheque_API.dto.UploadFileDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddBooksFromJsonFileTest extends TestBase_API {

    UploadFileDto requestDto = UploadFileDto.builder()
            .filePath(BookData.filePath)
            .build();

    @Test
    public void addBooksFromJsonFileApiSuccessTest() {

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.addBookFromJson)
                .then()
                .assertThat().statusCode(200);

    }

}
