package org.example.datatest.utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "LoginData")
    public static Object[][] loginData() {
        return ExcelUtils.getExcelData("Sheet0");
    }
}
