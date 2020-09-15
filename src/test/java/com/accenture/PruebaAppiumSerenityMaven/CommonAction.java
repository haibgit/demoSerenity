package com.accenture.PruebaAppiumSerenityMaven;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CommonAction  {

    public static void swipeDownByPercent(double start, double end, int percent) {
        WebDriver facade = getDriver();
        WebDriver driver= ((WebDriverFacade) getDriver()).getProxiedDriver();
//        TouchAction actions = new TouchAction((MobileDriver)driver) ;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Dimension dimens = driver.manage().window().getSize();
        int x = (int) (dimens.getWidth() / percent);
        int startY = (int) (dimens.getHeight() * start);
        int endY = (int) (dimens.getHeight() * end);
        System.out.println("toa do diem bat dau: ( " + x + "," + startY + ")");
        System.out.println("toa do diem ket thuc: ( " + x + "," + endY + ")");
        System.out.println("chieu rong man hinh la: " + dimens.getWidth());
        System.out.println("chieu cao man hinh la: " + dimens.getHeight());
        new TouchAction((MobileDriver)driver).press(PointOption.point(x, startY)).waitAction(waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(x, endY)).release().perform();

    }
}
