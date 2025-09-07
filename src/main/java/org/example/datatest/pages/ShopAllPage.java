package org.example.datatest.pages;

import io.qameta.allure.Step;
import org.example.datatest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class ShopAllPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ShopAllPage.class);

    @FindBy(xpath ="(//a[@data-title=\"shop all\"])[1]")
    private WebElement shopAllbutton;

    @FindBy(xpath = "(//div[@class='page-container'])[4]//div[@id='products']//div[@class='swiper-slide w-full'][4]")
    private WebElement Products;

    @FindBy(xpath = "//label[@class=\"cursor-pointer\"]")
    private WebElement color;

    @FindBy(xpath = "//button[@data-action=\"click->dropdown#toggle click@window->dropdown#hide\"]\n")
    private WebElement ShooseSize;

    @FindBy(xpath = "//p[text()=\"M\"]")
    private WebElement size;

    @FindBy(xpath = "//button[@data-action=\"click->quantity-picker#increase\"]")
    private WebElement increase;

    @FindBy(xpath = "(//button[@data-action=\"click->product-form#showNotSelectedOptions\"])[1]")
    private WebElement submit;

    @FindBy(xpath = "//span[text()=\"Cart\"]")
    private WebElement AssertCard;

    @FindBy(xpath = "//button[@data-action=\"slideover#toggle\"]")
    private WebElement X;

    public ShopAllPage(WebDriver driver) {
        super(driver);
    }

    @Step("click registerButton: {0}")
    public void shopAllbutton(){
        WaitUtils.waitForClickability(shopAllbutton);
        shopAllbutton.click();
    }

    @Step(" product and click on it {1}")
    public void Products(){
        WaitUtils.waitForVisibility(Products);
        Products.click();
    }

    @Step(" color and click on it {2}")
    public void color(){
        WaitUtils.waitForClickability(color);
        color.click();
    }

    @Step(" chooseSize and click on it {3}")
    public void ShooseSize(){
        WaitUtils.waitForClickability(ShooseSize);
        ShooseSize.click();
        WaitUtils.waitForClickability(size);
        size.click();
        ShooseSize.click();
    }

    @Step(" increase and click on it {4}")
    public void increase(){
        WaitUtils.waitForClickability(increase);
        increase.click();
    }

    @Step(" submit and click on it {5}")
    public void submit(){
        WaitUtils.waitForClickability(submit);
        submit.click();
    }

    @Step("Assert card: {6}")
    public void AssertCard(){
        WaitUtils.waitForVisibility(AssertCard);
        try {
            boolean isDispaly = AssertCard.isDisplayed();
            Assert.assertTrue(isDispaly, "AssertCard success message should be displayed.");
            log.info("Sign up success message is displayed as expected.");
        }catch(AssertionError e){
            log.error("Sign up success message is NOT displayed!");
            throw e;
        }
    }

    @Step("click X on it {7}")
    public void X(){
        WaitUtils.waitForClickability(X);
        X.click();
    }




}
