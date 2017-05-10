package com.github.wasiqb.coteafs.appium.ios;

import com.github.wasiqb.coteafs.appium.device.DeviceElementActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 02-May-2017 6:37:57 PM
 */
public class IOSDeviceElementActions extends DeviceElementActions <IOSDriver <MobileElement>, IOSDevice> {
	/**
	 * @author wasiq.bhamla
	 * @since 02-May-2017 6:38:12 PM
	 * @param device
	 * @param name
	 * @param element
	 */
	public IOSDeviceElementActions (final IOSDevice device, final String name, final MobileElement element) {
		super (device, name, element);
	}
}