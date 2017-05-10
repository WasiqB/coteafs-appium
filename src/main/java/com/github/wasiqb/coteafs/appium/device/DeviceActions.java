package com.github.wasiqb.coteafs.appium.device;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @param <TDevice>
 * @since 26-Apr-2017 8:39:17 PM
 */
public class DeviceActions <TDriver extends AppiumDriver <MobileElement>, TDevice extends Device <TDriver>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceActions.class);
	}

	protected final TDevice			device;
	protected final TDriver			driver;
	protected final WebDriverWait	wait;

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @since 26-Apr-2017 8:39:17 PM
	 */
	public DeviceActions (final TDevice device) {
		this.device = device;
		this.driver = this.device.getDriver ();
		this.wait = new WebDriverWait (this.driver, device.setting.getWaitForElementUntil ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 01-May-2017 8:24:34 PM
	 * @param path
	 */
	public void captureScreenshot (final String path) {
		final String msg = "Capturing screenshot and saving at [%s]...";
		log.info (String.format (msg, path));
		final File srcFiler = ((TakesScreenshot) this.driver).getScreenshotAs (OutputType.FILE);
		try {
			FileUtils.copyFile (srcFiler, new File (path));
		}
		catch (final IOException e) {
			log.error ("Error occurred while capturing screensshot...");
			log.catching (e);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:34:05 PM
	 */
	public void hideKeyboard () {
		log.info ("Hiding the keyboard...");
		this.driver.hideKeyboard ();
	}
}