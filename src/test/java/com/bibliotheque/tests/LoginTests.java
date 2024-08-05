package com.bibliotheque.tests;

import com.bibliotheque.pages.HomePage;
import com.bibliotheque.pages.LoginPage;
import com.bibliotheque.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    HomePage home;
    LoginPage login;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        login = new LoginPage(driver);

        home.getLoginPage();
    }

    @Test
    public void loginPositiveTest() {
        login.enterPersonalData("valid1@email.com", "validPass123$")
                .clickOnLoginButton();
//                .verifySignOutBtnIsPresent();
    }

    @Test
    public void loginNegativeTestWithEmptyEmailField() {
        login.enterPersonalData("", "validPass123$")
                .verifyEmailErrorMessage("Email required to login");
    }

    @Test
    public void loginNegativeTestWithEmptyPasswordField() {
        login.enterPersonalData("valid1@email.com", "")
                .verifyPasswordErrorMessage("Password required for login");
    }

    @Test
    public void loginNegativeTestWithInvalidEmail() {
        login.enterPersonalData("invalid1@email.", "validPass123$")
                .verifyEmailErrorMessage("This is not an acceptable email");
    }

    @Test
    public void loginNegativeTestWithShortPassword() {
        login.enterPersonalData("valid1@email.com", "Vp1234$")
                .verifyPasswordErrorMessage("Password must contain at least 8 symbols");
    }

    @Test
    public void loginNegativeTestWithoutSmallLetterInPassword() {
        login.enterPersonalData("valid1@email.com", "VP12345$")
                .verifyPasswordErrorMessage("Password must contain at least one small letter");
    }

    @Test
    public void loginNegativeTestWithoutCapitalLetterInPassword() {
        login.enterPersonalData("valid1@email.com", "vp12345$")
                .verifyPasswordErrorMessage("Password must contain at least one capital letter");
    }

    @Test
    public void loginNegativeTestWithoutSpecSymbolInPassword() {
        login.enterPersonalData("valid1@email.com", "Vp123456")
                .verifyPasswordErrorMessage("Password must contain at least one special symbol");
    }

    @Test
    public void loginNegativeTestWithoutDigitInPassword() {
        login.enterPersonalData("valid1@email.com", "Vpvpvpv$")
                .verifyPasswordErrorMessage("Password must contain at least one numerical digit");
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "negativeLoginWithInvalidPassFromCsv")
    public void loginNegativeTestWithInvalidPassword(String email, String password, String message) {
        login.enterPersonalData(email,password)
                .verifyPasswordErrorMessage(message);
    }


}
