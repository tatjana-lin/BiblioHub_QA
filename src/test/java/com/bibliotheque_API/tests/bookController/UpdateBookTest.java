package com.bibliotheque_API.tests.bookController;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.EndpointData;
import com.bibliotheque_API.dto.BookDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookTest extends TestBase_API {
    BookDto requestDto;
    BookDto updateDto;
    int bookId;

    @BeforeMethod
    public void precondition(){
        requestDto = BookDto.builder()
//                .id(bookId)
                .title(BookData.title)
                .authorName(BookData.authorName)
                .authorSurname(BookData.authorSurname)
                .year(BookData.year)
                .isbn(BookData.isbn)
                .publisher(BookData.publisher)
                .libraryId(4)
                .quantity(1)
                .available(1)
                .build();

        bookId = given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .body(requestDto)
                .post(EndpointData.addBook)
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");
    }

    @Test
    public void updateBookApiSuccessTest() {

        updateDto = BookDto.builder()
                .id(bookId)
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

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .body(updateDto)
                .put(EndpointData.updateBook)
                .then()
                .assertThat().statusCode(200);

    }

    @AfterMethod
    public void cleanUp(){

        given()
//                .header(AUTH, LibraryData.email)
                .contentType("application/json")
                .delete(EndpointData.deleteBook + bookId);

    }

}
