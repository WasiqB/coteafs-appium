package com.github.wasiqb.coteafs.appium.android;

import com.github.wasiqb.coteafs.appium.device.Device;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 5:32:01 PM
 */
public class AndroidDevice extends Device <AndroidDriver <MobileElement>> {
	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:12:47 PM
	 * @param server
	 * @param name
	 */
	public AndroidDevice (final AppiumServer server, final String name) {
		super (server, name);
	}
}