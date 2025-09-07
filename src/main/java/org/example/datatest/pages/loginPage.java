package org.example.datatest.pages;

import io.qameta.allure.Step;
import org.example.datatest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class loginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(registePage.class);

    @FindBy(xpath ="(//button[@data-action=\"click->slideover-account#toggle click@window->slideover-account#hide click->toggle-menu#hide touch->toggle-menu#hide\"])[1]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement loginPassword;

    @FindBy(xpath = "(//input[@name=\"user[remember_me]\"])[2]")
    private WebElement remember;

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    private WebElement login;

    @FindBy(xpath ="//p[@class=\"text-sm lg:text-base font-medium text-center uppercase text-text flash-message\"]")
    private WebElement loginAssert;

    @FindBy(xpath ="(//div[@class=\"hidden lg:flex\"])[3]\n")
    private WebElement registerButtonAfterlogin;

    @FindBy(xpath ="//button[text()=\"Log out\"]")
    private WebElement LogOut;


    public loginPage(WebDriver driver) {
        super(driver);
    }
    @Step("click registerButton: {0}")
    public void loginButton(){
        WaitUtils.waitForClickability(loginButton);
        loginButton.click();
    }

    @Step("Enter email: {1}")
    public void email(String ema){
        WaitUtils.waitForVisibility(loginEmail);
        loginEmail.sendKeys(ema);
    }

    @Step("Enter password: {2}")
    public void password(String pas){
        WaitUtils.waitForVisibility(loginPassword);
        loginPassword.sendKeys(pas);
    }

    @Step("click singUpButton: {3}")
    public void remember(){
        WaitUtils.waitForClickability(remember);
        remember.click();
    }

    @Step("click singUpButton: {4}")
    public void login(){
        WaitUtils.waitForClickability(login);
        login.click();
    }

    @Step("Assert singUpAssert: {5}")
    public void singUpAssert(){
        WaitUtils.waitForClickability(loginAssert);
        try {
            boolean isDispaly = loginAssert.isDisplayed();
            Assert.assertTrue(isDispaly, "Sign up success message should be displayed.");
            log.info("Sign up success message is displayed as expected.");
        }catch(AssertionError e){
            log.error("Sign up success message is NOT displayed!");
            throw e;
        }
    }

    @Step("click LogOut: {6}")
    public void LogOut(){
        WaitUtils.waitForClickability(registerButtonAfterlogin);
        registerButtonAfterlogin.click();
        WaitUtils.waitForClickability(LogOut);
        LogOut.click();
    }





}
