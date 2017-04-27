package com.github.wasiqb.coteafs.appium.android;

import com.github.wasiqb.coteafs.appium.device.DeviceActivity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 6:19:46 PM
 */
public abstract class AndroidActivity extends DeviceActivity <AndroidDriver <MobileElement>> {
	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 6:20:08 PM
	 * @param driver
	 */
	public AndroidActivity (final AndroidDriver <MobileElement> driver) {
		super (driver);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onDevice()
	 */
	@Override
	public AndroidDeviceActions onDevice () {
		return new AndroidDeviceActions (this.driver);
	}
}