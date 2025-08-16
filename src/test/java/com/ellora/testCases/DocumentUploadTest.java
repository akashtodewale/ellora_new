package com.ellora.testCases;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ellora.Utilities.*;
import com.ellora.pageObjects.DocumentUploadPage;



public class DocumentUploadTest extends BaseClass{

    @Test
    public void documentUploadTest()  {
		loginByKey("doctor");

        // Navigate to Clients
        driver.findElement(DocumentUploadPage.CLIENTS_TAB).click();

        // Search for Client
        driver.findElement(DocumentUploadPage.SEARCH_FIRST_NAME).sendKeys("Mrunal");
        driver.findElement(DocumentUploadPage.SEARCH_LAST_NAME).sendKeys("Patil");
        driver.findElement(DocumentUploadPage.SEARCH_BUTTON).click();

        // Screenshot Utility
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, "client_search_result");

        // Open Chart of patient
        driver.findElement(DocumentUploadPage.CHART_ICON).click();

        // Navigate to Documents
        driver.findElement(DocumentUploadPage.DOCUMENTS_TAB).click();

        // Add Document
        driver.findElement(DocumentUploadPage.ADD_DOCUMENT_BUTTON).click();
        driver.findElement(DocumentUploadPage.DOCUMENT_NAME).sendKeys("Test_document");

        // Upload File
        WebElement fileUpload = driver.findElement(DocumentUploadPage.DOCUMENT_FILE);
        fileUpload.sendKeys(screenshotPath);

        // Save Document
        driver.findElement(DocumentUploadPage.SAVE_DOCUMENT_BUTTON).click();

        // Verify Document Save Message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement successMessage = driver.findElement(DocumentUploadPage.SUCCESS_MESSAGE);
        Assert.assertTrue(successMessage.isDisplayed(), "Document save failed!");

        // Download document
        driver.findElement(DocumentUploadPage.DOWNLOAD_DOCUMENT).click();

        // Send Email
        driver.findElement(DocumentUploadPage.SEND_EMAIL_BUTTON).click();
        WaitUtil.waitForElementToBeVisible(driver, DocumentUploadPage.EMAIL_INPUT, 1);

        WebElement inputEmail = driver.findElement(DocumentUploadPage.EMAIL_INPUT);
        WebElement inputName = driver.findElement(DocumentUploadPage.NAME_INPUT);
        String Name = inputName.getText();
		String EmailId = inputEmail.getText();

        if (Name!="" || EmailId!="" ) {
            LogUtil.info("Email or name are present.");
            driver.findElement(DocumentUploadPage.SEND_MAIL_SUBMIT).click();
        } else {
            WaitUtil.waitForElementToBeClickable(driver,DocumentUploadPage.EMAIL_INPUT, 2);
            //send keys method to enter email and name
            inputEmail.sendKeys("akash.todewale@bostonbyte.com");
            inputName.sendKeys("Rockey");
            driver.findElement(DocumentUploadPage.SEND_MAIL_SUBMIT).click();
            LogUtil.info("Email is sent on my mail");
        }
        
        Assert.assertTrue(VerifyElement.verifyElementVisible(driver, DocumentUploadPage.EMAIL_SUCCESS_MESSAGE));

        // Edit Document
        driver.findElement(DocumentUploadPage.EDIT_DOCUMENT).click();
        driver.findElement(DocumentUploadPage.DOCUMENT_NAME).sendKeys("Document test");
        driver.findElement(DocumentUploadPage.SAVE_EDIT_BUTTON).click();
        Assert.assertTrue(VerifyElement.verifyElementVisible(driver, DocumentUploadPage.EDIT_SUCCESS_MESSAGE));

        // Delete Document
        driver.findElement(DocumentUploadPage.DELETE_DOCUMENT).click();
        driver.findElement(DocumentUploadPage.CONFIRM_DELETE).click();
        Assert.assertTrue(VerifyElement.verifyElementVisible(driver, DocumentUploadPage.DELETE_SUCCESS_MESSAGE));
    }
}
