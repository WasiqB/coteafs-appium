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
package com.github.wasiqb.coteafs.appium.windows;

import com.github.wasiqb.coteafs.appium.device.DeviceElementVerify;

import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;

/**
 * @author wasiq.bhamla
 * @since Oct 14, 2017 7:19:28 PM
 */
public class WindowsElementVerify extends DeviceElementVerify <WindowsDriver <MobileElement>, WindowsDevice> {
	/**
	 * @author wasiq.bhamla
	 * @since Oct 14, 2017 7:20:15 PM
	 * @param actions
	 */
	public WindowsElementVerify (final WindowsDeviceElementActions actions) {
		super (actions);
	}
}