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

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;

import com.github.wasiqb.coteafs.appium.device.DeviceActions;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;

import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;

/**
 * @author wasiq.bhamla
 * @since Oct 14, 2017 7:28:05 PM
 */
public class WindowsDeviceActions extends DeviceActions <WindowsDriver <MobileElement>, WindowsDevice> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (WindowsDeviceActions.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 14, 2017 7:28:32 PM
	 * @param device
	 */
	public WindowsDeviceActions (final WindowsDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActions#hideKeyboard()
	 */
	@Override
	public void hideKeyboard () {
		log.info ("Hiding keyboard on device...");
		try {
			this.driver.hideKeyboard ();
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}
}