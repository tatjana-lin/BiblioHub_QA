package com.bibliotheque.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
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

    @FindBy(css = "input")
    WebElement searchInput;
    public HomePage enterSearchData(String data) {
        click(searchInput);
        type(searchInput, data);
        return this;
    }

    @FindBy(css = "button")
    WebElement searchButton;
    public HomePage clickOnTheSearchButton() {
        click(searchButton);
        return this;
    }

    @FindBy(css="select")
    WebElement selector;
    public HomePage selectSearchCriteria(String searchBy) {
        Select select = new Select(selector);
        select.selectByVisibleText(searchBy);
        return this;
    }

    @FindBy(css = "nav a:nth-child(3)")
    WebElement profileLink;

    public UsersProfilePage getUsersProfilePage() {
        click(profileLink);
        return new UsersProfilePage(driver);
    }
}
