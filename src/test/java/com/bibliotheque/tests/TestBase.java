package com.bibliotheque.tests;

import com.bibliotheque.config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

import static com.bibliotheque.pages.BasePage.takeScreenshot;

public class TestBase {

    public static WebDriver driver;

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));

   Logger logger = LoggerFactory.getLogger(TestBase.class);

    //    @BeforeMethod
//     public void startBrowser(Method method, Object[] par) {

//        logger.info("Start test " + method.getName() + " with data: " + Arrays.asList(par));

//        driver = app.startTest();
//    }

    @BeforeSuite
    public void startBrowser() {
        driver = app.startTest();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] par) {
        logger.info("Start test " + method.getName() + " with data: " + Arrays.asList(par));
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName()) ;
//            logger.error("FAILED: " + result.getMethod().getMethodName() + takeScreenshot() ) ;
        }
        logger.info("Stop test");
        logger.info("===================================================================================");
    }

    //    @AfterMethod(enabled = false)
//       public void tearDown(ITestResult result) {
//        app.stopTest();

//        if (result.isSuccess()) {
//            logger.info("Test result: PASSED " + result.getMethod().getMethodName());
//        } else {
//            logger.error("Test result FAILED " + result.getMethod().getMethodName());
//        }
//        logger.info("***********************************************************************");
//    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        app.stopTest();

    }


}
