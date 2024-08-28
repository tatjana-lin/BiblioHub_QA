package com.bibliotheque_API.tests;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase_API {

    public static final String AUTH = "Authorization";

    public static Logger logger = LoggerFactory.getLogger(com.bibliotheque.tests.TestBase.class);

    @BeforeMethod
    public void startTest(Method method, Object[] par){
        logger.info("Start test " + method.getName() + " with data: " + Arrays.asList(par));

        RestAssured.baseURI = "http://localhost:8090";
        RestAssured.basePath = "api";

    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName() + "  message  " + result.getThrowable().getMessage());

        }
        logger.info("Stop test");
        logger.info("===================================================================================");
    }


    //        http://localhost:8080/api/swagger-ui/index.html#/auth-controller/login

}
