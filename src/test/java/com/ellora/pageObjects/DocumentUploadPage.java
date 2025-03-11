package com.ellora.pageObjects;

import org.openqa.selenium.By;

public class DocumentUploadPage {
	
	    // Navigation
	    public static By CLIENTS_TAB = By.linkText("Clients");
	    public static final By DOCUMENTS_TAB = By.linkText("Documents");
	    public static final By ADD_DOCUMENT_BUTTON = By.linkText("Add Document");
	    
	    // Search Client
	    public static final By SEARCH_FIRST_NAME = By.id("search_first_name");
	    public static final By SEARCH_LAST_NAME = By.id("search_last_name");
	    public static final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");

	    // Clipboard
	    public static final By CHART_ICON = By.className("bi-clipboard-data");

	    // Document Upload
	    public static final By DOCUMENT_NAME = By.id("document_name");
	    public static final By DOCUMENT_FILE = By.id("document_file");
	    public static final By SAVE_DOCUMENT_BUTTON = By.xpath("(//button[@class='btn btn-primary'])[2]");
	    public static final By SUCCESS_MESSAGE = By.xpath("//div[normalize-space()='Document saved successfully']");
	    
	    // Download & Send Email
	    public static final By DOWNLOAD_DOCUMENT = By.xpath("(//a[@title='Download'])[1]");
	    public static final By SEND_EMAIL_BUTTON = By.xpath("(//a[@title='Send Mail'])[1]");
	    public static final By EMAIL_INPUT = By.id("email_address");
	    public static final By NAME_INPUT = By.id("salutation_name");
	    public static final By SEND_MAIL_SUBMIT = By.xpath("//button[normalize-space()='Send Mail']");
	    public static final By EMAIL_SUCCESS_MESSAGE = By.xpath("//div[normalize-space()='Client document sent successfully']");
	    
	    // Edit Document
	    public static final By EDIT_DOCUMENT = By.xpath("(//a[@title='Edit Document'])[1]");
	    public static final By SAVE_EDIT_BUTTON = By.xpath("//div[@class='d-grid d-md-block']/button[normalize-space()='Save']");
	    public static final By EDIT_SUCCESS_MESSAGE = By.xpath("//div[normalize-space()='Document updated successfully']");
	    
	    // Delete Document
	    public static final By DELETE_DOCUMENT = By.xpath("(//a[@data-bs-title='Delete Document'])[1]");
	    public static final By CONFIRM_DELETE = By.xpath("//button[normalize-space()='Continue']");
	    public static final By DELETE_SUCCESS_MESSAGE = By.xpath("//div[normalize-space()='Document deleted successfully']");
	}

