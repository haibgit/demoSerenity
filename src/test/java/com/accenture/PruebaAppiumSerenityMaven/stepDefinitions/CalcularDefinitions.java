package com.accenture.PruebaAppiumSerenityMaven.stepDefinitions;

import com.accenture.PruebaAppiumSerenityMaven.Caculator;
//import com.accenture.PruebaAppiumSerenityMaven.steps.CalculadoraSteps;

import com.accenture.PruebaAppiumSerenityMaven.ui.PowerSprinnerDemo;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcularDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(CalcularDefinitions.class);


//    @Steps
//    CalculadoraSteps calculadoraSteps;

    @Steps
    PowerSprinnerDemo powerSprinnerDemo;

    SoftAssertions softAssertions = new SoftAssertions();
    @Steps
    Caculator caculator;


//    @Steps
//    CalculadoraUI1 calculadoraUI1;

    @Given("^I want to write a step with precondition$")
    public void i_want_to_write_a_step_with_precondition() {
        System.out.println("GIVEN");
//        calculadoraSteps.OpenPage();
    }

    @When("^I complete action$")
    public void i_complete_action() {
        System.out.println("WHEN");


    }

    @Then("^I validate the outcomes$")
    public void i_validate_the_outcomes() {
//		calculadoraSteps.prueba();
    }

    @io.cucumber.java.en.Then("I validate the outcomes{int}")
    public void iValidateTheOutcomes(int arg0) {

    }

    @When("I click to dropdown choose an item")
    public void iClickToDropdownChooseAnItem() {
        powerSprinnerDemo.clickToDropdownMenu();
        powerSprinnerDemo.chooseValueIndex(1);


    }

    @When("I click to dropdown choose an item with index {int}")
    public void iClickToDropdownChooseAnItemWithIndex(int index) {
        powerSprinnerDemo.clickToDropdownMenu();
        powerSprinnerDemo.chooseValueIndex(index);

    }


    @When("I storage value")
    public void iStorageValue() {
//        String txt= "10";
//        System.out.println("value is "+ txt);
//        Serenity.setSessionVariable("value").to(txt);
//        caculator.setValue(txt);
        logger.info("chạy tới step @When(\"I storage value\") ");
        softAssertions.assertThat(10).isEqualTo(2);
        logger.info("soft assert để đi tiếp");
//        assertThat(10).isEqualTo(2);
        System.out.println("abc");

        System.out.println("abc");
        System.out.println("abc");
        logger.info("kết thúc step @When(\"I storage value\") ");

    }

    @When("I get value")
    public void iGetValue() {
//        String value = Serenity.sessionVariableCalled("value");
        System.out.println("value get dc o TC1: " );
    }

//    @When("I get value{int}")
//    public void iGetValue(int arg0) {
//    }


    @When("I get value{int}")
    public void i_get_value(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I get value {string}")
    public void iGetValue(String arg0) {
        
    }

    @When("I login with phone is {string} and OTP is {string}")
    public void iLoginWithPhoneIsAndOTPIs(String arg0, String arg1) {
        
    }

    @When("Tôi login abc")
    public void tôiLoginAbc() {
    }


}
