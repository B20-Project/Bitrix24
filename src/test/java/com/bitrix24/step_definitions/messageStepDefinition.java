package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class messageStepDefinition {

    HomePage home = new HomePage();
    ActivityStreamPage activityStream = new ActivityStreamPage();

    @And("user clicks menu {string}")
    public void userClicksMenu(String item) {
        home.click_menu(item);
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
}
