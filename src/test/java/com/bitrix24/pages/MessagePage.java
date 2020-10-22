package com.bitrix24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MessagePage extends AbstractPageBase {

    @FindBy(xpath = "//span[contains(@id,'tab-message')]")
    private WebElement messageTab;

    @FindBy(xpath = "//span[@title='Link']")
    private WebElement linkIcon;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-text')]")
    private WebElement linkText;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-href')]")
    private WebElement linkUrl;

    @FindBy(xpath = "//div[contains(@class,'link-dialog')]//input[@value = 'Save']")
    private WebElement linkSaveButton;

    @FindBy(xpath = "//div[contains(@class,'video-dialog')]//input[@value = 'Save']")
    private WebElement videoSaveButton;




    public WebElement getLinkSaveButton() {
        return linkSaveButton;
    }

    public void click_on_message_tab() {
        messageTab.click();
    }

    public void click_on_link_icon(){
        linkIcon.click();
    }

    public void enter_link_text(String linktext){
        linkText.sendKeys(linktext);
    }

    public void enter_link_url(String linkurl){
        linkUrl.sendKeys(linkurl);
    }








    public void click_on_topic_icon() {
        String TopicIconxptah = "//span[@title='Topic']";
        driver.findElement(By.xpath(TopicIconxptah)).click();
    }

    public boolean is_post_title_displayed() {
        return driver.findElement(By.id("POST_TITLE")).isDisplayed();
    }

    //=================================================================================================================
    public void click_on_Task_tab() {
        String taskTabXpath = "//span[contains(@id,'tab-tasks')]";
        driver.findElement(By.xpath(taskTabXpath)).click();
    }

}
