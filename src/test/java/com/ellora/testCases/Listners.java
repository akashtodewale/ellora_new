package com.ellora.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.ellora.testCases.BaseClass;

//ITestListener interface which implements testNG Listeners
public class Listners implements ITestListener{


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        // Take screenshot on failure
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseClass) testClass).getDriver(); // casting to access driver

        if (driver != null) {
            takeScreenshot(result.getName(), driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Partially Failed: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Execution Finished: " + context.getName());
    }

    // Screenshot method
    private void takeScreenshot(String testName, WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = "test-output/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            File destFile = new File(destPath);
            destFile.getParentFile().mkdirs(); // Ensure directory exists
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("Screenshot saved: " + destPath);
        } catch (IOException e) {
            System.err.println("Screenshot failed: " + e.getMessage());
        }
    }

}
	

