package com.bibliotheque.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ErrorPage extends BasePage {
    public ErrorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "main>div:nth-child(2)>span")
    WebElement alreadyExistsErrorMessage;

    public ErrorPage verifyErrorMessage(String message) {
        pause(200);
        Assert.assertTrue(shouldHaveText(alreadyExistsErrorMessage, message, 10));
        return this;
    }
}
