package com.bitrix24.pages;

import com.bitrix24.util.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,5);


    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }


}

