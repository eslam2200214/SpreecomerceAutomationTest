package org.example.datatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.datatest.utils.Setup.getDriver;

public class WaitUtils {
    private static final int TimeOut =30;

    public static void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TimeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForClickability(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TimeOut));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForInvisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TimeOut));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static boolean waitForOptionsToBePresent(WebDriver driver, WebElement selectElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
            wait.until(driver1 -> {
                Select select = new Select(selectElement);
                return select.getOptions().size() > 0;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
