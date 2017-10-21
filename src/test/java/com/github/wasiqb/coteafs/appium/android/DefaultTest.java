package com.github.wasiqb.coteafs.appium.android;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.android.calabashtest.activities.MainActivity;
import com.github.wasiqb.coteafs.appium.device.SwipeDirection;
import com.github.wasiqb.coteafs.appium.device.SwipeDistance;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
	private AndroidDevice	androidDevice;
	private AppiumServer	androidServer;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 10:10:45 PM
	 */
	@BeforeSuite (alwaysRun = true)
	public void setupTestSuite () {
		this.androidServer = new AppiumServer ("android");
		this.androidServer.start ();

		this.androidDevice = new AndroidDevice (this.androidServer, "android");
		this.androidDevice.start ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 3:47:41 PM
	 */
	@AfterSuite (alwaysRun = true)
	public void tearDownTestSuite () {
		if (this.androidServer != null && this.androidDevice != null) {
			this.androidDevice.stop ();
			this.androidServer.stop ();
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 8:09:21 PM
	 */
	@Test (description = "Click next")
	public void test1 () {
		final MainActivity main = new MainActivity (this.androidDevice);
		main.onDevice ()
			.hideKeyboard ();
		main.onDevice ()
			.swipe (SwipeDirection.UP, SwipeDistance.HALF);
		System.out.println ("Swipe up...");
		main.onDevice ()
			.swipe (SwipeDirection.DOWN, SwipeDistance.QUARTER);
		System.out.println ("Swipe down...");
	}
}