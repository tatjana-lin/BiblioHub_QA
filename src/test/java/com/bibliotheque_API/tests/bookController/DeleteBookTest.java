package com.bibliotheque_API.tests.bookController;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.LibraryData;
import com.bibliotheque_API.dto.BookDto;
import com.bibliotheque_API.dto.LibraryDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookTest extends TestBase_API {

    int id;

    @BeforeMethod
    public void precondition() {

        BookDto requestDto = BookDto.builder()
                .title(BookData.title)
                .authorName(BookData.authorName)
                .authorSurname(BookData.authorSurname)
                .year(BookData.year)
                .isbn(BookData.isbn)
                .publisher(BookData.publisher)
                .libraryId(4)
                .quantity(10)
                .available(10)
                .build();

        id = given()
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.addBook)
                .then()
                .extract().path("id");

    }

    @Test
    public void deleteBookByIdApiSuccessTest() {

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .delete(EndpointData.deleteBook + id)
                .then()
                .assertThat().statusCode(200);

    }

}