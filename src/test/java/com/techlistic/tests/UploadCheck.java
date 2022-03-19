package com.techlistic.tests;

import Utilities.Utilities;
import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Diffcheckerhomepage;
import java.io.IOException;

@Listeners(listeners.Listeners.class)
public class UploadCheck extends Base {
Diffcheckerhomepage home;
Logger log = LogManager.getLogger(UploadCheck.class.getName());
    @BeforeClass(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        driver = initializeDriver();
        Reporter.log("Driver is initialized Successfully");
        log.info("Driver is initialized Successfully");
        Reporter.log("New Changes");
        driver.get(Utilities.getData("testurl2"));
        home  = new Diffcheckerhomepage(driver);
        Thread.sleep(1000);
        home.closePopUp();
    }

    @Test
    public void uploadFile() throws IOException, InterruptedException {
            home.gotoTextUpload();
            home.clicUploadText().click();
        Thread.sleep(2000);
            Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\AutoItScript.exe");
            Thread.sleep(2000);
             WebElement element = belowElement(home.clicUploadText(),"div");
        Reporter.log(element.getText());
        Assert.assertTrue(true,"file uploaded successfully");

        }
    }