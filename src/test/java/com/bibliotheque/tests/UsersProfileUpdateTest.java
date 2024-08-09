package com.bibliotheque.tests;

import com.bibliotheque.data.UserData;
import com.bibliotheque.pages.HomePage;
import com.bibliotheque.pages.LoginPage;
import com.bibliotheque.pages.UsersProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersProfileUpdateTest extends TestBase {

    HomePage home;
    LoginPage login;
    UsersProfilePage profile;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        profile = new UsersProfilePage(driver);

//        login.enterPersonalData(UserData.validEmail, UserData.validPassword)
//                .clickOnLoginButton();

        home.getUsersProfilePage();

    }
//    ============================= удалить весь класс ? ================================

//    @Test
//    public void updateProfilePositiveTest() {
//        profile.clickOnUpdateButton()
//                .changePersonalData(UserData.house)
//                .clickOnSaveButton()
//                .clickOnReturnToTheMainPageLink();
////        home.getUsersProfilePage()
////                .verifyChangesAreSaved();
//    }

}
