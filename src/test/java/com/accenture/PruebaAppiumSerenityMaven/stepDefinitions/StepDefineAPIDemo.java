package com.accenture.PruebaAppiumSerenityMaven.stepDefinitions;

import com.accenture.PruebaAppiumSerenityMaven.ui.EriBank;
import com.accenture.PruebaAppiumSerenityMaven.ui.HomeAPIPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.model.DataTable;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefineAPIDemo {


    @Steps
    HomeAPIPage homeAPIPage;

    @Steps
    EriBank eriBank;

    @Given("Open Application APIDemo")
    public void openApplicationAPIDemo() {
        homeAPIPage.gotoHomePage();
    }

    @When("I choose menu {string}")
    public void iChooseMenu(String menuName) {
        homeAPIPage.gotoMenuWithText(menuName);
    }

    @Then("I see title of screen is {string}")
    public void iSeeTitleOfScreenIs(String title) {
        assertThat(homeAPIPage.getTitle(), is(equalTo(title)));

    }

    @When("I choose menu (-?\\d+)")
    public void iChooseMenuAPIDemos(String menu) {
        homeAPIPage.gotoMenuWithText(menu);
    }

    @When("I choose menu Support v4 Demos")
    public void iChooseMenuSupportVDemos() {
        homeAPIPage.gotoMenuSupportV4Demo();
    }

//    @When("I choose menu Animation")
//    public void iChooseMenuAnimation() {
//        homeAPIPage.gotoMenuAnimation();
//    }


    @Then("I see title of screen is visible")
    public void iSeeTitleOfScreenIsVisible() {
        homeAPIPage.getStatusOfTitle();
    }

    @Then("I see button VIBRATE visible")
    public void iSeeButtonVIBRATEVisible() {
        homeAPIPage.verifyButtonVibrate();
    }

    @When("^I choose menu (.*)$")
    public void i_choose_menu(String menu) {
        homeAPIPage.gotoMenuWithText(menu);
    }

    @Then("^I see title of screen is (.*)$")
    public void i_see_title_of_screen_is(String title) {
        assertThat(homeAPIPage.getTitle(), is(equalTo(title)));

    }
//
//    @When("I input name and pass")
//    public void iInputNameAndPass(List<List<String>> list) {
//        for (List<String> l : list) {
//            eriBank.loginWithNameAndPass(l.get(0).trim(), l.get(1).trim());
//        }
//    }

    @When("I input name and pass")
    public void iInputNameAndPass(List<Map<String, String>> list) {
//        List<Map<String, String>> list = dataTable.ge (String.class, String.class);
        for (Map<String, String> stringStringMap : list) {
            String name = stringStringMap.get("userName");
            String pass = stringStringMap.get("Password");
            eriBank.loginWithNameAndPass(name, pass);
        }
    }

    @Given("I open Eribank app")
    public void iOpenEribankApp() {
        eriBank.openapp();
    }

    @When("I login with name is {string} and pass is {string}")
    public void iLoginWithNameIsAndPassIs(String name, String pass) throws IOException {
        eriBank.openapp();
        eriBank.loginWithNameAndPass(name, pass);
        Serenity.takeScreenshot();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eriBank.takeScreenshot();

    }

    @Then("I see text is show in screen {string}")
    public void iSeeTextIsShowInScreen(String expected) throws IOException {
//        Assert.assertTrue(eriBank.readImageAndCompare(expected));
        Assert.assertTrue(eriBank.getToastMessage(expected));
    }
}
