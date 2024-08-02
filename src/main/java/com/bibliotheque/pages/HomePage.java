package com.bibliotheque.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage removeWindow() {
        pause(5000);
        new Actions(driver).sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER).perform();
        return this;
    }

    @FindBy(css = "nav a:nth-child(1)")
    WebElement loginLink;

    public LoginPage getLoginPage() {
        click(loginLink);
        return new LoginPage(driver);
    }

    @FindBy(css = "nav a:nth-child(2)")
    WebElement registrationLink;

    public RegistrationPage getRegistrationPage() {
        click(registrationLink);
        return new RegistrationPage(driver);
    }
}
