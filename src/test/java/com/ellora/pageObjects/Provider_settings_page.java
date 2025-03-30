package com.ellora.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ellora.Utilities.WaitUtil;
import com.ellora.testCases.BaseClass;



	// using traditional Page object model-->
	// private final By Settings_menu =
	// By.xpath("//a[normalize-space()='Settings']");

	// using page Factory model -->
	// @FindBy(xpath="//a[normalize-space()='Settings']")
	// private WebElement Settings;
	public class Provider_settings_page {

	    WebDriver driver;
	    Actions act;

	    // General Settings Objects
	    @FindBy(xpath = "//li[@class='nav-item']//a[contains(@class,'nav-link')][normalize-space()='General']")
	    WebElement GeneralSubMenu;

	    @FindBy(id = "btn-edit-duration")
	    WebElement ChangeDurationicon;

	    By SelectdurationDD = By.xpath("//input[@name='select_duration']/following-sibling::div[1]");
	    By Select_5Min = By.xpath("//span[@data-tooltip='15 Min']");
	    
	    @FindBy(id = "btn-save-duration")
	    WebElement SaveDurationBtn;

	    @FindBy(id = "btn-edit-signature")
	    WebElement ChangeSignicon;

	    @FindBy(xpath = "//a[@id='initials-signature-tab']")
	    WebElement SignFromInitials;

	    @FindBy(id = "provider_initials")
	    WebElement InputInitials;

	    By Save_Signaturebtn = By.xpath("//button[@id='save-signature']");
	    @FindBy (xpath= "//div[@id='toast-container']")
	    WebElement Validationmsg;

	    // Notifications settings objects
	    By settingsMenu = By.xpath("//a[normalize-space()='Settings']");
	    By generalMenu = By.xpath("//a[normalize-space()='General']");
	    By notificationsSubmenu = By
	            .xpath("//li[@class='nav-item']//a[contains(@class,'nav-link')][normalize-space()='Notifications']");

	    // Constructor to initialize driver and elements
	    public Provider_settings_page(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.act = new Actions(driver);  // Initialize Actions properly
	    }

	    public void navigateToSettings() {
	        WebElement GeneralMenu = driver.findElement(settingsMenu);
	        act.moveToElement(GeneralMenu).perform();
	        
	        WebElement GeneralElement = driver.findElement(generalMenu);
	        act.moveToElement(GeneralElement).perform();
	        GeneralElement.click();
	       
	        
	    }

	    public void GeneralSettingsTest() {
	        GeneralSubMenu.click();
	        ChangeDurationicon.click();
	        driver.findElement(SelectdurationDD).click();
	        WaitUtil.waitForElementToBeVisible(driver, Select_5Min, 2000);
	        WebElement Select_5MinValue = driver.findElement(Select_5Min);
	        act.scrollToElement(Select_5MinValue).perform();  // Ensure scroll action is performed
	        Select_5MinValue.click();
	        SaveDurationBtn.click();
	        ChangeSignicon.click();
	        WaitUtil.waitForElementToBeClickable(driver, By.xpath("//a[@id='initials-signature-tab']"), 5000);
	        SignFromInitials.click();
	        InputInitials.clear();
	        InputInitials.sendKeys("Sam Doc");
	        WebElement save_sign =  driver.findElement(Save_Signaturebtn);
	        save_sign.click();
	        WaitUtil.waitForElementToBeVisible(driver, By.xpath("//div[@id='toast-container']"), 2000);
	       
	        
	    }
	    
	    public void Notifications_Setting_Update() {
	    	
	    	  driver.findElement(notificationsSubmenu).click();
	    	   for (int i = 1; i <= 8; i++) {
	               WebElement toggle = driver.findElement(By.xpath("(//input[@class='form-check-input'])[" + i + "]"));
	               System.out.println(toggle);
	               toggle.click();
	             
	           }
	    	
	    }
	}