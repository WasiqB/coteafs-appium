package com.github.wasiqb.coteafs.appium.android;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.android.controls.AndroidElement;
import com.github.wasiqb.coteafs.appium.android.controls.FindBy;
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
	 * @since 25-Apr-2017 7:58:40 PM
	 */
	@Test
	public void test0 () {
		final AndroidElement walk = AndroidElement.create ("Container")
			.using (FindBy.ID)
			.withLocator ("com.corfire.cwp.app:id/pageContainer");
		final AndroidElement frame = AndroidElement.create ("FrameLayout")
			.using (FindBy.CLASS_NAME)
			.withLocator ("android.widget.FrameLayout")
			.parent (walk);
		final AndroidElement linear = AndroidElement.create ("LinearLayout")
			.using (FindBy.CLASS_NAME)
			.withLocator ("android.widget.LinearLayout")
			.index (2)
			.parent (frame);
		AndroidElement.create ("Next")
			.using (FindBy.CLASS_NAME)
			.withLocator ("android.widget.ImageView")
			.parent (linear);
		System.out.println (walk);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 8:09:21 PM
	 */
	@Test (description = "Click next")
	public void test1 () {
		final MobileElement container = this.driver.findElement (By.id ("com.corfire.cwp.app:id/pageContainer"));
		final MobileElement frame = container.findElement (By.className ("android.widget.FrameLayout"));
		final MobileElement linear = frame.findElements (By.className ("android.widget.LinearLayout"))
			.get (2);
		final MobileElement next = linear.findElement (By.className ("android.widget.ImageView"));
		next.tap (1, 100);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 9:37:50 PM
	 */
	@Test (description = "Click on Skip")
	public void test2 () {
		final MobileElement container = this.driver.findElement (By.id ("com.corfire.cwp.app:id/pageContainer"));
		final MobileElement frame = container.findElement (By.className ("android.widget.FrameLayout"));
		final MobileElement linear = frame.findElements (By.className ("android.widget.LinearLayout"))
			.get (0);
		final MobileElement skip = linear.findElements (By.className ("android.widget.TextView"))
			.get (2);
		skip.tap (1, 100);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 9:45:31 PM
	 */
	@Test (description = "Login to App")
	public void test3 () {
		this.wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("email-username")));

		final MobileElement webkit = this.driver.findElement (By.className ("android.webkit.WebView"));
		final MobileElement loginView = webkit.findElements (By.className ("android.view.View"))
			.get (0);

		final MobileElement userId = loginView.findElement (By.id ("email-username"));
		userId.tap (1, 100);
		userId.clear ();
		userId.sendKeys ("mozido4");

		final MobileElement password = loginView.findElement (By.id ("password"));
		password.tap (1, 100);
		password.clear ();
		password.sendKeys ("password1");

		loginView.tap (1, 100);

		final MobileElement signIn = loginView.findElement (By.id ("login-button"));
		signIn.tap (1, 100);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-Apr-2017 11:15:28 PM
	 */
	@Test
	public void test4 () {
		this.wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("com.corfire.cwp.app:id/frmActionBar")));
		final MobileElement studentId = this.driver.findElement (By.id ("com.corfire.cwp.app:id/btnStudentId"));
		studentId.tap (1, 100);
	}
}