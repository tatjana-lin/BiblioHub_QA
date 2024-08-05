package com.bibliotheque.tests;

import com.bibliotheque.data.MessageData;
import com.bibliotheque.data.UserData;
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
                .verifyEmailErrorMessage(MessageData.emailErrorMessageReg);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationWithInvalidPassFromCsv")
    public void registrationNegativeTestWithInvalidPass(String email, String password, String repeatPass, String message) {

        registration.enterPersonalData(email, password, repeatPass)
                .verifyPasswordErrorMessage(message);
    }

    @Test
    public void registrationNegativeTestUserAlreadyExists() {
        logger.info("Registration with data --> " + UserData.validEmail + " *** " + UserData.validPassword);

        registration.enterPersonalData(UserData.validEmail, UserData.validPassword, UserData.validPassword)
                .clickOnRegistrationButton()
                .verifyErrorMessage(MessageData.alreadyExistsMessage);
    }

    @Test
    public void registrationNegativeTestWithWrongPassConfirmation() {
        logger.info("Registration with data --> " + UserData.validEmail + " * " + UserData.validPassword + " * " + UserData.invalidPassConfirm);

        registration.enterPersonalData(UserData.validEmail, UserData.validPassword, UserData.invalidPassConfirm)
                .verifyRepeatPassErrorMessage(MessageData.invalidPassConfirmMessage);
    }

    @Test
    public void registrationNegativeTestWithEmptyEmailField() {
        logger.info("Registration with data --> " + UserData.emptyEmail + " * " + UserData.validPassword);

        registration.enterPersonalData(UserData.emptyEmail, UserData.validPassword, UserData.validPassword)
                .verifyEmailErrorMessage(MessageData.emailRequiredMessage);
    }

    @Test
    public void registrationNegativeTestWithEmptyPasswordField() {
        logger.info("Registration with data --> " + UserData.validEmail + " * " + UserData.emptyPassword);

        registration.enterPersonalData(UserData.validEmail, UserData.emptyPassword, UserData.emptyPassword)
                .verifyPasswordErrorMessage(MessageData.passwordRequiredMessage);
    }

    @Test
    public void registrationNegativeTestWithEmptyRepeatPassField() {
        logger.info("Registration with data --> " + UserData.validEmail + " * " + UserData.validPassword + " * " + UserData.emptyRepeatPass);

        registration.enterPersonalData(UserData.validEmail, UserData.validPassword, UserData.emptyRepeatPass)
                .verifyRepeatPassErrorMessage(MessageData.repeatPassRequiredMessage);
    }


}
