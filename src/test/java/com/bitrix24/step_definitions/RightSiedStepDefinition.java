package com.bitrix24.step_definitions;

import com.bitrix24.pages.HomePage;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.util.ConfigurationReader;
import com.bitrix24.util.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RightSiedStepDefinition {

    @Given("user is on the home page")
    public void user_is_no_the_home_page() {
        LoginPage loginPage = new LoginPage();
        String URL = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.login("marketing");
    }

    @When("user click notification icon")
    public void user_click_notification_icon() {
        HomePage homePage= new HomePage();
        homePage.click_sidePopUpWindow_contact_you();
    }
    @Then("user should see popUp window page")
    public void user_should_see_pop_up_window_page() {
        HomePage homePage= new HomePage();
        Assert.assertTrue(homePage.sidePopUpWindow_Verify_dialogMessenger.isDisplayed());
    }
}
