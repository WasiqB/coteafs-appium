package com.github.wasiqb.coteafs.appium.ios;

import com.github.wasiqb.coteafs.appium.device.DeviceActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 11:34:39 PM
 */
public class IosDeviceActions extends DeviceActions <IOSDriver <MobileElement>> {
	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:34:58 PM
	 * @param driver
	 */
	public IosDeviceActions (final IOSDriver <MobileElement> driver) {
		super (driver);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:37:04 PM
	 */
	public void shake () {
		this.driver.shake ();
	}
}