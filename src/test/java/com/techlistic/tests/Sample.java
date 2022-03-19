package com.techlistic.tests;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sample {

    @Test
    public void getExcelData() throws IOException {
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rows = sheet.getPhysicalNumberOfRows();

        /*Object[][] data = new Object[9][2];
       for(int r=1;r<rows;r++){
           for(int c=0;c<sheet.getRow(r).getLastCellNum();c++){
               DataFormatter df = new DataFormatter();
              data[r-1][c] = df.formatCellValue(sheet.getRow(r).getCell(c));
           }
        }

         for(int r=0;r<data.length;r++){
           for(int c=0;c<data[r].length;c++){
               System.out.println(data[r][c]);
           }
       }*/

        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();  // linked hasmap is used to maintain order
        for (int r = 1; r < rows; r++) {
            DataFormatter df = new DataFormatter();
            String key = df.formatCellValue(sheet.getRow(r).getCell(0));
            String value = df.formatCellValue(sheet.getRow(r).getCell(1));
            map.put(key, value);

        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("For Key " + entry.getKey() + " value is " + entry.getValue());
        }
    }
}
