package com.github.wasiqb.coteafs.appium.config;

import io.appium.java_client.remote.MobilePlatform;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:34:59 PM
 */
public enum DeviceType {
	/**
	 * Android Device.
	 */
	ANDROID (MobilePlatform.ANDROID),
	/**
	 * iOS Device.
	 */
	IOS (MobilePlatform.IOS),
	/**
	 * Windows Device.
	 */
	WINDOWS (MobilePlatform.WINDOWS);

	private final String name;

	private DeviceType (final String name) {
		this.name = name;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 24-Apr-2017 9:17:44 PM
	 * @return the name
	 */
	public String getName () {
		return this.name;
	}
}