package com.github.wasiqb.coteafs.appium.ios;

import com.github.wasiqb.coteafs.appium.device.DeviceActivity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 7:41:49 PM
 */
public abstract class IosActivity extends DeviceActivity <IOSDriver <MobileElement>> {
	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 7:42:13 PM
	 * @param driver
	 */
	public IosActivity (final IOSDriver <MobileElement> driver) {
		super (driver);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onDevice()
	 */
	@Override
	public IosDeviceActions onDevice () {
		return new IosDeviceActions (this.driver);
	}
}