package base;
import Utilities.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


import java.io.IOException;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Base {

    public static WebDriver driver;


    public static WebDriver initializeDriver() throws IOException {
        if (Utilities.getData("browser").equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\driver\\chromedriverv99.exe");
            driver = new ChromeDriver();
        }
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

   @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void waitSeeResult() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static WebElement belowElement(org.openqa.selenium.WebElement element, String tag){
        return driver.findElement(with(By.tagName(tag)).below(element));
    }

}
