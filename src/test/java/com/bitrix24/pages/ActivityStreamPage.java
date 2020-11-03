package com.bitrix24.pages;

import static com.bitrix24.util.BrowserUtils.*;

import com.bitrix24.util.BrowserUtils;
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
    protected String uploadedFile = "//div[@id='log_internal_container']//a[@title='fileTest5.txt']";
    protected String feedTitle = "(//input[@placeholder='%s'])[1]";


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

    //inserted extra wait time here
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//a[.='%s']", file))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[.='%s']", file)))).click();
        driver.findElement(By.xpath("//span[.='Select document']")).click();
    }

    public void addEmployeeByTab(String employee, String tab) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addContact))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(contactPopupFormat, "All employees")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(contactPopupFormat, tab)))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(contactPopupFormat, employee)))).click();
        driver.findElement(By.xpath(contactPopupClose)).click();
    }

    public String getTextFromSelectedEmployee() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(selectedContact)))).getText();
    }

    public void enter_link_text(String linktext) {
        linkText.sendKeys(linktext);
    }

    public void enter_link_url(String linkurl) {
        linkUrl.sendKeys(linkurl);
    }

    public boolean is_new_created_link_displayed(String text) {
        driver.switchTo().frame(0);
        boolean result = driver.findElement(By.linkText(text)).isDisplayed();
        driver.switchTo().parentFrame();
        return result;
    }

    public void enter_video_url(String url) {
        videoUrl.sendKeys(url);
    }

    /**
     * @param type link, video
     */
    public void click_on_save_button(String type) {
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(String.format(saveButton, type))).click();
    }

    public void click_recordVideo() {
        wait.until(ExpectedConditions.elementToBeClickable(recordVideoIcon)).click();
    }

    public String deviceAccessPopUpWindow() {
        return deviceAccessMessage.getText();
    }

    public boolean topicInputBox_is_displayed() {
        return topicInputBox.isDisplayed();
    }

    public boolean isAlertPresent() {
        boolean foundAlert = false;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
            System.out.println("isAlertPresent : " + foundAlert);
        } catch (TimeoutException eTO) {
            foundAlert = false;
            System.out.println("isAlertPresent : " + foundAlert);
        }
        return foundAlert;
    }

    public void close_topic_input_box() {
        if (topicInputBox.isDisplayed()) {
            topicInputBoxCloseButton.click();
        }
    }

    public void clickSendBtn() {
        clickOnElement(sendButton);
    }

    public String getTextFromUploadedFile() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(uploadedFile)))).getText();
    }

    public void enterFeedTitle(String title, String text) {
        enterText(driver.findElement(By.xpath(String.format(feedTitle, title))), text);
    }

    public void enterDescription(String text) {
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//body")).sendKeys(text);
        driver.switchTo().defaultContent();
    }

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

    protected String calendar = "//div[@class='bx-calendar']//a[contains(@class,'%s')]";
    protected String calendarMonth = "//div[@class='bx-calendar-%s-content']/span";
    //a[contains(@class,'bx-calendar-cell') and .='%s']
    protected String listOfDates = "//a[.='%s']";

    protected String deadlineOptions = "//span[@data-target='%s']";
    protected String timePlanningOptions = "//*[contains(@data-bx-id,'%s')]";
    protected String durationOptions = "//span[@data-unit='%s']";
    protected String calendarValue = "//*[contains(@data-bx-id,'%s')]//input[@data-bx-id='datepicker-value']";

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
     * @return
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


    protected String plannedTime = "//inpaut[contains(@class,'timeestimate-%s')]";
    protected String reminderType = "//a[contains(@class,'link-%s')]";



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