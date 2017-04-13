package com.github.wasiqb.coteafs.appium.test;

import org.testng.annotations.BeforeSuite;

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.ios.IosDevice;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
	protected AndroidDevice	androidDevice;
	protected AppiumServer	androidServer;
	protected IosDevice		ipadDevice;
	protected AppiumServer	ipadServer;

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
		this.ipadServer = new AppiumServer ("ipad");

		this.androidDevice = new AndroidDevice (this.androidServer, "android");
		this.ipadDevice = new IosDevice (this.ipadServer, "ipad");
	}
}