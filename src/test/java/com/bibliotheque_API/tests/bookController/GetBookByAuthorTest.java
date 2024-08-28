package com.bibliotheque_API.tests.bookController;

import com.bibliotheque.data.BookData;
import com.bibliotheque.data.EndpointData;
import com.bibliotheque_API.tests.TestBase_API;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookByAuthorTest extends TestBase_API {

    @Test
    public void getBookByAuthorApiSuccessTest() {

        given()
//                .header(AUTH, UserData.libraryEmail)
                .contentType("application/json")
                .get(EndpointData.getBookByAuthor + BookData.authorSurname)
                .then()
                .assertThat().statusCode(200);

    }

}
