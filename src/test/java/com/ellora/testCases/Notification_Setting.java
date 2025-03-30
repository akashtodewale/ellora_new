package com.ellora.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ellora.pageObjects.Provider_settings_page;

public class Notification_Setting extends BaseClass {
	
	@Test
	public void Notification_Setting_Test() {
		
        Provider_settings_page settingsPage = new Provider_settings_page(driver);
        settingsPage.navigateToSettings();
        
        settingsPage.GeneralSettingsTest();
        
        settingsPage.Notifications_Setting_Update();
       
     

		
	}

}
