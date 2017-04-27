package com.github.wasiqb.coteafs.appium.android;

import com.github.wasiqb.coteafs.appium.device.DeviceActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 9:05:27 PM
 */
public class AndroidDeviceActions extends DeviceActions <AndroidDriver <MobileElement>> {
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
		return this.driver.currentActivity ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:35 PM
	 * @return isLocked
	 */
	public boolean isLocked () {
		return this.driver.isLocked ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:45 PM
	 */
	public void lock () {
		this.driver.lockDevice ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:52 PM
	 */
	public void unlock () {
		this.driver.unlockDevice ();
	}
}