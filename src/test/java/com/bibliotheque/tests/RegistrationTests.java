package com.bibliotheque.tests;

import com.bibliotheque.data.MessageData;
import com.bibliotheque.data.UserData;
import com.bibliotheque.pages.HomePage;
import com.bibliotheque.pages.RegistrationPage;
import com.bibliotheque.utils.DataProviders;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.bibliotheque.pages.BasePage.takeScreenshot;

public class RegistrationTests extends TestBase {

    HomePage home;
    RegistrationPage registration;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        registration = new RegistrationPage(driver);

        home.getRegistrationPage();
    }

    @AfterMethod
    public void returnToTheHomePage(ITestResult result){
        if (!result.isSuccess()) {
            logger.error("Screenshot with error --> " + takeScreenshot());
        }
        registration.getHomePage();
    }

//    @BeforeMethod
//    public void ensurePrecondition(){
//        if(!home.isLoginLinkPresent()){
//            home.clickOnLogOutButton();
//        }
//    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationFromCsv")
    public void registrationPositiveTestWithDataProvider(String email, String password, String repeatPass) {

        registration.enterPersonalData(email, password, repeatPass);
//                .clickOnRegistrationButton();
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

//    ============= пока нет локатора. Не запускать!============================
//    @Test
//    public void registrationNegativeTestUserAlreadyExists() {
//        logger.info("Registration with data --> " + UserData.validEmail + " *** " + UserData.validPassword);
//
//        registration.enterPersonalData(UserData.validEmail, UserData.validPassword, UserData.validPassword)
//                .clickOnRegistrationButton()
//                .verifyErrorMessage(MessageData.alreadyExistsMessage);
//    }
//==============================================================================
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

//    ============================= поломанный тест для проверки логов. Удалить =========================================

//    @Test
//    public void registrationNegativeTestWithEmptyEmailField1() {
//        logger.info("Registration with data --> " + UserData.emptyEmail + " * " + UserData.validPassword);
//
//        registration.enterPersonalData(UserData.emptyEmail, UserData.validPassword, UserData.validPassword)
//                .verifyEmailErrorMessage(MessageData.passwordRequiredMessage);
//    }


}
