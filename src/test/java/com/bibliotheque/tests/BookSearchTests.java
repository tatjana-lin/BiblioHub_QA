package com.bibliotheque.tests;

import com.bibliotheque.pages.HomePage;
import com.bibliotheque.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookSearchTests extends TestBase {

    HomePage home;

    @BeforeMethod
    public void precondition(){
        home = new HomePage(driver);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveSearchByTitleFromCsv")
    public void searchPositiveTestByBookTitle(String title) {
        home.enterSearchData(title)
            .clickOnTheSearchButton();
//            .verifySearchResultIsDisplayed();
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveSearchByAuthorFromCsv")
    public void searchPositiveTestByAuthorsName(String name) {
        home.selectSearchCriteria("Author")
                .enterSearchData(name)
                .clickOnTheSearchButton();
        //            .verifySearchResultIsDisplayed();

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeSearchFromCsv")
    public void searchNegativeTestByBookTitle(String title) {
        home.enterSearchData(title)
                .clickOnTheSearchButton();
//            .verifyNoSearchResultIsDisplayed();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeSearchFromCsv")
    public void searchNegativeTestByAuthorsName(String name) {
        home.selectSearchCriteria("Author")
                .enterSearchData(name)
                .clickOnTheSearchButton();
        //            .verifyNoSearchResultIsDisplayed();

    }

}
