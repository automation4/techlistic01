package listeners;

import Utilities.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import base.Base;
import org.testng.*;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    ExtentHtmlReporter ehr ;
    ExtentReports er;
    ExtentTest test ;


    public void onStart(ITestContext testContext) {

        ehr = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\src\\reports\\reportsExtentreport_"+ System.currentTimeMillis()+".html");
        ehr.config().setTestViewChartLocation(ChartLocation.TOP);
        ehr.config().setDocumentTitle("Tecgkusutc Atutomation");
        ehr.config().setReportName("Tester");
        ehr.config().setTheme(Theme.DARK);
        ehr.config().setProtocol(Protocol.HTTP);

        er = new ExtentReports();
        er.attachReporter(ehr);
        er.setSystemInfo("Windows","10");
        er.setSystemInfo("Build","5");
        er.setSystemInfo("Browser","Chrome");
    }

    public void onTestSuccess(ITestResult tr) {
    test = er.createTest(tr.getName());
    test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr) {
            test = er.createTest(tr.getName());
            test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
            try {
                String screenShotpath = Utilities.getScreenshot(driver, tr.getName());
                //To add it in the extent report
                test.addScreenCaptureFromPath(screenShotpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void onTestSkipped(ITestResult tr) {
        test = er.createTest(tr.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
    }


    public void onFinish(ITestContext testContext) {
    er.flush();
    }

}
