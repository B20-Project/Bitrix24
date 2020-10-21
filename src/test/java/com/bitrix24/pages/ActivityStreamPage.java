package com.bitrix24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActivityStreamPage extends AbstractPageBase {

    protected String activityStreamTab = "//div[@id='feed-add-post-form-tab']/span[.='%s']";
    protected String msgTabPostBtn = "//div[contains(@class,'form-wrap')]//span[contains(@title,'%s')]";
    protected String localFileBox = "//input[@name='bxu_files[]']";
    protected String msgTabAttachedFile = "//span[@title='Click to insert file']";
    protected String bitrixRemoteDrive = "//div[@style='display: block;']//span[.='Select document from Bitrix24']";
    protected String addContact = "//a[.='Add more']";
    protected String contactPopupFormat = "//div[@id='BXSocNetLogDestination']//a[contains(.,'%s')]";
    protected String contactPopupClose = "//span[@class='popup-window-close-icon']";
    protected String selectedContact = "//span[@id='feed-add-post-destination-item']";
    protected String mainWindow;
    protected String remoteDrive;
    public void clickActivityStreamTab(String tab){
        driver.findElement(By.xpath(String.format(activityStreamTab,tab))).click();
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
        mainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath(bitrixRemoteDrive)).click();
        remoteDrive = driver.getWindowHandle();
        driver.switchTo().window(remoteDrive);
    }

    public void uploadFromCompanyDrive(String file){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Sales and marketing']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Quotes']"))).click();
        driver.findElement(By.xpath(String.format("//a[.='%s']",file))).click();
        driver.findElement(By.xpath("//span[.='Select document']")).click();
        driver.switchTo().window(mainWindow);
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

}
