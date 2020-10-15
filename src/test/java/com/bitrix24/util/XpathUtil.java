package com.bitrix24.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XpathUtil {

    public static final String GEN_MENU_ITEM_FORMAT = "//a[@title='%s']";
    public static final String GEN_HEADER_ITEM_FORMAT = "//div[@id='header-inner']//div[contains(@class,'%s')]";
    public static final String GEN_MSG_BAR_FORMAT = "//div[@id='bx-im-bar']//div[contains(@id,'%s')]";

    /**
     * return webElement with no format
     * @param xpath
     * @return
     */
    public static WebElement get_webElement(String xpath){
        return Driver.getDriver().findElement(get_locator(xpath));
    }

    /**
     * return webElement with single format
     * @param format
     * @param element
     * @return
     */
    public static WebElement get_webElement(String format, String element){
        return Driver.getDriver().findElement(get_locator(format,element));
    }

    /**
     * return webElement with multiple format
     * @param format
     * @param elementA
     * @param elementB
     * @return
     */
    public static WebElement get_webElement(String format, String elementA, String elementB){
        return Driver.getDriver().findElement(get_locator(format,elementA,elementB));
    }

    /**
     * return locator with no format
     * @param xpath
     * @return
     */
    public static By get_locator(String xpath){
        return By.xpath(xpath);
    }

    /**
     * return locator with single format
     * @param format
     * @param element
     * @return
     */
    public static By get_locator(String format, String element){
        return By.xpath(get_xpath(format,element));
    }

    /**
     * return locator with multiple format
     * @param format
     * @param elementA
     * @param elementB
     * @return
     */
    public static By get_locator(String format, String elementA, String elementB){
        return By.xpath(get_xpath(format,elementA,elementB));
    }

    /**
     * return xpath with single format
     * @param format
     * @param element
     * @return
     */
    public static String get_xpath(String format, String element){
        return String.format(format,element);
    }

    /**
     * return xpath with multiple format
     * @param format
     * @param elementA
     * @param elementB
     * @return
     */
    public static String get_xpath(String format, String elementA, String elementB){
        return String.format(format,elementA,elementB);
    }
}