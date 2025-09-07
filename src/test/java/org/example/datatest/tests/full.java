package org.example.datatest.tests;
import io.qameta.allure.*;
import org.example.datatest.pages.registePage;
import org.example.datatest.pages.loginPage;
import org.example.datatest.pages.ShopAllPage;
import org.example.datatest.pages.FashionPage;
import org.example.datatest.pages.wellnessPage;
import org.example.datatest.pages.newArrivialsPages;
import org.example.datatest.pages.salePage;
import org.example.datatest.utils.ConfigReader;
import org.example.datatest.utils.FakeDataUtils;
import org.example.datatest.utils.Setup;
import org.testng.annotations.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class full  {

    private  registePage registePage;
    private  loginPage   loginPage ;
    private ShopAllPage shopAllPage;
    private FashionPage fashionPage;
    private wellnessPage wellnessPage;
    private newArrivialsPages newArrivialsPages;
    private salePage salePage;

    private static final Logger logger = LogManager.getLogger(shopallTest.class);

    @Parameters("browser")
    @BeforeTest
    public void startup(String browser){
        String baseUrl = ConfigReader.getInstance().getProperty("baseUrl");
        Setup.setDriver(browser);
        Setup.getDriver().get(baseUrl);
        registePage= new registePage(Setup.getDriver());
        loginPage=new loginPage(Setup.getDriver());
        shopAllPage=new ShopAllPage(Setup.getDriver());
        fashionPage=new FashionPage(Setup.getDriver());
        wellnessPage=new wellnessPage(Setup.getDriver());
        newArrivialsPages=new newArrivialsPages(Setup.getDriver());
        salePage=new salePage(Setup.getDriver());
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
            registePage.LogOut();

            loginPage.loginButton();
            loginPage.email(email);
            loginPage.password(pass);
            loginPage.remember();
            loginPage.login();
            loginPage.singUpAssert();
            logger.info("register test passed successfully");

            shopAllPage.shopAllbutton();
            shopAllPage.Products();
            shopAllPage.color();
            shopAllPage.ShooseSize();
            shopAllPage.increase();
            shopAllPage.submit();
            shopAllPage.AssertCard();
            shopAllPage.X();

            fashionPage.FashionPage();
            fashionPage.Knitwear();
            fashionPage.filter();
            fashionPage.clickAnyProduct();
            fashionPage.color();
            fashionPage.ShooseSize();
            fashionPage.increase();
            fashionPage.submit();
            fashionPage.AssertCard();
            fashionPage.X();

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

            newArrivialsPages.newArrivials();
            newArrivialsPages.filter();
            newArrivialsPages.clickAnyProduct();
            newArrivialsPages.color();
            newArrivialsPages.ShooseSize();
            newArrivialsPages.increase();
            newArrivialsPages.submit();
            newArrivialsPages.AssertCard();
            newArrivialsPages.X();

            salePage.saleButton();
            salePage.filter();
            salePage.clickAnyProduct();
            salePage.color();
            salePage.ShooseSize();
            salePage.increase();
            salePage.submit();
            salePage.AssertCard();
            salePage.X();
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