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

    @And("user clicks menu {string}")
    public void userClicksMenu(String item) {
        activityStream.click_menu(item);
    }

    @And("user clicks {string} tab under Activity Stream")
    public void userClicksTabUnderActivityStream(String tab) {
        activityStream.clickActivityStreamTab(tab);
        BrowserUtils.wait(3);
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
    }

    @When("user click \"Add mention\" icon")
    public void user_click_icon() {

        activityStream.click_message_addMention();
        BrowserUtils.wait(3);
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


}
