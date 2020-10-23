package com.bitrix24.pages;

import com.bitrix24.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {
    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,10);

    protected String menuItem = "//a[@title='%s']";
    protected String headerItem = "//div[@id='header-inner']//div[contains(@class,'%s')]";
    protected String messengerBar = "//div[@id='bx-im-bar']//div[contains(@id,'%s')]";

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

    public void click_leftMenu_tab(String tabName){
        String xpath = String.format("//a[contains(@title,'%s')]", tabName );
        driver.findElement(By.xpath(xpath)).click();
    }
}

