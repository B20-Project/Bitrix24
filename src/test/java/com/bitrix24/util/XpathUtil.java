package com.bitrix24.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XpathUtil {

    public static final String MENU_ITEM = "//a[@title='%s']";
    public static final String HEADER_ITEM = "//div[@id='header-inner']//div[contains(@class,'%s')]";
    public static final String MSG_BAR = "//div[@id='bx-im-bar']//div[contains(@id,'%s')]";

    /**
     * format xpath and return specific webelement
     * @param xpath
     * @param element
     * @return webElement
     */
    public static WebElement get_webElement(String xpath, String element){
        return Driver.getDriver().findElement(By.xpath(String.format(xpath,element)));
    }

    /**
     * format xpath and return specific element locator
     * @param xpath
     * @param element
     * @return locator
     */
    public static By get_locator(String xpath, String element){
        return By.xpath(String.format(xpath,element));
    }
}