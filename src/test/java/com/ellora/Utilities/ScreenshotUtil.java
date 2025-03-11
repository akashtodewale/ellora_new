package com.ellora.Utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String fileName) {
        // Define the directory path for storing screenshots
        String screenshotPath = System.getProperty("user.dir")+ fileName + ".png";
        try {
            // Capture the screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Create destination file and copy the screenshot
            File destination = new File(screenshotPath);
            FileHandler.copy(source, destination);
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
        return screenshotPath; // Return the screenshot path
    }
}