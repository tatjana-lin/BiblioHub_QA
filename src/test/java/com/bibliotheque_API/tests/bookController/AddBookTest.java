package com.bibliotheque_API.tests.bookController;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.EndpointData;
import com.bibliotheque_API.dto.BookDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddBookTest extends TestBase_API {
    int id;
    BookDto requestDto = BookDto.builder()
            .title(BookData.title)
            .authorName(BookData.authorName)
            .authorSurname(BookData.authorSurname)
            .year(BookData.year)
            .isbn(BookData.isbn)
            .publisher(BookData.publisher)
            .libraryId(3)
            .quantity(1)
            .available(1)
            .build();

    @Test
    public void addBookApiSuccessTest() {

        id = given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.addBook)
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");

    }

    @AfterMethod(enabled = true)
    public void cleanUp() {

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .delete(EndpointData.deleteBook + id);
    }

}
