package com.bitrix24.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),8);

    public static void wait(int seconds){

        try{
            Thread.sleep(1000*seconds);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element,"value",text));
        System.out.println("Entering text: "+text);
    }

    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for (WebElement element: elements){
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    /**
     * wait for page load after click action
     */
    public static void waitForLoad(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        By mask =By.xpath("//body/div[4]");
        wait.until(ExpectedConditions.presenceOfElementLocated(mask));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(mask));
    }

    /**
     * clicks on an element using JavaScript
     */
    public static void clickWithJS(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();",element);

    }

    /**
     * scroll to element using JavaScript
     * @param element
     */
    public static void scrollToJS(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void scrollByJS(){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("scroll(0,100)");
    }

    public static void scrollTo(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    /**
     *getScreenShot
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenShot(String name){
        name = new Date().toString().replace(" ","_").replace(":","-")+"_"+name;
        String path = System.getProperty("user.dir")+"/test-ouput/screenshots/"+name+".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
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
}
