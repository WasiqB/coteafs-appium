package com.github.wasiqb.coteafs.appium.device;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @since 26-Apr-2017 8:39:17 PM
 */
public class DeviceActions <TDriver extends AppiumDriver <MobileElement>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceActions.class);
	}

	protected final TDriver			driver;
	protected final WebDriverWait	wait;

	/**
	 * @author wasiq.bhamla
	 * @param driver
	 * @since 26-Apr-2017 8:39:17 PM
	 */
	public DeviceActions (final TDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (driver, 30);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:34:05 PM
	 */
	public void hideKeyboard () {
		log.info ("Hiding the keyboard...");
		this.driver.hideKeyboard ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:30:53 PM
	 * @param by
	 */
	public void tap (final By by) {
		log.info (String.format ("Tapping on %s...", by));
		this.wait.until (ExpectedConditions.visibilityOfElementLocated (by));
		try {
			final MobileElement element = this.driver.findElement (by);
			this.driver.tap (1, element, 100);
		}
		catch (final Exception e) {
			log.info ("Expected element not found so continuing...");
			log.catching (e);
			return;
		}
	}
}