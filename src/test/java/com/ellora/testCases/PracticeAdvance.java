package com.ellora.testCases;
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.*;

	import java.io.File;
	import java.io.FileInputStream;
	import java.time.Duration;
	import java.util.List;

	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class PracticeAdvance extends BaseClass{

	    WebDriver driver;
	    WebDriverWait wait;
	    String baseUrl = "https://ohsuat.ellorasystems.com/";

	    
	    


	    @Test
	    public void updateDoctorSchedule() throws Exception {
	    	loginByKey("admin");

	        FileInputStream fis = new FileInputStream(new File("/C:/Users/Dell/Downloads/updateDrSettingData.xlsx"));
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(0);

	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            String firstName = row.getCell(0).getStringCellValue();
	            String lastName = row.getCell(1).getStringCellValue();

	            filterDoctorByName(firstName, lastName);
	            impersonateDoctor();

	            openWorkboardMenu();
	            enableAllDayCheckboxes();
	            removeReadOnlyFromInputs();
	            updateWorkHours();

	            saveSchedule();
	            leaveImpersonation();
	        }

	        workbook.close();
	        fis.close();
	    }

	 

	    private void filterDoctorByName(String firstName, String lastName) {
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname-filter"))).sendKeys(firstName);
	        driver.findElement(By.id("lastname-filter")).sendKeys(lastName);
	        driver.findElement(By.id("submit-btn")).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-icon"))).click();
	    }

	    private void impersonateDoctor() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Impersonate')]"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("Bb1234!@#$");
	        driver.findElement(By.xpath("//button[contains(text(),'Validate')]")).click();
	    }

	    private void openWorkboardMenu() {
	        WebElement settingsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Settings']")));
	        new Actions(driver).moveToElement(settingsMenu).perform();
	        driver.findElement(By.xpath("//a[text()='Workboard']")).click();
	    }

	    private void enableAllDayCheckboxes() {
	        for (int day = 1; day <= 6; day++) {
	            for (int slot = 1; slot <= 3; slot++) {
	                try {
	                    WebElement checkbox = driver.findElement(By.id("checkbox_" + day + "_" + slot));
	                    if (!checkbox.isSelected()) {
	                        checkbox.click();
	                    }
	                } catch (Exception e) {
	                    System.out.println("Checkbox not found: " + day + "_" + slot);
	                }
	            }
	        }
	    }

	    private void removeReadOnlyFromInputs() {
	        List<WebElement> inputs = driver.findElements(By.tagName("input"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        for (WebElement input : inputs) {
	            js.executeScript("arguments[0].removeAttribute('readonly')", input);
	        }
	    }

	    private void updateWorkHours() {
	        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	        for (int i = 0; i < weekdays.length; i++) {
	            String day = weekdays[i];
	            int index = i + 1;

	            // Clear and set from time
	            driver.findElement(By.id("input_" + day + "_hour_from_" + index)).clear();
	            driver.findElement(By.id("hour-dd")).sendKeys("08");
	            driver.findElement(By.id("min-dd")).sendKeys("00");

	            // Clear and set to time
	            driver.findElement(By.id("input_" + day + "_hour_to_" + index)).clear();
	            driver.findElement(By.id("hour-dd")).sendKeys("07");
	            driver.findElement(By.id("min-dd")).sendKeys("00");
	        }
	    }

	    private void saveSchedule() {
	        driver.findElement(By.xpath("//button[contains(text(),'Save Schedule')]")).click();
	    }

	    private void leaveImpersonation() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".doctor-initials"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leave Impersonation']"))).click();
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}


