package com.github.wasiqb.coteafs.appium.android;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.android.activities.LoginActivity;
import com.github.wasiqb.coteafs.appium.android.activities.PermissionActivity;
import com.github.wasiqb.coteafs.appium.android.activities.WalkThruActivity2;
import com.github.wasiqb.coteafs.appium.android.activities.WalkthruActivity1;
import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
	private AndroidDevice					androidDevice;
	private AppiumServer					androidServer;
	private AndroidDriver <MobileElement>	driver;
	private WebDriverWait					wait;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 10:10:45 PM
	 */
	@BeforeSuite (alwaysRun = true)
	public void setupTestSuite () {
		ConfigLoader.load (System.getProperty ("coteafs.appium.config", "test-config.yaml"));
		this.androidServer = new AppiumServer ("default");
		this.androidServer.start ();

		this.androidDevice = new AndroidDevice (this.androidServer, "android");
		this.androidDevice.start ();
		this.driver = this.androidDevice.getAndroidDriver ();

		this.wait = new WebDriverWait (this.driver, 60);
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
		final WalkthruActivity1 walk = new WalkthruActivity1 (this.driver);
		walk.build ();
		walk.onElement ("Next")
			.tap (100);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 9:37:50 PM
	 */
	@Test (description = "Click on Skip")
	public void test2 () {
		final WalkThruActivity2 walk = new WalkThruActivity2 (this.driver);
		walk.build ();
		walk.onElement ("Skip")
			.tap (100);

		try {
			final PermissionActivity perm = new PermissionActivity (this.driver);
			perm.build ();
			final String msg = perm.onElement ("Message")
				.text ();
			System.out.println (msg);
			perm.onElement ("Allow")
				.tap (100);
		}
		catch (final Exception e) {
			System.err.println (e);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 9:45:31 PM
	 */
	@Test (description = "Login to App")
	public void test3 () {
		final LoginActivity login = new LoginActivity (this.driver);
		login.build ();
		login.onElement ("userName")
			.enterText ("mozido4");
		login.onElement ("password")
			.enterText ("password1");
		login.onDevice ()
			.hideKeyboard ();
		login.onElement ("login")
			.tap (100);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 11:15:28 PM
	 */
	@Test
	public void test4 () {
		this.wait.until (d -> d.findElement (By.id ("com.corfire.cwp.app:id/frmActionBar"))
			.isDisplayed ());
		final MobileElement studentId = this.driver.findElement (By.id ("com.corfire.cwp.app:id/btnStudentId"));
		studentId.tap (1, 100);
	}
}