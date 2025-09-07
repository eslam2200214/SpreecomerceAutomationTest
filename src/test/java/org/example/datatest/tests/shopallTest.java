package org.example.datatest.tests;

import io.qameta.allure.*;
import org.example.datatest.pages.ShopAllPage;
import org.example.datatest.pages.registePage;

import org.example.datatest.utils.ConfigReader;
import org.example.datatest.utils.FakeDataUtils;
import org.example.datatest.utils.Setup;
import org.testng.annotations.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class shopallTest  {

    private  registePage registePage;
    private ShopAllPage shopAllPage;
    private static final Logger logger = LogManager.getLogger(shopallTest.class);

    @Parameters("browser")
    @BeforeTest
    public void startup(String browser){
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");
        Setup.setDriver(browser);
        Setup.getDriver().get(baseUrl);
        registePage= new registePage(Setup.getDriver());
        shopAllPage=new ShopAllPage(Setup.getDriver());
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

            shopAllPage.shopAllbutton();
            shopAllPage.Products();
            shopAllPage.color();
            shopAllPage.ShooseSize();
            shopAllPage.increase();
            shopAllPage.submit();
            shopAllPage.AssertCard();
            shopAllPage.X();
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