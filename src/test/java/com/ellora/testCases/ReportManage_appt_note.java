package com.ellora.testCases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ellora.pageObjects.LoginPage;
import com.ellora.pageObjects.ReportsPage;

public class ReportManage_appt_note  {
	public WebDriver driver;
    


	    @Test
	    public void testReportsGeneration() {
	        
	   
			ReportsPage reportsPage = new ReportsPage(driver);
	        driver = BaseClass.initializeDriver("chrome");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.get("https://schedulerstage1mentalhealth.ellorasystems.com/");
	        LoginPage loginPage = new LoginPage(driver);

	        // Perform login steps
	        loginPage.enterUsername("medicalstage1");
	        loginPage.enterPassword("Bb123!@#"); 
	        loginPage.clickLoginButton();

	        // Open Reports
	        reportsPage.openReports();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        // Select Report
	        reportsPage.selectReport("Brief Note Report");

	        // Apply Filters
	        reportsPage.filterReport("sam", "Stage1 mental", "Jan 01, 2025 to Mar 10, 2025");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        // Generate Report
	        reportsPage.generateReport();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        // Send Email Report
	        reportsPage.sendEmailReport("akash.todewale@bostonbyte.com");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        // Verify Email Sent
	        Assert.assertTrue(reportsPage.isEmailSent(), "Email was not sent successfully!");
	    }
	}


