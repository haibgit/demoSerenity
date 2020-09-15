package com.accenture.PruebaAppiumSerenityMaven.runner;

import common.AppiumServer;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;


@CucumberOptions(
        features = "src/test/resources/features",   //nơi chứa tập hợp các file feature
        tags = "@read",   //là các tag mà mình muốn chạy -> nó k phân biệt tag name ở feature nào. cứ feature nào có tag name này là nó sẽ chạy

//        dryRun = true,
        glue = {"com.accenture.PruebaAppiumSerenityMaven.stepDefinitions"})
// thằng glue này là nơi chứa các file stepdefinition
@RunWith(CucumberWithSerenity.class)
public class Runner {

//    @BeforeClass
//    public static void setup() throws IOException {
//        AppiumServer.start();
//    }
//
//    @AfterClass
//    public static void after() {
//        AppiumServer.stop();
//    }

}
