package org.example.datatest.pages;

import io.qameta.allure.Step;
import org.example.datatest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class registePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(registePage.class);

    @FindBy(xpath ="(//button[@data-action=\"click->slideover-account#toggle click@window->slideover-account#hide click->toggle-menu#hide touch->toggle-menu#hide\"])[1]")
    private WebElement registerButton;

    @FindBy(xpath ="//a[text()=\"Sign Up\"]")
    private WebElement singUp;

    @FindBy(xpath = "//form[@action=\"/user?theme_id=2302\"]//input[@id='user_email']")
    private WebElement signUpEmail;

    @FindBy(xpath = "//form[@action=\"/user?theme_id=2302\"]//input[@id='user_password']")
    private WebElement signUpPassword;

    @FindBy(xpath = "//form[@action=\"/user?theme_id=2302\"]//input[@id='user_password_confirmation']")
    private WebElement signUpPasswordConfirm;

    @FindBy(xpath = "//input[@value='Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath ="//p[@class=\"text-sm lg:text-base font-medium text-center uppercase text-text flash-message\"]")
    private WebElement singUpAssert;

    @FindBy(xpath ="(//div[@class=\"hidden lg:flex\"])[3]\n")
    private WebElement registerButtonAfterSingUp;

    @FindBy(xpath ="//button[text()=\"Log out\"]")
    private WebElement LogOut;




    public registePage(WebDriver driver) {
        super(driver);
    }
    @Step("click registerButton: {0}")
    public void registerButtonClick(){
        WaitUtils.waitForClickability(registerButton);
        registerButton.click();
    }
    @Step("click singUp: {1}")
    public void singUp(){
        WaitUtils.waitForClickability(singUp);
        singUp.click();
        WaitUtils.waitForVisibility(signUpEmail);
    }

    @Step("Enter email: {2}")
    public void email(String ema){
        WaitUtils.waitForVisibility(signUpEmail);
        signUpEmail.sendKeys(ema);
    }

    @Step("Enter password: {3}")
    public void password(String pas){
        WaitUtils.waitForVisibility(signUpPassword);
        signUpPassword.sendKeys(pas);
    }

    @Step("Enter passwordConfirmation: {4}")
    public void passwordConfirmation(String pas){
        WaitUtils.waitForVisibility(signUpPasswordConfirm);
        signUpPasswordConfirm.sendKeys(pas);
    }

    @Step("click singUpButton: {5}")
    public void singUpButton(){
        WaitUtils.waitForClickability(signUpButton);
        signUpButton.click();
    }

    @Step("Assert singUpAssert: {6}")
    public void singUpAssert(){
        WaitUtils.waitForClickability(singUpAssert);
        try {
            boolean isDispaly = singUpAssert.isDisplayed();
            Assert.assertTrue(isDispaly, "Sign up success message should be displayed.");
            log.info("Sign up success message is displayed as expected.");
        }catch(AssertionError e){
            log.error("Sign up success message is NOT displayed!");
            throw e;
        }
    }

    @Step("click LogOut: {7}")
    public void LogOut(){
        WaitUtils.waitForClickability(registerButtonAfterSingUp);
        registerButtonAfterSingUp.click();
        WaitUtils.waitForClickability(LogOut);
        LogOut.click();
    }





}
