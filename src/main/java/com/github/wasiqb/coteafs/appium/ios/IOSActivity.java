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
		return new IOSDeviceActions (this.device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onElement(java.lang.String)
	 */
	@Override
	public IOSDeviceElementActions onElement (final String name) {
		String msg = "Preparing to perform actions on iOS device element [%s]...";
		log.info (String.format (msg, name));
		return new IOSDeviceElementActions (this.device, name, getElement (name));
	}
}