package com.ellora.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickApptObjects {
    private WebDriver driver;

    // Locators as By elements (Recommended for better flexibility)
    private By usersMenu = By.xpath("//a[normalize-space()='Clients']");
    private By quickApptIcon = By.xpath("//a[@title='Schedule Appointment' or @class='mr-3']/em");
    public By confirmButton = By.id("book_quick_app_btn");
    private By fNameInput = By.id("user_fname");
    private By inPersonApptButton = By.id("apt-type-3");

    // Optional/Commented locators if you need to use them later
     public By confirmModal = By.className("CorfirmModal");
    // private By buttonContinue = By.className("swal-button swal-button--confirm");

    // Constructor
    public QuickApptObjects(WebDriver driver) {
        this.driver = driver;
    }

    // Getter methods (Recommended approach)
    public WebElement getUsersMenu() {
        return driver.findElement(usersMenu);
    }

    public WebElement getQuickApptIcon() {
        return driver.findElement(quickApptIcon);
    }

    public WebElement getConfirmButton() {
        return driver.findElement(confirmButton);
    }

    public WebElement getFNameInput() {
        return driver.findElement(fNameInput);
    }

    public WebElement getInPersonApptButton() {
        return driver.findElement(inPersonApptButton);
    }

    // Optional getter methods if you uncomment above locators
     public WebElement getConfirmModal() {
       return driver.findElement(confirmModal);
     }

    // public WebElement getButtonContinue() {
    //     return driver.findElement(buttonContinue);
    // }

}