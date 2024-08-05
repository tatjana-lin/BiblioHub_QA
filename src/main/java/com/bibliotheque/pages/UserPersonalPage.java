package com.bibliotheque.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class UserPersonalPage extends BasePage {
    public UserPersonalPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="")
    WebElement logOutLink;

    @FindBy(css="")
    List<WebElement> logOutLink1;

    public UserPersonalPage verifyLogOutButtonIsPresent() {

     Assert.assertTrue(isElementPresent(logOutLink1));
//        Assert.assertTrue(isElementPresent(By.cssSelector("")));
        return this;
    }

    @FindBy(css="")
    WebElement alreadyExistsMessage;
    public UserPersonalPage verifyErrorMessage(String message) {
        Assert.assertEquals(alreadyExistsMessage.getText(), message);
        return this;
    }

    public HomePage clickOnLogOutLink() {
        click(logOutLink);
        return new HomePage(driver);
    }
}
