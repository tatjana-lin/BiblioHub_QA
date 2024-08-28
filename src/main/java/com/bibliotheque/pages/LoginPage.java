package com.bibliotheque.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passInput;

    public LoginPage enterPersonalData(String email, String password) {
        type(emailInput, email);
        type(passInput, password);
//        pause(7000);
        return this;
    }

    @FindBy(css = "button")
    WebElement loginButton;

    public HomePage clickOnLoginButton() {
        click(loginButton);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//input[@id='email']/following-sibling::div")
    WebElement emailErrorMessage;

    public LoginPage verifyEmailErrorMessage(String message) {
        Assert.assertTrue(shouldHaveText(emailErrorMessage, message, 10));
        return this;
    }

    @FindBy(xpath = "//input[@id='password']/following-sibling::div")
    WebElement passErrorMessage;

    public LoginPage verifyPasswordErrorMessage(String message) {
        Assert.assertTrue(shouldHaveText(passErrorMessage, message, 10));
        return this;
    }

    @FindBy(css = "header>a")
    WebElement homeElement;

    public HomePage getHomePage() {
        click(homeElement);
        return new HomePage(driver);
    }

    @FindBy(css="[class*='Toastify']")
    WebElement successAlert;
    public LoginPage waitUntilAlertDisappears() {
        if(isElementVisible(successAlert)){
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.invisibilityOf(successAlert));}

        return this;
    }

}
