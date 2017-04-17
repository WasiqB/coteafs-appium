package com.github.wasiqb.coteafs.appium.android;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
	protected AndroidDevice					androidDevice;
	protected AppiumServer					androidServer;
	private AndroidDriver <AndroidElement>	driver;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 10:10:45 PM
	 */
	@BeforeSuite (alwaysRun = true)
	public void setupTestSuite () {
		final StringBuilder path = new StringBuilder (System.getProperty ("user.dir"));
		path.append (System.getProperty ("file.separator"))
			.append ("src")
			.append (System.getProperty ("file.separator"))
			.append ("test")
			.append (System.getProperty ("file.separator"))
			.append ("resources")
			.append (System.getProperty ("file.separator"))
			.append (System.getProperty ("coteafs.appium.config", "test-config.yaml"));

		ConfigLoader.load (path.toString ());
		this.androidServer = new AppiumServer ("android");
		this.androidServer.start ();

		this.androidDevice = new AndroidDevice (this.androidServer, "android");
		this.androidDevice.start ();
		this.driver = this.androidDevice.getAndroidDevice ();
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
	@Test
	public void test1 () {
		final String curr = this.driver.getContext ();
		System.out.println (curr);
		String xpath = "//android.widget.ViewAnimator[@resource-id='com.corfire.cwp.app:id/pageContainer']/";
		xpath += "android.widget.FrameLayout/";
		xpath += "android.widget.LinearLayout[2]/";
		final String nextLink = xpath + "android.widget.ImageView";
		AndroidElement content = this.driver.findElementByXPath (nextLink);
		content.tap (1, 1);
		content = this.driver.findElementByXPath (nextLink);
		content.tap (1, 1);
		content = this.driver.findElementByXPath (nextLink);
		content.tap (1, 1);
		content = this.driver.findElementByXPath (nextLink);
		content.tap (1, 1);

	}
}