package com.bitrix24.pages;

import com.bitrix24.util.Driver;
import com.bitrix24.util.XpathUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,5);

    protected String menuItem = "//a[@title='%s']";
    protected String activityStreamTab = "//div[@id='feed-add-post-form-tab']/span[.='%s']";
    protected String headerItem = "//div[@id='header-inner']//div[contains(@class,'%s')]";
    protected String messengerBar = "//div[@id='bx-im-bar']//div[contains(@id,'%s')]";

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }

    /**
     * click any menu items (left column)
     * @param item
     */
    public void click_menu(String item){
        driver.findElement(By.xpath(String.format(menuItem,item))).click();
    }

    /**
     * click any header items (top)
     * @param item
     */
    public void click_header(String item){
        driver.findElement(By.xpath(String.format(headerItem,item))).click();
    }

    /**
     * click any msg bar items (right column)
     * @param item
     */
    public void click_msg_bar(String item){
        driver.findElement(By.xpath(String.format(messengerBar,item))).click();
    }
}

