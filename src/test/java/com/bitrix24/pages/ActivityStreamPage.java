package com.bitrix24.pages;

import static com.bitrix24.util.BrowserUtils.*;

import com.bitrix24.util.BrowserUtils;
import com.bitrix24.util.Driver;
import com.sun.org.apache.xerces.internal.util.DraconianErrorHandler;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActivityStreamPage extends AbstractPageBase {
    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    private WebElement enter_message_quote;

    @FindBy (xpath = "//a[ starts-with(@id,'destDepartmentTab')]")
    private WebElement message_addMention_DepartmentTab;

    @FindBy (xpath = "//div[@id='bx-lm-category-relation-129']/a[@href='#U514']")
    private WebElement message_addMention_DepartmentTab_peron;

    @FindBy(xpath = "//div[@id='feed-add-post-destination-container']")
    public WebElement to;

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
    private WebElement topicInputBoxCloseButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='task-additional-alt-more']")
    private WebElement task_more;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-flag task-edit-flag-replication']")
    private WebElement task_more_repeatTaskCheckBox;

    @FindBy(xpath = "//input[@class='js-id-replication-every-day task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_day;

    @FindBy(xpath = "//select[@class='js-id-replication-day-type task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_dayTypeSelector;

    @FindBy(xpath = "//input[@class='js-id-replication-daily-month-interval task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_dayMo;

    @FindBy(xpath = "//input[@class='js-id-replication-every-week task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_weekEnter;

    @FindBy(xpath = "//input[@class='js-id-replication-monthly-day-num task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_monthOfDayEnter;

    @FindBy(xpath = "//input[@class='js-id-replication-monthly-month-num-1 task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_monthOfmonthEnter;

    @FindBy(xpath = "//div[@class='js-id-replication-panel-monthly task-replication-params']//div[2]//input[@class='js-id-replication-monthly-type task-options-radio']")
    private WebElement task_more_repeatTask_repeatTerm_month_secondEveryCheckBox;

    @FindBy(xpath = "//select[@class='js-id-replication-monthly-week-day-num task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_month_secondEvery_firstSelector;

    @FindBy(xpath = "//select[@class='js-id-replication-monthly-week-day task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_month_secondEvery_secondSelector;

    @FindBy(xpath = "//select[@class='js-id-replication-yearly-month-1 task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector;

    @FindBy(xpath = "//input[@class='js-id-replication-yearly-day-num task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_year_firstEvery_monthEnter;

    @FindBy(xpath = "//input[@class='js-id-replication-yearly-day-num task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_year_secondEveryCheckBox;

    @FindBy(xpath = "//select[@class='js-id-replication-yearly-week-day-num task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_year_secondEvery_dayTypeSelector;

    @FindBy(xpath = "//select[@class='js-id-replication-yearly-week-day task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_year_secondEvery_weekSelector;

    @FindBy(xpath = "//select[@class='js-id-replication-yearly-month-2 task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_year_secondEvery_monthSelector;

    /**@param day:
     *
     * @param day: first, second, third, fourth, last
     */
    public void select_task_more_repeatTask_repeatTerm_year_secondEvery_dayTypeSelector(String day){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_secondEvery_dayTypeSelector);
        select.selectByVisibleText(day);
    }

    /**@param week:
     *
     * @param week:Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday  |
     */
    public void select_task_more_repeatTask_repeatTerm_year_secondEvery_weekSelector(String week){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_secondEvery_weekSelector);
        select.selectByVisibleText(week);
    }

    /**@param month
     *
     * @param month:January, February, March, April, May, June, July, August, September, October, November, December
     */
    public void select_task_more_repeatTask_repeatTerm_year_secondEvery_monthSelector(String month){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_secondEvery_monthSelector);
        select.selectByVisibleText(month);
    }

    public List<String> get_task_more_repeatTask_repeatTerm_year_secondEvery_dayTypeSelector(){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_secondEvery_dayTypeSelector);

        return BrowserUtils.getTextFromWebElements(select.getOptions());
    }

    public List<String> get_task_more_repeatTask_repeatTerm_year_secondEvery_weekSelector(){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_secondEvery_weekSelector);
        return BrowserUtils.getTextFromWebElements(select.getOptions());
    }

    public List<String> get_task_more_repeatTask_repeatTerm_year_secondEvery_monthSelector(){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_secondEvery_monthSelector);

        return BrowserUtils.getTextFromWebElements(select.getOptions());
    }

    public void click_task_more_repeatTask_repeatTerm_year_secondEveryCheckBox(){
        BrowserUtils.clickOnElement(task_more_repeatTask_repeatTerm_year_secondEveryCheckBox);
    }

    public void enter_task_more_repeatTask_repeatTerm_year_firstEvery_monthEnter(int num){
        BrowserUtils.enterText(task_more_repeatTask_repeatTerm_year_firstEvery_monthEnter,(num+""));
    }

    public void select_task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector(String str){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector);
        select.selectByVisibleText(str);
    }

    public List<String> get_task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector(){
        Select select = new Select(task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector);

       return BrowserUtils.getTextFromWebElements(select.getOptions());
    }

    public List<String>  get_task_more_repeatTask_repeatTerm_month_secondEvery_firstSelector(){
        Select select = new Select(task_more_repeatTask_repeatTerm_month_secondEvery_firstSelector);
        return BrowserUtils.getTextFromWebElements(select.getOptions());
    }

    public List<String> get_task_more_repeatTask_repeatTerm_month_secondEvery_secondSelector() {
        Select select = new Select(task_more_repeatTask_repeatTerm_month_secondEvery_secondSelector);
       return BrowserUtils.getTextFromWebElements(select.getOptions());
    }

    public void select_task_more_repeatTask_repeatTerm_month_secondEvery_secondSelector(String str) {
        Select select = new Select(task_more_repeatTask_repeatTerm_month_secondEvery_secondSelector);
        select.selectByVisibleText(str);
    }

    public void select_task_more_repeatTask_repeatTerm_month_secondEvery_firstSelector(String str){
        Select select = new Select(task_more_repeatTask_repeatTerm_month_secondEvery_firstSelector);
        select.selectByVisibleText(str);
    }

    public void click_task_more_repeatTask_repeatTerm_month_secondEveryCheckBox(){
        BrowserUtils.clickOnElement(task_more_repeatTask_repeatTerm_month_secondEveryCheckBox);
    }

    public void enter_task_more_repeatTask_repeatTerm_monthOfmonthEnter(int num){
        BrowserUtils.enterText(task_more_repeatTask_repeatTerm_monthOfmonthEnter,(num+""));
    }

    public void enter_task_more_repeatTask_repeatTerm_monthOfDayEnter(int num){
        BrowserUtils.enterText(task_more_repeatTask_repeatTerm_monthOfDayEnter,(num+""));
    }

    public WebElement verify_task_more_repeatTask_repeatTerm_weekDayCheckBox(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[@class='task-options-day'][contains(text(),'"+str+"')]/input"));
        BrowserUtils.scrollTo(element);
        return element;
    }

    /**@param str
     *
     * @param str: Sun, Mo, Tu, We, Thu, Fri, Sat
     */
    public void checkBox_task_more_repeatTask_repeatTerm_weekDayCheckBox(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[@class='task-options-day'][contains(text(),'"+str+"')]"));
        BrowserUtils.clickOnElement(element);
    }

    public void enter_task_more_repeatTask_repeatTerm_weekEnter(int num){
        BrowserUtils.enterText(task_more_repeatTask_repeatTerm_weekEnter,(num+""));
    }

    public void enter_task_more_repeatTask_repeatTerm_dayMo(int num){
        BrowserUtils.enterText(task_more_repeatTask_repeatTerm_dayMo,(num+""));
    }

    public void select_task_more_repeatTask_repeatTerm_dayTypeSelector(String str){
        Select select= new Select(task_more_repeatTask_repeatTerm_dayTypeSelector);
        select.selectByVisibleText(str);
    }

    public void enter_task_more_repeatTask_repeatTerm_day(int num){
        BrowserUtils.enterText(task_more_repeatTask_repeatTerm_day,(num+""));
    }

    public void click_task_more_activate_repeatTerm(String repeatTerm){
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[contains(@class,'js')][.='"+repeatTerm+"']"));
        ////span[contains(@class,'js-id-replication-period-type-option tasks-option')][.='week']
        BrowserUtils.clickOnElement(element);
    }

    public void click_taskMore(){
        BrowserUtils.clickOnElement(task_more);
    }

    public void click_task_more_repeatTaskCheckBox(){
        BrowserUtils.clickOnElement(task_more_repeatTaskCheckBox);
    }
    @FindBy (xpath = "//div[@id='blogPostEditCreateTaskPopup']//div[.='Task has been created']")
    private WebElement createdTaskConfirmationMessage;


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
    protected String uploadedFile= "//div[@id='log_internal_container']//a[@title='Test.txt']";
    protected String feedTitle = "(//input[@placeholder='%s'])[1]";


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

    public void close_topic_input_box(){
        if(topicInputBox.isDisplayed()){
           topicInputBoxCloseButton.click();
        }
    }

    public void clickSendBtn(){
       clickOnElement(sendButton);
    }

    public String getTextFromUploadedFile(){
        BrowserUtils.wait(1);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(uploadedFile))).getText();
    }

    public void enterFeedTitle(String title, String text){
        enterText(driver.findElement(By.xpath(String.format(feedTitle,title))),text);
    }

    public void enterDescription(String text){
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//body")).sendKeys(text);
        driver.switchTo().defaultContent();
    }

    protected String cancelSelectionBtn = "//div/span[.='%s']/..//span[@title='Cancel selection']";
    protected String taskAdditionalBlock = "//span/span[.='%s']";
    protected String finderBoxTabSelection ="//div[@class='bx-finder-box-tabs']/a[.='%s']";
    protected String employeeName ="//div[@class='bx-finder-company-department-employee-info']/div[contains(text(),'%s')]";

    public void clickCancelSelectionBtn(String taskOption){
       clickOnElement(driver.findElement(By.xpath(String.format(cancelSelectionBtn, taskOption))));
    }
    public void clickTaskAdditionalBlock(String name){
        System.out.println(String.format(taskAdditionalBlock, name));
        clickOnElement(driver.findElement(By.xpath(String.format(taskAdditionalBlock, name))));

    }

    public void clickAddBtn(String block, String btn) {
        if (block.equals("Responsible person")){
            driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]/..//div//a[contains(text(),'%s')]", block, btn))).click();
        }else if(block.equals("Created by")){
            driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]/..//div//a[contains(text(),'%s')]",block, btn))).click();
        } else if (block.equals("Participants")){
            driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]/..//div//a[contains(text(),'%s')][2]", block, btn))).click();
        }else{
            driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]/..//div//a[contains(text(),'%s')][2]",block,btn))).click();
        }
        }


    public void clickFinderBoxTabSelection(String tab){
        clickOnElement(driver.findElement(By.xpath(String.format(finderBoxTabSelection, tab))));
    }

    public void clickEmployeeName(String name){
        clickOnElement(driver.findElement(By.xpath(String.format(employeeName, name))));
    }

    public void closePopUpWindow(){
        clickOnElement(driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")));
    }

    public String getTextFromCreatedTaskConfirmationMessage(){
        return createdTaskConfirmationMessage.getText();
    }

}
