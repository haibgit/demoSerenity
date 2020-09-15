package com.accenture.PruebaAppiumSerenityMaven.ui;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class CalculadoraUI1 extends UIInteractionSteps {
	
	
	public void demo() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		getDriver().findElement(By.xpath("//android.widget.Button[@text='9']")).click();

//		getDriver().findElement(MobileBy.AndroidUIAutomator("text(\"9\")")).click();

//		getDriver().findElement(By.id("com.android.calculator2:id/digit_9")).click();



		$(HomePage.num9).waitUntilVisible().click();



	}

	public void hello() {
		System.out.println("hello");
	}
}