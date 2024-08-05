package com.bibliotheque.tests;

import com.bibliotheque.pages.HomePage;
import com.bibliotheque.pages.RegistrationPage;
import com.bibliotheque.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    HomePage home;
    RegistrationPage registration;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        registration = new RegistrationPage(driver);

        home.getRegistrationPage();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationFromCsv")
    public void registrationPositiveTestWithDataProvider(String email, String password, String repeatPass) {

        registration.enterPersonalData(email, password, repeatPass)
                .clickOnRegistrationButton();
//                .verifySignOutButtonIsPresent();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationWithInvalidEmailFromCsv")
    public void registrationNegativeTestWithInvalidEmail(String email, String password, String repeatPass) {

        registration.enterPersonalData(email, password, repeatPass)
                .verifyEmailErrorMessage("Input does not correspond with an email");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationWithInvalidPassFromCsv")
    public void registrationNegativeTestWithInvalidPass(String email, String password, String repeatPass, String message) {

        registration.enterPersonalData(email, password, repeatPass)
                .verifyPasswordErrorMessage(message);
    }
// ======================= возможно, лучше сделать мануально ======================================
    @Test
    public void registrationNegativeTestUserAlreadyExists() {
        registration.enterPersonalData("valid1@gmail.com", "Vp12345$", "Vp12345$")
                .clickOnRegistrationButton()
                .verifyErrorMessage("User already exists");
    }

    @Test
    public void registrationNegativeTestUserAlreadyExists1() {
        registration.enterPersonalData("already.exists@gmail.com", "Exists1$", "Exists1$")
                .clickOnRegistrationButton()
                .clickOnLogOutLink();

        home.getRegistrationPage()
                .enterPersonalData("already.exists@gmail.com", "Exists1$", "Exists1$")
                .clickOnRegistrationButton()
                .verifyErrorMessage("User already exists");

//        delete user

    }
// =====================================================================================================

    @Test
    public void registrationNegativeTestWithWrongPassConfirmation() {
        registration.enterPersonalData("non-match@email.com", "Vp12345$", "Vp12345#")
                .verifyRepeatPassErrorMessage("Passwords must coincide");
    }

    @Test
    public void registrationNegativeTestWithEmptyEmailField() {
        registration.enterPersonalData("", "validPass123$", "validPass123$")
                .verifyEmailErrorMessage("Email required");
    }

    @Test
    public void registrationNegativeTestWithEmptyPasswordField() {
        registration.enterPersonalData("valid1@email.com", "", "")
                .verifyPasswordErrorMessage("Password required");
    }

    @Test
    public void registrationNegativeTestWithEmptyRepeatPassField() {
        registration.enterPersonalData("valid1@email.com", "validPass123$","")
                .verifyRepeatPassErrorMessage("Repeat password is required");
    }


}
