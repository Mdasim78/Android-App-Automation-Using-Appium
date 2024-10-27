package automationScenarios;

import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Test {
public static void main(String[] args) {

	AppiumDriver driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appium:deviceName", "sdk_gphone64_x86_64");
	capabilities.setCapability("appium:automationName", "Uiautomator2");
	capabilities.setCapability("appium:appPackage", "com.google.android.contacts");
	capabilities.setCapability("appium:appActivity", "com.android.contacts.activities.PeopleActivity");

///aded new changes in new-test-scenarios
	//starting appium server
	AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
    service.start();

	driver = new AndroidDriver(service.getUrl(), capabilities);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));




}
}
