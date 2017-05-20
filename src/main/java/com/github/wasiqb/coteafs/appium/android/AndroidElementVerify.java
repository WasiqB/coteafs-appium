package com.github.wasiqb.coteafs.appium.android;

import com.github.wasiqb.coteafs.appium.device.DeviceElementVerify;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 20-May-2017 12:26:00 PM
 */
public class AndroidElementVerify extends DeviceElementVerify <AndroidDriver <MobileElement>, AndroidDevice> {
	/**
	 * @author wasiq.bhamla
	 * @since 20-May-2017 12:26:38 PM
	 * @param actions
	 */
	public AndroidElementVerify (final AndroidDeviceElementActions actions) {
		super (actions);
	}
}