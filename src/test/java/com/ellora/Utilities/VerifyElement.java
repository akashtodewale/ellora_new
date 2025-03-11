package com.ellora.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyElement {
	 public WebDriver driver;
    /**
     * Verifies if an element is visible on the page.
     * 
     * @param driver  WebDriver instance.
     * @param locator The locator of the element to be checked.
     * @return true if the element is visible, false otherwise.
     */
    public static boolean verifyElementVisible(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            // Catch NoSuchElementException or other exceptions if the element is not found
            return false;
          
        
        }
    }
}