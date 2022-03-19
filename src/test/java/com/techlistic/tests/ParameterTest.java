package com.techlistic.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    static final Logger log = LogManager.getLogger(PracticeForm.class.getName());

@Parameters({"browser","version"})
    @Test(groups = {"smoke"})
    public void testParameter(String browser ,String version){
    Reporter.log("Browser is > "+browser);
    log.info("Browser is > "+browser);

    Reporter.log("Version is > "+version);
    log.info("Version is > "+version);

    }
}
