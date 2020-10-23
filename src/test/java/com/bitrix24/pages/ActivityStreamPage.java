package com.bitrix24.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;


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

    protected String activityStreamTab = "//div[@id='feed-add-post-form-tab']/span[.='%s']";
    protected String msgTabPostBtn = "//div[contains(@class,'form-wrap')]//span[contains(@title,'%s')]";
    protected String localFileBox = "//input[@name='bxu_files[]']";
    protected String msgTabAttachedFile = "//span[@title='Click to insert file']";
    protected String bitrixRemoteDrive = "//div[@style='display: block;']//span[.='Select document from Bitrix24']";
    protected String addContact = "//a[.='Add more']";
    protected String contactPopupFormat = "//div[@id='BXSocNetLogDestination']//a[contains(.,'%s')]";
    protected String contactPopupClose = "//span[@class='popup-window-close-icon']";
    protected String selectedContact = "//span[@id='feed-add-post-destination-item']";
    public void clickActivityStreamTab(String tab){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(activityStreamTab,tab)))).click();
    }

    public void clickPostBtn(String btn){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(msgTabPostBtn,btn)))).click();
    }

    public void uploadLocalFile(String fileAddress){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(localFileBox))).sendKeys(fileAddress);
    }

    public String getTextFromAttachedFile(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(msgTabAttachedFile))).getText();
    }

    public void openBitrixRemoteDrive(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bitrixRemoteDrive))).click();
    }

    public void uploadFromCompanyDrive(String file){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Sales and marketing']")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[.='Sales and marketing']"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Sales and marketing']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Quotes']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Quotes']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//a[.='%s']",file))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[.='%s']",file)))).click();
        driver.findElement(By.xpath("//span[.='Select document']")).click();
    }

    public void addEmployeeByTab(String employee, String tab){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addContact))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(contactPopupFormat,"All employees")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(contactPopupFormat,tab)))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(contactPopupFormat,employee)))).click();
        driver.findElement(By.xpath(contactPopupClose)).click();
    }

    public String getTextFromSelectedEmployee(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(selectedContact)))).getText();
    }

}
