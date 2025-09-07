package org.example.datatest.pages;

import io.qameta.allure.Step;
import org.example.datatest.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class filter extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(filter.class);
    @FindBy(xpath = "//button[@class=\"uppercase flex gap-2 text-sm items-center font-semibold py-3\"]")
    private WebElement filterButton;

    @FindBy(xpath = "//*[@data-slideover-target='overlay']")
    private WebElement overlay;

    @FindBy(xpath = "//a[@href=\"#availability_filter\"]")
    private WebElement availability;

    @FindBy(xpath = "((//ul[@class=\"flex flex-col px-4 lg:px-10\"])//input[@type=\"checkbox\"])[1]")
    private WebElement stock;

    @FindBy(xpath ="//a[@href=\"#taxonomy_filter_39\"]")
    private WebElement categories;

    @FindBy(xpath = "//input[@id=\"filter_taxon_180\"]")
    private WebElement categoriesMen;

    @FindBy(xpath = "(//a[@data-action=\"accordion#toggle:prevent\"])[3]")
    private WebElement colorBytton;

    @FindBy(xpath = "(//a[@data-action=\"accordion#toggle:prevent\"])[4]\n")
    private WebElement sizeButton;

    @FindBy(xpath = "(//label[@class=\"flex items-center gap-2 cursor-pointer group text-sm h-10\"])[4]")
    private WebElement sizeChoise;

    @FindBy(xpath = "//button[text()=\"Apply\"]\n")
    private WebElement submits;

    public filter(WebDriver driver) {
        super(driver);
    }

    @Step("click registerButton: {0}")
    public void filterButton(){
        WaitUtils.waitForClickability(filterButton);
        filterButton.click();
    }
    @Step("click registerButton: {0}")
    public void availability(){
        WaitUtils.waitForClickability(availability);
        availability.click();
    }
    @Step("click registerButton: {0}")
    public void stock(){
        WaitUtils.waitForClickability(stock);
        stock.click();
    }
    @Step("click registerButton: {0}")
    public void categories(){
        WaitUtils.waitForClickability(categories);
        categories.click();
    }
    @Step("click registerButton: {0}")
    public void categoriesMen(){
        WaitUtils.waitForClickability(categoriesMen);
        categoriesMen.click();
    }
    @Step("click registerButton: {0}")
    public void colorBytton(){
        WaitUtils.waitForClickability(colorBytton);
        colorBytton.click();
    }
    @Step("click registerButton: {0}")
    public void colorChois(int index){
        By colorLocator = By.xpath("((//div[@data-accordion-id='colors_filter'])//label[@class='cursor-pointer'])[" + index + "]");
        WebElement colorElement = driver.findElement(colorLocator);
        WaitUtils.waitForClickability(colorElement);
        colorElement.click();
        log.info("Selected color at index: {}", index);

    }
    @Step("click registerButton: {0}")
    public void sizeButton(){
        WaitUtils.waitForClickability(sizeButton);
        sizeButton.click();
    }
    @Step("click registerButton: {0}")
    public void sizeChoise(){
        WaitUtils.waitForClickability(sizeChoise);
        sizeChoise.click();
    }
    @Step("click registerButton: {0}")
    public void submits(){
        WaitUtils.waitForClickability(submits);
        submits.click();
    }

  }

