package com.github.wasiqb.coteafs.appium.ios;

import com.github.wasiqb.coteafs.appium.device.Device;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 5:33:35 PM
 */
public class IOSDevice extends Device <IOSDriver <MobileElement>> {
	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:12:09 PM
	 * @param server
	 * @param name
	 */
	public IOSDevice (final AppiumServer server, final String name) {
		super (server, name);
	}
}