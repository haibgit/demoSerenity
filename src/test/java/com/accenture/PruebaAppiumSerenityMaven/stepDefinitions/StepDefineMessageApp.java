package com.accenture.PruebaAppiumSerenityMaven.stepDefinitions;

import com.accenture.PruebaAppiumSerenityMaven.ui.MessageApp;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StepDefineMessageApp {

    @Steps
    MessageApp messageApp;

    @When("I create new message to {string} with message is {string}")
    public void iCreateNewMessageToWithMessageIs(String to, String value) {
        messageApp.createNewMessageTo(to,value);


    }
}
