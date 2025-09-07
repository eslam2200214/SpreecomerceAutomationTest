package org.example.datatest.tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.datatest.pages.registePage;
import org.example.datatest.pages.wellnessPage;
import org.example.datatest.utils.ConfigReader;
import org.example.datatest.utils.FakeDataUtils;
import org.example.datatest.utils.Setup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class wellnessTest {

    private  registePage registePage;
    private wellnessPage wellnessPage;
    private static final Logger logger = LogManager.getLogger(shopallTest.class);

    @Parameters("browser")
    @BeforeTest
    public void startup(String browser){
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");
        Setup.setDriver(browser);
        Setup.getDriver().get(baseUrl);
        registePage= new registePage(Setup.getDriver());
        wellnessPage=new wellnessPage(Setup.getDriver());
    }

    @Test(description = "Click on login Button")
    @Epic("User login")
    @Feature("login Button Functionality")
    @Story("Click login button to navigate to login form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify if the login button works correctly")
    public  void shopAllPage(){
        logger.info("finish test: login()");
        try{
            String email = FakeDataUtils.getEmail();
            String pass = FakeDataUtils.getPassword();
            registePage.registerButtonClick();
            registePage.singUp();
            registePage.email(email);
            registePage.password(pass);
            registePage.passwordConfirmation(pass);
            registePage.singUpButton();
            registePage.singUpAssert();

            wellnessPage.wellnessButton();
            wellnessPage.sportswear();
            wellnessPage.filter();
            wellnessPage.clickAnyProduct();
            wellnessPage.color();
            wellnessPage.ShooseSize();
            wellnessPage.increase();
            wellnessPage.submit();
            wellnessPage.AssertCard();
            wellnessPage.X();
            registePage.LogOut();
            logger.info("register test passed successfully");
        }catch (AssertionError | Exception e ){
            logger.error("The test failed");
            throw e;
        }finally {
            logger.info("finshing test : register()");
        }
    }

    @AfterClass
    public void teardown(){
//        Setup.quitDriver();
    }
}