package com.bitrix24.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {

    @FindBy(className = "//div[@title='Show notifications']")
    private WebElement notificationIcon;

    @FindBy(className = "//div[@class='bx-desktop-appearance-avatar']")
    private WebElement notification_contact_you;

    @FindBy(className = "//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im']")
    private WebElement notification_message;

    @FindBy(className = "//div[@class='bx-desktop-tab bx-desktop-tab-notify']")
    private WebElement notification_notifications;

    @FindBy(className = "//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-config']")
    private WebElement notification_setting;

    @FindBy(className = "//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im-lf']")
    private WebElement notification_clones;




}
