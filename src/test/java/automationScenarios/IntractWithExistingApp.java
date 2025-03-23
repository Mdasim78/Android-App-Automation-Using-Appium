package automationScenarios;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.flutter.android.FlutterAndroidDriver;

public class IntractWithExistingApp {

	static AppiumDriver driver;


	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "Uiautomator2");
		caps.setCapability("appium:appPackage", "com.google.android.documentsui");
		caps.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");


		driver = new FlutterAndroidDriver(new URL("http://127.0.0.1:4723/"),caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}


	@Test
	public void setAlarm() {
		final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Point start = new Point(554, 1770);
		Point end = new Point (599, 1371);
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
		    PointerInput.Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
		    PointerInput.Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));

		driver.findElement(AppiumBy.accessibilityId("Clock")).click();

		WebElement alaramIconEle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.deskclock:id/navigation_bar_item_icon_view\").instance(0)"));
		alaramIconEle.click();
		WebElement addAlarmEle = driver.findElement(AppiumBy.accessibilityId("Add alarm"));
		addAlarmEle.click();
		String AlarmTimePickerEle ="com.google.android.deskclock:id/material_timepicker_mode_button";
		String AlarmTxtInpSwitcherEle ="//android.widget.Button[@content-desc=\"Switch to text input mode for the time input.\"]";
		 try {
			 	driver.findElement(By.id(AlarmTimePickerEle)).isDisplayed();
		 }
		 catch (Exception e) {
			 driver.findElement(By.id(AlarmTxtInpSwitcherEle)).click();
		}
		WebElement hourTextEle = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.google.android.deskclock:id/material_hour_text_input']//android.widget.EditText"));
		hourTextEle.clear();
		hourTextEle.sendKeys("08");
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'minutes')]")).click();
		WebElement minTextEle = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.google.android.deskclock:id/material_minute_text_input']//android.widget.EditText"));
		minTextEle.clear();
		minTextEle.sendKeys("19");
		WebElement setAlarmOKbtnEle = driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.google.android.deskclock:id/material_timepicker_ok_button']"));
		setAlarmOKbtnEle.click();
		WebElement mondayEle = driver.findElement(AppiumBy.accessibilityId("Monday"));
		WebElement fridayEle = driver.findElement(AppiumBy.accessibilityId("Friday"));
		mondayEle.click();
		fridayEle.click();


	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
