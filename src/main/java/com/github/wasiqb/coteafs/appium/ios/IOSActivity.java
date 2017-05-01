package com.github.wasiqb.coteafs.appium.ios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.appium.device.DeviceActivity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 7:41:49 PM
 */
public abstract class IOSActivity extends DeviceActivity <IOSDriver <MobileElement>, IOSDevice> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (IOSActivity.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 7:42:13 PM
	 * @param device
	 */
	public IOSActivity (final IOSDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onDevice()
	 */
	@Override
	public IOSDeviceActions onDevice () {
		log.info ("Preparing to perform actions on iOS device...");
		return new IOSDeviceActions (this.device.getDriver ());
	}
}