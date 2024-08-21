package com.bibliotheque.config;

import com.bibliotheque.utils.MyListener;
import com.bibliotheque.utils.PropertiesLoader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;
    String browser;

    public static String baseURL = PropertiesLoader.loadProperty("url");

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver startTest() {

        System.err.close();

        if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);

//            driver = new ChromeDriver();
        } else if (browser != null &&
                !browser.equalsIgnoreCase("edge") &&
                !browser.equalsIgnoreCase("firefox") &&
                !browser.equalsIgnoreCase("chrome")) {
            throw new IllegalArgumentException("Browser entered is not correct");
        }

        driver = new EventFiringDecorator(new MyListener()).decorate(driver);

//        driver.manage().window().setSize(new Dimension(320, 568)); // Задаем размер окна для тестирования мобильной версии

        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to(baseURL);

        return driver;
    }

    public void stopTest() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
