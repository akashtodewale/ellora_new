package com.ellora.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.ellora.Utilities.WaitUtil;
import com.ellora.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	    public static WebDriver driver;
	    public Properties prop;
	    
	    public BaseClass() {
	    	
	    	prop = new Properties();
	    	File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\config\\config.properties");
	    	FileInputStream Fis;
			try {
				Fis = new FileInputStream(propFile);
				prop.load(Fis); 	
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }

	    @BeforeMethod
	    public void setUp() {
	        //String browser = System.getProperty("browser", "Chrome"); // Default browser is Chrome
	        driver = initializeDriver(prop.getProperty("browser"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.get(prop.getProperty("url"));
	        LoginPage loginPage = new LoginPage(driver);

	        // Perform login steps
	        loginPage.enterUsername(prop.getProperty("DocUsername"));//taken Username from config.properties file.
	        loginPage.enterPassword(prop.getProperty("DocPassword")); 
	        loginPage.clickLoginButton();

	        //Add an assertion to verify login success
	       String expectedUrl = prop.getProperty("url") + "appointment/upcoming"; 
	       String actualUrl = driver.getCurrentUrl();
	      // Assert.assertEquals(actualUrl, expectedUrl, "Login failed or did not redirected to the dashboard.");
//	       
	    }

	    private WebElement waitForElementToBeVisible(By xpath) {
			// TODO Auto-generated method stub
			return null;
		}

		public static WebDriver initializeDriver(String browser) {
	        switch (browser.toLowerCase()) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                return new ChromeDriver();
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                return new FirefoxDriver();
	            case "edge":
	                WebDriverManager.edgedriver().setup();
	                return new EdgeDriver();
	            default:
	                throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }
	    }
		  
		public static WebDriver getDriver() {
		        return driver;
		    }
	  
    @AfterMethod
	    public void tearDown() {
        if (driver != null) {
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	}
