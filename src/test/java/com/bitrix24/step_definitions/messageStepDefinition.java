package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.util.ConfigurationReader;
import com.bitrix24.util.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class messageStepDefinition {

    LoginPage loginPage = new LoginPage();
    ActivityStreamPage activityStream = new ActivityStreamPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login("marketing");
    }
    @When("user clicks menu {string}")
    public void user_clicks_menu_and_tab(String string) throws InterruptedException {
        activityStream.click_leftMenu_tab("Activity Stream");
    }
    @And("user click {string} module")
    public void user_click_module(String string) throws InterruptedException {
        activityStream.click_tab_under_activity_stream("Message");
        Thread.sleep(3);
    }
    @And("user clicks on {string} icon")
    public void user_clicks_on_icon(String string) {
        activityStream.click_icon_under_activity_stream();

    }
    @Then("user should be able to see the editor text-bar displays on top message box")
    public void user_should_be_able_to_see_the_editor_text_bar_displays_on_top_message_box() {
        Assert.assertTrue(activityStream.editorTextBar_is_displayed());
    }

}
