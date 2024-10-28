package automationScenarios;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DifferentGestures {
	public static AndroidDriver driver;

	 @BeforeClass
	  public void beforeClass() {
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	  }

  //one finger gestures like tap,long tap,swipe up/down/left/right
  public void oneFingerGesture(Point p1, Point p2,Duration duration) {
	  PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
	  Sequence swipe = new Sequence(finger, 1);
	  swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), p1));
	  swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	  swipe.addAction(finger.createPointerMove(duration, Origin.viewport(), p2));
	  swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	  driver.perform(Arrays.asList(swipe));
  }

  //drag and drop method
  public void dragAndDrop(Point p1, Point p2,Duration duration) {
	  PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
	  Sequence dragAndDrop = new Sequence(finger, 1);
	  dragAndDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), p1));
	  dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	  dragAndDrop.addAction(finger.createPointerMove(Duration.ofSeconds(2), Origin.viewport(), p1));
	  dragAndDrop.addAction(finger.createPointerMove(duration, Origin.viewport(), p2));
	  dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	  driver.perform(Arrays.asList(dragAndDrop));
  }

  //two finger gestures like zoom in and zoom out
  public void twoFingerGesture(Point p1,Point p2,Point p3,Point p4,Duration duration) {
	  PointerInput finger1 = new PointerInput(Kind.TOUCH, "finger1");
	  Sequence swipe1 = new Sequence(finger1, 0);
	  swipe1.addAction(finger1.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), p1));
	  swipe1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	  swipe1.addAction(finger1.createPointerMove(duration, Origin.viewport(), p2));
	  swipe1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	  PointerInput finger2 = new PointerInput(Kind.TOUCH, "finger2");
	  Sequence swipe2 = new Sequence(finger2, 0);
	  swipe2.addAction(finger2.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), p3));
	  swipe2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	  swipe2.addAction(finger2.createPointerMove(duration, Origin.viewport(), p4));
	  swipe2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	  driver.perform(Arrays.asList(swipe1,swipe2));

  }

  //finding center point of element to perform action on that element
  public Point findCenter(WebElement element) {
	  Point center = new Point(element.getLocation().getX()+element.getRect().getWidth()/2,element.getLocation().getY()+element.getRect().getHeight()/2);
	  return center;
  }

  @Test
  public void performGestures() throws InterruptedException {

	  driver.activateApp("com.google.android.apps.photos");
	  driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Photo taken on Oct 12, 2024 1:48 PM\"]")).click();
	  Thread.sleep(2000);
	  //performing zoom in gesture
	  twoFingerGesture(new Point(440, 1025), new Point(150, 1812), new Point(660, 885), new Point(970, 450), Duration.ofMillis(500));

	  driver.openNotifications();
	  Thread.sleep(3000);
	 //perform swipe down gestures
	  oneFingerGesture(new Point(600, 300), new Point(600, 1800), Duration.ofMillis(100));
	  WebElement brightnessValue = driver.findElement(AppiumBy.id("com.android.systemui:id/slider"));
	 //performing seek bar operation
	  if(Float.parseFloat(brightnessValue.getText())>30500.0f) {
		oneFingerGesture(findCenter(brightnessValue), findCenter(brightnessValue).moveBy(-400, 0), Duration.ofMillis(400));
	}


	  driver.findElement(AppiumBy.accessibilityId("Edit order of settings.")).click();
	 //performing scroll
	  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
	  		+ ".scrollIntoView(new UiSelector().text(\"Font size\"))")).click();
	 //performing drag and drop
	  dragAndDrop(findCenter(driver.findElement(AppiumBy.accessibilityId("Font size"))), new Point(800,700), Duration.ofMillis(500));
	  Thread.sleep(3000);
	  driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"RESET\")")).click();
	  driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
	  WebElement bluetoothQsIcon = driver.findElement(AppiumBy.accessibilityId("Bluetooth."));
	 //perform longpress
	  oneFingerGesture(findCenter(bluetoothQsIcon), findCenter(bluetoothQsIcon), Duration.ofMillis(1000));

	   }

  @AfterClass
  public void afterClass() {
  }

}
