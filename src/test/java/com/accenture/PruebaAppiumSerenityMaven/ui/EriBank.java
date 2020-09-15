package com.accenture.PruebaAppiumSerenityMaven.ui;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EriBank extends UIInteractionSteps {

    By btnOK = By.id("android:id/button1");
    By txtUserName = By.id("com.experitest.ExperiBank:id/usernameTextField");
    By ttxPass = By.id("com.experitest.ExperiBank:id/passwordTextField");
    By btnLogin = By.id("com.experitest.ExperiBank:id/loginButton");

    public void loginWithNameAndPass(String name, String pass) {

        System.out.println("->>>>>>>>>>>>>>>>login with name and pass: " + "( " + name + "," + pass + " ) ->>>>>>>>>>");
        element(txtUserName).waitUntilVisible().sendKeys(name);
        element(ttxPass).waitUntilVisible().sendKeys(pass);
        element(btnLogin).click();
    }

    public boolean getToastMessage(String message) {
        String txt = getDriver().getPageSource();
        System.out.println(txt);
        return txt.contains(message);

    }

    public void openapp() {
        element(btnOK).waitUntilVisible().click();
    }

    public boolean readImageAndCompare(String expected) throws IOException {

        String path = System.getProperty("user.dir");
        Runtime.getRuntime().exec("cd " + path);
        Runtime.getRuntime().exec("tesseract demo.png out");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String fileName = path + "/out.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> stringList = new ArrayList<>();
        boolean status = false;
        while ((line = br.readLine()) != null) {
            stringList.add(line);
        }
        for (String index : stringList) {
            if (index.contains(expected)) {
                status = true;
                break;
            }
        }
        return status;
    }

    public void takeScreenshot() throws IOException {
        File screenShotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(System.getProperty("user.dir") + "/demo.png"));
        System.out.println("=>>>>>> save image at " + System.getProperty("user.dir") + "/demo.png");
    }

}
