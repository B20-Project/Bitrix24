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
