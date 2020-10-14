package com.bitrix24.pages;

import com.bitrix24.util.Driver;
import com.bitrix24.util.XpathUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,5);


    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }

    /**
     * click any menu items (left column)
     * @param item
     */
    public void click_menu(String item){
        XpathUtil.get_webElement(XpathUtil.getMenuXpath(),item).click();
    }

    /**
     * click any header items (top)
     * @param item
     */
    public void click_header(String item){
        XpathUtil.get_webElement(XpathUtil.getHeaderXpath(),item).click();
    }

    /**
     * click any msg bar items (right column)
     * @param item
     */
    public void click_msg_bar(String item){
        XpathUtil.get_webElement(XpathUtil.getMsgBarXpath(),item).click();
    }
}

