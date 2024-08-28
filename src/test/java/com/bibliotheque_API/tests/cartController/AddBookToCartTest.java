package com.bibliotheque_API.tests.cartController;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.EndpointData;
import com.bibliotheque.data.UserData;
import com.bibliotheque_API.dto.BookDto;
import com.bibliotheque_API.dto.UserRequestDto;
import com.bibliotheque_API.dto.UserUpdateDto;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddBookToCartTest extends TestBase_API {

    UserRequestDto requestDto;
    UserUpdateDto updateDto;
    BookDto bookRequestDto;
    int id;
    int bookId;

    @BeforeMethod
    public void precondition() {

        requestDto = UserRequestDto.builder()
                .email(UserData.registerEmail)
                .password(UserData.registerPassword)
                .role(UserData.roleUser)
                .build();

        id = given()
                .contentType("application/json")
                .body(requestDto)
                .when()
                .post(EndpointData.register)
                .then()
                .extract().path("id");

        updateDto = UserUpdateDto.builder()
                .id(id)
                .email(UserData.registerEmail)
                .name(UserData.firstName)
                .surname(UserData.lastName)
                .country(UserData.country)
                .city(UserData.city)
                .street(UserData.street)
                .number(UserData.house)
                .zip(UserData.zip)
                .phone(UserData.phone)
                .active(true)
                .build();

        given()
                .contentType("application/json")
                .body(updateDto)
                .put(EndpointData.update);

        bookRequestDto = BookDto.builder()
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
                .body(bookRequestDto)
                .post(EndpointData.addBook)
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");

    }

    @Test
    public void addBookToCartApiSuccessTest() {

        given()
//                .header(AUTH, UserData.validEmail)
                .contentType("application/json")
                .put("/cart/"+id+"/books/" + bookId)
                .then()
                .assertThat().statusCode(200);

    }

    @AfterMethod(enabled = true)
    public void cleanUp() {

        given()
                .contentType("application/json")
                .body(UserRequestDto.builder()
                        .email(UserData.registerEmail)
                        .build())
                .when()
                .delete(EndpointData.delete);

    }

}
