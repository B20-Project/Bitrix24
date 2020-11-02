package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.util.HelperUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        System.out.println("displayed value: " + activityStream.get_deadLine_displayed_value_in_tasks());
    }

}
