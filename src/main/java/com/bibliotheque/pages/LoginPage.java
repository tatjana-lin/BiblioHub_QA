package com.bibliotheque.pages;

import com.bibliotheque.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="email")
    WebElement emailInput;
    @FindBy(id="password")
    WebElement passInput;

    public LoginPage enterPersonalData(String email, String password) {
        type(emailInput, email);
        type(passInput, password);

        return this;
    }

    @FindBy(css="button")
    WebElement loginButton;
    public UserPersonalPage clickOnLoginButton() {
        click(loginButton);
        return new UserPersonalPage(driver);
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

}
