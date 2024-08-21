package com.bibliotheque.tests;

import com.bibliotheque.data.UserData;
import com.bibliotheque.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminFunctionsTests extends TestBase {
//===================== Удалить весь класс? ==========================
    HomePage home;
    LoginPage login;
    UsersProfilePage profile;
    ListOfAllUsersPage list;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        profile = new UsersProfilePage(driver);
        list = new ListOfAllUsersPage(driver);

        home.getLoginPage();

        login.enterPersonalData(UserData.adminEmail, UserData.adminPassword)
                .clickOnLoginButton();
    }

    @Test
    public void adminDeletesTheLastUserPositiveTest() {
        profile.clickOnTheListOfAllUsersBtn()
                .clickOnTheDeleteButton();
//                .verifyPopUpMessage();

    }


}
