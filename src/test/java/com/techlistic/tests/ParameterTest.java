package com.techlistic.tests;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

@Parameters({"browser","version"})
    @Test(groups = {"smoke"})
    public void testParameter(String browser ,String version){
    Reporter.log("Browser is > "+browser);
    Reporter.log("Version is > "+version);

    }
}
