package automationScenarios;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class interactWithKeyBoard {
	public static AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:automationName", "Uiautomator2");

		//setting capabilities to unlock a locked device
		capabilities.setCapability("appium:unlockStrategy", "uiautomator");
		capabilities.setCapability("appium:unlockType", "pin");
		capabilities.setCapability("appium:unlockKey", "78963");
		capabilities.setCapability("appium:skipUnlock",false);

		//starting appium server programmatically
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();

		//initiating and managing driver instance
		driver = new AndroidDriver(service, capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void keyboardInteractions() throws InterruptedException {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));  //clicking home button
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));  //clicking recent app button
		driver.pressKey(new KeyEvent(AndroidKey.BACK));   //clicking back button
		driver.findElement(AppiumBy.id("com.google.android.apps.nexuslauncher:id/overview_actions_view")).click();
		driver.findElement(AppiumBy.id("com.google.android.apps.nexuslauncher:id/input")).sendKeys("Settings");
		driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN)); //clicking down button
		driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));//clicking Enter button
		assertTrue(driver.getCurrentPackage().equals("com.android.settings"), "failed to open the searched app");

		driver.findElement(AppiumBy.id("com.android.settings:id/search_action_bar")).click();
		driver.findElement(AppiumBy.id("com.google.android.settings.intelligence:id/open_search_view_edit_text")).clear();
		driver.findElement(AppiumBy.id("com.google.android.settings.intelligence:id/open_search_view_edit_text")).sendKeys("Wifi");

		if(driver.isKeyboardShown()) { //checking if keyboard is showing or not
			driver.hideKeyboard();  //hides the keyboard
			System.out.println("We have hide the keyboard");
			Thread.sleep(3000);
			driver.terminateApp("com.android.settings");

		}
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

	@AfterClass
	public void tearDown() {
		//driver.lockDevice();
	}
}
