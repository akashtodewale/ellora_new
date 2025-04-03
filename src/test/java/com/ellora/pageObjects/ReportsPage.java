package com.ellora.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ellora.Utilities.WaitUtil;
public class ReportsPage {
   private WebDriver driver;
  
    public ReportsPage(WebDriver driver) {
	super();
	this.driver = driver;
}

	// Locators
    private By reportsMenu = By.xpath("//a[normalize-space()='Reports']");
    private By reportDropdown = By.xpath("//div[@data-tooltip=\"Select Report\"]");
    private By searchReport = By.xpath("//div[@id=\"select_report_name\"]//input[@class=\"vscomp-search-input\"]");
    private By includeInactiveButton = By.xpath("//input[@id=\"report_inactive_provider\"]");
    private By providerDropdown = By.xpath("//div[contains(text(),'Select Provider')]/parent::div/parent::div");
    private By searchProvider = By.xpath("//div[@id=\"report_select_providers\"]//input[@class=\"vscomp-search-input\"]");
    private By facilityDropdown = By.xpath("//div[contains(text(),'Select Facility')]");
    private By searchFacility = By.xpath("//div[@id=\"report_select_facilities\"]//input[@class=\"vscomp-search-input\"]");
    private By clientDropdown = By.xpath("//div[@class=\"vscomp-toggle-button\" and normalize-space()=\"Select Client\"]");
    private By selectAllClients = By.xpath("(//span[@class=\"vscomp-toggle-all-button\"])[2]");
    private By serviceDateField = By.xpath("//input[@id=\"report_date_range\"]/following-sibling::input");
    private By getReportButton = By.xpath("//button[normalize-space()='Get Report']");
    private By sendEmailField = By.xpath("//input[@id=\"report_send_email\"]");
    private By sendEmailButton = By.xpath("//button[@id=\"report_send_email_button\"]");
    private By emailSuccessMessage = By.xpath("//div[@class='toast-body fw-normal' and normalize-space()=\"Request for exporting report is accepted. You should receive an email once the report is ready!\"]");

    // Constructor
  

    // Methods
    public void openReports() {
        driver.findElement(reportsMenu).click();
    }

    public void selectReport(String reportName) {
        driver.findElement(reportDropdown).click();
        driver.findElement(searchReport).sendKeys(reportName);
        driver.findElement(searchReport).sendKeys(Keys.ENTER);
    }

    public void filterReport(String provider, String facility, String serviceDate) throws InterruptedException {
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

    public void generateReport() {
        driver.findElement(getReportButton).click();
    }

    public void sendEmailReport(String email) {
        if (driver.findElement(sendEmailField).isDisplayed()) {
            driver.findElement(sendEmailField).sendKeys(email);
            driver.findElement(sendEmailButton).click();
        }
    }

    public boolean isEmailSent() {
        return driver.findElement(emailSuccessMessage).isDisplayed();
    }
}