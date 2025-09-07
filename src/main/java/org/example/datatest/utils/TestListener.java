package org.example.datatest.utils;

import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String screenshotPath = screenshotUtil.TakescreenShot(testName); // ✅ احصل على المسار

        // ابعت السكرين شوت دي للتقرير
        File file = new File(screenshotPath);

        try {
            Allure.addAttachment("Screenshot on Failure", new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
