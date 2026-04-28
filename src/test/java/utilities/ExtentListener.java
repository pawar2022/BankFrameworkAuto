package utilities;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListener implements ITestListener {

    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context) {

        String path = System.getProperty("user.dir") + "/reports/ExtentReport.html";

        spark = new ExtentSparkReporter(path);
        spark.config().setReportName("Banking Automation Report");
        spark.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Pravin");
        extent.setSystemInfo("Environment", "QA");

        System.out.println("=== Test Suite Started ===");
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed: " + result.getThrowable());

        try {
            // 🔥 Get driver from test class
            WebDriver driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getField("driver")
                    .get(result.getInstance());

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

            File target = new File(path);
            FileHandler.copy(source, target);

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("=== Test Suite Finished ===");
    }
}