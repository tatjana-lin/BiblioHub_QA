package com.bibliotheque.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "repeatPassword")
    WebElement repeatPasswordInput;

    public RegistrationPage enterPersonalData(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        type(repeatPasswordInput, password);

        return new RegistrationPage(driver);
    }

    @FindBy(css = "button")
    WebElement registrationBtn;

    public UserPersonalPage clickOnRegistrationButton() {
        click(registrationBtn);
        return new UserPersonalPage(driver);
    }

    @FindBy(xpath = "//input[@id='email']/following-sibling::div")
    WebElement emailErrorMessage;

    public RegistrationPage verifyEmailErrorMessage(String message) {
        Assert.assertTrue(shouldHaveText(emailErrorMessage, message, 10));
        return this;
    }
}