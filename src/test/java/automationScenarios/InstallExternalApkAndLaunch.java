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


public class InstallExternalApkAndLaunch {
	static AndroidDriver driver;

	@BeforeTest
	public void SetUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:app", System.getProperty("user.dir")+"/src/test/resources/TapTap-v1.6.1.apk");
		caps.setCapability("appium:autoGrantPermissions", true); //grant all permissions

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
