package com.bitrix24.pages;

import com.bitrix24.util.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActivityStreamPage extends AbstractPageBase{

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-wrap']")
    private WebElement editorTextBar;

    @FindBy(xpath = "//span[@id='lhe_button_editor_blogPostForm']")
    private WebElement visualEditorIcon;

    @FindBy(xpath = "//span[@title='Link']")
    private WebElement linkIcon;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-text')]")
    private WebElement linkText;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-href')]")
    private WebElement linkUrl;

    @FindBy(xpath = "//span[@title='Insert video']")
    private WebElement videoIcon;

    @FindBy(xpath = "//input[contains(@id,'blogPostForm-source')]")
    private WebElement videoUrl;

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

    protected String saveButton = "//div[contains(@class,'%s-dialog')]//input[@value = 'Save']";

    //inserted extra wait time here
    public void clickActivityStreamTab(String tab){
        driver.findElement(By.xpath(String.format(activityStreamTab,tab))).click();
        BrowserUtils.wait(2);
    }

    public void clickPostBtn(String btn){
        driver.findElement(By.xpath(String.format(msgTabPostBtn,btn))).click();
    }

    public void uploadLocalFile(String fileAddress){
        driver.findElement(By.xpath(localFileBox)).sendKeys(fileAddress);
    }

    public String getTextFromAttachedFile(){
        return driver.findElement(By.xpath(msgTabAttachedFile)).getText();
    }

    public void openBitrixRemoteDrive(){
        driver.findElement(By.xpath(bitrixRemoteDrive)).click();
    }

    public void uploadFromCompanyDrive(String file){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Sales and marketing']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Quotes']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[.='%s']",file)))).click();
        driver.findElement(By.xpath("//span[.='Select document']")).click();
    }

    public void addEmployeeByTab(String employee, String tab){
        driver.findElement(By.xpath(addContact)).click();
        driver.findElement(By.xpath(String.format(contactPopupFormat,"All employees"))).click();
        driver.findElement(By.xpath(String.format(contactPopupFormat,tab))).click();
        driver.findElement(By.xpath(String.format(contactPopupFormat,employee))).click();
        driver.findElement(By.xpath(contactPopupClose)).click();
    }

    public String getTextFromSelectedEmployee(){
        return driver.findElement(By.xpath(selectedContact)).getText();
    }

    //Methods for AC_3
    public void click_on_link_icon(){ linkIcon.click(); }
    public void enter_link_text(String linktext){ linkText.sendKeys(linktext); }
    public void enter_link_url(String linkurl){ linkUrl.sendKeys(linkurl); }

    public boolean is_new_created_link_displayed(String text){
        driver.switchTo().frame(0);
        boolean result = driver.findElement(By.linkText(text)).isDisplayed();
        driver.switchTo().parentFrame();
        return result;
    }

    //Methods for AC_4
    public void click_on_video_icon(){ videoIcon.click();}
    public void enter_video_url(String url){ videoUrl.sendKeys(url); }

    /**
     *
     * @param type link, video
     */
    public void click_on_save_button(String type){
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(String.format(saveButton,type))).click();
    }


}
