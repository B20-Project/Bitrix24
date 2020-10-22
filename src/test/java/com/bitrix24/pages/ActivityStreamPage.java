package com.bitrix24.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityStreamPage extends AbstractPageBase {

    @FindBy(xpath = "//span[.='Message']")
    private WebElement message;

    @FindBy(xpath = "//span[@title='Quote text']")
    private WebElement message_quote;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    private WebElement enter_message_quote;

    @FindBy(xpath = "//span[@id='bx-b-mention-blogPostForm']")
    private WebElement message_addMention;

    @FindBy (xpath = "//a[ starts-with(@id,'destDepartmentTab')]")
    private WebElement message_addMention_DepartmentTab;

    @FindBy (xpath = "//a[@href='#U514']")
    private WebElement message_addMention_DepartmentTab_peron;

    @FindBy(xpath = "//div[@id='feed-add-post-destination-container']")
    public WebElement to;

    public void click_message(){
        message.click();
    }

    public void click_message_quote(){
        message_quote.click();
    }

    public  String getText_message_quote(){
        return enter_message_quote.getText();
    }

    public void enter_message_quote(String Enter_quote){
        enter_message_quote.sendKeys(Enter_quote);
    }

    public void click_message_addMention(){
        message_addMention.click();
    }

    public void click_message_addMention_DepartmentTab(){
        message_addMention_DepartmentTab.click();
    }

    public void click_message_addMention_DepartmentTab_peron(){
        message_addMention_DepartmentTab_peron.click();
    }

    public String get_message_addMention_DepartmentTab_peron(){
        return message_addMention_DepartmentTab_peron.getText();
    }
}
