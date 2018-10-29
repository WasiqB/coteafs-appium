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

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static java.lang.String.format;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;

import com.github.wasiqb.coteafs.appium.device.DeviceActions;
import com.github.wasiqb.coteafs.appium.device.SwipeDirection;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 11:34:39 PM
 */
public class IOSDeviceActions
	extends DeviceActions <IOSDriver <MobileElement>, IOSDevice, IOSTouchAction> {
	private static final Logger log = LogManager.getLogger (IOSDeviceActions.class);

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:34:58 PM
	 * @param device
	 */
	public IOSDeviceActions (final IOSDevice device) {
		super (device, new IOSTouchAction (device.getDriver ()));
	}

	/**
	 * @author wasiq.bhamla
	 * @return message
	 * @since 09-May-2017 8:46:51 PM
	 */
	public String handleAlert () {
		log.trace ("Handling iOS Alert pop-up...");
		try {
			final Alert alert = this.wait.until (d -> d.switchTo ()
				.alert ());
			final String description = alert.getText ();
			final String msg = "Alert Text: [%s]";
			log.info (format (msg, description));
			alert.accept ();
			return description;
		}
		catch (final TimeoutException e) {
			log.warn ("Expecting Alert not displayed...");
			log.warn (e.getMessage ());
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActions#hideKeyboard()
	 */
	@Override
	public void hideKeyboard () {
		if (this.driver.isKeyboardShown ()) {
			super.hideKeyboard ();
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 3:21:20 PM
	 * @param strategy
	 * @param keyName
	 */
	public void hideKeyboard (final String strategy, final String keyName) {
		final String msg = "Hiding keyboard on device using %s strategy for key %s...";
		log.info (format (msg, strategy, keyName));
		try {
			if (this.driver.isKeyboardShown ()) {
				this.driver.hideKeyboard (strategy, keyName);
			}
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActions#pinch(int)
	 */
	@Override
	public void pinch (final int distance) {
		log.info (format ("Pinching on device screen by [%d] distance...", distance));
		final Map <String, Object> param = new HashMap <> ();
		param.put ("scale", 0.5);
		param.put ("velocity", distance);
		this.device.executeCommand ("mobile: pinch", param);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:37:04 PM
	 */
	public void shake () {
		log.info ("Shaking the device...");
		try {
			this.driver.shake ();
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 * @param direction
	 */
	public void swipe (final SwipeDirection direction) {
		log.info (format ("Swiping [%s] on device screen...", direction));
		final Map <String, Object> param = new HashMap <> ();
		param.put ("direction", direction.name ()
			.toLowerCase ());
		this.device.executeCommand ("mobile: swipe", param);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActions#zoom(int)
	 */
	@Override
	public void zoom (final int distance) {
		log.info (format ("Zooming in device screen by [%d] distance...", distance));
		final Map <String, Object> param = new HashMap <> ();
		param.put ("scale", 1.5);
		param.put ("velocity", distance);
		this.device.executeCommand ("mobile: pinch", param);
	}
}