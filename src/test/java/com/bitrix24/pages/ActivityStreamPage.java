package com.bitrix24.pages;

import com.bitrix24.util.BrowserUtils;
import com.bitrix24.util.Driver;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.sun.org.apache.bcel.internal.generic.DREM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.XMLFormatter;

public class ActivityStreamPage extends AbstractPageBase {
    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    private WebElement enter_message_quote;

    @FindBy (xpath = "//a[ starts-with(@id,'destDepartmentTab')]")
    private WebElement message_addMention_DepartmentTab;

    @FindBy (xpath = "//div[@id='bx-lm-category-relation-129']/a[@href='#U514']")
    private WebElement message_addMention_DepartmentTab_peron;

    @FindBy(xpath = "//div[@id='feed-add-post-destination-container']")
    public WebElement to;

    @FindBy(xpath = "//input[@id='feed-add-post-destination-input']")
    private WebElement toInput;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-wrap']")
    private WebElement editorTextBar;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-text')]")
    private WebElement linkText;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-href')]")
    private WebElement linkUrl;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-source')]")
    private WebElement videoUrl;

    @FindBy(xpath = "//input[@id='POST_TITLE']")
    private WebElement topicInputBox;

    @FindBy(xpath = "//span[@class='feed-add-post-form-but-cnt feed-add-videomessage']")
    private WebElement recordVideoIcon;

    @FindBy(xpath = "//div[@id='popup-window-content-bx-popup-videomessage-popup']")
    private WebElement deviceAccessMessage;

    @FindBy(xpath = "/div[@class='feed-add-close-icon']")
    private WebElement closeButton;

    @FindBy(xpath = "//a[.='My Groups']")
    private WebElement to_myGroup;

    @FindBy(xpath = "//a[contains(@id,'group_SG4')]")
    private WebElement to_myGroup_soccerTeam;

    @FindBy(xpath = "//a[.='Employees and departments']")
    private WebElement to_employeesAndDepartments;

    @FindBy(xpath = "//div[@class='bx-finder-company-department']//div[.='IT ']/..")
    private WebElement to_employeesAndDepartments_iT;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-check-arrow']")
    private WebElement to_employeesAndDepartments_iT_allBox;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']" )
    private WebElement sendButton;

    @FindBy(xpath = "//a[.='marketing28@cybertekschool.com']/..//span//a")
    private List<WebElement> verify;

    protected String activityStreamTab = "//div[@id='feed-add-post-form-tab']/span[.='%s']";
    protected String msgTabPostBtn = "//div[@id='feed-add-post-content-message']//span[@title='%s']";
    protected String localFileBox = "//input[@name='bxu_files[]']";
    protected String msgTabAttachedFile = "//span[@title='Click to insert file']";
    protected String bitrixRemoteDrive = "//div[@style='display: block;']//span[.='Select document from Bitrix24']";
    protected String addContact = "//a[.='Add more']";
    protected String contactPopupFormat = "//div[@id='BXSocNetLogDestination']//a[contains(.,'%s')]";
    protected String contactPopupClose = "//span[@class='popup-window-close-icon']";
    protected String selectedContact = "//span[@id='feed-add-post-destination-item']";
    protected String saveButton = "//div[contains(@class,'%s-dialog')]//input[@value = 'Save']";


    public  String getText_message_quote(){
        return enter_message_quote.getText();
    }

    public void enter_message_quote(String Enter_quote){
        enter_message_quote.sendKeys(Enter_quote);
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

    public boolean editorTextBar_is_displayed(){
        return editorTextBar.isDisplayed();
    }

    //inserted extra wait time here
    public void clickActivityStreamTab(String tab){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(activityStreamTab,tab)))).click();
    }

    /**
     *
     * @param btn:Upload files, Link, Insert video, Quote text, Add mention, Visual editor, Topic
     */
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

    public void enter_link_text(String linktext){ linkText.sendKeys(linktext); }
    public void enter_link_url(String linkurl){ linkUrl.sendKeys(linkurl); }

    public boolean is_new_created_link_displayed(String text){
        driver.switchTo().frame(0);
        boolean result = driver.findElement(By.linkText(text)).isDisplayed();
        driver.switchTo().parentFrame();
        return result;
    }

    public void enter_video_url(String url){ videoUrl.sendKeys(url); }

    /**
     *
     * @param type link, video
     */
    public void click_on_save_button(String type){
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(String.format(saveButton,type))).click();
    }

    public void click_recordVideo(){
        wait.until(ExpectedConditions.elementToBeClickable(recordVideoIcon)).click();
    }

    public String deviceAccessPopUpWindow(){
        return deviceAccessMessage.getText();
    }

    public boolean topicInputBox_is_displayed(){
        return topicInputBox.isDisplayed();
    }

    public boolean isAlertPresent(){
        boolean foundAlert = false;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
            System.out.println("isAlertPresent : " +foundAlert);
        } catch (TimeoutException eTO) {
            foundAlert = false;
            System.out.println("isAlertPresent : " +foundAlert);
        }
        return foundAlert;
    }

    public void close_topic_input_box(){
        if(topicInputBox.isDisplayed()){
           closeButton.click();
        }

    }

    public void click_toInputBox(){
        BrowserUtils.clickOnElement(to);
    }

    public void click_to_myGroup(){
        BrowserUtils.clickOnElement(to_myGroup);
    }

    public void click_to_myGroup_soccerTram(){
        BrowserUtils.wait(2);
       to_myGroup_soccerTeam.click();
    }

    public void click_to_employeesAndDepartments(){
        BrowserUtils.clickOnElement(to_employeesAndDepartments);
    }

    public void click_to_employeesAndDepartments_iT(){
        BrowserUtils.clickOnElement(to_employeesAndDepartments_iT);
    }

    public void click_to_employeesAndDepartments_iT_allBox(){
        BrowserUtils.clickOnElement(to_employeesAndDepartments_iT_allBox);
    }

    public void sendKey_To(String email){
        BrowserUtils.clickOnElement(to);
        toInput.sendKeys(Keys.BACK_SPACE,email);
        BrowserUtils.wait(3);
        toInput.sendKeys(Keys.ENTER);
        toInput.click();
    }

    public void click_sendButton(){
        BrowserUtils.scrollTo(sendButton);
        Driver.getDriver().switchTo().frame(0);
        Driver.getDriver().findElement(By.xpath("//body")).click();
        Driver.getDriver().findElement(By.xpath("//body")).sendKeys("test");
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.clickOnElement(sendButton);
    }

    public String verify (String text){
        BrowserUtils.wait(3);
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='marketing28@cybertekschool.com']/..//span//a[.='"+text+"']"));
        return element.getText();


    }
}
