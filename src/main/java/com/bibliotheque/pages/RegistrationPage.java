package com.bibliotheque.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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

    public RegistrationPage enterPersonalData(String email, String password, String repeatPass) {
        type(emailInput, email);
        type(passwordInput, password);
        type(repeatPasswordInput, repeatPass);
//        pause(10000);

        return this;
    }

    public HomePage waitAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        return new HomePage(driver);
    }

    @FindBy(css = "button")
    WebElement registrationBtn;
//    @FindBy(css="[class*='success']")
//    WebElement successAlert;


    public HomePage clickOnRegistrationButton() {
        click(registrationBtn);
        return new HomePage(driver);

    }

    @FindBy(xpath = "//input[@id='email']/following-sibling::div")
    WebElement emailErrorMessage;

    public RegistrationPage verifyEmailErrorMessage(String message) {
        Assert.assertTrue(shouldHaveText(emailErrorMessage, message, 10));
        return this;
    }

    @FindBy(xpath = "//input[@id='password']/following-sibling::div")
    WebElement passErrorMessage;

    public RegistrationPage verifyPasswordErrorMessage(String message) {
        Assert.assertTrue(shouldHaveText(passErrorMessage, message, 10));
        return this;
    }


    @FindBy(xpath = "//input[@id='repeatPassword']/following-sibling::div")
    WebElement repeatPassErrorMessage;

    public RegistrationPage verifyRepeatPassErrorMessage(String message) {
        Assert.assertTrue(shouldHaveText(repeatPassErrorMessage, message, 10));
        return this;
    }

    @FindBy(css = "header>a")
    WebElement homeElement;

    public HomePage getHomePage() {
        click(homeElement);
        return new HomePage(driver);
    }

    public ErrorPage clickOnRegistrationButtonError() {
        pause(100);
        click(registrationBtn);
        return new ErrorPage(driver);
    }

    @FindBy(css="[class*='Toastify']")
    WebElement successAlert;
    public RegistrationPage waitUntilAlertDisappears() {
        if(isElementVisible(successAlert)){
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.invisibilityOf(successAlert));}

        return this;
    }


}