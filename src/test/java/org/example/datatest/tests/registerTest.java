package org.example.datatest.tests;

import io.qameta.allure.*;
import org.example.datatest.pages.registePage;
import org.example.datatest.utils.ConfigReader;
import org.example.datatest.utils.FakeDataUtils;
import org.example.datatest.utils.Setup;
import org.testng.annotations.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class registerTest  {

    private  registePage  registePage;
    private static final Logger logger = LogManager.getLogger(registerTest.class);

    @Parameters("browser")
    @BeforeTest
    public void startup(String browser){
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");
        Setup.setDriver(browser);
        Setup.getDriver().get(baseUrl);
        registePage= new registePage(Setup.getDriver());
    }

    @Test(description = "Click on Register Button")
    @Epic("User Registration")
    @Feature("Register Button Functionality")
    @Story("Click register button to navigate to sign up form")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify if the register button works correctly")
    public  void register(){
        logger.info("finish test: register()");
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
        Setup.quitDriver();
    }
}