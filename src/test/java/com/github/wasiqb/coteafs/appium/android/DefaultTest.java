package com.github.wasiqb.coteafs.appium.android;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.android.activities.LoginActivity;
import com.github.wasiqb.coteafs.appium.android.activities.WalkThruActivity2;
import com.github.wasiqb.coteafs.appium.android.activities.WalkthruActivity1;
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
		this.androidServer = new AppiumServer ("default");
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
		final WalkthruActivity1 walk = new WalkthruActivity1 (this.androidDevice);
		walk.onElement ("Next")
			.tap (100);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 9:37:50 PM
	 */
	@Test (description = "Click on Skip")
	public void test2 () {
		final WalkThruActivity2 walk = new WalkThruActivity2 (this.androidDevice);
		walk.onElement ("Skip")
			.tap (100);
		walk.onDevice ()
			.handlePermissionAlert ("Allow");
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 9:45:31 PM
	 */
	@Test (description = "Login to App")
	public void test3 () {
		final LoginActivity login = new LoginActivity (this.androidDevice);
		login.onElement ("userName")
			.enterText ("user_id_1");
		login.onElement ("password")
			.enterText ("password_1");
		login.onDevice ()
			.hideKeyboard ();
		login.onElement ("login")
			.tap (100);
	}
}