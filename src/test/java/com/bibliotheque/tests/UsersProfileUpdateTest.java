package com.bibliotheque.tests;

import com.bibliotheque.data.UserData;
import com.bibliotheque.pages.HomePage;
import com.bibliotheque.pages.LoginPage;
import com.bibliotheque.pages.UsersProfilePage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.bibliotheque.pages.BasePage.takeScreenshot;

public class UsersProfileUpdateTest extends TestBase {

    HomePage home;
    LoginPage login;
    UsersProfilePage profile;

    @BeforeMethod(enabled = true)
    public void precondition() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        profile = new UsersProfilePage(driver);

        home.getLoginPage()
                .enterPersonalData(UserData.validEmail, UserData.validPassword)
                .waitUntilAlertDisappears()
                .clickOnLoginButton()
                .clickOnUserNameLink();

    }

    @BeforeMethod(enabled = false)
    public void preconditionDemo() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        profile = new UsersProfilePage(driver);

        home.getLoginPage()
                .enterPersonalData(UserData.registerEmail, UserData.registerPassword)
                .waitUntilAlertDisappears()
                .clickOnLoginButton();
    }

    @Test
    public void fillInTheUsersProfilePositiveTest() {
        profile.waitUntilAlertDisappears()
                .clickOnUpdateButton()
                .enterPersonalData(UserData.lastName,
                        UserData.firstName,
                        UserData.phone,
                        UserData.zip,
                        UserData.country,
                        UserData.city,
                        UserData.street,
                        UserData.house)
                .clickOnSaveButton()
                .verifySuccessAlertIsPresent();

        profile.waitUntilAlertDisappears()
                .clickOnUpdateButton()
                .enterPersonalData(UserData.firstName,
                        UserData.lastName,
                        UserData.phone,
                        UserData.zip,
                        UserData.country,
                        UserData.city,
                        UserData.newStreet,
                        UserData.newHouse)
                .clickOnSaveButton();

    }
    @AfterMethod
    public void logOut(ITestResult result) {
        if (!result.isSuccess()) {
            logger.error("Screenshot with error --> " + takeScreenshot());
        }
        profile.clickOnLogOutLink();
    }

}
