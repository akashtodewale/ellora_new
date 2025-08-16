package com.ellora.testCases;


import com.ellora.pageObjects.DocumentUploadPage;
import com.ellora.testCases.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class DocumentStepDefinitions extends BaseClass {

    WebDriver driver = getDriver(); // Use this if BaseClass provides WebDriver
    DocumentUploadPage docPage = new DocumentUploadPage();

    @Given("I am logged into the application")
    public void i_am_logged_into_the_application() {
		loginByKey("doctor");
        // Assume login is handled in hooks or globally
        assertTrue(driver != null);
    }

    @When("I navigate to the Clients tab")
    public void i_navigate_to_the_clients_tab() {
        driver.findElement(DocumentUploadPage.CLIENTS_TAB).click();
    }

    @When("I search for a client with first name {string} and last name {string}")
    public void i_search_for_a_client_with_first_name_and_last_name(String firstName, String lastName) {
        driver.findElement(DocumentUploadPage.SEARCH_FIRST_NAME).sendKeys(firstName);
        driver.findElement(DocumentUploadPage.SEARCH_LAST_NAME).sendKeys(lastName);
        driver.findElement(DocumentUploadPage.SEARCH_BUTTON).click();
    }

    @When("I open the chart of the client")
    public void i_open_the_chart_of_the_client() {
        driver.findElement(DocumentUploadPage.CHART_ICON).click();
    }

    @When("I navigate to the Documents tab")
    public void i_navigate_to_the_documents_tab() {
        driver.findElement(DocumentUploadPage.DOCUMENTS_TAB).click();
    }

    @When("I click on the Add Document button")
    public void i_click_on_the_add_document_button() {
        driver.findElement(DocumentUploadPage.ADD_DOCUMENT_BUTTON).click();
    }

    @When("I enter the document name {string}")
    public void i_enter_the_document_name(String docName) {
        driver.findElement(DocumentUploadPage.DOCUMENT_NAME).sendKeys(docName);
    }

    @When("I upload a screenshot as the document file")
    public void i_upload_a_screenshot_as_the_document_file() {
        // Replace path with valid file path on your machine
        String filePath = System.getProperty("user.dir") + "/testdata/testdoc.png";
        driver.findElement(DocumentUploadPage.DOCUMENT_FILE).sendKeys(filePath);
    }

    @When("I click on the Save Document button")
    public void i_click_on_the_save_document_button() {
        driver.findElement(DocumentUploadPage.SAVE_DOCUMENT_BUTTON).click();
    }

    @Then("I should see a success message confirming the document was saved")
    public void i_should_see_a_success_message_confirming_the_document_was_saved() {
        assertTrue(driver.findElement(DocumentUploadPage.SUCCESS_MESSAGE).isDisplayed());
    }

    @When("I download the uploaded document")
    public void i_download_the_uploaded_document() {
        driver.findElement(DocumentUploadPage.DOWNLOAD_DOCUMENT).click();
    }

    @When("I click on the Send Email button")
    public void i_click_on_the_send_email_button() {
        driver.findElement(DocumentUploadPage.SEND_EMAIL_BUTTON).click();
    }

    @Then("I should see email and name fields pre-filled or fill them manually")
    public void i_should_see_email_and_name_fields_pre_filled_or_fill_them_manually() {
        driver.findElement(DocumentUploadPage.EMAIL_INPUT).clear();
        driver.findElement(DocumentUploadPage.EMAIL_INPUT).sendKeys("akash.todewale@bostonbyte.com");

        driver.findElement(DocumentUploadPage.NAME_INPUT).clear();
        driver.findElement(DocumentUploadPage.NAME_INPUT).sendKeys("Rockey");
    }

    @When("I submit the email form")
    public void i_submit_the_email_form() {
        driver.findElement(DocumentUploadPage.SEND_MAIL_SUBMIT).click();
    }
    
}