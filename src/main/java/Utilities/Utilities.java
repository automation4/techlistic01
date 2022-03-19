package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Utilities {


    public static LinkedHashMap<String, String> getExcelData() throws IOException {
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

        return map;
    }

    public static String getExceldataFromMap(LinkedHashMap<String,String> obj, String key) throws IOException {
        String value=null;
        for(Map.Entry<String,String> entry : obj.entrySet()){
            if(entry.getKey().equals(key)){
                value = entry.getValue();
                break;
            }
        }
        if(value==null){
            System.out.println(key +"not present");
            Assert.fail("key not present");
        }
        return value;
    }


    public static String getLocator(String locator) throws IOException {
        FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\locator.properties");
        Properties prop = new Properties();
        prop.load(fis2);
        return  prop.getProperty(locator);
    }

    public static String getData(String data) throws IOException {
        FileInputStream fis3 = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties");
        Properties prop = new Properties();
        prop.load(fis3);
        return prop.getProperty(data);

    }

    public static String getScreenshot(WebDriver driver, String failMethod) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File soruce = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") +"\\src\\screenshot\\" + failMethod + ".png";
        File finaldestination = new File(destination );
        try {
            FileUtils.copyFile(soruce, finaldestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static WebElement getElementValue(List<WebElement> elements, String expectedvalue){

        WebElement elem=null;

        for(WebElement element :elements){
            System.out.println(element.getAttribute("value")+"from list & expected element" + expectedvalue);
            if(element.getAttribute("value").equalsIgnoreCase(expectedvalue)){
                return element;
            }
        }
        return elem;
    }

    public static void scrollToElement(WebElement elm, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",elm);
    }


}


       /* for (int r = 0; r < lastRowNum; r++) {
            LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();  // linked hasmap is used to maintain order
            for (int c = 0; c < lastCellNum; c++) {

                DataFormatter df = new DataFormatter();
                String key = df.formatCellValue(sheet.getRow(r).getCell(0));
                String value = df.formatCellValue(sheet.getRow(r).getCell(1));
                map.put(key, value);
            }
                obj[r][0] = map;
            }
            return obj;*/






