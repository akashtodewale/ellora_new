package com.ellora.pageObjects;

import org.openqa.selenium.By;

public class BookAudioAppointmentPage {


    public static final By NEW_APPOINTMENT_BUTTON = By.xpath("//a[@id='chart_new_appointment_btn']");
    public static final By IN_PERSON_BUTTON = By.xpath("//label[normalize-space()='In Person']");
    public static final By AM_PM = By.xpath("//div[contains(text(),'AM')]");
    public static final By SELECT_PM = By.xpath(" //span[normalize-space()='PM']");
    public static final By APPT_REASON_INPUT = By.xpath("//textarea[@id='reason']");
    public static final By SAVE_BUTTON = By.xpath("//button[@id='appointment_submit']");
    public static final By CONTINUE_BUTTON = By.xpath("//button[normalize-space()='Continue']");
    public static final By SUCCESS_MESSAGE = By.xpath("//div[contains(text(),'Appointment Session')]");

}