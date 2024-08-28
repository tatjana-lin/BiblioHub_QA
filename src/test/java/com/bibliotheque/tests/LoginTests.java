package com.bibliotheque.tests;

import com.bibliotheque.data.MessageData;
import com.bibliotheque.data.UserData;
import com.bibliotheque.pages.HomePage;
import com.bibliotheque.pages.LoginPage;
import com.bibliotheque.utils.DataProviders;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.bibliotheque.pages.BasePage.takeScreenshot;

public class LoginTests extends TestBase {

    HomePage home;
    LoginPage login;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        login = new LoginPage(driver);

        home.getLoginPage();
    }

    @AfterMethod
    public void negativeResultScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            logger.error("Screenshot with error --> " + takeScreenshot());
        }
    }

    @Test
    public void loginPositiveTest() {
        logger.info("Login with data --> " + UserData.validEmail + " *** " + UserData.validPassword);

        login.enterPersonalData(UserData.validEmail, UserData.validPassword)
                .waitUntilAlertDisappears()
                .clickOnLoginButton()
                .verifyLogOutLinkIsPresent();
        home.clickOnLogOutLink();
    }

//    @Test
//    public void loginPositiveDemoTest() {
//        logger.info("Login with data --> " + UserData.registerEmail + " *** " + UserData.registerPassword);
//
//        login.enterPersonalData(UserData.registerEmail, UserData.registerPassword)
//                .waitUntilAlertDisappears()
//                .clickOnLoginButton()
//                .verifyLogOutLinkIsPresent();
//        home.clickOnLogOutLink();
//    }

    //    =========================================запускать вместе с Registration==============================================
    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveDeleteApi")
    public void loginPositiveTestFromCsv(String email, String password) {

        login.enterPersonalData(email, password)
                .waitUntilAlertDisappears()
                .clickOnLoginButton()
                .verifyLogOutLinkIsPresent();
        home.clickOnLogOutLink();
    }

    @Test
    public void loginNegativeTestWithEmptyEmailField() {
        logger.info("Login with data --> " + UserData.emptyEmail + " *** " + UserData.validPassword);

        login.enterPersonalData(UserData.emptyEmail, UserData.validPassword)
                .verifyEmailErrorMessage(MessageData.emailRequiredMessage)
                .getHomePage();
    }

    @Test
    public void loginNegativeTestWithEmptyPasswordField() {
        logger.info("Login with data --> " + UserData.validEmail + " *** " + UserData.emptyPassword);

        login.enterPersonalData(UserData.validEmail, UserData.emptyPassword)
                .verifyPasswordErrorMessage(MessageData.passwordRequiredMessage)
                .getHomePage();
    }

//    @Test
//    public void loginNegativeTestWithInvalidEmail() {
//        logger.info("Login with data --> " + UserData.invalidEmail + " *** " + UserData.validPassword);
//
//        login.enterPersonalData(UserData.invalidEmail, UserData.validPassword)
//                .verifyEmailErrorMessage(MessageData.emailErrorMessage);
//    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeLoginWithInvalidEmailFromCsv")
    public void loginNegativeTestWithInvalidEmailFromCsv(String email, String password) {
        login.enterPersonalData(email, password)
                .verifyEmailErrorMessage(MessageData.emailErrorMessage)
                .getHomePage();
    }


//    @Test
//    public void loginNegativeTestWithShortPassword() {
//        login.enterPersonalData("valid1@email.com", "Vp1234$")
//                .verifyPasswordErrorMessage("Password must contain at least 8 symbols");
//    }
//
//    @Test
//    public void loginNegativeTestWithoutSmallLetterInPassword() {
//        login.enterPersonalData("valid1@email.com", "VP12345$")
//                .verifyPasswordErrorMessage("Password must contain at least one small letter");
//    }
//
//    @Test
//    public void loginNegativeTestWithoutCapitalLetterInPassword() {
//        login.enterPersonalData("valid1@email.com", "vp12345$")
//                .verifyPasswordErrorMessage("Password must contain at least one capital letter");
//    }
//
//    @Test
//    public void loginNegativeTestWithoutSpecSymbolInPassword() {
//        login.enterPersonalData("valid1@email.com", "Vp123456")
//                .verifyPasswordErrorMessage("Password must contain at least one special symbol");
//    }
//
//    @Test
//    public void loginNegativeTestWithoutDigitInPassword() {
//        login.enterPersonalData("valid1@email.com", "Vpvpvpv$")
//                .verifyPasswordErrorMessage("Password must contain at least one numerical digit");
//    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeLoginWithInvalidPassFromCsv")
    public void loginNegativeTestWithInvalidPasswordFromCsv(String email, String password, String message) {
        login.enterPersonalData(email, password)
                .verifyPasswordErrorMessage(message)
                .getHomePage();
    }

}
