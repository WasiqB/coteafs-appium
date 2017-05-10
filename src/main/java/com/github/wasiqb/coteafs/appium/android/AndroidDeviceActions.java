package com.github.wasiqb.coteafs.appium.android;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.github.wasiqb.coteafs.appium.device.DeviceActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 9:05:27 PM
 */
public class AndroidDeviceActions extends DeviceActions <AndroidDriver <MobileElement>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (AndroidDeviceActions.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:05:43 PM
	 * @param driver
	 */
	public AndroidDeviceActions (final AndroidDriver <MobileElement> driver) {
		super (driver);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:09:43 PM
	 * @return activity
	 */
	public String currentActivity () {
		log.info ("Getting current activity name...");
		return this.driver.currentActivity ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 9:14:16 PM
	 * @param buttonText
	 */
	public void handleAlert (final String buttonText) {
		log.trace ("Handling iOS Alert pop-up...");
		final By dialog = By.id ("com.android.packageinstaller:id/dialog_container");
		final By desc = By.className ("android.widget.TextView");
		final By button = By.name (buttonText);
		try {
			final WebElement alert = this.wait.until (d -> d.findElement (dialog));
			final WebElement description = alert.findElement (desc);
			final String msg = "Alert Text: %s";
			log.trace (String.format (msg, description.getText ()));
			final WebElement btn = alert.findElement (button);
			btn.click ();
		}
		catch (final TimeoutException e) {
			log.warn ("Expecting Alert not displayed...");
			log.warn (e.getMessage ());
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:35 PM
	 * @return isLocked
	 */
	public boolean isLocked () {
		log.info ("Checking if device is locked...");
		return this.driver.isLocked ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:45 PM
	 */
	public void lock () {
		log.info ("Locking the Android device...");
		this.driver.lockDevice ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:52 PM
	 */
	public void unlock () {
		log.info ("Unlocking the Android device...");
		this.driver.unlockDevice ();
	}
}