package com.ellora.testCases;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import com.ellora.Utilities.VerifyElement;
import com.ellora.pageObjects.ProfilePage;

public class ProfileTest extends BaseClass{
   // WebDriver driver;
    ProfilePage profilePage;
    VerifyElement verify;

    @Test
    public void testUpdateProfileFields() {
		loginByKey("doctor");

		profilePage = new ProfilePage(driver);
       	driver.findElement(By.xpath("//span[@class='bg-primary text-uppercase text-white fw-600 auth-initials']")).click();
       	driver.findElement(By.xpath("//a[normalize-space()='Profile']")).click();
        profilePage.setFirstName("Sam");
        profilePage.setLastName("Doc");
        profilePage.setMiddleName("A");
        profilePage.setContactNumber("9876543210");
        profilePage.setEmailAddress("samdoc@example.com");
        profilePage.setEmployeeId("EMP001");

        profilePage.selectSmsOptInYes();
        profilePage.selectSubscribedYes();

        profilePage.setAddressLine1("123 Main Street");
        
//        profilePage.setAddressLine2("Apt 456");
//        profilePage.selectCountry("United States of America");
//        profilePage.setState("California");
//        profilePage.setCity("Los Angeles");
//        profilePage.setCounty("LA County");
//        profilePage.setZipCode("90001");
//        profilePage.setZipExt("1234");
//
//        profilePage.setSignature("Dr. Sam");
//        profilePage.setTitle("Psychologist");
        
        
        //  String str = "//div[normalize-space()='User updated successfully']";
          profilePage.scrollToBottomUntilStable(driver, 200);
          
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("document.querySelector('#has_valid_email').value = 'yes';");
          
          profilePage.clickSave();
         try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         VerifyElement.verifyElementVisible(driver, By.xpath("//div[normalize-space()='User updated successfully']"));
       
    }

  
}