package org.example.datatest.pages;

import io.qameta.allure.Step;
import org.example.datatest.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class newArrivialsPages extends filter {
    private static final Logger log = LoggerFactory.getLogger(newArrivialsPages.class);

    @FindBy(xpath ="(//span[text()=\"New Arrivals\"])[1]")
    private WebElement newArrivials;

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

    public newArrivialsPages(WebDriver driver) {
        super(driver);
    }

    @Step("click registerButton: {0}")
    public void newArrivials(){
        WaitUtils.waitForClickability(newArrivials);
        newArrivials.click();
    }

    @Step("click registerButton: {0}")
    public void filter(){
        filterButton();
        availability();
        stock();
        colorBytton();
        colorChois(10);
        submits();
    }

    @Step("Click any product at index 3")
    public void clickAnyProduct() {
        By productLocator = By.xpath("(//div[@id='products']//div[contains(@class,'swiper-slide')]//*[self::h2 or self::h3 or self::p])[3]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement product = driver.findElement(productLocator);
                WaitUtils.waitForClickability(product);
                product.click();
                log.info("Clicked product at index: 3");
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                log.warn("StaleElementReferenceException caught, retrying... attempt {}", attempts + 1);
            }
            attempts++;
        }
        throw new RuntimeException("Failed to click product after retries: " + productLocator);
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
