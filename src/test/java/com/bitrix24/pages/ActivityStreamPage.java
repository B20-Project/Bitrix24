package com.bitrix24.pages;

import static com.bitrix24.util.BrowserUtils.*;

import com.bitrix24.util.BrowserUtils;
import com.bitrix24.util.Driver;
import com.bitrix24.util.HelperUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActivityStreamPage extends AbstractPageBase {
    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    private WebElement enter_message_quote;

    @FindBy(xpath = "//a[ starts-with(@id,'destDepartmentTab')]")
    private WebElement message_addMention_DepartmentTab;

    @FindBy(xpath = "//div[@id='bx-lm-category-relation-129']/a[@href='#U514']")
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

    @FindBy(xpath = "//input[@id='replication-repeat-constraint-none']")
    private WebElement task_more_repeatTask_repeatTerm_repeatUntil_noEndDateCheckBox;

    @FindBy(xpath = "//input[@id='replication-repeat-constraint-date']")
    private WebElement task_more_repeatTask_repeatTerm_repeatUntil_endDateCheckBox;

    @FindBy(xpath = "//span[@class='js-id-replication-end-date-datepicker task-options-inp-container task-options-date t-empty']//input[@class='js-id-datepicker-display task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_repeatUntil_endDateInput;

    @FindBy(xpath = "//input[@id='replication-repeat-constraint-times']")
    private WebElement task_more_repeatTask_repeatTerm_repeatUntil_completeAfterCheckBox;

    @FindBy(xpath = "//input[@class='js-id-replication-times task-options-inp']")
    private WebElement task_more_repeatTask_repeatTerm_repeatUntil_completeAfterInput;

    @FindBy (xpath = "//div[@id='blogPostEditCreateTaskPopup']//div[.='Task has been created']")
    private WebElement createdTaskConfirmationMessage;

    @FindBy (xpath = "//*[.='Task planned time']/input")
    private WebElement taskPlannedTime;

    @FindBy (xpath = "//span[@data-bx-id='reminder-open-form']")
    private WebElement addReminder;

    @FindBy (xpath = "//span[@data-bx-id='form-date']")
    private WebElement reminderInputBox;

    @FindBy (xpath = "//select[@data-bx-id='form-change-recipient']")
    private WebElement reminderRoles;

    @FindBy (xpath = "//button[@data-bx-id='form-submit']")
    private WebElement reminderAddButton;

    @FindBy(xpath = "//span[@data-bx-id='dateplanmanager-deadline']/input[1]")
    private WebElement deadLine;

    @FindBy(xpath = "//a[@data-action='submit']")
    private WebElement sumbit;

    @FindBy(xpath = "//span[@data-bx-id='dateplanmanager-deadline']/input[@data-bx-id='datepicker-value']")
    private WebElement deadLineValue;

    @FindBy(xpath = "//input[@class='bx-calendar-year-input']")
    private WebElement yearInput;

    @FindBy(xpath = "//input[@class='bx-calendar-form-input']")
    private List<WebElement> calendarTime;

    @FindBy(xpath = "//span[@data-action='time_ampm']")
    private WebElement calendar_am_pm;

    @FindBy(xpath = "//div[@class='task-options-field-inner']")
    private List<WebElement> optionsCheckboxes;

    @FindBy(className = "task-additional-alt-more")
    private WebElement moreButton;

    @FindBy(xpath = "//div[@id='task-item-set-popupparenttask']//span[@class='popup-window-button popup-window-button-accept']")
    private WebElement subtaskOf_popUp_selectButton;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-create'][.='Save']")
    private WebElement tags_popUp_saveButton;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept'][.='Select']")
    private WebElement dependentTasks_popUp_selectButton;


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
    protected String plannedTime = "//input[contains(@class,'timeestimate-%s')]";
    protected String reminderType = "//a[contains(@class,'link-%s')]";
    protected String calendar = "//div[@class='bx-calendar']//a[contains(@class,'%s')]";
    protected String calendarMonth = "//div[@class='bx-calendar-%s-content']/span";
    protected String listOfDates = "//a[.='%s']";
    protected String deadlineOptions = "//span[@data-target='%s']";
    protected String timePlanningOptions = "//*[contains(@data-bx-id,'%s')]";
    protected String durationOptions = "//span[@data-unit='%s']";
    protected String calendarValue = "//*[contains(@data-bx-id,'%s')]//input[@data-bx-id='datepicker-value']";
    protected String cancelSelectionBtn = "//div/span[.='%s']/..//span[@title='Cancel selection']";
    protected String taskAdditionalBlock = "//span/span[.='%s']";
    protected String finderBoxTabSelection ="//div[@class='bx-finder-box-tabs']/a[.='%s']";
    protected String employeeName ="//div[@class='bx-finder-company-department-employee-info']/div[contains(text(),'%s')]";
    protected String checkBoxName="//label[.='%s']/../preceding-sibling::input";
    protected String weekDayCheckBox_verify="//label[@class='task-options-day'][contains(text(),'%s')]/input";
    protected String weekDayCheckBox_checkBox="//label[@class='task-options-day'][contains(text(),'%s')]/input";
    protected String repeatTerm="//span[contains(@class,'js')][.='%s']";
    protected String taskTypes="//span[.='%s']/following-sibling::div//span[contains(text(),'Add')]";
    protected String subtaskOf_popUp_recentTasks="//div[@id='task-item-set-popupparenttask']//div[@class='finder-box-item-text'][.='%s']";
    protected String tags_popUp="//label[.='%s']/preceding-sibling::input";
    protected String dependentTasks_popUp="//div[@id='task-item-set-popupdependson']//div[@class='finder-box-item-text'][.='%s']";

    public void click_dependentTasks_popUp_selectButton(){
        BrowserUtils.clickOnElement(dependentTasks_popUp_selectButton);
    }

    public void click_dependentTasks_popUp(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath(String.format(dependentTasks_popUp, str)));
        BrowserUtils.clickOnElement(element);
    }

    public void click_tags_popUp_saveButton(){
        BrowserUtils.clickOnElement(tags_popUp_saveButton);
    }

    public void click_tags_popUp(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath(String.format(tags_popUp, str)));
        BrowserUtils.clickOnElement(element);
    }

    public void click_subtaskOf_popUp_selectButton(){
        BrowserUtils.clickOnElement(subtaskOf_popUp_selectButton);
    }

    public void click_subtaskOf_popUp_recentTasks(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath(String.format(subtaskOf_popUp_recentTasks, str)));
        BrowserUtils.clickOnElement(element);
    }

    public void click_addTaskType(String taskType){

        if (taskType.equalsIgnoreCase("tags")){
            WebElement element = Driver.getDriver().findElement(By.xpath(String.format((taskTypes+"[2]"), taskType)));
            System.out.println("element = " + element);
            System.out.println("element = " + element.getLocation());
            //BrowserUtils.scrollByJS(434, 926);
            element.click();
        }else {
            WebElement element = Driver.getDriver().findElement(By.xpath(String.format(taskTypes, taskType)));
            System.out.println("element = " + element);
            System.out.println("element = " + element.getLocation());
            BrowserUtils.scrollByJS(434, 926);

            element.click();
            //BrowserUtils.clickOnElement(element);
        }
    }

    public void enter_task_more_repeatTask_repeatTerm_repeatUntil_completeAfterInput(int num){
        BrowserUtils.scrollTo(task_more_repeatTask_repeatTerm_repeatUntil_completeAfterInput);
        task_more_repeatTask_repeatTerm_repeatUntil_completeAfterInput.sendKeys((num+""));
    }

    public void click_task_more_repeatTask_repeatTerm_repeatUntil_checkBox(String checkBoxNames){
        WebElement element = Driver.getDriver().findElement(By.xpath(String.format(checkBoxName, checkBoxNames)));
        System.out.println("element = " + element);
        BrowserUtils.scrollByJS(435, 931);
        BrowserUtils.clickOnElement(element);
        element.click();
    }

    public void click_task_more_repeatTask_repeatTerm_repeatUntil_endDateEnter(){
        BrowserUtils.scrollTo(task_more_repeatTask_repeatTerm_repeatUntil_endDateInput);
        BrowserUtils.clickOnElement(task_more_repeatTask_repeatTerm_repeatUntil_endDateInput);
    }

    public boolean is_task_more_repeatTask_repeatTerm_repeatUntil_noEndDateCheckBox_select(){
        return task_more_repeatTask_repeatTerm_repeatUntil_noEndDateCheckBox.isSelected();
    }

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
        WebElement element = Driver.getDriver().findElement(By.xpath(String.format(weekDayCheckBox_verify,str)));
        BrowserUtils.scrollTo(element);
        return element;
    }

    /**@param str
     *
     * @param str: Sun, Mo, Tu, We, Thu, Fri, Sat
     */
    public void checkBox_task_more_repeatTask_repeatTerm_weekDayCheckBox(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath(String.format(weekDayCheckBox_checkBox,str)));
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

    public void click_task_more_activate_repeatTerm(String repeatTerms){
        WebElement element = Driver.getDriver().findElement(By.xpath(String.format(repeatTerm, repeatTerms)));
        BrowserUtils.clickOnElement(element);
    }

    public void click_taskMore(){
        BrowserUtils.clickOnElement(task_more);
    }

    public void click_task_more_repeatTaskCheckBox(){
        BrowserUtils.clickOnElement(task_more_repeatTaskCheckBox);
    }
    protected String inputBox = "(//div[@class='task-options task-options-main']//span[.='%s']/.. //input)[1]";

    public String getText_message_quote() {
        return enter_message_quote.getText();
    }

    public void enter_message_quote(String Enter_quote) {
        enter_message_quote.sendKeys(Enter_quote);
    }

    public void click_message_addMention_DepartmentTab() {
        message_addMention_DepartmentTab.click();
    }

    public void click_message_addMention_DepartmentTab_peron() {
        message_addMention_DepartmentTab_peron.click();
    }

    public String get_message_addMention_DepartmentTab_peron() {
        return message_addMention_DepartmentTab_peron.getText();
    }

    public boolean editorTextBar_is_displayed() {
        return editorTextBar.isDisplayed();
    }

    public void clickActivityStreamTab(String tab) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(activityStreamTab, tab)))).click();
    }

    /**
     * @param btn:Upload files, Link, Insert video, Quote text, Add mention, Visual editor, Topic
     */
    public void clickPostBtn(String btn) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(msgTabPostBtn, btn)))).click();
    }

    public void uploadLocalFile(String fileAddress) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(localFileBox))).sendKeys(fileAddress);
    }

    public String getTextFromAttachedFile() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(msgTabAttachedFile))).getText();
    }

    public void openBitrixRemoteDrive() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bitrixRemoteDrive))).click();
    }

    public void uploadFromCompanyDrive(String file) {
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
        //BrowserUtils.wait(2);
        enterText(driver.findElement(By.xpath(String.format(feedTitle,title))),text);
    }

    public void enterDescription(String text){
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//body")).sendKeys(text);
        driver.switchTo().defaultContent();
    }

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
        return wait.until(ExpectedConditions.visibilityOf(createdTaskConfirmationMessage)).getText();
    }

    public String get_current_month() { return driver.findElement(By.xpath(String.format(calendar, "month"))).getText(); }

    public String get_current_year() {
        return driver.findElement(By.xpath(String.format(calendar, "year"))).getText();
    }

    public void click_on_deadLine_in_tasks() {
        clickOnElement(deadLine);
    }

    public void click_on_submit_in_calendar() {
        clickOnElement(sumbit);
    }

    /**
     * @param num 1-12
     */
    public void set_month(int num) {
        Actions action = new Actions(driver);
        WebElement month = driver.findElement(By.xpath(String.format(calendar, "month")));
        action.moveToElement(month).click().perform();

        List<WebElement> elementList = driver.findElements(By.xpath(String.format(calendarMonth, "month")));
        action.moveToElement(elementList.get(num - 1)).click().perform();
        System.out.println("selecting "+num+" as month");
    }

    /**
     *
     * @param num  1900-2100
     */
    public void set_year(int num) {
        Actions action = new Actions(driver);
        WebElement year = driver.findElement(By.xpath(String.format(calendar, "year")));
        action.moveToElement(year).click().perform();
        enterText(yearInput, "" + num);
    }

    /**
     *
     * @param num 1-31
     */
    public void set_date(int num) {
        Actions action = new Actions(driver);
        List<WebElement> elementList = driver.findElements(By.xpath(String.format(listOfDates, num)));
        for (WebElement each : elementList){
            if (!each.getAttribute("class").contains("hidden")){
                action.moveToElement(each).click().perform();
            }
        }
        System.out.println("selecting "+num+" as date");
    }

    /**
     *
     * @param hour  1-12
     * @param min   0-59
     * @param am_pm am/pm
     */
    public void set_time(String hour, String min, String am_pm){
        enterText(calendarTime.get(0),""+hour);
        enterText(calendarTime.get(1),""+min);
        if (!calendar_am_pm.getText().equalsIgnoreCase(am_pm)) calendar_am_pm.click();
        System.out.println("ampm set to: " + calendar_am_pm.getText());
    }

    /**
     *
     * @param string start-date, end-date, deadline
     */
    public String get_calendar_displayed_value_in_tasks(String string){
        return driver.findElement(By.xpath(String.format(calendarValue,string))).getAttribute("value");
    }

    /**
     *
     * @param string date-plan, options
     */
    public void click_on_deadline_options_in_task(String string){
        if (string.equalsIgnoreCase("time planning")) string = "date-plan";
        clickOnElement(driver.findElement(By.xpath(String.format(deadlineOptions,string))));
    }

    /**
     *
     * @param string start-date, duration, end-date
     */
    public void click_on_timePlanning_options_in_task(String string){
        if (string.equalsIgnoreCase("Start task on")) string = "start-date";
        if (string.equalsIgnoreCase("finish")) string = "end-date";
        clickOnElement(driver.findElement(By.xpath(String.format(timePlanningOptions,string))));
    }

    public void enter_duration_under_timePlanning_in_task(String string){
        enterText(driver.findElement(By.xpath(String.format(timePlanningOptions,"duration"))),string);
    }

    /**
     *
     * @param string days, hours, mins
     */
    public void select_duration_options_under_timePlanning_in_task(String string){
        if (string.equalsIgnoreCase("minutes")) string = "mins";
        clickOnElement(driver.findElement(By.xpath(String.format(durationOptions,string))));
    }

    public void select_all_the_available_checkboxes_under_options_in_task(){
        clickOnElement(optionsCheckboxes.get(0));
        for (WebElement each: optionsCheckboxes){
            clickOnElement(each);
        }
    }

    //this method can be replaced
    public void click_on_more_button_in_task(){
        clickOnElement(moreButton);
    }

    public void select_task_planned_time_under_more_in_task(){
        if (!taskPlannedTime.isSelected()) clickOnElement(taskPlannedTime);
    }

    public void enter_hour_and_minutes_in_task_planning(String hours, String minutes){
        enterText(driver.findElement(By.xpath(String.format(plannedTime,"hour"))),hours);
        enterText(driver.findElement(By.xpath(String.format(plannedTime,"minute"))),minutes);
    }

    public void click_on_add_reminder_btn_under_more_in_task(){
        clickOnElement(addReminder);
    }

    public void click_on_add_reminder_date_input_box_under_more_in_task(){
        clickOnElement(reminderInputBox);
    }

    public void select_random_roles_in_reminder_under_more_in_task(){
        Select objSelect = new Select(reminderRoles);
        int randomInt = HelperUtil.get_random_int(0, objSelect.getOptions().size());
        objSelect.selectByIndex(randomInt);
    }

    /**
     *
     * @param string mes, mail
     */
    public void select_reminder_type_in_add_reminder(String string){
        if (string.equalsIgnoreCase("email")) string = "mail";
        if (string.equalsIgnoreCase("message")) string = "mes";
        clickOnElement(driver.findElement(By.xpath(String.format(reminderType,string))));
    }

    public void click_on_Add_button_in_add_reminder(){
        clickOnElement(reminderAddButton);
    }



}