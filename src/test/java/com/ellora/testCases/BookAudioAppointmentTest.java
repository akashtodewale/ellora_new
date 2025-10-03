package com.ellora.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ellora.Utilities.ScreenshotUtil;
import com.ellora.Utilities.VerifyElement;
import com.ellora.Utilities.WaitUtil;
import com.ellora.pageObjects.BookAudioAppointmentPage;
import com.ellora.pageObjects.DocumentUploadPage;

public class BookAudioAppointmentTest extends BaseClass {


	    @Test
	    public void bookAudioAppointmentTest() throws InterruptedException {
			loginByKey("doctor");
			
			

	        // Click on clients menu
	    	  driver.findElement(DocumentUploadPage.CLIENTS_TAB).click();

	          // Search for Client
	          driver.findElement(DocumentUploadPage.SEARCH_FIRST_NAME).sendKeys("Mrunal");
	          driver.findElement(DocumentUploadPage.SEARCH_LAST_NAME).sendKeys("Patil");
	          driver.findElement(DocumentUploadPage.SEARCH_BUTTON).click();

	          // Open Chart of patient
	          driver.findElement(DocumentUploadPage.CHART_ICON).click();
	          
	        // Click on New Appointment button
	        driver.findElement(BookAudioAppointmentPage.NEW_APPOINTMENT_BUTTON).click();

	        // Click on PM In-person button
	        driver.findElement(BookAudioAppointmentPage.AM_PM).click();
	        WaitUtil.waitForElementToBeVisible(driver, BookAudioAppointmentPage.SELECT_PM, 1);
	        driver.findElement(BookAudioAppointmentPage.SELECT_PM).click();
            driver.findElement(BookAudioAppointmentPage.IN_PERSON_BUTTON).click();

	        // Set appointment reason
	        driver.findElement(BookAudioAppointmentPage.APPT_REASON_INPUT).click();
	        driver.findElement(BookAudioAppointmentPage.APPT_REASON_INPUT).sendKeys("Test appointment reason");

	        // Click save button
	        driver.findElement(BookAudioAppointmentPage.SAVE_BUTTON).click();
	      Thread.sleep(4);

	        // Click Continue button (optional)
	        try {
	            WebElement continueButton = driver.findElement(BookAudioAppointmentPage.CONTINUE_BUTTON);
	            if (continueButton.isDisplayed()) {
	                continueButton.click();
	                //continueButton.click();
	            }
	        } catch (Exception e) {
	            System.out.println("Continue button not found or not visible.");
	        }

	        // Verification can be added here based on success message or confirmation
	        Assert.assertTrue(VerifyElement.verifyElementVisible(driver, BookAudioAppointmentPage.SUCCESS_MESSAGE));
	        System.out.println("Appointment Booked Successfully");
	    
	    }    
}    //Appointment canceled successfully
    

