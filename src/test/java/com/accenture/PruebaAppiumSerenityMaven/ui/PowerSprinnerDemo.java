package com.accenture.PruebaAppiumSerenityMaven.ui;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PowerSprinnerDemo extends UIInteractionSteps {

    /*
    có 2 cách để khai báo 1 kiểu by cho element
    kiểu 1 là khai báo By bình thường như cho web
    kiểu 2 là khai báo riêng cho mobile app
     */
    By ChooseAnItem = By.id("com.skydoves.powerspinnerdemo:id/spinnerView2");
//    By ChooseAnItem2 = MobileBy.AndroidUIAutomator("");


    public void clickToDropdownMenu() {
        /*
        có 4 cách gọi lại 1 element
        - kiểu 1 là dùng kiểu truyền thống là dùng driver.findBy..... và click
        - kiểu số 2, dùng $() , kết hợp với chờ cho nó visiable với số giây timeout mong muốn, sau đó click
        - kiểu số 3 thì dùng element(By)
        - kiểu số 4 thì dùng find(By)

         */

//        getDriver().findElement(ChooseAnItem).click();
        $(ChooseAnItem).withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().click();
//        element(ChooseAnItem).waitUntilVisible().click();
//        find(ChooseAnItem).waitUntilEnabled().click();


    }

    public void chooseValueIndex(int index) {
        WebElement element;
        Dimension size = element(ChooseAnItem).getSize();

        System.out.println("=>>>>>> size of element width is " + size.getWidth() + " height " + size.getHeight());

        Point point = element(ChooseAnItem).getLocation();

        System.out.println("=>>>>>> point of element x is " + point.getX() + "and Y: " + point.getY());
//        541 + 115 + (115 / 2) =
        int y = point.getY() + size.getHeight() + (size.getHeight() / 2 + (size.getHeight() * index));
        int x = point.getX() * 2;

        new TouchAction((MobileDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).tap(PointOption.point(x, y)).release().perform();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String txt = element(ChooseAnItem).getText();
        System.out.println("current value of dropdown is: " + txt);
        Assert.assertTrue(txt.contains("Item" + index));

    }


}
