package com.github.wasiqb.coteafs.appium.ios;

import com.github.wasiqb.coteafs.appium.device.DeviceElementVerify;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 20-May-2017 12:29:27 PM
 */
public class IOSElementVerify extends DeviceElementVerify <IOSDriver <MobileElement>, IOSDevice> {
	/**
	 * @author wasiq.bhamla
	 * @since 20-May-2017 12:31:51 PM
	 * @param actions
	 */
	public IOSElementVerify (final IOSDeviceElementActions actions) {
		super (actions);
	}
}