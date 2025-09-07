package org.example.datatest.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static org.example.datatest.utils.Setup.getDriver;


public class WebActions {

    public static void click(WebElement element) {
        WaitUtils.waitForClickability(element);
        element.click();
    }

    public static void type(WebElement element, String text) {
        WaitUtils.waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void hover(WebElement element) {
        WaitUtils.waitForVisibility(element);
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
    }

    public static void selectByVisibleText(WebElement element, String text) {
        WaitUtils.waitForInvisibility(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void scrollByPixels(int x, int y) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "window.scrollBy(arguments[0], arguments[1]);", x, y);
    }



}

