package com.bibliotheque.pages;

import com.bibliotheque.data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class UsersProfilePage extends BasePage {
    public UsersProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="")
    WebElement logOutLink;

    @FindBy(css="")
    List<WebElement> logOutLink1;

    public UsersProfilePage verifyLogOutButtonIsPresent() {

     Assert.assertTrue(isElementPresent(logOutLink1));
//        Assert.assertTrue(isElementPresent(By.cssSelector("")));
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

    @FindBy(id="phone")
    WebElement phoneInput;

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

    @FindBy(xpath = "//button[.='Update Your Profile Info']")
    WebElement updateButton;

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;
    @FindBy(xpath = "//a[.='Return to the main page']")
    WebElement returnLink;

//=================== методы для проверки изменения профиля, можно удалить ============================================

    public UsersProfilePage clickOnUpdateButton() {
        click(updateButton);
        return this;
    }

    public UsersProfilePage changePersonalData(String house){
        type(houseNumberInput, house);
        return this;
    }

    public UsersProfilePage clickOnSaveButton() {
        click(saveButton);
        return this;
    }

    public HomePage clickOnReturnToTheMainPageLink() {
        click(returnLink);
        return new HomePage(driver);
    }

    public UsersProfilePage verifyChangesAreSaved() {
        Assert.assertEquals(houseNumberInput.getText(), UserData.house);
        return this;
    }
}
