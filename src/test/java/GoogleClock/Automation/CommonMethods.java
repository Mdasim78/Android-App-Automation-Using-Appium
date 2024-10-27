package GoogleClock.Automation;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class CommonMethods {
	public static void Swipe(AppiumDriver driver,Point start,Point end) {
	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	//Point start = new Point(554, 1770);
	//Point end = new Point (599, 1371);
	Sequence swipe = new Sequence(finger, 1);
	swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
		    PointerInput.Origin.viewport(), start.getX(), start.getY()));
	swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
		    PointerInput.Origin.viewport(), end.getX(), end.getY()));
	swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	driver.perform(Arrays.asList(swipe));
	}
}
