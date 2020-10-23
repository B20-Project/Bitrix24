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

public class MessageStepDefinition {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
     LoginPage loginPage = new LoginPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.login("marketing");
    }

    @When("user click \"message\"")
    public void user_click_message() {

        activityStreamPage.click_message();
    }

    @And("user click \"quote text\" icon")
    public void userClickIcon() {

        activityStreamPage.click_message_quote();
    }

    @Then("user should able to enter the quote")
    public void user_should_able_to_enter_the_quote() {
        Driver.getDriver().switchTo().frame(0);

        String expectedResult = "test123";

        activityStreamPage.enter_message_quote(expectedResult);
        String actualResult = activityStreamPage.getText_message_quote();

        Assert.assertEquals(expectedResult, actualResult);
        Driver.closeDriver();
    }
    
    @When("user click \"Add mention\" icon")
    public void user_click_icon() {

        activityStreamPage.click_message_addMention();
    }

    @Then("user should able to mention contacts from giving list;")
    public void user_should_able_to_mention_contacts_from_giving_list() {

        activityStreamPage.click_message_addMention_DepartmentTab();
        String expectedResult ="helpdesk24@cybertekschool.com";
        String actualResult = activityStreamPage.get_message_addMention_DepartmentTab_peron();
        activityStreamPage.click_message_addMention_DepartmentTab_peron();
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);

        Assert.assertTrue(activityStreamPage.to.getText().contains(expectedResult));

        Driver.closeDriver();


    }


}
