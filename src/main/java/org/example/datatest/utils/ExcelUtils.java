package org.example.datatest.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getExcelData(String sheetName) {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/data/TestData.xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);
            int totalRows = sheet.getPhysicalNumberOfRows();
            int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[totalRows - 1][totalCols];
            for (int i = 1; i < totalRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < totalCols; j++) {
                    DataFormatter formatter = new DataFormatter();
                    data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                }
            }
            workbook.close();
            file.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
