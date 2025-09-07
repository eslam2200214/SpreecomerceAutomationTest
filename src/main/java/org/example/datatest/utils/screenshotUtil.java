package org.example.datatest.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshotUtil {

    public static String  TakescreenShot(String testName){
        WebDriver driver =Setup.getDriver();

        String Time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "src/main/java/org/example/datatest/screenshots/" + testName + "_" + Time + ".png";

        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);

        try{
            FileUtils.copyFile(SrcFile,destFile);
        } catch (IOException e) {
            System.out.println(" Failed to save screenshot: " + e.getMessage());
        }
        return destFile.getAbsolutePath(); // ✅ رجّع المسار الحقيقي

    }
}

