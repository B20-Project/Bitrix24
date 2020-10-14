package com.bitrix24.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XpathUtil {

    private static final String MENU_ITEM = "//a[@title='%s']";
    private static final String HEADER_ITEM = "//div[@id='header-inner']//div[contains(@class,'%s')]";
    private static final String MSG_BAR = "//div[@id='bx-im-bar']//div[contains(@id,'%s')]";

    public static String getMenuXpath() {
        return MENU_ITEM;
    }

    public static String getHeaderXpath() {
        return HEADER_ITEM;
    }

    public static String getMsgBarXpath() {
        return MSG_BAR;
    }

    public static WebElement get_webElement(String xpath, String element){
        return Driver.getDriver().findElement(By.xpath(String.format(xpath,element)));
    }

    public static By get_locator(String xpath, String element){
        return By.xpath(String.format(xpath,element));
    }
}
