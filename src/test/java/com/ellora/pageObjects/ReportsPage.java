package com.ellora.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ellora.Utilities.WaitUtil;
public class ReportsPage {
   public static WebDriver driver;
  
    public ReportsPage(WebDriver driver) {
	super();
	ReportsPage.driver = driver;
    }

	// Locators
    public static final By reportsMenu = By.xpath("//a[normalize-space()='Reports']");
    public static final By reportDropdown = By.xpath("//div[@data-tooltip=\"Select Report\"]");
    public static final By searchReport = By.xpath("//div[@id=\"select_report_name\"]//input[@class=\"vscomp-search-input\"]");
    public static final By includeInactiveButton = By.xpath("//input[@id=\"report_inactive_provider\"]");
    public static final By providerDropdown = By.xpath("//div[contains(text(),'Select Provider')]/parent::div/parent::div");
    public static final By searchProvider = By.xpath("//div[@id=\"report_select_providers\"]//input[@class=\"vscomp-search-input\"]");
    public static final By facilityDropdown = By.xpath("//div[contains(text(),'Select Facility')]");
    public static final By searchFacility = By.xpath("//div[@id=\"report_select_facilities\"]//input[@class=\"vscomp-search-input\"]");
    public static final By clientDropdown = By.xpath("//div[@class=\"vscomp-toggle-button\" and normalize-space()=\"Select Client\"]");
    public static final By selectAllClients = By.xpath("(//span[@class=\"vscomp-toggle-all-button\"])[2]");
    public static final By serviceDateField = By.xpath("//input[@id=\"report_date_range\"]/following-sibling::input");
    public static final By getReportButton = By.xpath("//button[normalize-space()='Get Report']");
    public static final By sendEmailField = By.xpath("//input[@id=\"report_send_email\"]");
    public static final By sendEmailButton = By.xpath("//button[@id=\"report_send_email_button\"]");
    public static final By emailSuccessMessage = By.xpath("//div[@class='toast-body fw-normal' and normalize-space()=\"Request for exporting report is accepted. You should receive an email once the report is ready!\"]");

    // Constructor
  

    // Methods
    public static void openReports() {
        driver.findElement(reportsMenu).click();
    }

    public static void selectReport(String reportName) {
        driver.findElement(reportDropdown).click();
        driver.findElement(searchReport).sendKeys(reportName);
        driver.findElement(searchReport).sendKeys(Keys.ENTER);
    }

    public static void filterReport(String provider, String facility, String serviceDate) throws InterruptedException {
    	 Actions actions = new Actions(driver);
        driver.findElement(includeInactiveButton).click();
       
        driver.findElement(providerDropdown).click();
        WaitUtil.waitForElementToBeClickable(driver, By.xpath("//div[contains(text(),'Select Provider')]/parent::div/parent::div"), 5);
        driver.findElement(searchProvider).sendKeys(provider);
        WaitUtil.waitForElementToBeClickable(driver, By.xpath("//div[@id=\"report_select_providers\"]//input[@class=\"vscomp-search-input\"]"), 5);
        actions.sendKeys(Keys.ENTER).perform();
        driver.findElement(searchProvider).sendKeys(Keys.ENTER);

       
        driver.findElement(facilityDropdown).click();
        driver.findElement(searchFacility).sendKeys(facility);
        actions.sendKeys(Keys.ENTER).perform();

        driver.findElement(clientDropdown).click();
        driver.findElement(selectAllClients).click();
        driver.findElement(clientDropdown).sendKeys(Keys.ESCAPE);

        driver.findElement(serviceDateField).clear();
        driver.findElement(serviceDateField).sendKeys(serviceDate);
        driver.findElement(serviceDateField).sendKeys(Keys.ENTER);
    }

    public static void generateReport() {
        driver.findElement(getReportButton).click();
    }

    public static void sendEmailReport(String email) {
        if (driver.findElement(sendEmailField).isDisplayed()) {
            driver.findElement(sendEmailField).sendKeys(email);
            driver.findElement(sendEmailButton).click();
        }
    }

    public static boolean isEmailSent() {
        return driver.findElement(emailSuccessMessage).isDisplayed();
    }
    
}