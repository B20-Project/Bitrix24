package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.HomePage;
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


    HomePage home = new HomePage();


    @And("user clicks menu {string}")
    public void userClicksMenu(String item) {
        activityStream.click_menu(item);
    }

    @And("user clicks {string} tab under Activity Stream")
    public void userClicksTabUnderActivityStream(String tab) {
        activityStream.clickActivityStreamTab(tab);
    }


    @When("user clicks on post button {string}")
    public void userClicksOnPostButton(String btn) {
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
    @When("user click \"message\"")
    public void user_click_message() {

        activityStream.click_message();
    }

    @And("user click \"quote text\" icon")
    public void userClickIcon() {

        activityStream.click_message_quote();
    }

    @Then("user should able to enter the quote")
    public void user_should_able_to_enter_the_quote() {
        Driver.getDriver().switchTo().frame(0);

        String expectedResult = "test123";

        activityStream.enter_message_quote(expectedResult);
        String actualResult = activityStream.getText_message_quote();

        Assert.assertEquals(expectedResult, actualResult);
        Driver.closeDriver();
    }

    @When("user click \"Add mention\" icon")
    public void user_click_icon() {

        activityStream.click_message_addMention();
    }

    @Then("user should able to mention contacts from giving list;")
    public void user_should_able_to_mention_contacts_from_giving_list() {

        activityStream.click_message_addMention_DepartmentTab();
        String expectedResult ="helpdesk24@cybertekschool.com";
        String actualResult = activityStream.get_message_addMention_DepartmentTab_peron();
        activityStream.click_message_addMention_DepartmentTab_peron();
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);

        Assert.assertTrue(activityStream.to.getText().contains(expectedResult));

        Driver.closeDriver();


    }



    @When("the user click on the link icon")
    public void the_user_click_on_the_link_icon() {
        activityStream.click_on_link_icon();
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

    @When("the user click on the video icon")
    public void the_user_click_on_the_video_icon() {
        activityStream.click_on_video_icon();
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


}
