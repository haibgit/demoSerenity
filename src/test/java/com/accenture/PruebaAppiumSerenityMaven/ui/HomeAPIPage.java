package com.accenture.PruebaAppiumSerenityMaven.ui;

import io.appium.java_client.MobileBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.List;

public class HomeAPIPage extends UIInteractionSteps {
    By btnOK = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");
    By menuAPIDemo = By.xpath("//android.widget.TextView[@text='API Demos']");
    By lblTitle = By.xpath("//android.widget.ImageButton/following-sibling::android.widget.TextView");

    public void gotoHomePage() {
        element(btnOK).click();
    }

    public void gotoMenuWithText(String value) {
        element(By.xpath("//android.widget.TextView[@text='" + value + "']")).click();
    }

    public String getTitle() {
        String title = element(lblTitle).waitUntilVisible().getText();
        System.out.println("current title is " + title);
        return title;
    }

    public void gotoMenuAPIDemo() {
        element(menuAPIDemo).click();
    }

    public void gotoMenuSupportV4Demo() {
        element(menuAPIDemo).click();
    }

    public void gotoMenuAnimation() {
//        element(By.id("android:id/list")).then(By.xpath("//android.widget.TextView[@text='Animation']")).click();

        List<WebElementFacade> webElementFacadeList = findAll(By.id("android:id/text1"));

        System.out.println(webElementFacadeList.size());

        element(By.id("android:id/list")).then(MobileBy.AndroidUIAutomator("text(\"Animation\")")).click();

    }

    public void getStatusOfTitle()  {
         find(lblTitle).shouldBeVisible();

        getClock().pauseFor(100);

    }

    public void verifyButtonVibrate() {
        find(By.id("com.touchboarder.android.api.demos:id/button")).shouldBeVisible();
    }
}
