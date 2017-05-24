/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
		return new AndroidDeviceActions (this.device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onElement(java.lang.String)
	 */
	@Override
	public AndroidDeviceElementActions onElement (final String name) {
		final String msg = "Preparing to perform actions on Android device element %s...";
		log.info (String.format (msg, name));
		return new AndroidDeviceElementActions (this.device, name, getElement (name));
	}
}