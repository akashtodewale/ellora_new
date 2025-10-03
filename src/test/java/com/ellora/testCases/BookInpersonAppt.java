package com.ellora.testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ellora.Utilities.VerifyElement;
import com.ellora.pageObjects.QuickApptObjects;

public class BookInpersonAppt extends BaseClass {
	
	@Test
	
	public void bookInpersonAppt() throws InterruptedException {
		
		loginByKey("doctor");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		 
		
		
		QuickApptObjects quickApptObjects = new QuickApptObjects(driver);
		
		quickApptObjects.getUsersMenu().click();
		
		quickApptObjects.getFNameInput().sendKeys("jen" +Keys.ENTER);
        System.out.println("test");
    	
		quickApptObjects.getQuickApptIcon().click();
		wait.wait(2);
		quickApptObjects.getInPersonApptButton().click();
		//((WebElement) quickApptObjects.confirmButton).click();
		quickApptObjects.getConfirmButton().click();
		if(((WebElement) quickApptObjects.confirmModal).isDisplayed()) {
			
			quickApptObjects.getButtonContinue().click();
		}
		
		 WebElement textElement = driver.findElement(By.xpath("//div[normalize-space()='Appointments']"));
	        String actualText = textElement.getText();
	        String expectedText = "Appointment Session";

	        // Verify using TestNG assertion
	        Assert.assertEquals(actualText, expectedText, "Text does not match!");
	        VerifyElement.verifyElementVisible(driver, By.xpath("//div[normalize-space()='Appointments']"));
		
		
	}

	
	}
	
	

	
	

