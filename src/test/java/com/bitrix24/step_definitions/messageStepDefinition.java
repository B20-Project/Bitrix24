package com.bitrix24.step_definitions;

import com.bitrix24.pages.HomePage;
import com.bitrix24.util.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class messageStepDefinition {

    @When("user click \"message\"")
    public void user_click_message() {
        HomePage homePage = new HomePage();
        homePage.click_message();
    }

    @And("user click \"quote text\" icon")
    public void userClickIcon() {
        HomePage homePage = new HomePage();
        homePage.click_message_quote();
    }

    @Then("user should able to enter the quote")
    public void user_should_able_to_enter_the_quote() {
        Driver.getDriver().switchTo().frame(0);
        HomePage homePage = new HomePage();
        String expectedResult = "test123";

        homePage.enter_message_quote(expectedResult);
        String actualResult = homePage.getText_message_quote();

        Assert.assertEquals(expectedResult, actualResult);
        Driver.closeDriver();
    }


    @When("user click \"Add mention\" icon")
    public void user_click_icon() {
        HomePage homePage = new HomePage();
        homePage.click_message_addMention();
    }

    @Then("user should able to mention contacts from giving list;")
    public void user_should_able_to_mention_contacts_from_giving_list() {
        HomePage homePage = new HomePage();
        homePage.click_message_addMention_DepartmentTab();
        String expectedResult ="helpdesk24@cybertekschool.com";
        String actualResult = homePage.get_message_addMention_DepartmentTab_peron();
        homePage.click_message_addMention_DepartmentTab_peron();
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);

        Assert.assertTrue(homePage.to.getText().contains(expectedResult));

        Driver.closeDriver();


    }


}
