package com.bibliotheque.tests;

import com.bibliotheque.config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {

    public WebDriver driver;

    ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startBrowser(Method method) {
        logger.info("Start test: " + method.getName());
        driver = app.startTest();
    }

    @AfterMethod(enabled = false)
    public void tearDown(ITestResult result) {
        app.stopTest();

        if (result.isSuccess()) {
            logger.info("Test result: PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("Test result FAILED " + result.getMethod().getMethodName());
        }
        logger.info("***********************************************************************");
    }

}
