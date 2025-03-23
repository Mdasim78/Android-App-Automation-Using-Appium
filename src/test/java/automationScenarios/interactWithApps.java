package automationScenarios;



import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.bidi.module.Input;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class interactWithApps {
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
	public void appInteractions() throws InterruptedException {
		String taptapAppId ="com.kieronquinn.app.taptap";

		//installs app using apk file present in windows pc and optionally autogranted permissions
		driver.installApp(System.getProperty("user.dir")+"/src/test/resources/TapTap-v1.6.1.apk",
				new AndroidInstallApplicationOptions().withGrantPermissionsEnabled());

		//checks if app is installed or not
		System.out.println("Tap tap app is installed :------------->  "+driver.isAppInstalled(taptapAppId));

		//Activates the given application or launches it if necessary. The action literally simulates clicking the corresponding application icon on the dashboard
		driver.activateApp(taptapAppId);
		Thread.sleep(5000);
		//running the app in background
		driver.runAppInBackground(Duration.ofSeconds(5));

		//Terminates the app
		driver.terminateApp(taptapAppId);

		//Remove the corresponding application if is installed. The call is ignored if the app is not installed.
		driver.removeApp(taptapAppId);

		//checking if the application got removed or not
		System.out.println("Tap tap app is uninstalled :------------->  "+!driver.isAppInstalled(taptapAppId));


//		driver.openNotifications();
//		driver.lockDevice();
//		driver.unlockDevice();


	}

	@AfterClass
	public void tearDown() {
		driver.lockDevice();
	}
}
