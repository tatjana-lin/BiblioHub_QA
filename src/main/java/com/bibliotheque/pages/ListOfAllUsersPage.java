package com.bibliotheque.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListOfAllUsersPage extends BasePage{
    public ListOfAllUsersPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//main/div/div[1]")
//    List<WebElement> usersList;
//    public ListOfAllUsersPage findTheUserToDelete() {
//
//        System.out.println("usersList.size = " + usersList.size());
//        if(isElementPresent(usersList)){
//            System.out.println(driver.findElements(By.xpath("//main/div/div[1]/div)")).size());
//
//        }
//
//        return this;
//    }

//============================== должен кликнуть на кнопку первого сверху юзера ===============================
    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteUserButton;
    public ListOfAllUsersPage clickOnTheDeleteButton() {
click(deleteUserButton);
        return this;
    }
}
