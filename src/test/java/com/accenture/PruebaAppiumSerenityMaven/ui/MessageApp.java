package com.accenture.PruebaAppiumSerenityMaven.ui;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MessageApp extends UIInteractionSteps {
    By btnNew = By.id("com.google.android.apps.messaging:id/start_new_conversation_button");
    By txtTo = By.id("com.google.android.apps.messaging:id/recipient_text_view");
    By txtMessage = By.id("com.google.android.apps.messaging:id/compose_message_text");


    public void createNewMessageTo(String value, String message) {

        $(btnNew).click();
        $(txtTo).waitUntilVisible().sendKeys(value);

//        $(txtTo).type(value);

        Dimension elementSize = $(txtTo).getSize();
        System.out.println("chieu rong la " + elementSize.getWidth());
        System.out.println("chieu cao la " + elementSize.getHeight());

        WebElement element;
        Point point = $(txtTo).getLocation();
        System.out.println("x la: " + point.getX() + " y la: " + point.getY());
        new TouchAction((MobileDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).tap(PointOption.point(point.getX(), point.getY() * 2)).release().perform();
        getClock().pauseFor(2000);
        element(txtTo).shouldContainText(value);
        element(txtMessage).waitUntilVisible().type(message);
        element(MobileBy.AccessibilityId("Send SMS")).click();
        String cont = element(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[last()]")).getAttribute("content-desc");
        System.out.println(cont);
        Assert.assertTrue(cont.contains(message));
    }

}
