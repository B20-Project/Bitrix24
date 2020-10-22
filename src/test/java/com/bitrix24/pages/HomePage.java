package com.bitrix24.pages;

import com.bitrix24.util.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='bx-im-informer bx-im-border-b']")
    public  WebElement notificationIcon;

    @FindBy(xpath = "//div[@class = 'bx-im-search bx-im-border-b']")
    public WebElement search;

    @FindBy(xpath = "//div[@class='bx-im-scroll-wrap']/span")
    public WebElement listOfCurrentContacted;

    @FindBy(xpath = "//div[@class='bx-im-bottom-block']")
    public WebElement bottomBlock;

    @FindBy(xpath = "//div[@class='bx-desktop-appearance']")
    public WebElement sideWindowPopUp;

    @FindBy(xpath = "//div[@class='bx-desktop-appearance-avatar']")
    private WebElement sidePopUpWindow_contact_you;

    @FindBy(xpath = "//div[@class='bx-desktop-appearance-avatar']")
    public WebElement sidePopUpWindow_Verify_dialogMessenger;

    @FindBy(xpath = "//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im']")
    private WebElement sidePopUpWindow_message;

    @FindBy(xpath = "//div[@class='bx-desktop-tab bx-desktop-tab-notify']")
    private WebElement sidePopUpWindow_notifications;

    @FindBy(xpath = "//div[@class='bx-messenger-box-extra']")
    public WebElement sidePopUpWindow_Verify_dialogNotifications;

    @FindBy(xpath = "//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-config']")
    private WebElement sidePopUpWindow_setting;

    @FindBy(xpath = "//div[@id='bx-messenger-popup-settings']")
    public WebElement sidePopUpWindow_Verify_popupSettings;

    @FindBy(xpath = "//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im-lf']")
    private WebElement sidePopUpWindow_clones;



    public void click_sidePopUpWindow_contact_you(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        notificationIcon.click();
        wait.until(ExpectedConditions.visibilityOf(sideWindowPopUp));
        sidePopUpWindow_contact_you.click();
    }

    public void click_sidePopUpWindow_message(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        notificationIcon.click();
        wait.until(ExpectedConditions.visibilityOf(sideWindowPopUp));
        sidePopUpWindow_message.click();
    }

    public void click_sidePopUpWindow_notifications(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        search.click();
        wait.until(ExpectedConditions.visibilityOf(sideWindowPopUp));
        sidePopUpWindow_notifications.click();
    }

    public void click_sidePopUpWindow_setting(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        notificationIcon.click();
        wait.until(ExpectedConditions.visibilityOf(sideWindowPopUp));
        sidePopUpWindow_setting.click();
    }

    public void click_sidePopUpWindow_clones(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        notificationIcon.click();
        wait.until(ExpectedConditions.visibilityOf(sideWindowPopUp));
        sidePopUpWindow_clones.click();
    }






}
