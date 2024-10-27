package GoogleClock.Automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;

public class ClockAppAutomationFunc {
	static AppiumDriver driver;
	
	@BeforeClass
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "Uiautomator2");
		caps.setCapability("appium:packageName", "com.google.android.documentsui");
		caps.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void setAlarm() {
		CommonMethods.Swipe(driver, new Point(554, 1770), new Point (599, 1371));
		driver.findElement(ByAccessibilityId.accessibilityId("Clock")).click();
		ClockElements CE = new ClockElements();
		
		
		driver.findElement(ByAccessibilityId.accessibilityId(CE.alaramIconEle_accesId)).click();
		driver.findElement(ByAccessibilityId.accessibilityId(CE.addAlarmEle_accesId)).click();
		try {
			driver.findElement(By.id(CE.AlarmTimePickerEle_id)).isDisplayed();
		}
		catch (Exception e) {
			driver.findElement(By.id(CE.AlarmTxtInpSwitcherEle_id)).click();
		}
		driver.findElement(By.xpath(CE.txtSelctTimeHrEle_xpath)).clear();
		driver.findElement(By.xpath(CE.txtSelctTimeHrEle_xpath)).sendKeys("04");
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'minutes')]")).click();
		driver.findElement(By.xpath(CE.txtSelctTimeMinEle_xpath)).clear();
		driver.findElement(By.xpath(CE.txtSelctTimeMinEle_xpath)).sendKeys("44");
		driver.findElement(By.id(CE.txtSelctTimePMeEle_id)).click();
		driver.findElement(By.xpath(CE.txtSelctTimeOKBtn_xpath)).click();
		driver.findElement(By.id(CE.alrmCardExpndAddLabl_id)).click();
		driver.findElement(By.id(CE.alrmLablTxtField_id)).sendKeys("Test Alarm");
		driver.findElement(By.id(CE.alrmLablOkBtn_id)).click();
		driver.findElement(ByAccessibilityId.accessibilityId(CE.alrmCardExpndSelctMonDay_accesId)).click();
		driver.findElement(ByAccessibilityId.accessibilityId(CE.alrmCardExpndPauseAlrmIcon_accesId)).click();
		driver.findElement(ByAccessibilityId.accessibilityId(CE.pauseAlrmNxtMnthArrow_accesId)).click();
		driver.findElement(ByAndroidUIAutomator.androidUIAutomator(CE.pauseAlrmStrtDt_androidUIAutomator)).click();
		driver.findElement(ByAndroidUIAutomator.androidUIAutomator(CE.pauseAlrmEndDt_androidUIAutomator)).click();
		driver.findElement(By.id(CE.pauseAlrmDialogOKBtn_id)).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
