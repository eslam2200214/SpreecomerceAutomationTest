package org.example.datatest.pages;

import io.qameta.allure.Step;
import org.example.datatest.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class FashionPage extends filter {
    private static final Logger log = LoggerFactory.getLogger(FashionPage.class);

    @FindBy(xpath ="//span[text()=\"Fashion\"]")
    private WebElement FashionPage;

    @FindBy(xpath ="//a[@data-title='knitwear']//span[normalize-space()='Knitwear']\n")
    private WebElement Knitwear;

    @FindBy(xpath = "//div[@id='products']//div[contains(@class,'swiper-slide')]//*[self::h2 or self::h3 or self::p]")
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
    private WebElement submitt;

    @FindBy(xpath = "//span[text()=\"Cart\"]")
    private WebElement AssertCard;

    @FindBy(xpath = "//button[@data-action=\"slideover#toggle\"]")
    private WebElement X;

    public FashionPage(WebDriver driver) {
        super(driver);
    }

    @Step("click registerButton: {0}")
    public void FashionPage(){

        WaitUtils.waitForClickability(FashionPage);
        FashionPage.click();
    }

    public void Knitwear(){
        WaitUtils.waitForClickability(Knitwear);
        Knitwear.click();
    }

    @Step("click registerButton: {0}")
    public void filter(){
        filterButton();
        availability();
        stock();
        colorBytton();
        colorChois(4);
        submits();
    }

    @Step("product and click on it {1}")
    public void clickAnyProduct() {
        WaitUtils.waitForClickability(Products);
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
        WaitUtils.waitForClickability(submitt);
        submitt.click();
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
