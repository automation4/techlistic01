package com.techlistic.tests;
import Utilities.Utilities;
import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.Techlisticpage;
import java.io.IOException;
import java.util.LinkedHashMap;


@Listeners(listeners.Listeners.class)
public class PracticeForm extends Base{
    LinkedHashMap<String,String> gettestdata;
    Techlisticpage home;
    WebDriver driver;

  static final Logger log = LogManager.getLogger(PracticeForm.class.getName());
   @BeforeClass(alwaysRun = true)
    public void asetup() throws IOException {
        driver = initializeDriver();
        Reporter.log("Driver is initialized Successfully");
        driver.get(Utilities.getData("testurl"));
        home  = new Techlisticpage(driver);
        gettestdata = Utilities.getExcelData();
    }

    @Test(groups = {"smoke","regression"},priority = 1)
   public void enterName() throws IOException {
       // log.debug("first name is initialized Successfully");

        home.setFirstname().sendKeys(Utilities.getExceldataFromMap(gettestdata,"first name"));
       home.setLastname().sendKeys(Utilities.getExceldataFromMap(gettestdata,"last name"));

   }
   @Test(groups = {"regression"},priority = 2)
    public void selectGender() throws IOException {
       Utilities.getElementValue(home.setGender(),Utilities.getExceldataFromMap(gettestdata,"Gender")).click();
    }

    @Test(groups = {"regression"},priority = 3)
    public void yearOfExperiece() throws IOException {
        Utilities.getElementValue(home.setYearofexp(),Utilities.getExceldataFromMap(gettestdata,"Years of Experience")).click();
    }

    @Test(groups = {"regression"},priority = 7)
    public void enterDate() throws IOException {
        home.setCssdatepicker().sendKeys(Utilities.getExceldataFromMap(gettestdata,"Date"));
    }

    @Test(groups = {"regression"},priority = 4)
    public void selectProfession() throws IOException {
        Utilities.getElementValue(home.setProfession(),Utilities.getExceldataFromMap(gettestdata,"Profession")).click();
    }

    @Test(groups = {"regression"},priority =5)
    public void selectAutomationTools() throws IOException {
        Utilities.getElementValue(home.setAutomationtools(),Utilities.getExceldataFromMap(gettestdata,"Automation tools")).click();

    }

    @Test(groups = {"regression"})
    public void selectContinents() throws IOException {
        WebElement elm = home.setContinents();
        Select sel = new Select(elm);
        sel.selectByVisibleText(Utilities.getExceldataFromMap(gettestdata,"Continents"));
    }

    @Test(groups = {"regression"})
    public void SeleniumCommands() throws IOException {
        String values = Utilities.getExceldataFromMap(gettestdata,"Selenium Commands");
        String [] Latest = values.split(",");

        for(String value:Latest){
            Select sel = new Select(home.setSelenium_commands());
            sel.selectByVisibleText(value);
        }
        }

    @Test(groups = {"regression"})
    public void UploadImage() throws IOException, InterruptedException {
        WebElement elm = home.setCssphotoupload();
        Utilities.scrollToElement(elm,driver);
        elm.click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\AutoItScript.exe");
        Thread.sleep(2000);
    }




     /*@DataProvider(name = "test1")
    public Object[][] getData() throws IOException {
         Object[][] obj = Utilities.getExcelData();
         return obj;
     }*/
}
