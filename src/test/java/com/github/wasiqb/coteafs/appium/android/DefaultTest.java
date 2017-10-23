package com.github.wasiqb.coteafs.appium.android;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
	protected AndroidDevice	androidDevice;
	private AppiumServer	androidServer;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 10:10:45 PM
	 */
	@BeforeSuite (alwaysRun = true)
	public void setupTestSuite () {
		this.androidServer = new AppiumServer ("android");
		this.androidServer.start ();

		this.androidDevice = new AndroidDevice (this.androidServer, "test");
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
}