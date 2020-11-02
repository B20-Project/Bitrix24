package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.util.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
    @Given("user selects  responsible person {string} from {string}")
    public void user_selects_responsible_person_from(String name, String tab) {
        activityStream.clickCancelSelectionBtn("Responsible person");
        BrowserUtils.wait(1);
        activityStream.clickFinderBoxTabSelection(tab);
        BrowserUtils.wait(1);
        activityStream.clickEmployeeName(name);
        activityStream.closePopUpWindow();
    }

    @When("user clicks on task additional block {string}")
    public void user_clicks_on_task_additional_block(String string) {
        activityStream.clickTaskAdditionalBlock(string);
    }

    @And("user selects {string} from {string}")
    public void user_selects_from(String name, String tab) {
        BrowserUtils.wait(1);
        activityStream.clickFinderBoxTabSelection(tab);
        BrowserUtils.wait(1);
        activityStream.clickEmployeeName(name);
        activityStream.closePopUpWindow();
    }

    @When("user clicks on {string} button in {string} block")
    public void user_clicks_on_button_in_block(String block, String string2) {
        activityStream.clickAddBtn(string2,block);
        BrowserUtils.wait(1);
    }

    @Then("{string} message should display in pop-up window")
    public void message_should_display_in_pop_up_window(String string) {
        Assert.assertEquals(activityStream.getTextFromCreatedTaskConfirmationMessage(), string);

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
