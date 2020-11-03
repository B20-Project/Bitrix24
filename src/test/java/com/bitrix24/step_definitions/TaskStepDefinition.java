package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.util.BrowserUtils;
import io.cucumber.java.bs.A;
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

    @Then("select evert and enter {int} day of every {int} month")
    public void select_evert_day_of_every_month(Integer int1, Integer int2) {
        activityStream.enter_task_more_repeatTask_repeatTerm_monthOfDayEnter(int1);
        activityStream.enter_task_more_repeatTask_repeatTerm_monthOfmonthEnter(int2);
    }

    @Then("select evert and select {string} {string}")
    public void select_evert_and_select(String string, String string2) {
        activityStream.click_task_more_repeatTask_repeatTerm_month_secondEveryCheckBox();
        activityStream.select_task_more_repeatTask_repeatTerm_month_secondEvery_firstSelector(string);
        activityStream.select_task_more_repeatTask_repeatTerm_month_secondEvery_secondSelector(string2);
    }

    @Then("verify following type is in first selector under month")
    public void verify_following_type_is_in_first_selector(List<String> dataTable) {
        Assert.assertTrue(dataTable.containsAll(activityStream.get_task_more_repeatTask_repeatTerm_month_secondEvery_firstSelector()));
    }

    @Then("verify following type is in second selector under month")
    public void verify_following_type_is_in_second_selector(List<String> dataTable) {
        Assert.assertTrue(dataTable.containsAll(activityStream.get_task_more_repeatTask_repeatTerm_month_secondEvery_secondSelector()));

    }

    @Then("verify following type is in first selector under year")
    public void verify_following_type_is_in_first_selector_under_year(List<String> dataTable) {

        Assert.assertTrue(dataTable.containsAll(activityStream.get_task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector()));
    }

    @Then("enter {int} day {string} on first every under year")
    public void enter_day_on_first_every_under_year(Integer int1, String string) {
        activityStream.enter_task_more_repeatTask_repeatTerm_year_firstEvery_monthEnter(int1);
        activityStream.select_task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector(string);
    }

    @Then("select second every under year")
    public void select_second_every_under_year() {
    activityStream.click_task_more_repeatTask_repeatTerm_year_secondEveryCheckBox();
    }

    @Then("verify following day type of day in second selector under year")
    public void verify_following_type_of_day_in_second_selector_under_year(List<String> dataTable) {
        Assert.assertTrue(dataTable.containsAll(activityStream.get_task_more_repeatTask_repeatTerm_year_secondEvery_dayTypeSelector()));
    }

    @Then("verify following week type of week in second selector under year")
    public void verify_following_type_of_week_in_second_selector_under_year(List<String> dataTable) {
        Assert.assertTrue(dataTable.containsAll(activityStream.get_task_more_repeatTask_repeatTerm_year_secondEvery_weekSelector()));
    }

    @Then("verify following month type of month in second selector under year")
    public void verify_following_type_of_month_in_second_selector_under_year(List<String> dataTable) {
        Assert.assertTrue(dataTable.containsAll(activityStream.get_task_more_repeatTask_repeatTerm_year_secondEvery_monthSelector()));
    }

    @Then("select {string} {string} month {string} under year")
    public void select_month_under_year(String string, String string2, String string3) {
        activityStream.select_task_more_repeatTask_repeatTerm_year_secondEvery_dayTypeSelector(string);
        activityStream.select_task_more_repeatTask_repeatTerm_year_secondEvery_weekSelector(string2);
        activityStream.select_task_more_repeatTask_repeatTerm_year_secondEvery_monthSelector(string3);
        System.out.println("Don");

    }
}
