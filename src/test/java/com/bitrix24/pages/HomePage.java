package com.bitrix24.pages;

import com.bitrix24.util.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    /*
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

 */



}
