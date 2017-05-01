package com.github.wasiqb.coteafs.appium.android;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.appium.device.DeviceActivity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 6:19:46 PM
 */
public abstract class AndroidActivity extends DeviceActivity <AndroidDriver <MobileElement>, AndroidDevice> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (AndroidActivity.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 6:20:08 PM
	 * @param device
	 */
	public AndroidActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onDevice()
	 */
	@Override
	public AndroidDeviceActions onDevice () {
		log.info ("Preparing to perform actions on Android device...");
		return new AndroidDeviceActions (this.device.getDriver ());
	}
}