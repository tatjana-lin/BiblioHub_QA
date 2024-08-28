package com.bibliotheque.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "p:nth-child(1)")
    WebElement titleResult;

    public SearchResultPage verifySearchResultTitleIsDisplayed(String title) {
//        Assert.assertTrue(shouldHaveText(titleResult, title, 10));
        Assert.assertEquals(titleResult.getText().toLowerCase(), title.toLowerCase());
        return this;
    }

    @FindBy(xpath = "//header/a")
    WebElement homeElement;

    public HomePage getHomePage() {
        pause(200);
        click(homeElement);
        return new HomePage(driver);
    }

    @FindBy(css = "p:nth-child(2)>span:nth-child(2)")
    WebElement nameResult;

    public SearchResultPage verifySearchResultNameIsDisplayed(String name) {
        pause(200);
        Assert.assertEquals(nameResult.getText().toLowerCase(), name.toLowerCase());
        return this;
    }

    @FindBy(xpath = "//main/div[.='Failed to fetch books']")
    WebElement errorMessage;

    public SearchResultPage verifyNoSearchResultIsDisplayed() {
        pause(200);
        Assert.assertEquals(errorMessage.getText(), "Failed to fetch books");
        return this;
    }

    @FindBy(css = "p:nth-child(3)>span:nth-child(2)")
    WebElement isbnResult;

    public SearchResultPage verifySearchResultIsbnIsDisplayed(String isbn) {
        pause(200);
        Assert.assertEquals(isbnResult.getText(), isbn);
        return this;
    }
}
