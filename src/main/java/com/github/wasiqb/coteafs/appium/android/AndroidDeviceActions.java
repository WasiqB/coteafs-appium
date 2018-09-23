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

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static java.lang.String.format;

import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;

import com.github.wasiqb.coteafs.appium.android.system.AlertActivity;
import com.github.wasiqb.coteafs.appium.android.system.PermissionActivity;
import com.github.wasiqb.coteafs.appium.device.DeviceActions;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 9:05:27 PM
 */
public class AndroidDeviceActions
		extends DeviceActions <AndroidDriver <MobileElement>, AndroidDevice, AndroidTouchAction> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (AndroidDeviceActions.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:05:43 PM
	 * @param device
	 */
	public AndroidDeviceActions (final AndroidDevice device) {
		super (device, new AndroidTouchAction (device.getDriver ()));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:09:43 PM
	 * @return activity
	 */
	public String currentActivity () {
		return getValue ("Getting current activity name...",
				AndroidDriver <MobileElement>::currentActivity);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 8, 2018 4:01:35 PM
	 * @return message
	 */
	public String handleAlert () {
		return getValue ("Handling Android Alert pop-up...", d -> {
			final String msg = "Alert Text: %s";
			try {
				final AlertActivity perm = new AlertActivity (this.device);
				final String description = perm.onElement ("Message")
						.text ();
				log.trace (String.format (msg, description));
				perm.onElement ("OK")
						.tap ();
				return description;
			} catch (final TimeoutException e) {
				log.warn ("Expected Alert not displayed...");
				log.warn (e.getMessage ());
			}
			return null;
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 9:14:16 PM
	 * @param buttonText
	 * @return message
	 */
	public String handlePermissionAlert (final String buttonText) {
		return getValue ("Handling Android Permission Alert pop-up...", d -> {
			final String msg = "Alert Text: %s";
			try {
				final PermissionActivity perm = new PermissionActivity (this.device);
				final String description = perm.onElement ("Message")
						.text ();
				log.trace (String.format (msg, description));
				perm.onElement (buttonText)
						.tap ();
				return description;
			} catch (final TimeoutException e) {
				log.warn ("Expected Alert not displayed...");
				log.warn (e.getMessage ());
			}
			return null;
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:35 PM
	 * @return isLocked
	 */
	public boolean isLocked () {
		return getValue ("Checking if device is locked...",
				AndroidDriver <MobileElement>::isDeviceLocked);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:45 PM
	 */
	public void lock () {
		perform ("Locking the Android device...", AndroidDriver <MobileElement>::lockDevice);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 21, 2017 8:27:50 PM
	 */
	public void pressBack () {
		perform ("Pressing Back button on Android device...",
				d -> d.pressKey (new KeyEvent (AndroidKey.BACK)));
	}

	/**
	 * @author wasiq.bhamla
	 * @since Mar 5, 2018 10:50:09 PM
	 */
	public void pressEnter () {
		perform ("Pressing Enter button on Android device...",
				d -> d.pressKey (new KeyEvent (AndroidKey.ENTER)));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 9:11:52 PM
	 */
	public void unlock () {
		perform ("Unlocking the Android device...", AndroidDriver <MobileElement>::unlockDevice);
	}

	private <T> T getValue (final String message,
			final Function <AndroidDriver <MobileElement>, T> action, final Object... args) {
		log.info (format (message, args));
		try {
			return action.apply (this.driver);
		} catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
		return null;
	}

	private void perform (final String message,
			final Consumer <AndroidDriver <MobileElement>> action, final Object... args) {
		log.info (format (message, args));
		try {
			action.accept (this.driver);
		} catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}
}