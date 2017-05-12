package com.github.wasiqb.coteafs.appium.ios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;

import com.github.wasiqb.coteafs.appium.device.DeviceActions;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerStoppedException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 11:34:39 PM
 */
public class IOSDeviceActions extends DeviceActions <IOSDriver <MobileElement>, IOSDevice> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (IOSDeviceActions.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:34:58 PM
	 * @param device
	 */
	public IOSDeviceActions (final IOSDevice device) {
		super (device);
	}

	/**
	 * @author wasiq.bhamla
	 * @return message
	 * @since 09-May-2017 8:46:51 PM
	 */
	public String handleAlert () {
		log.trace ("Handling iOS Alert pop-up...");
		try {
			final Alert alert = this.wait.until (d -> d.switchTo ()
				.alert ());
			final String description = alert.getText ();
			final String msg = "Alert Text: %s";
			log.trace (String.format (msg, description));
			alert.accept ();
			return description;
		}
		catch (final TimeoutException e) {
			log.warn ("Expecting Alert not displayed...");
			log.warn (e.getMessage ());
		}
		catch (final NoSuchSessionException e) {
			throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
		}
		return null;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 3:21:20 PM
	 * @param strategy
	 * @param keyName
	 */
	public void hideKeyboard (final String strategy, final String keyName) {
		final String msg = "Hiding keyboard on device using %s strategy for key %s...";
		log.info (String.format (msg, strategy, keyName));
		try {
			this.driver.hideKeyboard (strategy, keyName);
		}
		catch (final NoSuchSessionException e) {
			throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:37:04 PM
	 */
	public void shake () {
		log.info ("Shaking the device...");
		try {
			this.driver.shake ();
		}
		catch (final NoSuchSessionException e) {
			throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
		}
	}
}