package com.bibliotheque.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

    public static WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isElementPresent(List<WebElement> element) {
        return element.size() > 0;
    }

//    public boolean isElementPresent(By locator) {
//        return driver.findElements(locator).size() > 0;
//    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }

    public static String takeScreenshot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }

    @FindBy(css = "header>a" )
    WebElement homeElement;
    public HomePage getHomePage() {
        click(homeElement);
        return new HomePage(driver);
    }

    public void clickWithJS(WebElement element, int x, int y){
        js.executeScript("window.scrollBy("+ x +","+ y +")");
        click(element);
    }

    private static boolean isInvisible(final WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | StaleElementReferenceException var2) {
            return true;
        }
    }


}
