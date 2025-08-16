package com.ellora.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.ellora.pageObjects.ProfilePage;
import com.ellora.Utilities.VerifyElement;
import io.cucumber.java.en.*;

import java.util.Map;

public class ProfileStepDefinitions extends BaseClass {

	    //WebDriver driver;
	  ProfilePage profilePage = new ProfilePage(driver);

	  @Given("User is logged into the application")
	    public void user_is_logged_into_the_application() {
	        // Initialize WebDriver from BaseClass
			loginByKey("doctor");
	        driver = BaseClass.getDriver();
	        profilePage = new ProfilePage(driver);
	    }

    @When("User navigates to the Profile page")
    public void user_navigates_to_the_profile_page() {
    	
    	 if (driver == null) {
             driver = BaseClass.getDriver();  // fallback
         }
    	
       	driver.findElement(By.xpath("//span[@class='bg-primary text-uppercase text-white fw-600 auth-initials']")).click();
       	driver.findElement(By.xpath("//a[normalize-space()='Profile']")).click();
    }

    @When("User updates profile with the following details:")
    public void user_updates_profile_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        profilePage.setFirstName(data.get("FirstName"));
        profilePage.setMiddleName(data.get("MiddleName"));
        profilePage.setLastName(data.get("LastName"));
        profilePage.setContactNumber(data.get("ContactNumber"));
        profilePage.setEmailAddress(data.get("Email"));
        profilePage.setEmployeeId(data.get("EmployeeID"));
    }

    @When("User selects SMS opt-in as {string}")
    public void user_selects_sms_opt_in_as(String opt) {
        if (opt.equalsIgnoreCase("Yes")) {
            profilePage.selectSmsOptInYes();
        } else {
            //profilePage.selectSmsOptInNo(); // you may add this method if required
        	System.out.println("Not selected sms option");
        }
    }

    @When("User selects Subscribed as {string}")
    public void user_selects_subscribed_as(String sub) {
        if (sub.equalsIgnoreCase("Yes")) {
            profilePage.selectSubscribedYes();
        } else {
        	System.out.println("Not selected sms option");
        	//profilePage.selectSubscribedNo(); // add if needed
        }
    }

    @When("User clicks the Save button")
    public void user_clicks_the_save_button() {
        profilePage.clickSave();
    }

    @Then("Success message {string} should be displayed")
    public void success_message_should_be_displayed(String expectedMessage) {
        boolean isVisible = driver.findElement(By.xpath("//div[normalize-space()='" + expectedMessage + "']")).isDisplayed();
        assert isVisible : "Success message not displayed!";
    }
}
