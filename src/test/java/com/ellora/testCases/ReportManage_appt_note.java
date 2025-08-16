package com.ellora.testCases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ellora.pageObjects.LoginPage;
import com.ellora.pageObjects.ReportsPage;

public class ReportManage_appt_note extends BaseClass{
	//public WebDriver driver;
	ReportsPage reportspage;
	
	  @BeforeClass
	    public void setUpPageObjects() {
	        reportspage = new ReportsPage(driver);  // ✅ Initialize here
	    }

	
	@Test
	public void testReportsGeneration() {
		loginByKey("doctor");

//		driver = BaseClass.initializeDriver("chrome");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://schedulerstage1mentalhealth.ellorasystems.com/");
//		LoginPage loginPage = new LoginPage(driver);
//
//		ReportsPage reportsPage = new ReportsPage(driver);
//
//		// Perform login steps
//		loginPage.enterUsername("medicalstage1");
//		loginPage.enterPassword("Bb123!@#");
//		loginPage.clickLoginButton();

		// Open Reports
		reportspage.openReports();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Select Report
		reportspage.selectReport("Brief Note Report");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Apply Filters
		try {
			reportspage.filterReport("Sam Doc", "Omni", "Jan 01, 2025 to Mar 10, 2025");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Generate Report
		reportspage.generateReport();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Send Email Report
		reportspage.sendEmailReport("akash.todewale@bostonbyte.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Verify Email Sent
		Assert.assertTrue(reportspage.isEmailSent(), "Email was not sent successfully!");
	
}
}
