package com.bitrix24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActivityStreamPage extends AbstractPageBase{

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-wrap']")
    private WebElement editorTextBar;

    @FindBy(xpath = "//span[@id='lhe_button_editor_blogPostForm']")
    private WebElement visualEditorIcon;

    public void click_tab_under_activity_stream(String module){
        String xpath = String.format("//div[@id='feed-add-post-form-tab']/span[.='%s']", module);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void click_icon_under_activity_stream(){
        wait.until(ExpectedConditions.elementToBeClickable(visualEditorIcon)).click();
    }

    public boolean editorTextBar_is_displayed(){
        return editorTextBar.isDisplayed();
    }
}
