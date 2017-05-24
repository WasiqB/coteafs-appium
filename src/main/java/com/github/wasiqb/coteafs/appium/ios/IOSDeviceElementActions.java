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

import com.github.wasiqb.coteafs.appium.device.DeviceElementActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author wasiq.bhamla
 * @since 02-May-2017 6:37:57 PM
 */
public class IOSDeviceElementActions extends DeviceElementActions <IOSDriver <MobileElement>, IOSDevice> {
	/**
	 * @author wasiq.bhamla
	 * @since 02-May-2017 6:38:12 PM
	 * @param device
	 * @param name
	 * @param element
	 */
	public IOSDeviceElementActions (final IOSDevice device, final String name, final MobileElement element) {
		super (device, name, element);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#verifyThat()
	 */
	@Override
	public IOSElementVerify verifyThat () {
		return new IOSElementVerify (this);
	}
}