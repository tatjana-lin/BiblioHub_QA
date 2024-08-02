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
    public void registrationPositiveTestWithDataProvider(String email, String password) {

        registration.enterPersonalData(email, password)
                .clickOnRegistrationButton();
//                .verifySignOutButtonIsPresent();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeRegistrationWithWrongEmailFromCsv")
    public void registrationNegativeTestWithWrongEmail(String email, String password) {

        registration.enterPersonalData(email, password)
                .verifyEmailErrorMessage("Значение не соответствует формату email");
    }


}
