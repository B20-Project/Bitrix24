package com.bitrix24.step_definitions;

import com.bitrix24.pages.HomePage;
import io.cucumber.java.en.And;

public class messageStepDefinition {

    HomePage home = new HomePage();

    @And("user clicks menu {string}")
    public void userClicksMenu(String item) {
        home.click_menu(item);
    }

    @And("user clicks {string} tab under Activity Stream")
    public void userClicksTabUnderActivityStream(String tab) {
        home.clickActivityStreamTab(tab);
    }


}
