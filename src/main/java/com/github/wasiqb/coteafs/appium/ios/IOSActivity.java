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

import static com.github.wasiqb.coteafs.appium.utils.BatteryHealth.check;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.appium.config.enums.DeviceType;
import com.github.wasiqb.coteafs.appium.device.DeviceActivity;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSBatteryInfo;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 7:41:49 PM
 */
public abstract class IOSActivity
	extends DeviceActivity <IOSDriver <MobileElement>, IOSDevice, IOSTouchAction> {
	private static final Logger log = LogManager.getLogger (IOSActivity.class);

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 7:42:13 PM
	 * @param device
	 */
	public IOSActivity (final IOSDevice device) {
		super (device, new IOSTouchAction (device.getDriver ()));
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onDevice()
	 */
	@Override
	public IOSDeviceActions onDevice () {
		checkBattery ();
		log.trace ("Preparing to perform actions on iOS device...");
		return new IOSDeviceActions (this.device);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.github.wasiqb.coteafs.appium.device.DeviceActivity#onElement(java.lang.
	 * String)
	 */
	@Override
	public IOSDeviceElementActions onElement (final String name) {
		checkBattery ();
		log.trace ("Preparing to perform actions on iOS device element [{}]...", name);
		return new IOSDeviceElementActions (this.device, name, getElement (name));
	}

	private void checkBattery () {
		final IOSBatteryInfo battery = this.device.getDriver ()
			.getBatteryInfo ();
		if (!this.device.getSetting ()
			.isCloudApp ()
			&& this.device.getSetting ()
				.getDeviceType () == DeviceType.REAL) {
			check (battery.getState ()
				.name (), battery.getLevel ());
		}
	}
}