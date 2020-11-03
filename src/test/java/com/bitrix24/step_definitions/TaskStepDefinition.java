package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.util.BrowserUtils;
import com.bitrix24.util.HelperUtil;
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
    @When("user clicks on Deadline input box under task")
    public void user_clicks_on_deadline_input_box_under_task() {
        activityStream.click_on_deadLine_in_tasks();
    }

    @And("Select {string} as date")
    public void select_as_date(String string) {
        System.out.println("expected date: " + string);
        activityStream.set_month(HelperUtil.get_int_value(string,"month"));
        activityStream.set_year(HelperUtil.get_int_value(string,"year"));
        activityStream.set_date(HelperUtil.get_int_value(string,"date"));
    }

    @And("Select {string} as time")
    public void select_as_time(String string) {
        System.out.println("expected time: " + string);
        String [] timeParts = HelperUtil.time_format(string);
        activityStream.set_time(timeParts[0],timeParts[1],timeParts[2]);
    }

    @And("user clicks on select button in calendar")
    public void user_clicks_on_select_button_in_calendar() {
        activityStream.click_on_submit_in_calendar();
    }

    @Then("{string} should be displayed in the Deadline input box")
    public void should_be_displayed_in_the_deadline_input_box(String string) {
        System.out.println("displayed value: " + activityStream.get_calendar_displayed_value_in_tasks("deadline"));
    }

    @When("user click on {string} next to Deadline")
    public void user_click_on_next_to_deadline(String string) {
        activityStream.click_on_deadline_options_in_task(string);
    }

    @When("user click on {string} under time planning")
    public void user_click_on_under_time_planning(String string) {
        activityStream.click_on_timePlanning_options_in_task(string);
    }

    @Then("user enter {string} as duration")
    public void user_enter_as_duration(String string) {
        activityStream.enter_duration_under_timePlanning_in_task(string);
    }

    @When("user select {string} under duration")
    public void user_select_under_duration(String string) {
        activityStream.select_duration_options_under_timePlanning_in_task(string);
    }

    @Then("{string} should be displayed on finish input box")
    public void should_be_displayed_on_finish_input_box(String string) {
        System.out.println("displayed value: " + activityStream.get_calendar_displayed_value_in_tasks("end-date"));
    }

    @Then("user should be able to select all available checkboxes")
    public void user_should_be_able_to_select_all_available_checkboxes() {
        activityStream.select_all_the_available_checkboxes_under_options_in_task();
    }

    @When("user click on More")
    public void user_click_on_more() {
       activityStream.click_on_more_button_in_task();
    }

    @When("user select Task planned time checkbox")
    public void user_select_task_planned_time_checkbox() {
        activityStream.select_task_planned_time_under_more_in_task();
    }

    @Then("enter {string} in hour and {string} minutes")
    public void enter_in_hour_and_minutes(String string, String string2) {
       activityStream.enter_hour_and_minutes_in_task_planning(string, string2);
    }

    @When("user click on Add reminder")
    public void user_click_on_add_reminder() {
       activityStream.click_on_add_reminder_btn_under_more_in_task();
    }

    @When("user click on date input box")
    public void user_click_on_date_input_box() {
        activityStream.click_on_add_reminder_date_input_box_under_more_in_task();
    }

    @Then("verify following type is in first selector under year")
    public void verify_following_type_is_in_first_selector_under_year(List<String> dataTable) {
    @Then("select any role under reminder")
    public void select_any_role_under_reminder() {
       activityStream.select_random_roles_in_reminder_under_more_in_task();
    }

        Assert.assertTrue(dataTable.containsAll(activityStream.get_task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector()));
    }
    @Then("user clicks on {string} icon in reminder")
    public void user_clicks_on_icon_in_reminder(String string) {
        activityStream.select_reminder_type_in_add_reminder(string);
    }

    @Then("enter {int} day {string} on first every under year")
    public void enter_day_on_first_every_under_year(Integer int1, String string) {
        activityStream.enter_task_more_repeatTask_repeatTerm_year_firstEvery_monthEnter(int1);
        activityStream.select_task_more_repeatTask_repeatTerm_year_firstEvery_monthSelector(string);
    }
    @Then("user clicks on Add in reminder")
    public void user_clicks_on_add_in_reminder() {
        activityStream.click_on_Add_button_in_add_reminder();
    }

    @Then("new reminder tab should be displayed above Add reminder")
    public void new_reminder_tab_should_be_displayed_above_add_reminder() {

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
