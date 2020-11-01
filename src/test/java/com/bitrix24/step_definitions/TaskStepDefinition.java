package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.util.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class TaskStepDefinition {
    ActivityStreamPage activityStream = new ActivityStreamPage();

    @Given("user enters title on {string} input box and enters {string}")
    public void user_enters_title_on_input_box(String string, String string2) {
        activityStream.enterFeedTitle(string, string2);
    }

    @And("user enters description {string}")
    public void user_enters_description(String text) {
        activityStream.enterDescription(text);
    }

    @When("user click \"More\"")
    public void user_click() {
        activityStream.click_taskMore();
    }

    @When("user click \"Repeat task\" check box")
    public void user_click_check_box() {
        activityStream.click_task_more_repeatTaskCheckBox();
    }

    @Then("user select {string}")
    public void user_select(String string) {
        activityStream.click_task_more_activate_repeatTerm(string);
    }

    @Then("enter every {int} {string} day with an interval of {int} mo.")
    public void enter_every_day_with_an_interval_of_mo(Integer int1, String string, Integer int2) {
        activityStream.enter_task_more_repeatTask_repeatTerm_day(int1);
        activityStream.select_task_more_repeatTask_repeatTerm_dayTypeSelector(string);
        activityStream.enter_task_more_repeatTask_repeatTerm_dayMo(int2);
    }

    @Then("enter every {int} week")
    public void enter_every_week(Integer int1) {
    activityStream.enter_task_more_repeatTask_repeatTerm_weekEnter(int1);
    }

    @Then("select following day")
    public void select_following_day(List<String> dataTable) {
        for (String each :dataTable){
            activityStream.checkBox_task_more_repeatTask_repeatTerm_weekDayCheckBox(each);
        }


    }

    @Then("verify following day is selected")
    public void verify_following_day_is_selected(List<String> dataTable) {
        for (String each : dataTable){
            Assert.assertTrue(activityStream.verify_task_more_repeatTask_repeatTerm_weekDayCheckBox(each).isSelected());
        }
    }

}
