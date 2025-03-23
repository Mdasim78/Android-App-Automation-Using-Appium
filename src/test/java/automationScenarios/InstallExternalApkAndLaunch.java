package automationScenarios;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class InstallExternalApkAndLaunch {
	static AndroidDriver driver;

	@BeforeTest
	public void SetUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:app", System.getProperty("user.dir")+"/src/test/resources/TapTap-v1.6.1.apk");
		caps.setCapability("appium:autoGrantPermissions", true); //grant all permissions

		//starting appium server programmatically
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		serviceBuilder.usingAnyFreePort();
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(serviceBuilder);
		service.start();
		System.out.println(service.getUrl());

		//initiating and managing driver instance
		driver = new AndroidDriver(service, caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void clickApp() {
		driver.findElement(By.id("com.kieronquinn.app.taptap:id/setup_landing_skip_setup")).click();


	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
