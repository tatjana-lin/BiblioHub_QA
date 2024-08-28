package com.bibliotheque.tests;

import com.bibliotheque.data.BookData;
import com.bibliotheque.pages.HomePage;
import com.bibliotheque.utils.DataProviders;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.bibliotheque.pages.BasePage.takeScreenshot;

public class BookSearchTests extends TestBase {

    HomePage home;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
    }

    @AfterMethod
    public void negativeResultScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            logger.error("Screenshot with error --> " + takeScreenshot());
        }
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveSearchByTitleFromCsv")
    public void searchPositiveTestByBookTitle(String title) {
        home.enterSearchData(title)
                .clickOnTheSearchButton()
                .verifySearchResultTitleIsDisplayed(title)
                .getHomePage();
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveSearchByAuthorFromCsv")
    public void searchPositiveTestByAuthorsName(String name) {
        home.selectSearchCriteria("Author")
                .enterSearchData(name)
                .clickOnTheSearchButton()
                .verifySearchResultNameIsDisplayed(name)
                .getHomePage();

    }

    @Test
    public void searchPositiveTestByIsbn(){
        home.selectSearchCriteria("ISBN")
                .enterSearchData(BookData.isbn)
                .clickOnTheSearchButton()
                .verifySearchResultIsbnIsDisplayed(BookData.isbn)
                .getHomePage();

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeSearchFromCsv")
    public void searchNegativeTestByBookTitle(String title) {
        home.enterSearchData(title)
                .clickOnTheSearchButton()
                .verifyNoSearchResultIsDisplayed()
                .getHomePage();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeSearchFromCsv")
    public void searchNegativeTestByAuthorsName(String name) {
        home.selectSearchCriteria("Author")
                .enterSearchData(name)
                .clickOnTheSearchButton()
                .verifyNoSearchResultIsDisplayed()
                .getHomePage();

    }

}
