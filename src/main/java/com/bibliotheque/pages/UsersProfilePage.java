package com.bibliotheque.pages;

import com.bibliotheque.data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class UsersProfilePage extends BasePage {
    public UsersProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a:nth-child(2)")
    WebElement logOutLink;

    public UsersProfilePage verifyLogOutLinkIsPresent() {
     Assert.assertTrue(shouldHaveText(logOutLink, "Log out", 10));

//     click(logOutLink);

        return this;
    }

    @FindBy(css="")
    WebElement alreadyExistsMessage;
    public UsersProfilePage verifyErrorMessage(String message) {
        Assert.assertEquals(alreadyExistsMessage.getText(), message);
        return this;
    }

    public HomePage clickOnLogOutLink() {
        click(logOutLink);
        return new HomePage(driver);
    }

//    ================ локаторы ==========================
    @FindBy(id="firstName")
    WebElement firstNameInput;

    @FindBy(id="lastName")
    WebElement lastNameInput;

    @FindBy(name="phone")
    WebElement phoneInput;
////input[@name='phone']
    @FindBy(id="country")
    WebElement countryInput;

    @FindBy(id="zip")
    WebElement zipInput;

    @FindBy(id="city")
    WebElement cityInput;

    @FindBy(id="street")
    WebElement streetInput;

    @FindBy(id="houseNumber")
    WebElement houseNumberInput;

    @FindBy(xpath = "//button[.='Update Info']")
    WebElement updateButton;

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;


//=================== методы для проверки изменения профиля, можно удалить ============================================

    public UsersProfilePage clickOnUpdateButton() {
        pause(500);
        click(updateButton);
        return this;
    }

    public UsersProfilePage changePersonalData(String house){
        type(houseNumberInput, house);
        return this;
    }

    public UsersProfilePage clickOnSaveButton() {
        pause(200);
        click(saveButton);
        return this;
    }

    public UsersProfilePage verifyChangesAreSaved() {
        Assert.assertEquals(houseNumberInput.getText(), UserData.house);
        return this;
    }

//    @FindBy(css = ".css-saj4jc")
    @FindBy(xpath = "//button[.='List of all users']")
    WebElement listOfAllUsersButton;
    public ListOfAllUsersPage clickOnTheListOfAllUsersBtn() {
        pause(200);
        click(listOfAllUsersButton);
        return new ListOfAllUsersPage(driver);
    }

    public UsersProfilePage enterPersonalData(String firstName, String lastName, String phone, String zip, String country, String city, String street, String house) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(phoneInput, phone);
        type(zipInput, zip);
        type(countryInput, country);
        type(cityInput, city);
        type(streetInput, street);
        type(houseNumberInput, house);
        return this;
    }

    @FindBy(css="[class*='success']")
    List<WebElement> successAlert;

    public UsersProfilePage verifySuccessAlertIsPresent() {
        pause(200);
        Assert.assertTrue(isElementPresent(successAlert));
        return this;
    }


//    @FindBy(css = "nav a:nth-child(2)")
//    WebElement logOutLink;
//    public UsersProfilePage verifyLogOutLinkIsPresent() {
//Assert.assertTrue(isElementPresent());
//        return this;
//    }
}
