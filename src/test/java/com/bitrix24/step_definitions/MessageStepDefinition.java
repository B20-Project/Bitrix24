package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.util.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.util.ConfigurationReader;
import com.bitrix24.util.Driver;
import io.cucumber.java.en.Given;



public class MessageStepDefinition {

    LoginPage loginPage = new LoginPage();
    ActivityStreamPage activityStream = new ActivityStreamPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.login("marketing");
    }

    @And("user clicks menu {string}")
    public void userClicksMenu(String item) {
        activityStream.click_menu(item);
        BrowserUtils.wait(1);
    }

    @And("user clicks {string} tab under Activity Stream")
    public void userClicksTabUnderActivityStream(String tab) {
        activityStream.clickActivityStreamTab(tab);
        BrowserUtils.wait(1);
    }

    @Then("user should be able to see the editor text-bar displays on top message box")
    public void user_should_be_able_to_see_the_editor_text_bar_displays_on_top_message_box() {
        Assert.assertTrue(activityStream.editorTextBar_is_displayed());
    }

    @When("user clicks on post button {string}")
    public void userClicksOnPostButton(String btn) {
        if(btn.equals("Topic")){
            activityStream.close_topic_input_box();
        }
        BrowserUtils.wait(1);
        activityStream.clickPostBtn(btn);
    }

    @And("user uploads local file {string}")
    public void userUploadsLocalFile(String fileAddress) {
        activityStream.uploadLocalFile(fileAddress);
    }

    @Then("{string} should display under attached files")
    public void shouldDisplayUnderAttachedFiles(String fileName) {
        Assert.assertEquals(activityStream.getTextFromAttachedFile(),fileName);
    }

    @And("user clicks bitrix24 remote drive")
    public void userClicksBitrix24RemoteDrive() {
        activityStream.openBitrixRemoteDrive();
    }

    @And("user uploads {string} file from company drive")
    public void userUploadsFileFromQuotesSubfolder(String file) {
        activityStream.uploadFromCompanyDrive(file);
    }

    @And("user adds employee {string} from contacts {string} tab")
    public void userAddsEmployeeFromContactsTab(String employee, String tab) {

        activityStream.addEmployeeByTab(employee,tab);
    }

    @Then("employee {string} should appear in the destination box")
    public void employeeShouldAppearInTheDestinationBox(String employee) {
        Assert.assertEquals(activityStream.getTextFromSelectedEmployee(),employee);
    }

    @Then("user should able to enter the quote")
    public void user_should_able_to_enter_the_quote() {
        Driver.getDriver().switchTo().frame(0);

        String expectedResult = "test123";

        activityStream.enter_message_quote(expectedResult);
        String actualResult = activityStream.getText_message_quote();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("user should able to mention contacts from giving list;")
    public void user_should_able_to_mention_contacts_from_giving_list() {
        activityStream.click_message_addMention_DepartmentTab();
        BrowserUtils.wait(2);

        String expectedResult ="helpdesk24@cybertekschool.com";
        String actualResult = activityStream.get_message_addMention_DepartmentTab_peron();
        activityStream.click_message_addMention_DepartmentTab_peron();
        BrowserUtils.wait(2);
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);

        Assert.assertTrue(activityStream.to.getText().contains(expectedResult));
    }

    @When("the user click on Text to enter {string}")
    public void the_user_click_on_text_to_enter(String string) {
        activityStream.enter_link_text(string);
    }

    @When("the user click on Link to enter {string}")
    public void the_user_click_on_link_to_enter(String string) {
        activityStream.enter_link_url(string);
    }

    @And("click on link save button")
    public void click_on_link_save_button() {
        activityStream.click_on_save_button("link");
    }

    @Then("new link should be created displaying {string}")
    public void new_link_should_be_created_displaying(String string) {
        System.out.println(activityStream.is_new_created_link_displayed(string));
        Assert.assertTrue(activityStream.is_new_created_link_displayed(string));
    }

    @And("the user enter video url {string}")
    public void the_user_enter_video_url(String string) {
        activityStream.enter_video_url(string);
    }

    @And("click on save button")
    public void click_on_save_button() {
        activityStream.click_on_save_button("video");
    }

    @Then("new video link should be created on the text box")
    public void new_video_link_should_be_created_on_the_text_box() {
    }

    @Then("Topic input box should display")
    public void topic_input_box_should_display() {
        activityStream.topicInputBox_is_displayed();
        Assert.assertTrue(activityStream.topicInputBox_is_displayed());
        BrowserUtils.wait(2);
    }

    @When("user clicks on icon \"Record Video\"")
    public void user_click_on_icon() {
        activityStream.click_recordVideo();
    }

    @Then("user should be able to see message in pop-up window")
    public void user_should_be_able_to_see_pop_up_window() {
        String expected = "You have to allow access to your camera and microphone to record a video.";
        String actual = activityStream.deviceAccessPopUpWindow();
        Assert.assertEquals(expected, actual);
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String string) {
        BrowserUtils.wait(2);
       activityStream.clickSendBtn();
    }

    @Then("{string} should display under Activity Stream")
    public void should_display_under(String fileName) {
        BrowserUtils.wait(1);
        Assert.assertEquals(activityStream.getTextFromUploadedFile(),fileName);



    }


}
