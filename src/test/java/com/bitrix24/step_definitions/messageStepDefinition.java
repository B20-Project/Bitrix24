package com.bitrix24.step_definitions;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.pages.MessagePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class messageStepDefinition {

    MessagePage message = new MessagePage();
    LoginPage login = new LoginPage();

    @Given("the user logged in and located in basepage")
    public void the_user_logged_in_and_located_in_basepage() {
        login.login("marketing");
        message.click_on_message_tab();
    }

    @When("the user click on the link tab")
    public void the_user_click_on_the_link_tab() {
        message.click_on_link_icon();
    }

    @When("the user click on Text to enter {string}")
    public void the_user_click_on_text_to_enter(String string) {
        message.enter_link_text(string);
    }

    @When("the user click on Link to enter {string}")
    public void the_user_click_on_link_to_enter(String string) {
        message.enter_link_url(string);
    }

    @And("click on save button")
    public void click_on_save_button() {
       message.getLinkSaveButton().click();
    }

    @Then("new link should be created on the text box")
    public void new_link_should_be_created_on_the_text_box() {

    }
}
