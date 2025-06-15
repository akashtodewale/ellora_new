package com.ellora.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	 WebDriver driver;

	    public ProfilePage(WebDriver driver) {
	        this.driver = driver;
	    }

    // Locators public static final
    public static final By firstName = By.id("first_name");
    public static final By lastName = By.id("last_name");
    public static final By middleName = By.id("middle_name");
    public static final By contactNumber = By.xpath("//input[contains(@name,'phone_number')]");
    public static final By emailAddress = By.id("email");
    public static final By employeeId = By.id("employee_id");
    public static final By smsOptInYes = By.xpath("//input[@id=\"sms_consented_yes\"]");
    public static final By subscribedYes = By.xpath("//input[@id=\"email_consented_yes\"]");
//    public static final By addressLine1 = By.id("Address1");
//    public static final By addressLine2 = By.id("Address2");
//    public static final By country = By.id("Country");
//    public static final By state = By.id("State");
//    public static final By city = By.id("City");
//    public static final By county = By.id("County");
//    public static final By zipCode = By.id("ZipCode");
//    public static final By zipExt = By.id("ZipExt");
//    public static final By signature = By.id("Signature");
//    public static final By title = By.id("Title");
    public static final By saveButton = By.xpath("//button[@id=\"save_user_data_btn\"]");

    // Actions
    public void setFirstName(String value) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(value);
    }

    public void setLastName(String value) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(value);
    }

    public void setMiddleName(String value) {
        driver.findElement(middleName).clear();
        driver.findElement(middleName).sendKeys(value);
    }

    public void setContactNumber(String value) {
        driver.findElement(contactNumber).clear();
        driver.findElement(contactNumber).sendKeys(value);
    }

    public void setEmailAddress(String value) {
        driver.findElement(emailAddress).clear();
        driver.findElement(emailAddress).sendKeys(value);
    }

    public void setEmployeeId(String value) {
        driver.findElement(employeeId).sendKeys(value);
    }

    public void selectSmsOptInYes() {
        driver.findElement(smsOptInYes).click();
    }

    public void selectSubscribedYes() {
        driver.findElement(subscribedYes).click();
    }

//    public void setAddressLine1(String value) {
//        driver.findElement(addressLine1).sendKeys(value);
//    }
//
//    public void setAddressLine2(String value) {
//        driver.findElement(addressLine2).sendKeys(value);
//    }
//
//    public void selectCountry(String visibleText) {
//        new Select(driver.findElement(country)).selectByVisibleText(visibleText);
//    }
//
//    public void setState(String value) {
//        driver.findElement(state).sendKeys(value);
//    }
//
//    public void setCity(String value) {
//        driver.findElement(city).sendKeys(value);
//    }
//
//    public void setCounty(String value) {
//        driver.findElement(county).sendKeys(value);
//    }
//
//    public void setZipCode(String value) {
//        driver.findElement(zipCode).sendKeys(value);
//    }
//
//    public void setZipExt(String value) {
//        driver.findElement(zipExt).sendKeys(value);
//    }
//
//    public void setSignature(String value) {
//        driver.findElement(signature).sendKeys(value);
//    }
//
//    public void setTitle(String value) {
//        driver.findElement(title).sendKeys(value);
//    }
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void clickSave() {
    	
    	WebElement saveButton = driver.findElement(By.id("save_user_data_btn"));
    	scrollToElement(driver, saveButton);
    
    	saveButton.click();
    	
    }

	public void selectSmsOptInNo() {
		// TODO Auto-generated method stub
		 driver.findElement(smsOptInYes).click();
	}
}