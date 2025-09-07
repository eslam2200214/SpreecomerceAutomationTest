package org.example.datatest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup  {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver (){
        return driver.get();
    }

    public static  void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
